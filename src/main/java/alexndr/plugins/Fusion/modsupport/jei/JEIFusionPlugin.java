package alexndr.plugins.Fusion.modsupport.jei;

import alexndr.plugins.Fusion.Content;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import mcjty.lib.jei.JeiCompatTools;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEIFusionPlugin extends BlankModPlugin
{

    @Override
    public void register(IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        
        registry.addRecipeCategories(new FusionFurnaceRecipeCategory(guiHelper));
        registry.addRecipeHandlers(new FusionFurnaceRecipeHandler(jeiHelpers));
        JeiCompatTools.addRecipes(registry, FusionFurnaceRecipes.getRecipeList());
        //registry.addRecipes(FusionFurnaceRecipes.getRecipeList());
        registry.addRecipeCategoryCraftingItem(new ItemStack(Content.fusion_furnace), 
                                                FusionFurnaceRecipeCategory.UID);
     } // end register()

} // end class
