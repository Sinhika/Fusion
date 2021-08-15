package mod.alexndr.fusion.client.gui;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.client.gui.AbstractAlloyFurnaceScreen;
import mod.alexndr.fusion.content.FusionFurnaceContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class FusionFurnaceScreen extends AbstractAlloyFurnaceScreen<FusionFurnaceContainer>
{
    private final static int name_color =  0x404040;
    
    public FusionFurnaceScreen(final FusionFurnaceContainer screenContainer, Inventory inv, 
                               Component titleIn)
    {
        super(screenContainer, inv, 
              new ResourceLocation(Fusion.MODID, "textures/gui/container/fusion_furnace_gui.png"), 
              titleIn, name_color);
    }

} // end class
