package mod.alexndr.fusion.content;

import java.util.Objects;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceContainer;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModContainers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fmllegacy.network.IContainerFactory;

/**
 * Smelt time is synced with Server: Each tick {@link #detectAndSendChanges()}
 * is called ({@link ServerPlayerEntity#tick()}) Server: The (tracked) value of
 * the tile's energy is updated ({@link #updateProgressBar(int, int)}) Server:
 * If the value is different from the value last sent to the client
 * ({@link IntRefere,nceHolder#isDirty()}), it is synced to the client
 * ({@link ServerPlayerEntity#sendWindowProperty(Container, int, int)}) Client:
 * The sync packet is received
 * ({@link ClientPlayNetHandler#handleWindowProperty(SWindowPropertyPacket)})
 * and the tracked value of is updated
 * ({@link Container#updateProgressBar(int, int)}) Client: The tile's data is
 * set to the new value
 *
 * @author Cadiboo
 */
public class FusionFurnaceContainer extends AbstractAlloyFurnaceContainer<FusionFurnaceBlock>
{
    /**
     * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
     * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
     */
    public FusionFurnaceContainer(final int windowId, final Inventory playerInventory, 
                                  final FriendlyByteBuf data)
    {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    /**
     * Constructor called logical-server-side from {@link FusionFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #FusionFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public FusionFurnaceContainer(final int windowId, final Inventory playerInventory, final FusionFurnaceTileEntity tileEntity)
    {
        super(ModContainers.FUSION_FURNACE.get(), windowId, playerInventory, tileEntity.inventory, tileEntity.dataAccess,
        		tileEntity);
 
    }  // end-ctor server-side
    
    private static FusionFurnaceTileEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data)
    {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final BlockEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof AbstractAlloyFurnaceTileEntity) return (FusionFurnaceTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    } // end getTileEntity()
    
} // end class
