package mod.alexndr.fusion.content;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

public class FusionFurnaceTileEntity extends AbstractAlloyFurnaceTileEntity
{
    public FusionFurnaceTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.FUSION_FURNACE.get(), blockpos, blockstate);
    }
    
    @Nonnull
    @Override
    public Component getDefaultName() {
        return new TranslatableComponent(ModBlocks.fusion_furnace.get().getDescriptionId());
    }

	@Override
	public AbstractContainerMenu createMenu(int windowId, Inventory inv)
	{
        return new FusionFurnaceContainer(windowId, inv, this);
	}


} // end class
