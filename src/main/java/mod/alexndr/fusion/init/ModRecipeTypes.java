package mod.alexndr.fusion.init;

import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeTypes
{
    public static final RecipeType<IFusionRecipe> FUSION_TYPE = new RecipeType<>();
    public static final RecipeSerializer<FusionRecipe> FUSION_SERIALIZER = 
            new FusionRecipe.FusionRecipeSerializer();
    
    private static class RecipeType<T extends Recipe<?>> implements RecipeType<T>
    {
        @Override
        public String toString()
        {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    } // end class RecipeType
} // end class ModRecipeTypes
