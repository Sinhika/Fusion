package alexndr.plugins.Fusion.modsupport.jei;

import alexndr.plugins.Fusion.Content;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.RecipeEntry;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JEIFusionPlugin extends BlankModPlugin
{

    @Override
    public void register(IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        registry.handleRecipes(RecipeEntry.class, new FusionFurnaceRecipeHandler(jeiHelpers), 
        					   FusionFurnaceRecipeCategory.UID);
        registry.addRecipes(FusionFurnaceRecipes.getRecipeList(), FusionFurnaceRecipeCategory.UID);
        registry.addRecipeCatalyst(Content.fusion_furnace, FusionFurnaceRecipeCategory.UID);
     } // end register()

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) 
	{
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new FusionFurnaceRecipeCategory(guiHelper));
	} // end registerCategories()

} // end class
