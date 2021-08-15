package mod.alexndr.fusion.content;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceBlock;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FusionFurnaceBlock extends AbstractAlloyFurnaceBlock
{
    public FusionFurnaceBlock(Properties builder)
    {
        super(builder);
    } // end ctor

    @Override
    public BlockEntity createTileEntity(BlockState state, BlockGetter world)
    {
        // Always use TileEntityType#create to allow registry overrides to work.
        return ModTiles.FUSION_FURNACE.get().create();
    }

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
    protected void interactWith(Level worldIn, BlockPos pos, Player player)
    {
        final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        if (tileEntity instanceof FusionFurnaceTileEntity) {
            NetworkHooks.openGui((ServerPlayer) player, (FusionFurnaceTileEntity) tileEntity, pos);
        }
    }
    
} // end class
