package alexndr.plugins.Fusion;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import alexndr.api.config.types.ConfigFusionRecipe;
import alexndr.api.logger.LogHelper;
import alexndr.plugins.Fusion.modsupport.ModSupport;

/**
 * @author AleXndrTheGr8st
 */
public class Recipes 
{
	@SuppressWarnings("unused")
	private static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	public static void preInitialize()
	{
		try {
			doOreDictEntries();
			ModSupport.doOreDictEntries();
			LogHelper.verbose("Fusion",
					"All OreDictionary entries were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Fusion",
							"OreDictionary entries were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize
	
	public static void initialize()
	{
		try {
			doRecipes();
			ModSupport.doRecipes();
			LogHelper.verbose("Fusion", "All recipes were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Fusion",
							"Recipes were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end initialize
	
	public static void postInitialize()
	{
		try {
			if (Settings.customRecipes == true) {
				doCustomFusionRecipes();
			}
		}
		catch (Exception e) {
			LogHelper.severe("Fusion",
					"Custom recipes were not added successfully. This is a problem!");
			e.printStackTrace();
		}
	} // end postInitialzie()
	
	public static void doOreDictEntries()
	{
		OreDictionary.registerOre("ingotSteel", new ItemStack(Content.steel_ingot));
		OreDictionary.registerOre("blockSteel", new ItemStack(Content.steel_block));
	}
	
	public static void doRecipes()
	{	
		//Block Recipes
		//Special Furnace Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.fusion_furnace, true, new Object[]{
				"XWX", "ZYZ", "XWX", Character.valueOf('X'), Blocks.BRICK_BLOCK, 
				Character.valueOf('Y'), Blocks.FURNACE, 
				Character.valueOf('W'), Items.COAL, 
				Character.valueOf('Z'), "ingotIron"}));


		//Storage Blocks
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotSteel"}));

		//Item Recipes
		//Ingot Recipes
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Content.steel_ingot, 9), 
				new Object[]{"blockSteel"}));

		//Steel Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(Content.large_steel_chunk), new Object[]{
			Content.small_steel_chunk, Content.small_steel_chunk, Content.small_steel_chunk, Content.small_steel_chunk, Content.small_steel_chunk});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.large_steel_chunk), new Object[]{
			Content.medium_steel_chunk, Content.medium_steel_chunk, Content.medium_steel_chunk});

		//Extra Chunk Recipes
		if(Settings.extraChunkRecipes)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_steel_chunk), new Object[]{
				Content.small_steel_chunk, Content.small_steel_chunk, Content.medium_steel_chunk, Content.medium_steel_chunk});
			GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_steel_chunk), new Object[]{
				Content.small_steel_chunk, Content.small_steel_chunk, Content.small_steel_chunk});
			GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_steel_chunk, 2), new Object[]{
				Content.large_steel_chunk});
			GameRegistry.addShapelessRecipe(new ItemStack(Content.small_steel_chunk, 2), new Object[]{
				Content.medium_steel_chunk});
		}

		//Tools Recipes
		//Steel Tools
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_shears, false,
				new Object[] { " Y", "Y ", Character.valueOf('Y'), "ingotSteel" }));

		//Armor Recipes
		//Steel Armor
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(Content.steel_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotSteel"}));

		//Smelting Recipes
		//Fusion Furnace
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of(Items.COAL),
				new ItemStack(Content.small_steel_chunk), 2.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial
				.of("gunpowder"), new ItemStack(
						Content.medium_steel_chunk), 4.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial
				.of("dustRedstone"), new ItemStack(
						Content.large_steel_chunk), 8.0F);
		
		//Regular Furnace
		GameRegistry.addSmelting(Content.large_steel_chunk, new ItemStack(Content.steel_ingot), 0.4F);
	} // end doRecipes
	
	private static void doCustomFusionRecipes()
	{
		// avoid NPE
		if (Settings.numCustomRecipes == 0 || Settings.customFusionRecipes == null) {
			return;
		}
		for (int ii=0; ii < Settings.customFusionRecipes.length; ii++)
		{
			ConfigFusionRecipe r = Settings.customFusionRecipes[ii];
			ItemStack outStack = new ItemStack(FusionMaterial.of(r.getOutput()).getItem());
			
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of(r.getInput1()), 
										     FusionMaterial.of(r.getInput2()), 
										     FusionMaterial.of(r.getCatalyst()),
											 outStack, 1.0F);
			LogHelper.info(ModInfo.ID, r.getName() + " registered.");
		} // end-for
	} // end doCustomFusionRecipes()
} // end class Recipes
