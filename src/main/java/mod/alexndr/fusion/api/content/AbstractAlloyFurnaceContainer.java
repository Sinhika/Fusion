package mod.alexndr.fusion.api.content;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.api.helpers.FunctionalIntReferenceHolder;
import mod.alexndr.fusion.api.helpers.FurnaceResultSlotItemHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.items.SlotItemHandler;

public abstract class AbstractAlloyFurnaceContainer<T extends AbstractAlloyFurnaceBlock> extends Container
{
    protected RegistryObject<T> my_block; 

    public final AbstractAlloyFurnaceTileEntity tileEntity;
    protected final IWorldPosCallable canInteractWithCallable;

    public AbstractAlloyFurnaceContainer(ContainerType<?> type, int id, final PlayerInventory playerInventory,
                                        final AbstractAlloyFurnaceTileEntity tileEntity, 
                                        final RegistryObject<T> block)
    {
        super(type, id);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
        this.my_block = block;
        
        // Add tracking for data (Syncs to client/updates value when it changes)
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.smeltTimeLeft, v -> tileEntity.smeltTimeLeft = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxSmeltTime, v -> tileEntity.maxSmeltTime = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.fuelBurnTimeLeft, v -> tileEntity.fuelBurnTimeLeft = (int) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxFuelBurnTime, v -> tileEntity.maxFuelBurnTime = (int) v));

        // Add all the slots for the tileEntity's inventory and the playerInventory to this container

        // Tile inventory slot(s)
        this.addSlot(new SlotItemHandler(tileEntity.inventory, AbstractAlloyFurnaceTileEntity.FUEL_SLOT, 79, 62));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, AbstractAlloyFurnaceTileEntity.INPUT1_SLOT, 33, 35));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, AbstractAlloyFurnaceTileEntity.INPUT2_SLOT, 126, 34));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, AbstractAlloyFurnaceTileEntity.CATALYST_SLOT, 79, 7));
        this.addSlot(new FurnaceResultSlotItemHandler(playerInventory.player, tileEntity, 
                                            tileEntity.inventory, AbstractAlloyFurnaceTileEntity.OUTPUT_SLOT, 79, 34));

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
    }

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
    public boolean canInteractWith(@Nonnull final PlayerEntity player)
    {
        return isWithinUsableDistance(canInteractWithCallable, player, my_block.get());
    }

}