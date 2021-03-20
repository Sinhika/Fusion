package mod.alexndr.fusion.api.recipe;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IFusionRecipe extends IRecipe<RecipeWrapper>
{
    ResourceLocation TYPE_ID = new ResourceLocation(Fusion.MODID, "alloying");

    @Override
    default boolean canCraftInDimensions(int width, int height)
    {
        return false;
    }

    @Override
    default IRecipeType<?> getType()
    {
        return Registry.RECIPE_TYPE.get(TYPE_ID);
    }

    @Override
    default ItemStack getToastSymbol()
    {
        return new ItemStack(ModBlocks.fusion_furnace.get());
    }

    Ingredient getCatalyst();

    float getExperience();
    
    
} // end-class
