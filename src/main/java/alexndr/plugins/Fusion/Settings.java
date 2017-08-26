package alexndr.plugins.Fusion;

import alexndr.api.config.ConfigHelper;
import alexndr.api.config.types.ConfigArmor;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigBow;
import alexndr.api.config.types.ConfigFusionRecipe;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.logger.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{

	private static Configuration settings;

	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		settings = ConfigHelper.GetConfig(event, "AleXndr", ModInfo.ID + ".cfg");

		LogHelper.verbose(ModInfo.ID, "Loading Settings...");
		try {
			settings.load();
			ConfigHelper.createHelpEntry(settings, ModInfo.URL);
			
			configureGeneral();
			configureBlocks();
			configureItems();
			configureTools();
			configureBows();
			configureArmor();
			configureRecipes();
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Settings failed to load correctly. The plugin may not function correctly");
			e.printStackTrace();
		} 
		finally {
            if(settings.hasChanged())
            	settings.save();
			LogHelper.verbose(ModInfo.ID, "Settings loaded successfully");
		}
	} // end createOrLoadSettings()

	/**
	 * completed revised config.
	 */
	public static void configureBlocks()
	{
		// Blocks
		steelBlock = new ConfigBlock("Steel Block", ConfigHelper.CATEGORY_BLOCK).setHardness(7.0F)
						.setResistance(12.0F).setLightValue(0.0F)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		steelBlock.GetConfig(settings);
		
		bronzeBlock = new ConfigBlock("Bronze Block", ConfigHelper.CATEGORY_BLOCK).setHardness(7.0F)
						.setResistance(12.0F).setLightValue(0.0F)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		bronzeBlock.GetConfig(settings);
		
		thyriumBlock = new ConfigBlock("Thyrium Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestTool("pickaxe")
						.setBeaconBase(true);
		thyriumBlock.GetConfig(settings);
		
		sinisiteBlock = new ConfigBlock("Sinisite Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestTool("pickaxe")
						.setBeaconBase(true);
		sinisiteBlock.GetConfig(settings);

		fusionFurnace = new ConfigBlock("Fusion Furnace", "Machines")
						.setHardness(3.5F).setResistance(10.0F)
						.setLightValue(1.0F).setHarvestTool("pickaxe");
		fusionFurnace.GetConfig(settings);
	} // end configBlocks()
	
	/**
	 * completed revised config.
	 */
	public static void configureTools()
	{
		// Tools
		steelTools = new ConfigTool("Steel Tools").setUses(700)
						.setHarvestLevel(2).setHarvestSpeed(7.5F)
						.setDamageVsEntity(3.0F).setEnchantability(24);
		steelTools.GetConfig(settings);
		
		bronzeTools = new ConfigTool("Bronze Tools").setUses(800)
						.setHarvestLevel(2).setHarvestSpeed(9.0F)
						.setDamageVsEntity(2.0F).setEnchantability(7);
		bronzeTools.GetConfig(settings);
		
		thyriumTools = new ConfigTool("Thyrium Tools").setUses(2000)
						.setHarvestLevel(3).setHarvestSpeed(22.0F)
						.setDamageVsEntity(6.0F).setEnchantability(28);
		thyriumTools.GetConfig(settings);
		
		sinisiteTools = new ConfigTool("Sinisite Tools").setUses(4100)
						.setHarvestLevel(5).setHarvestSpeed(18.0F)
						.setDamageVsEntity(8.0F).setEnchantability(11);
		sinisiteTools.GetConfig(settings);
	} // end configureTools()
	
	/**
	 * completed revised config.
	 */
	public static void configureArmor()
	{
		// Armor
		steelArmor = new ConfigArmor("Steel Armor").setDurability(20)
						.setHelmReduction(3).setChestReduction(6)
						.setLegsReduction(5).setBootsReduction(3)
						.setEnchantability(14);
		steelArmor.GetConfig(settings);
		
		bronzeArmor = new ConfigArmor("Bronze Armor").setDurability(16)
						.setHelmReduction(3).setChestReduction(5)
						.setLegsReduction(3).setBootsReduction(1)
						.setEnchantability(7);
		bronzeArmor.GetConfig(settings);

		thyriumArmor = new ConfigArmor("Thyrium Armor").setDurability(39)
						.setHelmReduction(4).setChestReduction(7)
						.setLegsReduction(6).setBootsReduction(3)
						.setEnchantability(28);
		thyriumArmor.GetConfig(settings);

		sinisiteArmor = new ConfigArmor("Sinisite Armor")
						.setDurability(56).setHelmReduction(5)
						.setChestReduction(8).setLegsReduction(6)
						.setBootsReduction(5).setEnchantability(11);
		sinisiteArmor.GetConfig(settings);

	} // end configureArmor()
	
	/**
	 * completed revised config.
	 */
	public static void configureBows()
	{
		thyriumBow = new ConfigBow("Thyrium Bow").setHasDamageModifier(true)
				.setDamageModifier(5.0F).setZoomAmount(0.35F);
		thyriumBow.GetConfig(settings);

		sinisiteBow = new ConfigBow("Sinisite Bow").setHasDamageModifier(true)
				.setDamageModifier(6.0F).setHasKnockback(true).setKnockBackFactor(2);
		sinisiteBow.GetConfig(settings);

	} // end configureBows()
	
	/**
	 * completed revised config.
	 */
	public static void configureItems()
	{
		// Items
		steelIngot = new ConfigItem("Steel Ingot", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(0.4F);
		steelIngot.GetConfig(settings);
		bronzeIngot = new ConfigItem("Bronze Ingot", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(0.4F);
		bronzeIngot.GetConfig(settings);
		thyriumIngot = new ConfigItem("Thyrium Ingot", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(0.4F);
		thyriumIngot.GetConfig(settings);
		sinisiteIngot = new ConfigItem("Sinisite Ingot", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(0.4F);
		sinisiteIngot.GetConfig(settings);
	} // end configureItems()
	
	/**
	 * completed revised config.
	 */
	public static void configureRecipes()
	{
		// Toggles
		customRecipes = settings.getBoolean("EnableCustomRecipes", ConfigHelper.CATEGORY_RECIPE, 
											false, "If true, read custom recipes from config");
		extraChunkRecipes = settings.getBoolean("EnableExtraChunkRecipes", 
												ConfigHelper.CATEGORY_RECIPE, false,
												"If true, enable extra chunk recipes");
		// CUSTOM RECIPES
		if (customRecipes) 
		{
			numCustomRecipes = settings.getInt("NumCustomRecipes", ConfigHelper.CATEGORY_RECIPE, 
												0, 1, 255, "Number of custom recipes listed");
			customFusionRecipes = numCustomRecipes > 0 
					? new ConfigFusionRecipe[numCustomRecipes] 
					: null;
			
			for (int i = 0; i < numCustomRecipes; i++) 
			{
				ConfigFusionRecipe recipe = 
						new ConfigFusionRecipe(ModInfo.ID,ConfigHelper.CATEGORY_RECIPE,i);
				recipe.setInput1("minecraft:cobblestone");
				recipe.setInput2("minecraft:flint");
				recipe.setCatalyst("minecraft:stone");
				recipe.setOutput("minecraft:gravel");
				recipe.GetConfig(settings);
				customFusionRecipes[i] = recipe;
			} // end-for
		} // end-if
		else {
			customFusionRecipes = null;
			numCustomRecipes = 0;
		}
	} // end configureRecipes()
	
	/**
	 * completed revised config.
	 */
public static void configureGeneral()
	{
		enableSimpleOres = settings.getBoolean("EnableSimpleOres", Configuration.CATEGORY_GENERAL,
											    false, "if true, enable Simple Ores alloy recipes");
	} // end configureGeneral()
	
	public static ConfigItem steelIngot, bronzeIngot, thyriumIngot,
			sinisiteIngot;

	public static ConfigBow thyriumBow, sinisiteBow;
	public static ConfigBlock steelBlock, bronzeBlock, thyriumBlock,
			sinisiteBlock;
	public static ConfigBlock fusionFurnace;
	public static ConfigTool steelTools, bronzeTools, thyriumTools,
			sinisiteTools;
	public static ConfigArmor steelArmor, bronzeArmor, thyriumArmor,
			sinisiteArmor;

	public static boolean customRecipes, extraChunkRecipes, updateChecker;
	public static boolean enableSimpleOres;
	public static int numCustomRecipes;
	public static ConfigFusionRecipe [] customFusionRecipes;
} // end Settings class
