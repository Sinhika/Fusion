package mod.alexndr.fusion.content;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceBlock;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class FusionFurnaceBlock extends AbstractAlloyFurnaceBlock
{
    public FusionFurnaceBlock(Properties builder)
    {
        super(builder);
    } // end ctor

    /**
     * Called on the logical server when a BlockState with a TileEntity is replaced by another BlockState.
     * We use this method to drop all the items from our tile entity's inventory and update comparators near our block.
     *
     * @deprecated Call via {@link BlockState#onReplaced(World, BlockPos, BlockState, boolean)}
     * Implementing/overriding is fine.
     */
   @Override
    public void onRemove(BlockState oldState, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (!oldState.is(newState.getBlock())) 
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractAlloyFurnaceTileEntity) 
            {
                final ItemStackHandler inventory = ((AbstractAlloyFurnaceTileEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));
                worldIn.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(oldState, worldIn, pos, newState, isMoving);
    } // end onReplaced

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate,
			BlockEntityType<T> entityType)
	{
		return createFurnaceTicker(level, entityType, ModTiles.FUSION_FURNACE.get());
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate)
	{
		return new FusionFurnaceTileEntity(bpos, bstate);
	}

	@Override
	protected void openContainer(Level level, BlockPos bpos, Player player)
	{
		BlockEntity blockentity = level.getBlockEntity(bpos);
		if (blockentity instanceof FusionFurnaceTileEntity)
		{
			player.openMenu((MenuProvider) blockentity);
			player.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}

     
} // end class
