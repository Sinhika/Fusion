package mod.alexndr.fusion.content;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkHooks;

public class FusionFurnaceTileEntity extends AbstractAlloyFurnaceTileEntity
{
    public FusionFurnaceTileEntity()
    {
        super(ModTiles.FUSION_FURNACE.get());
    }
    
    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.fusion_furnace.get().getDescriptionId());
    }

    /**
     * Called from {@link NetworkHooks#openGui}
     * (which is called from {@link FusionFurnaceBlock#onBlockActivated} on the logical server)
     *
     * @return The logical-server-side Container for this TileEntity
     */
    @Nonnull
    @Override
    public Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player) 
    {
        return new FusionFurnaceContainer(windowId, inventory, this);
    }

} // end class
