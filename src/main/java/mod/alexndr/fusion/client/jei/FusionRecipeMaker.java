package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;

public final class FusionRecipeMaker
{
	// private static final Logger LOGGER = LogManager.getLogger();
	private FusionRecipeMaker() {}
	
	
	public static List<Recipe<?>> getFusionRecipes(RecipeManager recipeManager)
	{
		Collection<Recipe<?>> recipes = recipeManager.getRecipes();
        List<Recipe<?>> fusion_recipes = new ArrayList<Recipe<?>> ();
        fusion_recipes = recipes.stream()
        		.filter(t -> t.getType() == ModRecipeTypes.FUSION_TYPE)
        		.toList();
        return fusion_recipes;
	}
} // end class
