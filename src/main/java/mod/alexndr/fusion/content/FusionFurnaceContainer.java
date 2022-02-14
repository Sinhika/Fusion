package mod.alexndr.fusion.content;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceContainer;
import mod.alexndr.fusion.init.ModContainers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.network.IContainerFactory;

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
    	// MenuType<?> menutype, RecipeType<? extends AbstractCookingRecipe> recipetype, int id, Inventory inv
        super(ModContainers.FUSION_FURNACE.get(), windowId, playerInventory);
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
    
    
} // end class
