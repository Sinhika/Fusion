package alexndr.plugins.Fusion.blocks;

import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.Plugin;
import alexndr.plugins.Fusion.Fusion;
import alexndr.plugins.Fusion.ModBlocks;
import alexndr.plugins.Fusion.helpers.FusionGuiHandler;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author AleXndrTheGr8st
 */
public class BlockFusionFurnace extends SimpleFurnace<TileEntityFusionFurnace>
{
	// repeat for custom furnace classes
	private static Block unlit_furnace;
	private static Block lit_furnace;
	
	public BlockFusionFurnace(String furnace_name, Plugin plugin, boolean isActive) 
	{
		super(furnace_name, plugin, Material.ROCK, ContentCategories.Block.MACHINE, isActive);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2) 
	{
		return new TileEntityFusionFurnace();
	}

	public static Block getUnlit_furnace() {
		return ModBlocks.fusion_furnace;
	}

	public static void setUnlit_furnace(Block unlit_furnace) {
		BlockFusionFurnace.unlit_furnace = unlit_furnace;
	}

	public static Block getLit_furnace() {
		return ModBlocks.fusion_furnace_lit;
	}
	
	public static void setLit_furnace(Block lit_furnace) {
		BlockFusionFurnace.lit_furnace = lit_furnace;
	}

    public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
    	
        keepInventory = true;

        if (active)
        {
            worldIn.setBlockState(pos, BlockFusionFurnace.unlit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, BlockFusionFurnace.lit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            worldIn.setBlockState(pos, BlockFusionFurnace.unlit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, BlockFusionFurnace.lit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    } // end setState()

    
    /* (non-Javadoc)
	 * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand, net.minecraft.util.EnumFacing, float, float, float)
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityFusionFurnace)
            {
            	playerIn.openGui(Fusion.INSTANCE, FusionGuiHandler.FUSION_FURNACE_TILE_ID, 
            		  			worldIn, pos.getX(), pos.getY(), pos.getZ());
                // playerIn.addStat(StatList.FURNACE_INTERACTION);
            }
            return true;
        }
	} // end onBlockActivated

	@Override
	public Class<TileEntityFusionFurnace> getTileEntityClass() {
		return TileEntityFusionFurnace.class;
	}

	@Override
	public TileEntityFusionFurnace createTileEntity(World world, IBlockState state) {
		return new TileEntityFusionFurnace();
	}

} // end class
