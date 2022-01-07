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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
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
        registerNetherrocksFusionRecyclingRecipes(consumer);
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
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                ModItems.large_steel_chunk.get(), 
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
    	// stone recycling
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(Items.STONE_AXE, Items.STONE_HOE, Items.STONE_PICKAXE, Items.STONE_SHOVEL,
                			  Items.STONE_SWORD), 
                Ingredient.of(Items.FURNACE), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                Blocks.STONE.asItem(),5.0F, 600, flag("recycle_vanilla"), "recycle_stone_items");
    	
    	// iron recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(Items.IRON_AXE, Items.IRON_BOOTS, Items.IRON_HELMET, Items.CHAINMAIL_HELMET,
                        Items.IRON_HOE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.IRON_SWORD, Items.BUCKET,
                        Items.CHAINMAIL_BOOTS, Items.COMPASS, Items.HOPPER, Items.IRON_DOOR, Items.MINECART,
                        Items.SHEARS), 
                Ingredient.of(Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_HORSE_ARMOR, Items.CAULDRON,
                		Items.CHAINMAIL_CHESTPLATE, Items.CHAINMAIL_LEGGINGS, Items.HOPPER_MINECART), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                Items.RAW_IRON, 
                10.0F, 600, flag("recycle_vanilla"), "recycle_iron_items");
        
        // iron anvils yield even more.
    	ResourceLocation recipe_anvil = AbstractFusionRecipeProvider.id(Fusion.MODID, "recycle_iron_items4");
        ConditionalRecipe.builder().addCondition(flag("recycle_vanilla"))
        	.addRecipe(new AbstractFusionRecipeProvider.FinishedFusionRecipe(recipe_anvil,
                        new ItemStack(Items.RAW_IRON.asItem(), 4), 600, 40.0F, 
                        Ingredient.of(ItemTags.COALS), 
                        Ingredient.of(Items.ANVIL, Items.CHIPPED_ANVIL, Items.DAMAGED_ANVIL), 
                        Ingredient.of(Items.GRAVEL)))
        	.build(consumer, recipe_anvil);

        // gold recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(Items.GOLDEN_AXE, Items.GOLDEN_BOOTS, Items.GOLDEN_HELMET, Items.CLOCK,
                        Items.GOLDEN_HOE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_SWORD), 
                Ingredient.of(Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_HORSE_ARMOR), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                Items.RAW_GOLD, 
                15.0F, 600, flag("recycle_vanilla"), "recycle_gold_items");
        
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
    	// Copper recycling
    	fusionbuilder.buildFusionRecyclingRecipes(consumer,
    		Ingredient.of(mod.alexndr.simpleores.init.ModItems.copper_axe.get(),
                mod.alexndr.simpleores.init.ModItems.copper_boots.get(),
                mod.alexndr.simpleores.init.ModItems.copper_bucket.get(),
                mod.alexndr.simpleores.init.ModItems.copper_helmet.get(),
                mod.alexndr.simpleores.init.ModItems.copper_hoe.get(),
                mod.alexndr.simpleores.init.ModItems.copper_pickaxe.get(),
                mod.alexndr.simpleores.init.ModItems.copper_shears.get(),
                mod.alexndr.simpleores.init.ModItems.copper_shovel.get(),
                mod.alexndr.simpleores.init.ModItems.copper_sword.get(),
                mod.alexndr.simpleores.init.ModBlocks.copper_door.get()), 
    		Ingredient.of(mod.alexndr.simpleores.init.ModItems.copper_chestplate.get(),
                mod.alexndr.simpleores.init.ModItems.copper_leggings.get()), 
	        Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS),
	        Items.RAW_COPPER, 10.0F, 600, and(flag("recycle_simpleores"), modLoaded("simpleores")),
	        "recycle_copper_items");
 
    	// Tin recycling
    	fusionbuilder.buildFusionRecyclingRecipes(consumer,
        		Ingredient.of(mod.alexndr.simpleores.init.ModItems.tin_axe.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_boots.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_helmet.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_hoe.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_pickaxe.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_shears.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_shovel.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_sword.get()), 
        		Ingredient.of(mod.alexndr.simpleores.init.ModItems.tin_chestplate.get(),
                    mod.alexndr.simpleores.init.ModItems.tin_leggings.get()), 
    	        Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS),
                mod.alexndr.simpleores.init.ModItems.raw_tin.get(), 
    	        10.0F, 600, and(flag("recycle_simpleores"), modLoaded("simpleores")),
    	        "recycle_tin_items");
    	
    	// Mythril recycling
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(mod.alexndr.simpleores.init.ModItems.mythril_axe.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_boots.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_bow.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_helmet.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_hoe.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_pickaxe.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_rod.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_shears.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_shovel.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_sword.get()), 
                Ingredient.of(mod.alexndr.simpleores.init.ModItems.mythril_chestplate.get(),
                        mod.alexndr.simpleores.init.ModItems.mythril_leggings.get()), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                mod.alexndr.simpleores.init.ModItems.raw_mythril.get(), 
                15.0F, 600, and(flag("recycle_simpleores"), modLoaded("simpleores")), 
                "recycle_mythril_items");
    	
    	// Adamantium recycling
    	fusionbuilder.buildFusionRecyclingRecipes(consumer,
        		Ingredient.of(mod.alexndr.simpleores.init.ModItems.adamantium_axe.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_boots.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_helmet.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_hoe.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_pickaxe.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_shears.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_shovel.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_sword.get()), 
        		Ingredient.of(mod.alexndr.simpleores.init.ModItems.adamantium_chestplate.get(),
                    mod.alexndr.simpleores.init.ModItems.adamantium_leggings.get()), 
    	        Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS),
    	        mod.alexndr.simpleores.init.ModItems.raw_adamantium.get(), 
    	        15.0F, 600, and(flag("recycle_simpleores"), modLoaded("simpleores")),
    	        "recycle_adamantium_items");
    	
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
                mod.alexndr.simpleores.init.ModItems.onyx_gem.get(), 
                20.0F, 600, and(flag("recycle_gems"), flag("recycle_simpleores"), modLoaded("simpleores")), 
                "recycle_onyx_items");
    } // end registerSimpleOresFusionRecyclingRecipes()
    
    protected void registerNetherrocksFusionRecyclingRecipes(Consumer<FinishedRecipe> consumer)
    {
    	// Argonite recycling
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(mod.alexndr.netherrocks.init.ModItems.argonite_axe.get(),
                        mod.alexndr.netherrocks.init.ModItems.argonite_hoe.get(),
                        mod.alexndr.netherrocks.init.ModItems.argonite_pickaxe.get(),
                        mod.alexndr.netherrocks.init.ModItems.argonite_shovel.get(),
                        mod.alexndr.netherrocks.init.ModItems.argonite_sword.get()), 
                null, 
                Ingredient.of(Items.NETHERRACK), Ingredient.of(Items.QUARTZ), 
                mod.alexndr.netherrocks.init.ModItems.raw_argonite.get(), 
                15.0F, 600, and(flag("recycle_netherrocks"), modLoaded("netherrocks")), 
                "recycle_argonite_items");
        
    	// Ashstone recycling
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(mod.alexndr.netherrocks.init.ModItems.ashstone_axe.get(),
                        mod.alexndr.netherrocks.init.ModItems.ashstone_hoe.get(),
                        mod.alexndr.netherrocks.init.ModItems.ashstone_pickaxe.get(),
                        mod.alexndr.netherrocks.init.ModItems.ashstone_shovel.get(),
                        mod.alexndr.netherrocks.init.ModItems.ashstone_sword.get()), 
                null, 
                Ingredient.of(Items.NETHERRACK), Ingredient.of(Items.QUARTZ), 
                mod.alexndr.netherrocks.init.ModItems.ashstone_gem.get(), 
                15.0F, 600, and(flag("recycle_gems"), flag("recycle_netherrocks"), modLoaded("netherrocks")), 
                "recycle_ashstone_items");
        
    	// Dragonstone recycling
    	// Fyrite recycling
    	// Illumenite recycling
    	// Malachite recycling
    	
    } // end registerNetherrocksFusionRecyclingRecipes()
    
    
    /**
     * Builds an ICondition representing FlagCondition...
     *
     */
    public ICondition flag(String name)
    {
        return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
    }

} // end-class FusionRecipes