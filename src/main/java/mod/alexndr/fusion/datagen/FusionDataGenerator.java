package mod.alexndr.fusion.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.function.Consumer;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.fusion.init.ModTags;
import mod.alexndr.simpleores.api.config.FlagCondition;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = Fusion.MODID, bus = MOD)
public class FusionDataGenerator
{

    /**
     * GatherDataEvent handler.
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
    {
        public FusionRecipes(DataGenerator generatorIn)
        {
            super(generatorIn);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerBronzeRecipes(consumer);
        }

        protected void registerSteelRecipes(Consumer<IFinishedRecipe> consumer)
        {
            
        }
        
        protected void registerBronzeRecipes(Consumer<IFinishedRecipe> consumer)
        {
            ConditionalRecipe.builder()
                .addCondition( flag("bronze_making"))
                .addRecipe(new FinishedRecipe(id(Fusion.MODID, "bronze_nugget"), 
                           new ItemStack(ModItems.bronze_nugget.get()), 600, 2.0F, 
                           Ingredient.fromItems(Items.BONE_MEAL), 
                           Ingredient.fromTag(ModTags.Items.INGOTS_COPPER),
                           Ingredient.fromTag(ModTags.Items.INGOTS_TIN)))
                .build(consumer, id(Fusion.MODID, "bronze_nugget"));
                
        }

        /**
         * Builds an ICondition representing FlagCondition...
         *
         */
        public ICondition flag(String name)
        {
            return new FlagCondition(FusionConfig.INSTANCE, name, new ResourceLocation("fusion:flag"));
        }
        
    } // end-class FusionRecipes
    
    
    /** 
     * Basic RecipeProvider for Fusion.
     * @author Sinhika
     *
     */
    public static class Recipes extends RecipeProvider implements IConditionBuilder
    {

        public Recipes(DataGenerator generatorIn)
        {
            super(generatorIn);
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
        {
        } // end registerToolRecipes()
        
        protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
        {
        } // end registerArmorRecipes()
        
        protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
        {
         } // end registerStorageRecipes()
        
        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {
            
        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
         } // end registerFurnaceRecipes()

    } // end subclass FusionDataGenerator$Recipes.
    
} // end-class FusionDataGenerator
