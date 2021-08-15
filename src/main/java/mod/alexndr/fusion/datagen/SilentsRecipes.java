package mod.alexndr.fusion.datagen;

import java.util.function.Consumer;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class SilentsRecipes extends RecipeProvider implements ISimpleConditionBuilder, IConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public SilentsRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(Fusion.MODID);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()


    private void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.bronze_dust.get().asItem()),
                ModItems.bronze_ingot.get(), 
                has(ModItems.bronze_dust.get().asItem()), 0.4F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.steel_dust.get().asItem()),
                ModItems.steel_ingot.get(), 
                has(ModItems.steel_dust.get().asItem()), 0.4F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.thyrium_dust.get().asItem()),
                ModItems.thyrium_ingot.get(), 
                has(ModItems.thyrium_dust.get().asItem()), 0.4F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.sinisite_dust.get().asItem()),
                ModItems.sinisite_ingot.get(), 
                has(ModItems.sinisite_dust.get().asItem()), 0.4F, 200, "_from_dust");
    }
    
    @Override
    public ICondition flag(String name)
    {
        return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
    }

} // end class
