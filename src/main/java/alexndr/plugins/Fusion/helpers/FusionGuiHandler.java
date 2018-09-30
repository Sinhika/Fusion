package alexndr.plugins.Fusion.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import alexndr.plugins.Fusion.gui.GuiFusionFurnace;
import alexndr.plugins.Fusion.inventory.ContainerFusionFurnace;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;

public class FusionGuiHandler implements IGuiHandler 
{
	public static final int FUSION_FURNACE_TILE_ID	= 2;
	
    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID The Gui ID Number
     * @param player The player viewing the Gui
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) 
	{
		if (ID != FUSION_FURNACE_TILE_ID) return null;
		
		TileEntity machine = world.getTileEntity(new BlockPos(x, y, z));
        if(machine == null)
        {
        	return null;
        }
        if(machine instanceof TileEntityFusionFurnace)
        {
        	return new ContainerFusionFurnace(player.inventory, (TileEntityFusionFurnace) machine);
        }
        return null;
	}

 /**
  * Returns a Container to be displayed to the user. On the client side, this
  * needs to return a instance of GuiScreen On the server side, this needs to
  * return a instance of Container
  *
  * @param ID The Gui ID Number
  * @param player The player viewing the Gui
  * @param world The current world
  * @param x X Position
  * @param y Y Position
  * @param z Z Position
  * @return A GuiScreen/Container to be displayed to the user, null if none.
  */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) 
	{
		if (ID != FUSION_FURNACE_TILE_ID) return null;
		
		TileEntity machine = world.getTileEntity(new BlockPos(x, y, z));
        if(machine == null)
        {
        	return null;
        }
        if(machine instanceof TileEntityFusionFurnace)
        {
        	return new GuiFusionFurnace(player.inventory, (TileEntityFusionFurnace)machine);
        }
        return null;
	}

} // end class
