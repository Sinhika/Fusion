package alexndr.plugins.Fusion;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import alexndr.api.core.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;

/**
 * @author AleXndrTheGr8st
 */
public class BlockFusionFurnace extends SimpleFurnace
{
	public BlockFusionFurnace(boolean isActive) 
	{
		super(Fusion.plugin, Material.rock, ContentCategories.Block.MACHINE, isActive);
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
	@SideOnly(Side.CLIENT)
	public Item getItem(World worldIn, BlockPos pos) {
		return Item.getItemFromBlock(Content.fusion_furnace);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Content.fusion_furnace);
	}
} // end class
