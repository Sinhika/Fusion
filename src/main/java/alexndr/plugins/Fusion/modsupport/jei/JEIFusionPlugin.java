package alexndr.plugins.Fusion.modsupport.jei;

import alexndr.plugins.Fusion.ModBlocks;
import alexndr.plugins.Fusion.crafting.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.crafting.RecipeEntry;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEIFusionPlugin implements IModPlugin
{

    @Override
    public void register(IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        registry.handleRecipes(RecipeEntry.class, new FusionFurnaceRecipeHandler(jeiHelpers), 
        					   FusionFurnaceRecipeCategory.UID);
        registry.addRecipes(FusionFurnaceRecipes.getRecipeList(), FusionFurnaceRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.fusion_furnace), FusionFurnaceRecipeCategory.UID);
     } // end register()

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) 
	{
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new FusionFurnaceRecipeCategory(guiHelper));
	} // end registerCategories()

} // end class
