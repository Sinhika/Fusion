package mod.alexndr.fusion.content;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FusionFurnaceTileEntity extends AbstractAlloyFurnaceTileEntity
{
    public FusionFurnaceTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.FUSION_FURNACE.get(), blockpos, blockstate);
    }
    
} // end class
