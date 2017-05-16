package alexndr.plugins.Fusion;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import alexndr.api.config.ConfigHelper;
import alexndr.api.config.types.ConfigArmor;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigBow;
import alexndr.api.config.types.ConfigEntry;
import alexndr.api.config.types.ConfigFusionRecipe;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.logger.LogHelper;
import alexndr.plugins.SimpleOres.ModInfo;

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

	public static void configureBlocks()
	{
		// Blocks
		steelBlock = settings.get(
				new ConfigBlock("Steel Block", "Blocks").setHardness(7.0F)
						.setResistance(12.0F).setLightValue(0.0F)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true)).asConfigBlock();
		bronzeBlock = settings.get(
				new ConfigBlock("Bronze Block", "Blocks").setHardness(7.0F)
						.setResistance(12.0F).setLightValue(0.0F)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true)).asConfigBlock();
		thyriumBlock = settings.get(
				new ConfigBlock("Thyrium Block", "Blocks")
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestTool("pickaxe")
						.setBeaconBase(true)).asConfigBlock();
		sinisiteBlock = settings.get(
				new ConfigBlock("Sinisite Block", "Blocks")
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestTool("pickaxe")
						.setBeaconBase(true)).asConfigBlock();

		fusionFurnace = settings.get(
				new ConfigBlock("Fusion Furnace", "Machines")
						.setHardness(3.5F).setResistance(10.0F)
						.setLightValue(1.0F).setHarvestTool("pickaxe")
						.setCreativeTab("SimpleMachines")).asConfigBlock();

		
	}
	
	public static void configureTools()
	{
		// Tools
		steelTools = settings.get(
				new ConfigTool("Steel Tools", "Tools").setUses(700)
						.setHarvestLevel(2).setHarvestSpeed(7.5F)
						.setDamageVsEntity(3.0F).setEnchantability(24))
				.asConfigTool();
		bronzeTools = settings.get(
				new ConfigTool("Bronze Tools", "Tools").setUses(800)
						.setHarvestLevel(2).setHarvestSpeed(9.0F)
						.setDamageVsEntity(2.0F).setEnchantability(7))
				.asConfigTool();
		thyriumTools = settings.get(
				new ConfigTool("Thyrium Tools", "Tools").setUses(2000)
						.setHarvestLevel(3).setHarvestSpeed(22.0F)
						.setDamageVsEntity(6.0F).setEnchantability(28))
				.asConfigTool();
		sinisiteTools = settings.get(
				new ConfigTool("Sinisite Tools", "Tools").setUses(4100)
						.setHarvestLevel(5).setHarvestSpeed(18.0F)
						.setDamageVsEntity(8.0F).setEnchantability(11))
				.asConfigTool();

	
	}
	
	public static void configureArmor()
	{
		// Armor
		steelArmor = settings.get(
				new ConfigArmor("Steel Armor", "Armor").setDurability(20)
						.setHelmReduction(3).setChestReduction(6)
						.setLegsReduction(5).setBootsReduction(3)
						.setEnchantability(14)).asConfigArmor();
		bronzeArmor = settings.get(
				new ConfigArmor("Bronze Armor", "Armor").setDurability(16)
						.setHelmReduction(3).setChestReduction(5)
						.setLegsReduction(3).setBootsReduction(1)
						.setEnchantability(7)).asConfigArmor();
		thyriumArmor = settings.get(
				new ConfigArmor("Thyrium Armor", "Armor").setDurability(39)
						.setHelmReduction(4).setChestReduction(7)
						.setLegsReduction(6).setBootsReduction(3)
						.setEnchantability(28)).asConfigArmor();
		sinisiteArmor = settings.get(
				new ConfigArmor("Sinisite Armor", "Armor")
						.setDurability(56).setHelmReduction(5)
						.setChestReduction(8).setLegsReduction(6)
						.setBootsReduction(5).setEnchantability(11))
				.asConfigArmor();
	
	}
	
	public static void configureBows()
	{
		thyriumBow = settings.get(new ConfigEntry("Thyrium Bow", "Bows"));
		thyriumBow.createNewValue("DamageModifier").setDataType("@F")
				.setCurrentValue("5.0").setDefaultValue("5.0");
		thyriumBow.createNewValue("ZoomAmount").setDataType("@F")
				.setCurrentValue("0.35").setDefaultValue("0.35");
		thyriumBowDamageModifier = thyriumBow
				.getValueByName("DamageModifier");
		thyriumBowZoomAmount = thyriumBow.getValueByName("ZoomAmount");

		sinisiteBow = settings.get(new ConfigEntry("Sinisite Bow", "Bows"));
		// .setComment("The damage multiplier of the Sinisite Bow (versus vanilla bow).").setCommentIndentNumber(2);
		sinisiteBow.createNewValue("DamageModifier").setDataType("@F")
				.setCurrentValue("6.0").setDefaultValue("6.0");
		// .setComment("The knockback level of the Sinisite Bow.").setCommentIndentNumber(2);
		sinisiteBow.createNewValue("KnockbackAmount").setDataType("@I")
				.setCurrentValue("2").setDefaultValue("2");
		sinisiteBowDamageModifier = sinisiteBow
				.getValueByName("DamageModifier");
		sinisiteBowKnockbackAmount = sinisiteBow
				.getValueByName("KnockbackAmount");

	}
	
	public static void configureItems()
	{
		// Items
		steelIngot = new ConfigItem("Steel Ingot", "Items").setSmeltingXP(0.4F);
		bronzeIngot = new ConfigItem("Bronze Ingot", "Items").setSmeltingXP(0.4F);
		thyriumIngot = new ConfigItem("Thyrium Ingot", "Items").setSmeltingXP(0.4F);
		sinisiteIngot = new ConfigItem("Sinisite Ingot", "Items").setSmeltingXP(0.4F);
	}
	
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
