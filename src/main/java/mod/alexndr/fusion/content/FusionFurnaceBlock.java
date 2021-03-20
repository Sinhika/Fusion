package mod.alexndr.fusion.content;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceBlock;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

import net.minecraft.block.AbstractBlock.Properties;

public class FusionFurnaceBlock extends AbstractAlloyFurnaceBlock
{
    public FusionFurnaceBlock(Properties builder)
    {
        super(builder);
    } // end ctor

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
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
    public void onRemove(BlockState oldState, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (!oldState.is(newState.getBlock())) 
        {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractAlloyFurnaceTileEntity) 
            {
                final ItemStackHandler inventory = ((AbstractAlloyFurnaceTileEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));
                worldIn.updateNeighbourForOutputSignal(pos, this);
            }
        }
    } // end onReplaced

   
    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player)
    {
        final TileEntity tileEntity = worldIn.getBlockEntity(pos);
        if (tileEntity instanceof FusionFurnaceTileEntity) {
            NetworkHooks.openGui((ServerPlayerEntity) player, (FusionFurnaceTileEntity) tileEntity, pos);
        }
    }
    
} // end class
