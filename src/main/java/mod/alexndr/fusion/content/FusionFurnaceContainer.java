package mod.alexndr.fusion.content;

import java.util.Objects;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceContainer;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModContainers;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SWindowPropertyPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IntReferenceHolder;
import net.minecraftforge.fml.network.IContainerFactory;

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
public class FusionFurnaceContainer extends AbstractAlloyFurnaceContainer<FusionFurnaceBlock>
{
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
                                  final AbstractAlloyFurnaceTileEntity tileEntity)
    {
        super(ModContainers.FUSION_FURNACE.get(), windowId, playerInventory, tileEntity, ModBlocks.fusion_furnace);
 
    }  // end-ctor server-side
    
    private static AbstractAlloyFurnaceTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data)
    {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof AbstractAlloyFurnaceTileEntity) return (AbstractAlloyFurnaceTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    } // end getTileEntity()
    
} // end class
