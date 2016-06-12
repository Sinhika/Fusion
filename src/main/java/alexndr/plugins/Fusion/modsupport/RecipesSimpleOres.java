package alexndr.plugins.Fusion.modsupport;

import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import alexndr.plugins.Fusion.Settings;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipesSimpleOres 
{
	@SuppressWarnings("unused")
	private static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	public static void doOreDictRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre("ingotBronze", new ItemStack(ContentSimpleOres.bronze_ingot));
		OreDictionary.registerOre("ingotThyrium", new ItemStack(ContentSimpleOres.thyrium_ingot));
		OreDictionary.registerOre("ingotSinisite", new ItemStack(ContentSimpleOres.sinisite_ingot));
		OreDictionary.registerOre("blockBronze", new ItemStack(ContentSimpleOres.bronze_block));
		OreDictionary.registerOre("blockThyrium", new ItemStack(ContentSimpleOres.thyrium_block));
		OreDictionary.registerOre("blockSinisite", new ItemStack(ContentSimpleOres.sinisite_block));
	}
	
	public static void doRecipes()
	{	
		//Block Recipes
			//Storage Content
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotThyrium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotSinisite"}));
			
		//Item Recipes
			//Ingot Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.bronze_ingot, 9), new Object[] { 
				ContentSimpleOres.bronze_block });
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.thyrium_ingot, 9), new Object[] { 
				ContentSimpleOres.thyrium_block });
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.sinisite_ingot, 9), new Object[] { 
				ContentSimpleOres.sinisite_block });
			
			//Bronze Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_bronze_chunk, 1), new Object[] { 
				ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk });
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_bronze_chunk, 1), new Object[] { 
				ContentSimpleOres.medium_bronze_chunk, ContentSimpleOres.medium_bronze_chunk, ContentSimpleOres.medium_bronze_chunk });
			
			//Thyrium Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_thyrium_chunk, 1), new Object[] { 
				ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk });
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_thyrium_chunk, 1), new Object[] { 
				ContentSimpleOres.medium_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk });
			
			//Sinisite Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_sinisite_chunk, 1), new Object[] { 
				ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk });
			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_sinisite_chunk, 1), new Object[] { 
				ContentSimpleOres.medium_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk });
			
			//Extra Chunk Recipes
			if(Settings.extraChunkRecipes.asBoolean())
			{
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_bronze_chunk, 1), new Object[] { 
					ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.medium_bronze_chunk, ContentSimpleOres.medium_bronze_chunk });
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_bronze_chunk, 1), new Object[] { 
					ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_bronze_chunk, 2), new Object[] { 
					ContentSimpleOres.large_bronze_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.small_bronze_chunk, 2), new Object[] { 
					ContentSimpleOres.medium_bronze_chunk});
				
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_thyrium_chunk, 1), new Object[] { 
					ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk });
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_thyrium_chunk, 1), new Object[] { 
					ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_thyrium_chunk, 2), new Object[] { 
					ContentSimpleOres.large_thyrium_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.small_thyrium_chunk, 2), new Object[] { 
					ContentSimpleOres.medium_thyrium_chunk});
				
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_sinisite_chunk, 1), new Object[] { 
					ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk });
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_sinisite_chunk, 1), new Object[] { 
					ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_sinisite_chunk, 2), new Object[] { 
					ContentSimpleOres.large_sinisite_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.small_sinisite_chunk, 2), new Object[] { 
					ContentSimpleOres.medium_sinisite_chunk});
			}
			
			//Rods
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_rod, true, new Object[]{
				"X", "X", Character.valueOf('X'), "ingotThyrium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_rod, true, new Object[]{
				"X", "X", Character.valueOf('X'), "ingotSinisite"}));
			
		//Tool Recipes
			//Bronze Tool Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			
			//Thyrium Tool Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			
			//Sinisite Tool Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			
			//Bow Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_bow, true, new Object[]{
				" XY", "Z Y", " XY", Character.valueOf('X'), ContentSimpleOres.thyrium_rod, Character.valueOf('Y'), "string", Character.valueOf('Z'), "ingotGold"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_bow, true, new Object[]{
				" XY", "Z Y", " XY", Character.valueOf('X'), ContentSimpleOres.sinisite_rod, Character.valueOf('Y'), "string", Character.valueOf('Z'), "gemOnyx"}));
			
		//Armour Recipes
			//Bronze Armour Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotBronze"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotBronze"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotBronze"}));
			
			//Thyrium Armour Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotThyrium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotThyrium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotThyrium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotThyrium"}));
			
			//Sinisite Armour Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotSinisite"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotSinisite"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotSinisite"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotSinisite"}));
			
		//Smelting Recipes
			//Fusion Furnace
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial.of(Items.DYE, 1,
						15),
				new ItemStack(ContentSimpleOres.small_bronze_chunk), 2.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial
						.of("gunpowder"), new ItemStack(
						ContentSimpleOres.medium_bronze_chunk), 3.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial
						.of("dustRedstone"), new ItemStack(
						ContentSimpleOres.large_bronze_chunk), 10.0F);

		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
				FusionMaterial.of("ingotAdamantium"), FusionMaterial
						.of("dustRedstone"), new ItemStack(
						ContentSimpleOres.small_thyrium_chunk), 6.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
				FusionMaterial.of("ingotAdamantium"), FusionMaterial.of(
						"gemLapis"), new ItemStack(
						ContentSimpleOres.medium_thyrium_chunk), 10.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
				FusionMaterial.of("ingotAdamantium"), FusionMaterial
						.of("dustGlowstone"), new ItemStack(
						ContentSimpleOres.large_thyrium_chunk), 30.0F);

		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
				FusionMaterial.of("ingotMythril"), FusionMaterial
						.of("dustGlowstone"), new ItemStack(
						ContentSimpleOres.small_sinisite_chunk), 12.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
				FusionMaterial.of("ingotMythril"), FusionMaterial
						.of(Items.BLAZE_POWDER), new ItemStack(
						ContentSimpleOres.medium_sinisite_chunk), 20.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
				FusionMaterial.of("ingotMythril"), FusionMaterial
						.of(Items.GHAST_TEAR), new ItemStack(
						ContentSimpleOres.large_sinisite_chunk), 60.0F);

		    //Regular Furnace
			GameRegistry.addSmelting(ContentSimpleOres.large_bronze_chunk, new ItemStack(ContentSimpleOres.bronze_ingot), 0.3F);
			GameRegistry.addSmelting(ContentSimpleOres.large_thyrium_chunk, new ItemStack(ContentSimpleOres.thyrium_ingot), 0.6F);
			GameRegistry.addSmelting(ContentSimpleOres.large_sinisite_chunk, new ItemStack(ContentSimpleOres.sinisite_ingot), 1.0F);
	}
}
