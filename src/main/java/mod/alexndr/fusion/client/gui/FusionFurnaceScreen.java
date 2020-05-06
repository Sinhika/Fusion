package mod.alexndr.fusion.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.client.gui.AbstractAlloyFurnaceScreen;
import mod.alexndr.fusion.content.FusionFurnaceContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FusionFurnaceScreen extends AbstractAlloyFurnaceScreen<FusionFurnaceContainer>
{
    private final static int name_color =  0x404040;
    
    public FusionFurnaceScreen(final FusionFurnaceContainer screenContainer, PlayerInventory inv, 
                               ITextComponent titleIn)
    {
        super(screenContainer, inv, 
              new ResourceLocation(Fusion.MODID, "textures/gui/container/fusion_furnace_gui.png"), 
              titleIn, name_color);
    }

} // end class
