package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.List;

import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;

public final class FusionRecipeMaker
{
	// private static final Logger LOGGER = LogManager.getLogger();
	private FusionRecipeMaker() {}
	
	public static List<FusionRecipe> getFusionRecipes(RecipeManager recipeManager)
	{
		Iterable<Recipe<?>> recipes = recipeManager.getRecipes();
        List<FusionRecipe> fusion_recipes = new ArrayList<FusionRecipe> ();
        for (Recipe<?> recipe : recipes) {
            if (recipe.getType() == ModRecipeTypes.FUSION_TYPE) {
                fusion_recipes.add((FusionRecipe) recipe);
            }
        } // end-for
        return fusion_recipes;
	}
} // end class
