package mod.alexndr.fusion.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.fusion.init.ModTags;
import mod.alexndr.simpleores.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simpleores.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers
 * for data generation.
 * 
 * @author Sinhika
 */
@EventBusSubscriber(modid = Fusion.MODID, bus = MOD)
public class FusionDataGenerator
{

    /**
     * GatherDataEvent handler.
     * 
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
            gen.addProvider(new FusionRecipes(gen));
        }
    } // end gatherData()

    /**
     * Fusion RecipeProvider for Fusion
     */
    public static class FusionRecipes extends AbstractFusionRecipeProvider
            implements IConditionBuilder, ISimpleConditionBuilder
    {
        private FusionRecipeSetBuilder fusionbuilder;

        public FusionRecipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            fusionbuilder = new FusionRecipeSetBuilder(Fusion.MODID);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerBronzeRecipes(consumer);
            registerSteelRecipes(consumer);
            registerSinisiteRecipes(consumer);
            registerThyriumRecipes(consumer);
        }

        /**
         * Steel alloying recipes and steel recycling recipes.
         * @param consumer
         */
        protected void registerSteelRecipes(Consumer<IFinishedRecipe> consumer)
        {
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromTag(ItemTags.COALS));
            primary_inputs.add(Ingredient.fromItems(Items.IRON_INGOT));
            catalysts[0] = Ingredient.fromTag(ItemTags.COALS);
            catalysts[1] = Ingredient.fromItems(Items.GUNPOWDER);
            catalysts[2] = Ingredient.fromItems(Items.REDSTONE);

            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.steel_nugget.get(),
                    ModItems.medium_steel_chunk.get(), ModItems.large_steel_chunk.get(), 2.0F, 600,
                    flag("steel_making"));
            
            // steel recycling recipes
            fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                    Ingredient.fromItems(ModItems.steel_axe.get(),ModItems.steel_boots.get(), ModItems.steel_helmet.get(),
                            ModItems.steel_hoe.get(), ModItems.steel_pickaxe.get(), ModItems.steel_shovel.get(),
                            ModItems.steel_sword.get(), ModItems.steel_shears.get()), 
                    Ingredient.fromItems(ModItems.steel_chestplate.get(), ModItems.steel_leggings.get()), 
                    Ingredient.fromItems(Items.GRAVEL), Ingredient.fromTag(ItemTags.COALS), ModItems.large_steel_chunk.get(), 
                    10.0F, 600, flag("recycle_fusion"), "recycle_steel_items");
        }

        /**
         * Bronze alloy recipes and bronze recycling recipes.
         * @param consumer
         */
        protected void registerBronzeRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // bronze alloy recipes
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_COPPER));
            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_TIN));
            catalysts[0] = Ingredient.fromItems(Items.BONE_MEAL);
            catalysts[1] = Ingredient.fromItems(Items.GUNPOWDER);
            catalysts[2] = Ingredient.fromItems(Items.REDSTONE);

            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.bronze_nugget.get(),
                    ModItems.medium_bronze_chunk.get(), ModItems.large_bronze_chunk.get(), 2.0F, 600,
                    flag("bronze_making"));
            
            // bronze recycling recipes
            fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                    Ingredient.fromItems(ModItems.bronze_axe.get(),ModItems.bronze_boots.get(), ModItems.bronze_helmet.get(),
                            ModItems.bronze_hoe.get(), ModItems.bronze_pickaxe.get(), ModItems.bronze_shovel.get(),
                            ModItems.bronze_sword.get()), 
                    Ingredient.fromItems(ModItems.bronze_chestplate.get(), ModItems.bronze_leggings.get()), 
                    Ingredient.fromItems(Items.GRAVEL), Ingredient.fromTag(ItemTags.COALS), ModItems.large_bronze_chunk.get(), 
                    10.0F, 600, flag("recycle_fusion"), "recycle_bronze_items");
        } // end registerBronzeRecipes

        /**
         * Sinisite alloy recipes and sinisite recycling recipes.
         * @param consumer
         */
        protected void registerSinisiteRecipes(Consumer<IFinishedRecipe> consumer)
        {
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_MYTHRIL));
            primary_inputs.add(Ingredient.fromTag(ModTags.Items.GEMS_ONYX));
            catalysts[0] = Ingredient.fromItems(Items.GLOWSTONE_DUST);
            catalysts[1] = Ingredient.fromItems(Items.BLAZE_POWDER);
            catalysts[2] = Ingredient.fromItems(Items.GHAST_TEAR);

            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.sinisite_nugget.get(),
                    ModItems.medium_sinisite_chunk.get(), ModItems.large_sinisite_chunk.get(), 12.0F, 600,
                    flag("sinisite_making"));
            
            // Sinisite recycling recipes
            fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                    Ingredient.fromItems(ModItems.sinisite_axe.get(),ModItems.sinisite_boots.get(), ModItems.sinisite_helmet.get(),
                            ModItems.sinisite_hoe.get(), ModItems.sinisite_pickaxe.get(), ModItems.sinisite_shovel.get(),
                            ModItems.sinisite_sword.get(), ModItems.sinisite_bow.get(), ModItems.sinisite_rod.get()), 
                    Ingredient.fromItems(ModItems.sinisite_chestplate.get(), ModItems.sinisite_leggings.get()), 
                    Ingredient.fromItems(Items.NETHERRACK), Ingredient.fromItems(Items.LAVA_BUCKET), 
                    ModItems.large_sinisite_chunk.get(), 
                    20.0F, 600, flag("recycle_fusion"), "recycle_sinisite_items");
        } // end ()

        /**
         * Thyrium fusion alloy recipes and thyrium fusion recycling recipes.
         * @param consumer
         */
        protected void registerThyriumRecipes(Consumer<IFinishedRecipe> consumer)
        {
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_MYTHRIL));
            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_ADAMANTIUM));
            catalysts[0] = Ingredient.fromItems(Items.REDSTONE);
            catalysts[1] = Ingredient.fromItems(Items.LAPIS_LAZULI);
            catalysts[2] = Ingredient.fromItems(Items.GLOWSTONE_DUST);

            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.thyrium_nugget.get(),
                    ModItems.medium_thyrium_chunk.get(), ModItems.large_thyrium_chunk.get(), 6.0F, 600,
                    flag("thyrium_making"));
            
            // Thyrium recycling recipes
            fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                    Ingredient.fromItems(ModItems.thyrium_axe.get(),ModItems.thyrium_boots.get(), ModItems.thyrium_helmet.get(),
                            ModItems.thyrium_hoe.get(), ModItems.thyrium_pickaxe.get(), ModItems.thyrium_shovel.get(),
                            ModItems.thyrium_sword.get(), ModItems.thyrium_bow.get(), ModItems.thyrium_rod.get()), 
                    Ingredient.fromItems(ModItems.thyrium_chestplate.get(), ModItems.thyrium_leggings.get()), 
                    Ingredient.fromItems(Items.GRAVEL), Ingredient.fromItems(Items.LAVA_BUCKET), 
                    ModItems.large_thyrium_chunk.get(), 
                    15.0F, 600, flag("recycle_fusion"), "recycle_thyrium_items");
        }

        
        /**
         * Builds an ICondition representing FlagCondition...
         *
         */
        public ICondition flag(String name)
        {
            return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
        }

    } // end-class FusionRecipes

    /**
     * Basic RecipeProvider for Fusion.
     * 
     * @author Sinhika
     *
     */
    public static class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
    {
        private RecipeSetBuilder setbuilder;

        public Recipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            setbuilder = new RecipeSetBuilder(Fusion.MODID);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
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
                    ModItems.bronze_nugget.get(), hasItem(ModItems.bronze_ingot.get()));
            setbuilder.buildSimpleStorageRecipes(consumer, ModItems.steel_ingot.get(), ModBlocks.steel_block.get(),
                    ModItems.steel_nugget.get(), hasItem(ModItems.steel_ingot.get()));
            setbuilder.buildSimpleStorageRecipes(consumer, ModItems.sinisite_ingot.get(),
                    ModBlocks.sinisite_block.get(), ModItems.sinisite_nugget.get(),
                    hasItem(ModItems.sinisite_ingot.get()));
            setbuilder.buildSimpleStorageRecipes(consumer, ModItems.thyrium_ingot.get(), ModBlocks.thyrium_block.get(),
                    ModItems.thyrium_nugget.get(), hasItem(ModItems.thyrium_ingot.get()));

            setbuilder.buildChunkConversionRecipes(consumer, ModItems.bronze_nugget.get(),
                    ModItems.medium_bronze_chunk.get(), ModItems.large_bronze_chunk.get(),
                    hasItem(ModItems.bronze_nugget.get()));
            setbuilder.buildChunkConversionRecipes(consumer, ModItems.steel_nugget.get(),
                    ModItems.medium_steel_chunk.get(), ModItems.large_steel_chunk.get(),
                    hasItem(ModItems.steel_nugget.get()));
            setbuilder.buildChunkConversionRecipes(consumer, ModItems.sinisite_nugget.get(),
                    ModItems.medium_sinisite_chunk.get(), ModItems.large_sinisite_chunk.get(),
                    hasItem(ModItems.sinisite_nugget.get()));
            setbuilder.buildChunkConversionRecipes(consumer, ModItems.thyrium_nugget.get(),
                    ModItems.medium_thyrium_chunk.get(), ModItems.large_thyrium_chunk.get(),
                    hasItem(ModItems.thyrium_nugget.get()));
        } // end registerStorageRecipes()

        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {

        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
            setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_bronze_chunk.get()),
                    ModItems.bronze_ingot.get(), hasItem(ModItems.large_bronze_chunk.get()), 0.4F, 200);
            setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_steel_chunk.get()),
                    ModItems.steel_ingot.get(), hasItem(ModItems.large_steel_chunk.get()), 0.4F, 200);
            setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_sinisite_chunk.get()),
                    ModItems.sinisite_ingot.get(), hasItem(ModItems.large_sinisite_chunk.get()), 0.4F, 200);
            setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_thyrium_chunk.get()),
                    ModItems.thyrium_ingot.get(), hasItem(ModItems.large_thyrium_chunk.get()), 0.4F, 200);
            
        } // end registerFurnaceRecipes()

        @Override
        public ICondition flag(String name)
        {
            return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
        }

    } // end subclass FusionDataGenerator$Recipes.

} // end-class FusionDataGenerator
