package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.List;

import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.world.item.crafting.RecipeManager;

public final class FusionRecipeMaker
{
	// private static final Logger LOGGER = LogManager.getLogger();
	private FusionRecipeMaker() {}
	
	
	public static List<IFusionRecipe> getFusionRecipes(RecipeManager recipeManager)
	{
		// Collection<Recipe<?>> recipes = recipeManager.getRecipes();
        List<IFusionRecipe> fusion_recipes = new ArrayList<IFusionRecipe> ();
        fusion_recipes = recipeManager.getAllRecipesFor(ModRecipeTypes.FUSION_TYPE.get());
        
//        fusion_recipes = recipes.stream()
//        		.filter(t -> t.getType() == ModRecipeTypes.FUSION_TYPE.get())
//        		.toList();
        return fusion_recipes;
	}
} // end class
