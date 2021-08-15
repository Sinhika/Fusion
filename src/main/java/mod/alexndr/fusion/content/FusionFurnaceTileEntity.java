package mod.alexndr.fusion.content;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.fml.network.NetworkHooks;

public class FusionFurnaceTileEntity extends AbstractAlloyFurnaceTileEntity
{
    public FusionFurnaceTileEntity()
    {
        super(ModTiles.FUSION_FURNACE.get());
    }
    
    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.fusion_furnace.get().getDescriptionId());
    }

    /**
     * Called from {@link NetworkHooks#openGui}
     * (which is called from {@link FusionFurnaceBlock#onBlockActivated} on the logical server)
     *
     * @return The logical-server-side Container for this TileEntity
     */
    @Nonnull
    @Override
    public AbstractContainerMenu createMenu(final int windowId, final Inventory inventory, final Player player) 
    {
        return new FusionFurnaceContainer(windowId, inventory, this);
    }

} // end class
