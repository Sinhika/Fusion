package alexndr.plugins.Fusion.modsupport;

public class RecipesSimpleOres 
{
	public static void doRecipes()
	{	
		//Block Recipes
			//Storage Content
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_block, true, new Object[]{
//				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_block, true, new Object[]{
//				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotThyrium"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_block, true, new Object[]{
//				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotSinisite"}));
//			
//		//Item Recipes
//			//Ingot Recipes
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.bronze_ingot, 9), new Object[] { 
//				ContentSimpleOres.bronze_block });
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.thyrium_ingot, 9), new Object[] { 
//				ContentSimpleOres.thyrium_block });
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.sinisite_ingot, 9), new Object[] { 
//				ContentSimpleOres.sinisite_block });
//			
//			//Bronze Ingot
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_bronze_chunk, 1), new Object[] { 
//				ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk });
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_bronze_chunk, 1), new Object[] { 
//				ContentSimpleOres.medium_bronze_chunk, ContentSimpleOres.medium_bronze_chunk, ContentSimpleOres.medium_bronze_chunk });
//			
//			//Thyrium Ingot
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_thyrium_chunk, 1), new Object[] { 
//				ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk });
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_thyrium_chunk, 1), new Object[] { 
//				ContentSimpleOres.medium_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk });
//			
//			//Sinisite Ingot
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_sinisite_chunk, 1), new Object[] { 
//				ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk });
//			GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_sinisite_chunk, 1), new Object[] { 
//				ContentSimpleOres.medium_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk });
//			
//			//Extra Chunk Recipes
//			if(Settings.extraChunkRecipes)
//			{
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_bronze_chunk, 1), new Object[] { 
//					ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.medium_bronze_chunk, ContentSimpleOres.medium_bronze_chunk });
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_bronze_chunk, 1), new Object[] { 
//					ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk, ContentSimpleOres.small_bronze_chunk});
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_bronze_chunk, 2), new Object[] { 
//					ContentSimpleOres.large_bronze_chunk});
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.small_bronze_chunk, 2), new Object[] { 
//					ContentSimpleOres.medium_bronze_chunk});
//				
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_thyrium_chunk, 1), new Object[] { 
//					ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk, ContentSimpleOres.medium_thyrium_chunk });
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_thyrium_chunk, 1), new Object[] { 
//					ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk, ContentSimpleOres.small_thyrium_chunk});
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_thyrium_chunk, 2), new Object[] { 
//					ContentSimpleOres.large_thyrium_chunk});
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.small_thyrium_chunk, 2), new Object[] { 
//					ContentSimpleOres.medium_thyrium_chunk});
//				
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.large_sinisite_chunk, 1), new Object[] { 
//					ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk, ContentSimpleOres.medium_sinisite_chunk });
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_sinisite_chunk, 1), new Object[] { 
//					ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk, ContentSimpleOres.small_sinisite_chunk});
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.medium_sinisite_chunk, 2), new Object[] { 
//					ContentSimpleOres.large_sinisite_chunk});
//				GameRegistry.addShapelessRecipe(new ItemStack(ContentSimpleOres.small_sinisite_chunk, 2), new Object[] { 
//					ContentSimpleOres.medium_sinisite_chunk});
//			}
//			
//			//Rods
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_rod, true, new Object[]{
//				"X", "X", Character.valueOf('X'), "ingotThyrium"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_rod, true, new Object[]{
//				"X", "X", Character.valueOf('X'), "ingotSinisite"}));
//			
//		//Tool Recipes
//			//Bronze Tool Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_pickaxe, true, new Object[]{
//				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_axe, true, new Object[]{
//				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_shovel, true, new Object[]{
//				"X", "Y", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_sword, true, new Object[]{
//				"X", "X", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_hoe, true, new Object[]{
//				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
//			
//			//Thyrium Tool Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_pickaxe, true, new Object[]{
//				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_axe, true, new Object[]{
//				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_shovel, true, new Object[]{
//				"X", "Y", "Y", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_sword, true, new Object[]{
//				"X", "X", "Y", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_hoe, true, new Object[]{
//				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
//			
//			//Sinisite Tool Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_pickaxe, true, new Object[]{
//				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_axe, true, new Object[]{
//				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_shovel, true, new Object[]{
//				"X", "Y", "Y", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_sword, true, new Object[]{
//				"X", "X", "Y", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_hoe, true, new Object[]{
//				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
//			
//			//Bow Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_bow, true, new Object[]{
//				" XY", "Z Y", " XY", Character.valueOf('X'), ContentSimpleOres.thyrium_rod, Character.valueOf('Y'), "string", Character.valueOf('Z'), "ingotGold"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_bow, true, new Object[]{
//				" XY", "Z Y", " XY", Character.valueOf('X'), ContentSimpleOres.sinisite_rod, Character.valueOf('Y'), "string", Character.valueOf('Z'), "gemOnyx"}));
//			
//		//Armour Recipes
//			//Bronze Armour Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_helmet, true, new Object[]{
//				"XXX", "X X", Character.valueOf('X'), "ingotBronze"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_chestplate, true, new Object[]{
//				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_leggings, true, new Object[]{
//				"XXX", "X X", "X X", Character.valueOf('X'), "ingotBronze"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.bronze_boots, true, new Object[]{
//				"X X", "X X", Character.valueOf('X'), "ingotBronze"}));
//			
//			//Thyrium Armour Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_helmet, true, new Object[]{
//				"XXX", "X X", Character.valueOf('X'), "ingotThyrium"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_chestplate, true, new Object[]{
//				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotThyrium"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_leggings, true, new Object[]{
//				"XXX", "X X", "X X", Character.valueOf('X'), "ingotThyrium"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.thyrium_boots, true, new Object[]{
//				"X X", "X X", Character.valueOf('X'), "ingotThyrium"}));
//			
//			//Sinisite Armour Recipes
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_helmet, true, new Object[]{
//				"XXX", "X X", Character.valueOf('X'), "ingotSinisite"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_chestplate, true, new Object[]{
//				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotSinisite"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_leggings, true, new Object[]{
//				"XXX", "X X", "X X", Character.valueOf('X'), "ingotSinisite"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(ContentSimpleOres.sinisite_boots, true, new Object[]{
//				"X X", "X X", Character.valueOf('X'), "ingotSinisite"}));
			
	}
} // end class
