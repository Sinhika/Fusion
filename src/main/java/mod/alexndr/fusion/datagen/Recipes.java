package mod.alexndr.fusion.datagen;

import java.util.function.Consumer;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

/**
 * Basic RecipeProvider for Fusion.
 * 
 * @author Sinhika
 *
 */
public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public Recipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(Fusion.MODID);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()

    protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
    {} // end registerToolRecipes()

    protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
    {} // end registerArmorRecipes()

    protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.bronze_ingot.get(), ModBlocks.bronze_block.get(),
                ModItems.bronze_nugget.get(), has(ModItems.bronze_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.steel_ingot.get(), ModBlocks.steel_block.get(),
                ModItems.steel_nugget.get(), has(ModItems.steel_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.sinisite_ingot.get(),
                ModBlocks.sinisite_block.get(), ModItems.sinisite_nugget.get(),
                has(ModItems.sinisite_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.thyrium_ingot.get(), ModBlocks.thyrium_block.get(),
                ModItems.thyrium_nugget.get(), has(ModItems.thyrium_ingot.get()));

        setbuilder.buildChunkConversionRecipes(consumer, ModItems.bronze_nugget.get(),
                ModItems.medium_bronze_chunk.get(), ModItems.large_bronze_chunk.get(),
                has(ModItems.bronze_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.steel_nugget.get(),
                ModItems.medium_steel_chunk.get(), ModItems.large_steel_chunk.get(),
                has(ModItems.steel_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.sinisite_nugget.get(),
                ModItems.medium_sinisite_chunk.get(), ModItems.large_sinisite_chunk.get(),
                has(ModItems.sinisite_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.thyrium_nugget.get(),
                ModItems.medium_thyrium_chunk.get(), ModItems.large_thyrium_chunk.get(),
                has(ModItems.thyrium_nugget.get()));
    } // end registerStorageRecipes()

    protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
    {

    } // end registerMiscRecipes()

    protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_bronze_chunk.get()),
                ModItems.bronze_ingot.get(), has(ModItems.large_bronze_chunk.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_steel_chunk.get()),
                ModItems.steel_ingot.get(), has(ModItems.large_steel_chunk.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_sinisite_chunk.get()),
                ModItems.sinisite_ingot.get(), has(ModItems.large_sinisite_chunk.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_thyrium_chunk.get()),
                ModItems.thyrium_ingot.get(), has(ModItems.large_thyrium_chunk.get()), 0.4F, 200);
        
    } // end registerFurnaceRecipes()

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
    }

} // end subclass FusionDataGenerator$Recipes.