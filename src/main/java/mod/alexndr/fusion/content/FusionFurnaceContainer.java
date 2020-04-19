package mod.alexndr.fusion.content;

import java.util.Objects;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.helpers.FunctionalIntReferenceHolder;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModContainers;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SWindowPropertyPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Smelt time is synced with Server: Each tick {@link #detectAndSendChanges()}
 * is called ({@link ServerPlayerEntity#tick()}) Server: The (tracked) value of
 * the tile's energy is updated ({@link #updateProgressBar(int, int)}) Server:
 * If the value is different from the value last sent to the client
 * ({@link IntReferenceHolder#isDirty()}), it is synced to the client
 * ({@link ServerPlayerEntity#sendWindowProperty(Container, int, int)}) Client:
 * The sync packet is received
 * ({@link ClientPlayNetHandler#handleWindowProperty(SWindowPropertyPacket)})
 * and the tracked value of is updated
 * ({@link Container#updateProgressBar(int, int)}) Client: The tile's data is
 * set to the new value
 *
 * @author Cadiboo
 */
public class FusionFurnaceContainer extends Container
{
    public final FusionFurnaceTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    /**
     * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
     * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
     */
    public FusionFurnaceContainer(final int windowId, final PlayerInventory playerInventory, 
                                  final PacketBuffer data)
    {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    /**
     * Constructor called logical-server-side from {@link FusionFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #FusionFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public FusionFurnaceContainer(final int windowId, final PlayerInventory playerInventory, 
                                  final FusionFurnaceTileEntity tileEntity)
    {
        super(ModContainers.FUSION_FURNACE.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        // Add tracking for data (Syncs to client/updates value when it changes)
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.smeltTimeLeft, v -> tileEntity.smeltTimeLeft = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxSmeltTime, v -> tileEntity.maxSmeltTime = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.fuelBurnTimeLeft, v -> tileEntity.fuelBurnTimeLeft = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxFuelBurnTime, v -> tileEntity.maxFuelBurnTime = (short) v));

        // Add all the slots for the tileEntity's inventory and the playerInventory to this container

        // Tile inventory slot(s)
        this.addSlot(new SlotItemHandler(tileEntity.inventory, FusionFurnaceTileEntity.FUEL_SLOT, 79, 62));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, FusionFurnaceTileEntity.INPUT1_SLOT, 33, 35));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, FusionFurnaceTileEntity.INPUT2_SLOT, 126, 34));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, FusionFurnaceTileEntity.CATALYST_SLOT, 79, 7));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, FusionFurnaceTileEntity.OUTPUT_SLOT, 79, 34));

        final int playerInventoryStartX = 8;
        final int playerInventoryStartY = 84;
        final int slotSizePlus2 = 18; // slots are 16x16, plus 2 (for spacing/borders) is 18x18

        // Player Top Inventory slots
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, playerInventoryStartX + (column * slotSizePlus2), playerInventoryStartY + (row * slotSizePlus2)));
            }
        }

        final int playerHotbarY = playerInventoryStartY + slotSizePlus2 * 3 + 4;
        // Player Hotbar slots
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, playerInventoryStartX + (column * slotSizePlus2), playerHotbarY));
        }
    }  // end-ctor server-side
    
    private static FusionFurnaceTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data)
    {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof FusionFurnaceTileEntity) return (FusionFurnaceTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    } // end getTileEntity()
   
    /**
     * Generic & dynamic version of {@link Container#transferStackInSlot(PlayerEntity, int)}.
     * Handle when the stack in slot {@code index} is shift-clicked.
     * Normally this moves the stack between the player inventory and the other inventory(s).
     *
     * @param player the player passed in
     * @param index  the index passed in
     * @return the {@link ItemStack}
     */
    @Nonnull
    @Override
    public ItemStack transferStackInSlot(final PlayerEntity player, final int index) 
    {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            final ItemStack slotStack = slot.getStack();
            returnStack = slotStack.copy();

            final int containerSlots = 
                    this.inventorySlots.size() - player.inventory.mainInventory.size();
            if (index < containerSlots) 
            {
                if (!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) 
                {
                    return ItemStack.EMPTY;
                }
            } 
            else if (!mergeItemStack(slotStack, 0, containerSlots, false)) 
            {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0) 
            {
                slot.putStack(ItemStack.EMPTY);
            } 
            else {
                slot.onSlotChanged();
            }
            if (slotStack.getCount() == returnStack.getCount()) 
            {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return returnStack;
    } // end transferStackInSlot()
    
    @Override
    public boolean canInteractWith(@Nonnull final PlayerEntity player) {
        return isWithinUsableDistance(canInteractWithCallable, player, ModBlocks.fusion_furnace.get());
    }
    
} // end class
