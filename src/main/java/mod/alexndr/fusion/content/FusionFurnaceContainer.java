package mod.alexndr.fusion.content;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceContainer;
import mod.alexndr.fusion.init.ModContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

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
public class FusionFurnaceContainer extends AbstractAlloyFurnaceContainer
{
     /**
     * Constructor called logical-server-side from {@link FusionFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #FusionFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public FusionFurnaceContainer(final int windowId, final Inventory playerInventory, final BlockPos pos, Player playerEntity)
    {
        super(ModContainers.FUSION_FURNACE.get(), windowId, pos, playerInventory, playerEntity);
 
    }  // end-ctor server-side
    
    
} // end class
