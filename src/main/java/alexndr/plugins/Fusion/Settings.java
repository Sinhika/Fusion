package alexndr.plugins.Fusion;

import java.io.File;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import alexndr.api.config.Configuration;
import alexndr.api.config.types.ConfigArmor;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigEntry;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.config.types.ConfigValue;
import alexndr.api.logger.LogHelper;

public class Settings {

	private static Configuration settings = new Configuration();
	
	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		settings.setModName("Fusion");
		File settingsFile = new File(event.getModConfigurationDirectory() + "/AleXndr", "FusionSettings.xml");
		settings.setFile(settingsFile);
		
		LogHelper.verbose("Fusion","Loading Settings...");
		try {
			settings.load();
			
			//Config Help
			ConfigEntry link = new ConfigEntry("Documentation", "ConfigHelp");
			link.createNewValue("DocumentationLink").setActive().setDataType("@S").setCurrentValue("https://github.com/AleXndrTheGr8st/SimpleCore/wiki/Using-The-Config").setDefaultValue("");
			link = settings.get(link);
			
			ConfigEntry dataTypes = new ConfigEntry("Data Types", "ConfigHelp");
			dataTypes.createNewValue("ABOUT").setActive().setDataType("@S").setCurrentValue("It is important that the correct data types are used. They are designated by the @ symbol.").setDefaultValue("");
			dataTypes.createNewValue("Boolean").setActive().setDataType("@B").setCurrentValue("Accepts: true, false.").setDefaultValue("");
			dataTypes.createNewValue("Integer").setActive().setDataType("@I").setCurrentValue("Accepts: Whole numbers only, such as 2 or 4096.").setDefaultValue("");
			dataTypes.createNewValue("Float").setActive().setDataType("@F").setCurrentValue("Accepts: Decimal numbers, such as 1.5 or 98.9.").setDefaultValue("");
			dataTypes.createNewValue("Double").setActive().setDataType("@D").setCurrentValue("Accepts: Decimal numbers, such as 1.5 or 98.9.").setDefaultValue("");
			dataTypes.createNewValue("String").setActive().setDataType("@S").setCurrentValue("Accepts: Any number or character, such as abcdefg or 9dsa29213mn#.").setDefaultValue("");
			dataTypes = settings.get(dataTypes);
			
			//Toggles
			ConfigEntry toggles = new ConfigEntry("Fusion Toggles", "Toggles");
			// .setComment("(NYI) Allows custom Fusion Furnace recipes").setCommentIndentNumber(2)
			toggles.createNewValue("EnableCustomRecipes").setCurrentValue("false").setDefaultValue("false");
			// .setComment("Enables extra chunk-combining recipes.").setCommentIndentNumber(0)
			toggles.createNewValue("EnableExtraChunkRecipes").setCurrentValue("false").setDefaultValue("false");
			toggles = settings.get(toggles);
			customRecipes = toggles.getValueByName("EnableCustomRecipes");
			extraChunkRecipes = toggles.getValueByName("EnableExtraChunkRecipes");
			
			ConfigEntry contentToggles = new ConfigEntry("Content Toggles", "Toggles");
			// .setComment("Enables SimpleOres-based content.")
			contentToggles.createNewValue("EnableSimpleOres").setCurrentValue("true").setDefaultValue("true");
			// .setComment("Enables Netherrocks-based content.")
			contentToggles.createNewValue("EnableNetherrocks").setCurrentValue("true").setDefaultValue("true");
			contentToggles = settings.get(contentToggles);
			enableSimpleOres = contentToggles.getValueByName("EnableSimpleOres");
			enableNetherrocks = contentToggles.getValueByName("EnableNetherrocks");
				
			//Items
			steelIngot = settings.get(new ConfigItem("Steel Ingot", "Items").setStackSize(64)
					.setCreativeTab("SimpleMaterials").setSmeltingXP(0.4F)).asConfigItem();
			bronzeIngot = settings.get(new ConfigItem("Bronze Ingot", "Items").setStackSize(64)
					.setCreativeTab("SimpleMaterials").setSmeltingXP(0.4F)).asConfigItem();
			thyriumIngot = settings.get(new ConfigItem("Thyrium Ingot", "Items").setStackSize(64)
					.setCreativeTab("SimpleMaterials").setSmeltingXP(0.4F)).asConfigItem();
			sinisiteIngot = settings.get(new ConfigItem("Sinisite Ingot", "Items").setStackSize(64)
					.setCreativeTab("SimpleMaterials").setSmeltingXP(0.4F)).asConfigItem();

			//Blocks
			steelBlock = settings.get(new ConfigBlock("Steel Block", "Blocks").setHardness(7.0F).setResistance(12.0F)
									 .setLightValue(0.0F).setHarvestTool("pickaxe")).asConfigBlock();
			bronzeBlock = settings.get(new ConfigBlock("Bronze Block", "Blocks").setHardness(7.0F).setResistance(12.0F)
										.setLightValue(0.0F).setHarvestTool("pickaxe")).asConfigBlock();
			thyriumBlock = settings.get(new ConfigBlock("Thyrium Block", "Blocks").setHardness(7.0F).setResistance(12.0F)
										.setLightValue(0.0F).setHarvestTool("pickaxe")).asConfigBlock();
			sinisiteBlock = settings.get(new ConfigBlock("Sinisite Block", "Blocks").setHardness(7.0F).setResistance(12.0F)
										.setLightValue(0.0F).setHarvestTool("pickaxe")).asConfigBlock();
			
			fusionFurnace = settings.get(new ConfigBlock("Fusion Furnace", "Machines").setHardness(3.5F).setResistance(10.0F)
										.setLightValue(1.0F).setHarvestTool("pickaxe")).asConfigBlock();
			
			//Tools
			steelTools = settings.get(new ConfigTool("Steel Tools", "Tools").setUses(700).setHarvestLevel(2)
									  .setHarvestSpeed(7.5F).setDamageVsEntity(3.0F).setEnchantability(24)).asConfigTool();
			bronzeTools = settings.get(new ConfigTool("Bronze Tools", "Tools").setUses(800).setHarvestLevel(2)
										.setHarvestSpeed(9.0F).setDamageVsEntity(2.0F).setEnchantability(7)).asConfigTool();
			thyriumTools = settings.get(new ConfigTool("Thyrium Tools", "Tools").setUses(2000).setHarvestLevel(3)
										.setHarvestSpeed(22.0F).setDamageVsEntity(6.0F).setEnchantability(28)).asConfigTool();
			sinisiteTools = settings.get(new ConfigTool("Sinisite Tools", "Tools").setUses(4100).setHarvestLevel(5)
										.setHarvestSpeed(18.0F).setDamageVsEntity(8.0F).setEnchantability(11)).asConfigTool();
			
			thyriumBow = settings.get(new ConfigEntry("Thyrium Bow", "Tools"));
			// 	.setComment("The damage multiplier of the Thyrium Bow (versus vanilla bow).").setCommentIndentNumber(2);
			thyriumBow.createNewValue("DamageModifier").setDataType("@F").setCurrentValue("5.0").setDefaultValue("5.0");
			// .setMinimumValue("0.0").setMaximumValue("32000").setComment("The zoom amount of the Thyrium Bow.");
			thyriumBow.createNewValue("ZoomAmount").setDataType("@F").setCurrentValue("0.35").setDefaultValue("0.35");
			thyriumBow = settings.get(thyriumBow);
			thyriumBowDamageModifier = thyriumBow.getValueByName("DamageModifier");
			thyriumBowZoomAmount = thyriumBow.getValueByName("ZoomAmount");
			
			sinisiteBow = settings.get(new ConfigEntry("Sinisite Bow", "Tools"));
			//	.setComment("The damage multiplier of the Sinisite Bow (versus vanilla bow).").setCommentIndentNumber(2);
			sinisiteBow.createNewValue("DamageModifier").setDataType("@F").setCurrentValue("6.0").setDefaultValue("6.0");
			// .setComment("The knockback level of the Sinisite Bow.").setCommentIndentNumber(2);
			sinisiteBow.createNewValue("KnockbackAmount").setDataType("@F").setCurrentValue("2").setDefaultValue("2");
			sinisiteBow = settings.get(sinisiteBow);
			sinisiteBowDamageModifier = sinisiteBow.getValueByName("DamageModifier");
			sinisiteBowKnockbackAmount = sinisiteBow.getValueByName("ZoomAmount");
			
			//Armor
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
			
			/*
			if(customRecipes.asBoolean()) {
				ConfigEntry customRecipeConfig = settings.add(new ConfigGeneric("Recipe Config", "CustomRecipes"));
					ConfigValue numCustomRecipes = customRecipeConfig.createNewValue("NumCustomRecipes").setCurrentValue("1").setDefaultValue("1").setMinimumValue("0").setMaximumValue("32000").setComment("The number of custom recipes to add.");
				
				for(int i = 0; i < numCustomRecipes.asInteger(); i++) {
					ConfigEntry recipe = settings.add(new ConfigGeneric("Custom Recipe #" + (i + 1), "CustomRecipes"));
						recipe.createNewValue("Input1").setCurrentValue("minecraft:dirt");
						recipe.createNewValue("Input2").setCurrentValue("minecraft:diamond");
						recipe.createNewValue("Catalyst").setCurrentValue("minecraft:stone");
						recipe.createNewValue("Output").setCurrentValue("minecraft:diamond_block");
				}
			}
			*/
			
		} catch(Exception e) {
			LogHelper.severe("Fusion", "Settings failed to load correctly. The plugin may not function correctly");
			e.printStackTrace();
		} finally {
			settings.save();
			LogHelper.verbose("Fusion", "Settings loaded successfully");
		}
	} // end ()
	public static ConfigItem steelIngot, bronzeIngot, thyriumIngot, sinisiteIngot;
	
	public static ConfigEntry thyriumBow, sinisiteBow;
	public static ConfigBlock steelBlock, bronzeBlock, thyriumBlock, sinisiteBlock;
	public static ConfigBlock fusionFurnace;
	public static ConfigTool steelTools, bronzeTools, thyriumTools, sinisiteTools;
	public static ConfigArmor steelArmor, bronzeArmor, thyriumArmor, sinisiteArmor;
	
	public static ConfigValue customRecipes, extraChunkRecipes, updateChecker;
	public static ConfigValue enableSimpleOres, enableNetherrocks;
	public static ConfigValue thyriumBowDamageModifier, thyriumBowZoomAmount, 
							  sinisiteBowDamageModifier, sinisiteBowKnockbackAmount;
}
