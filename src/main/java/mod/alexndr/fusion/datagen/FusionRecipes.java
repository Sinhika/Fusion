package mod.alexndr.fusion.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.fusion.init.ModTags;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

/**
 * Fusion RecipeProvider for Fusion
 */
public class FusionRecipes extends AbstractFusionRecipeProvider
        implements IConditionBuilder, ISimpleConditionBuilder
{
    private FusionRecipeSetBuilder fusionbuilder;

    public FusionRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        fusionbuilder = new FusionRecipeSetBuilder(Fusion.MODID);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerBronzeRecipes(consumer);
        registerSteelRecipes(consumer);
        registerSinisiteRecipes(consumer);
        registerThyriumRecipes(consumer);
        registerVanillaFusionRecyclingRecipes(consumer);
        registerSimpleOresFusionRecyclingRecipes(consumer);
    }

    /**
     * Steel alloying recipes and steel recycling recipes.
     * @param consumer
     */
    protected void registerSteelRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ItemTags.COALS));
        primary_inputs.add(Ingredient.of(Items.IRON_INGOT));
        catalysts[0] = Ingredient.of(ItemTags.COALS);
        catalysts[1] = Ingredient.of(Items.GUNPOWDER);
        catalysts[2] = Ingredient.of(Items.REDSTONE);

        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.steel_nugget.get(),
                ModItems.medium_steel_chunk.get(), ModItems.large_steel_chunk.get(), 2.0F, 600,
                flag("steel_making"));
        
        // steel recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.steel_axe.get(),ModItems.steel_boots.get(), ModItems.steel_helmet.get(),
                        ModItems.steel_hoe.get(), ModItems.steel_pickaxe.get(), ModItems.steel_shovel.get(),
                        ModItems.steel_sword.get(), ModItems.steel_shears.get()), 
                Ingredient.of(ModItems.steel_chestplate.get(), ModItems.steel_leggings.get()), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), ModItems.large_steel_chunk.get(), 
                10.0F, 600, flag("recycle_fusion"), "recycle_steel_items");
    }

    /**
     * Bronze alloy recipes and bronze recycling recipes.
     * @param consumer
     */
    protected void registerBronzeRecipes(Consumer<FinishedRecipe> consumer)
    {
        // bronze alloy recipes
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_COPPER));
        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_TIN));
        catalysts[0] = Ingredient.of(Items.BONE_MEAL);
        catalysts[1] = Ingredient.of(Items.GUNPOWDER);
        catalysts[2] = Ingredient.of(Items.REDSTONE);

        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.bronze_nugget.get(),
                ModItems.medium_bronze_chunk.get(), ModItems.large_bronze_chunk.get(), 2.0F, 600,
                flag("bronze_making"));
        
        // bronze recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.bronze_axe.get(),ModItems.bronze_boots.get(), ModItems.bronze_helmet.get(),
                        ModItems.bronze_hoe.get(), ModItems.bronze_pickaxe.get(), ModItems.bronze_shovel.get(),
                        ModItems.bronze_sword.get()), 
                Ingredient.of(ModItems.bronze_chestplate.get(), ModItems.bronze_leggings.get()), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), ModItems.large_bronze_chunk.get(), 
                10.0F, 600, flag("recycle_fusion"), "recycle_bronze_items");
    } // end registerBronzeRecipes

    /**
     * Sinisite alloy recipes and sinisite recycling recipes.
     * @param consumer
     */
    protected void registerSinisiteRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_MYTHRIL));
        primary_inputs.add(Ingredient.of(ModTags.Items.GEMS_ONYX));
        catalysts[0] = Ingredient.of(Items.GLOWSTONE_DUST);
        catalysts[1] = Ingredient.of(Items.BLAZE_POWDER);
        catalysts[2] = Ingredient.of(Items.GHAST_TEAR);

        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.sinisite_nugget.get(),
                ModItems.medium_sinisite_chunk.get(), ModItems.large_sinisite_chunk.get(), 12.0F, 600,
                flag("sinisite_making"));
        
        // Sinisite recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.sinisite_axe.get(),ModItems.sinisite_boots.get(), ModItems.sinisite_helmet.get(),
                        ModItems.sinisite_hoe.get(), ModItems.sinisite_pickaxe.get(), ModItems.sinisite_shovel.get(),
                        ModItems.sinisite_sword.get(), ModItems.sinisite_bow.get(), ModItems.sinisite_rod.get()), 
                Ingredient.of(ModItems.sinisite_chestplate.get(), ModItems.sinisite_leggings.get()), 
                Ingredient.of(Items.NETHERRACK), Ingredient.of(Items.LAVA_BUCKET), 
                ModItems.large_sinisite_chunk.get(), 
                20.0F, 600, flag("recycle_fusion"), "recycle_sinisite_items");
    } // end ()

    /**
     * Thyrium fusion alloy recipes and thyrium fusion recycling recipes.
     * @param consumer
     */
    protected void registerThyriumRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_MYTHRIL));
        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_ADAMANTIUM));
        catalysts[0] = Ingredient.of(Items.REDSTONE);
        catalysts[1] = Ingredient.of(Items.LAPIS_LAZULI);
        catalysts[2] = Ingredient.of(Items.GLOWSTONE_DUST);

        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.thyrium_nugget.get(),
                ModItems.medium_thyrium_chunk.get(), ModItems.large_thyrium_chunk.get(), 6.0F, 600,
                flag("thyrium_making"));
        
        // Thyrium recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.thyrium_axe.get(),ModItems.thyrium_boots.get(), ModItems.thyrium_helmet.get(),
                        ModItems.thyrium_hoe.get(), ModItems.thyrium_pickaxe.get(), ModItems.thyrium_shovel.get(),
                        ModItems.thyrium_sword.get(), ModItems.thyrium_bow.get(), ModItems.thyrium_rod.get()), 
                Ingredient.of(ModItems.thyrium_chestplate.get(), ModItems.thyrium_leggings.get()), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(Items.LAVA_BUCKET), 
                ModItems.large_thyrium_chunk.get(), 
                15.0F, 600, flag("recycle_fusion"), "recycle_thyrium_items");
    }

    protected void registerVanillaFusionRecyclingRecipes(Consumer<FinishedRecipe> consumer)
    {
        // Diamond recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(Items.DIAMOND_AXE, Items.DIAMOND_BOOTS, Items.DIAMOND_HELMET,
                        Items.DIAMOND_HOE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_SWORD), 
                Ingredient.of(Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_HORSE_ARMOR), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                Items.DIAMOND, 
                20.0F, 600, and(flag("recycle_gems"), flag("recycle_vanilla")), "recycle_diamond_items");
 
 
   } // end registerVanillaFusionRecyclingRecipes()
 
    protected void registerSimpleOresFusionRecyclingRecipes(Consumer<FinishedRecipe> consumer)
    {
        // Onyx recycling
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(mod.alexndr.simpleores.init.ModItems.onyx_axe.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_boots.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_bow.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_helmet.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_hoe.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_pickaxe.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_rod.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_shears.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_shovel.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_sword.get()), 
                Ingredient.of(mod.alexndr.simpleores.init.ModItems.onyx_chestplate.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_leggings.get()), 
                Ingredient.of(Items.NETHERRACK), Ingredient.of(Items.LAVA_BUCKET), 
                mod.alexndr.simpleores.init.ModItems.onyx_gem.get().asItem(), 
                20.0F, 600, and(flag("recycle_gems"), flag("recycle_simpleores"), modLoaded("simpleores")), 
                "recycle_onyx_items");
    } // end registerSimpleOresFusionRecyclingRecipes()
    
    /**
     * Builds an ICondition representing FlagCondition...
     *
     */
    public ICondition flag(String name)
    {
        return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
    }

} // end-class FusionRecipes