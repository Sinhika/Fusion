package mod.alexndr.fusion.api.datagen;

import java.util.List;
import java.util.function.Consumer;

import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class FusionRecipeSetBuilder extends RecipeSetBuilder
{

    public FusionRecipeSetBuilder(String modid)
    {
        super(modid);
    }

    public void buildBasicAlloyRecipes(Consumer<FinishedRecipe> consumer, List<Ingredient> primaryInputs,
            Ingredient[] catalysts, ItemLike nugget, ItemLike medium_chunk, ItemLike large_chunk,
            float experience, int cooktime, ICondition condition)
    {
        buildBasicAlloyRecipes(consumer, primaryInputs, catalysts, nugget, medium_chunk, large_chunk,
                experience, cooktime, condition, null);
    }
    
    /**
     * Create the fusion_furnace alloy recipes for nuggets, medium chunks, and large chunks for a given pair of
     * ingredients and set of catalysts.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param primaryInputs a list of two ingredients that will be alloyed.
     * @param catalysts 3-item array of catalysts, in order [nugget, medium_chunk, large_chunk]; null for non-existent 
     *  recipes.
     * @param nugget nugget item to be created by fusion alloying recipe.
     * @param medium_chunk medium_chunk item to be created by fusion alloying recipe.
     * @param large_chunk large_chunk item to be created by fusion alloying recipe.
     * @param experience experience for creating nugget item. Will be multiplied x2 for medium, x4 for large.
     * @param cooktime standard fusion furnace cooking time, usually 600.
     * @param condition Usually a flag condition, could be more complex.
     */
    public void buildBasicAlloyRecipes(Consumer<FinishedRecipe> consumer, List<Ingredient> primaryInputs,
            Ingredient[] catalysts, ItemLike nugget, ItemLike medium_chunk, ItemLike large_chunk,
            float experience, int cooktime, ICondition condition, String suffix)
    {
        if (suffix == null) {
            suffix = "";
        }
        
        ResourceLocation nugget_name = (nugget != null) 
                ? AbstractFusionRecipeProvider.id(modid, nugget.asItem().toString() + suffix) 
                : null;
        
        ResourceLocation medium_chunk_name = (medium_chunk != null) 
                ? AbstractFusionRecipeProvider.id(modid, medium_chunk.asItem().toString() + suffix) 
                : null;
        ResourceLocation large_chunk_name = (large_chunk != null) 
                ? AbstractFusionRecipeProvider.id(modid, large_chunk.asItem().toString() + suffix) 
                : null;
                
        if (condition == null)
        {
            if (nugget != null)
            {
                consumer.accept(new AbstractFusionRecipeProvider.FinishedRecipe(nugget_name,
                        new ItemStack(nugget.asItem()), cooktime, experience, catalysts[0], primaryInputs.get(0),
                        primaryInputs.get(1)));
            }
            if (medium_chunk != null)
            {
                consumer.accept(new AbstractFusionRecipeProvider.FinishedRecipe(medium_chunk_name,
                        new ItemStack(medium_chunk.asItem()), cooktime, experience * 2.0F, catalysts[1], primaryInputs.get(0),
                        primaryInputs.get(1)));
            }
            if (large_chunk != null)
            {
                consumer.accept(new AbstractFusionRecipeProvider.FinishedRecipe(large_chunk_name,
                        new ItemStack(large_chunk.asItem()), cooktime, experience * 4.0F, catalysts[2], primaryInputs.get(0),
                        primaryInputs.get(1)));
            }
        } // end-if no condition
        else {
            if (nugget != null)
            {
                ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(new AbstractFusionRecipeProvider.FinishedRecipe(nugget_name,
                        new ItemStack(nugget.asItem()), cooktime, experience, catalysts[0], primaryInputs.get(0),
                        primaryInputs.get(1)))
                .build(consumer, nugget_name);            
            }
            if (medium_chunk != null)
            {
                ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(new AbstractFusionRecipeProvider.FinishedRecipe(medium_chunk_name,
                        new ItemStack(medium_chunk.asItem()), cooktime, experience * 2.0F, catalysts[1], primaryInputs.get(0),
                        primaryInputs.get(1)))
                .build(consumer, medium_chunk_name);            
            }
            if (large_chunk != null)
            {
                ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(new AbstractFusionRecipeProvider.FinishedRecipe(large_chunk_name,
                        new ItemStack(large_chunk.asItem()), cooktime, experience * 4.0F, catalysts[2], primaryInputs.get(0),
                        primaryInputs.get(1)))
                .build(consumer, large_chunk_name);            
            }
        } // end-else condition exists
    } // end buildBasicAlloyRecipes()
    
    /**
     * Create the fusion_furnace recipes for fusion recycling of the list of ingredients.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param ingredients all the possible inputs that will produce a single output_item.
     * @param ingrs_doubleoutput all the possible inputs that will produce 2 output items.
     * @param input2 2nd input ingredient (often minecraft:gravel)
     * @param catalyst catalyst ingredient.
     * @param output_item output from recycling.
     * @param experience experience
     * @param cooktime cooking time; usually 600.
     * @param condition must be here; a flag or mod_loaded or some combination.
     * @param name simple name of recipe.
     */
    public void buildFusionRecyclingRecipes(Consumer<FinishedRecipe> consumer, Ingredient ingredients,
            Ingredient ingrs_doubleoutput, Ingredient input2, Ingredient catalyst, ItemLike output_item, float experience,
            int cooktime, ICondition condition, String name)
    {
        ResourceLocation recipe1 = AbstractFusionRecipeProvider.id(modid, name + '1');
        if (ingredients != null)
        {
            ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(new AbstractFusionRecipeProvider.FinishedRecipe(recipe1,
                                new ItemStack(output_item.asItem()), cooktime, experience, 
                                catalyst, ingredients, input2))
                .build(consumer, recipe1); 
        }
        if (ingrs_doubleoutput != null)
        {
            ResourceLocation recipe2 = AbstractFusionRecipeProvider.id(modid, name + '2');
            ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(new AbstractFusionRecipeProvider.FinishedRecipe(recipe1,
                                new ItemStack(output_item.asItem(), 2), cooktime, experience * 2.0F, 
                                catalyst, ingrs_doubleoutput, input2))
                .build(consumer, recipe2);
        }
    } // end buildFusionRecyclingRecipes
    
} // end class
