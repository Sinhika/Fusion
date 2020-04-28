package mod.alexndr.fusion.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mod.alexndr.fusion.Fusion;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIFusionPlugin implements IModPlugin
{
    private static final ResourceLocation ID = new ResourceLocation(Fusion.MODID, "main");
    
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new FusionFurnaceRecipeCategory(guiHelper));    
    }

} // end-class
