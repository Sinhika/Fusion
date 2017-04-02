package alexndr.plugins.Fusion.blocks;

import java.util.Random;

import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.Content;
import alexndr.plugins.Fusion.Fusion;
import alexndr.plugins.Fusion.helpers.FusionGuiHandler;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author AleXndrTheGr8st
 */
public class BlockFusionFurnace extends SimpleFurnace
{
	public BlockFusionFurnace(boolean isActive) 
	{
		super(Fusion.plugin, Material.ROCK, ContentCategories.Block.MACHINE, isActive);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2) 
	{
		return new TileEntityFusionFurnace();
	}

	public static SimpleFurnace getUnlit_furnace() {
		return (SimpleFurnace) Content.fusion_furnace;
	}

	public static SimpleFurnace getLit_furnace() {
		return (SimpleFurnace) Content.fusion_furnace_lit;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Content.fusion_furnace);
	}
	
    public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
    	
        keepInventory = true;

        if (active)
        {
            worldIn.setBlockState(pos, getLit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, getLit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            worldIn.setBlockState(pos, getUnlit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, getUnlit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    } // end setState()

    /* cut & pasted from BlockFurnace & modified per CompatBlock */
	@Override
	protected boolean clOnBlockActivated( World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ ) 
	{
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
                playerIn.addStat(StatList.FURNACE_INTERACTION);
            }
            return true;
        }
	} // end onBlockActivated

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(Content.fusion_furnace));
	}

} // end class
