package mod.alexndr.fusion.init;

import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;

public class ModRecipeTypes
{
    public static final IRecipeType<IFusionRecipe> FUSION_TYPE = new RecipeType<>();
    public static final IRecipeSerializer<FusionRecipe> FUSION_SERIALIZER = 
            new FusionRecipe.FusionRecipeSerializer();
    
    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T>
    {
        @Override
        public String toString()
        {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    } // end class RecipeType
} // end class ModRecipeTypes
