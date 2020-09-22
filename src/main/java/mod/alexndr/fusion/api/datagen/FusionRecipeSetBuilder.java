package mod.alexndr.fusion.api.datagen;

import java.util.List;
import java.util.function.Consumer;

import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simpleores.api.datagen.RecipeSetBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class FusionRecipeSetBuilder extends RecipeSetBuilder
{

    public FusionRecipeSetBuilder(String modid)
    {
        super(modid);
    }

    public void buildBasicAlloyRecipes(Consumer<IFinishedRecipe> consumer, List<Ingredient> primaryInputs,
                                       Ingredient[] catalysts, IItemProvider nugget, IItemProvider medium_chunk,
                                       IItemProvider large_chunk, float experience, int cooktime, ICondition condition)
    {
        ResourceLocation nugget_name = (nugget != null) 
                ? AbstractFusionRecipeProvider.id(modid, nugget.asItem().toString()) 
                : null;
        ResourceLocation medium_chunk_name = (medium_chunk != null) 
                ? AbstractFusionRecipeProvider.id(modid, medium_chunk.asItem().toString()) 
                : null;
        ResourceLocation large_chunk_name = (large_chunk != null) 
                ? AbstractFusionRecipeProvider.id(modid, large_chunk.asItem().toString()) 
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
    
    
} // end class
