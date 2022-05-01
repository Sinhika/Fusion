package mod.alexndr.fusion.datagen;

import java.util.function.Consumer;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.fusion.init.ModTags;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
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
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
        registerAestheticRecipes(consumer);
    } // end registerRecipes()

    protected void registerToolRecipes(Consumer<FinishedRecipe> consumer)
    {
    	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.bronze_ingot.get()), "bronze", 
    			has(ModItems.bronze_ingot.get()), flag("bronze_tools"), false);
    	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.steel_ingot.get()), "steel", 
    			has(ModItems.steel_ingot.get()), flag("steel_tools"), true);
    	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.sinisite_ingot.get()), "sinisite", 
    			has(ModItems.sinisite_ingot.get()), flag("sinisite_tools"), false);
    	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.thyrium_ingot.get()), "thyrium", 
    			has(ModItems.thyrium_ingot.get()), flag("thyrium_tools"), false);
    } // end registerToolRecipes()

    protected void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.bronze_ingot.get()), "bronze", 
    			has(ModItems.bronze_ingot.get()), flag("bronze_armor"));
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.steel_ingot.get()), "steel", 
    			has(ModItems.steel_ingot.get()), flag("steel_armor"));
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.sinisite_ingot.get()), "sinisite", 
    			has(ModItems.sinisite_ingot.get()), flag("sinisite_armor"));
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.thyrium_ingot.get()), "thyrium", 
    			has(ModItems.thyrium_ingot.get()), flag("thyrium_armor"));
    } // end registerArmorRecipes()

    protected void registerStorageRecipes(Consumer<FinishedRecipe> consumer)
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

    
    protected void registerAestheticRecipes(Consumer<FinishedRecipe> consumer)
    {
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.bronze_ingot.get()), "bronze", 
 			has(ModItems.bronze_ingot.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.steel_ingot.get()), "steel", 
 			has(ModItems.steel_ingot.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.sinisite_ingot.get()), "sinisite", 
 			has(ModItems.sinisite_ingot.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.thyrium_ingot.get()), "thyrium", 
 			has(ModItems.thyrium_ingot.get()), flag("aesthetics_enabled"));
    } // end registerAestheticRecipes()
    
    
    
    protected void registerMiscRecipes(Consumer<FinishedRecipe> consumer)
    {
    	// fusion furnace
    	ShapedRecipeBuilder.shaped(ModBlocks.fusion_furnace.get())
    		.define('W', ItemTags.COALS)
    		.define('X', Blocks.BRICKS)
    		.define('Y', Blocks.FURNACE)
    		.define('Z', Items.IRON_INGOT)
    		.pattern("XWX")
    		.pattern("ZYZ")
    		.pattern("XWX")
    		.unlockedBy("has_item", has(Blocks.FURNACE))
    		.save(consumer);
    	
    	// fusion bows
    	setbuilder.buildModBowRecipe(consumer, new ResourceLocation(Fusion.MODID, "sinisite_bow"), 
    			Ingredient.of(ModItems.sinisite_ingot.get()), ModItems.sinisite_rod.get(), Ingredient.of(ModTags.Items.GEMS_ONYX), 
    			has(Items.STRING), flag("fusion_bows"));
    	setbuilder.buildModBowRecipe(consumer, new ResourceLocation(Fusion.MODID, "thyrium_bow"), 
    			Ingredient.of(ModItems.thyrium_ingot.get()), ModItems.thyrium_rod.get(), Ingredient.of(Items.GOLD_INGOT), 
    			has(Items.STRING), flag("fusion_bows"));
    	
    } // end registerMiscRecipes()

    
    protected void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
    	// chunk to ingot smelting/blasting
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_bronze_chunk.get()),
                ModItems.bronze_ingot.get(), has(ModItems.large_bronze_chunk.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_steel_chunk.get()),
                ModItems.steel_ingot.get(), has(ModItems.large_steel_chunk.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_sinisite_chunk.get()),
                ModItems.sinisite_ingot.get(), has(ModItems.large_sinisite_chunk.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_thyrium_chunk.get()),
                ModItems.thyrium_ingot.get(), has(ModItems.large_thyrium_chunk.get()), 0.4F, 200);
        
        // vanilla recycling
        setbuilder.buildVanillaRecyclingRecipes(consumer, 
        		Ingredient.of(ModItems.bronze_axe.get(), ModItems.bronze_boots.get(), ModItems.bronze_chestplate.get(),
        					  ModItems.bronze_helmet.get(), ModItems.bronze_hoe.get(), ModItems.bronze_leggings.get(),
        					  ModItems.bronze_pickaxe.get(), ModItems.bronze_shovel.get(), ModItems.bronze_sword.get()), 
        		ModItems.bronze_nugget.get(), has(ModItems.bronze_axe.get()), 0.2F, 200);
        setbuilder.buildVanillaRecyclingRecipes(consumer, 
        		Ingredient.of(ModItems.steel_axe.get(), ModItems.steel_boots.get(), ModItems.steel_chestplate.get(),
        					  ModItems.steel_helmet.get(), ModItems.steel_hoe.get(), ModItems.steel_leggings.get(),
        					  ModItems.steel_pickaxe.get(), ModItems.steel_shovel.get(), ModItems.steel_sword.get()), 
        		ModItems.steel_nugget.get(), has(ModItems.steel_axe.get()), 0.2F, 200);
        setbuilder.buildVanillaRecyclingRecipes(consumer, 
        		Ingredient.of(ModItems.sinisite_axe.get(), ModItems.sinisite_boots.get(), ModItems.sinisite_chestplate.get(),
        					  ModItems.sinisite_helmet.get(), ModItems.sinisite_hoe.get(), ModItems.sinisite_leggings.get(),
        					  ModItems.sinisite_pickaxe.get(), ModItems.sinisite_shovel.get(), ModItems.sinisite_sword.get()), 
        		ModItems.sinisite_nugget.get(), has(ModItems.sinisite_axe.get()), 0.2F, 200);
        setbuilder.buildVanillaRecyclingRecipes(consumer, 
        		Ingredient.of(ModItems.thyrium_axe.get(), ModItems.thyrium_boots.get(), ModItems.thyrium_chestplate.get(),
        					  ModItems.thyrium_helmet.get(), ModItems.thyrium_hoe.get(), ModItems.thyrium_leggings.get(),
        					  ModItems.thyrium_pickaxe.get(), ModItems.thyrium_shovel.get(), ModItems.thyrium_sword.get()), 
        		ModItems.thyrium_nugget.get(), has(ModItems.thyrium_axe.get()), 0.2F, 200);
    } // end registerFurnaceRecipes()

    
    @Override
    public ICondition flag(String name)
    {
        return impl_flag(Fusion.MODID, FusionConfig.INSTANCE, name);
    }

} // end subclass FusionDataGenerator$Recipes.