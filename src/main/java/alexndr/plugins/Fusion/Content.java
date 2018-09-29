package alexndr.plugins.Fusion;

import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.logger.LogHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	public static boolean use_simpleores = false;
	
	//Tool Materials
	public static ToolMaterial toolSteel;
	public static ToolMaterial toolBronze, toolThyrium, toolSinisite;
	
	//Armor Materials
	public static ArmorMaterial armorSteel;
	public static ArmorMaterial armorBronze, armorThyrium, armorSinisite;
	
	/**
	 * Loads all the Fusion content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		use_simpleores = Loader.isModLoaded("simpleores") && Settings.enableSimpleOres;	
		
		setToolAndArmorStats();
//		ModSupport.setToolAndArmorStats();
		
		try {
			ModItems.configureItems();
			ModBlocks.configureBlocks();
			ModItems.configureTools();
			ModItems.configureArmor();
			if(use_simpleores) {
				ModItems.configureSimpleOresItems();
				ModBlocks.configureSimpleOresBlocks();
				ModItems.configureSimpleOresArmor();
				ModItems.configureSimpleOresTools();
			}
			LogHelper.verbose("Fusion",
					"Content pre-init completed successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Fusion",
					"Content pre-init failed. This is a serious problem!");
			e.printStackTrace();
		}
		
	} // end ()
	
    protected static void setToolAndArmorStats()
    {
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);
		
    	toolSteel = EnumHelper.addToolMaterial("STEEL", Settings.steelTools.getHarvestLevel(), Settings.steelTools.getUses(), 
    											Settings.steelTools.getHarvestSpeed(), Settings.steelTools.getDamageVsEntity(), 
    											Settings.steelTools.getEnchantability());
        armorSteel = EnumHelper.addArmorMaterial("STEEL", "steel",
                        Settings.steelArmor.getDurability(),
                        new int[] { Settings.steelArmor.getBootsReduction(),
                                    Settings.steelArmor.getLegsReduction(),
                                    Settings.steelArmor.getChestReduction(),
                                    Settings.steelArmor.getHelmReduction() },
                        Settings.steelArmor.getEnchantability(), armorNoise, 0.5F);
		setSimpleOresToolAndArmorStats();
    } // end setToolAndArmorStats()

    protected static void setSimpleOresToolAndArmorStats()
    {
		toolBronze = EnumHelper.addToolMaterial("BRONZE",
				Settings.bronzeTools.getHarvestLevel(),
				Settings.bronzeTools.getUses(),
				Settings.bronzeTools.getHarvestSpeed(),
				Settings.bronzeTools.getDamageVsEntity(),
				Settings.bronzeTools.getEnchantability());
		toolThyrium = EnumHelper.addToolMaterial("THYRIUM",
				Settings.thyriumTools.getHarvestLevel(),
				Settings.thyriumTools.getUses(),
				Settings.thyriumTools.getHarvestSpeed(),
				Settings.thyriumTools.getDamageVsEntity(),
				Settings.thyriumTools.getEnchantability());
		toolSinisite = EnumHelper.addToolMaterial("SINISITE",
				Settings.sinisiteTools.getHarvestLevel(),
				Settings.sinisiteTools.getUses(),
				Settings.sinisiteTools.getHarvestSpeed(),
				Settings.sinisiteTools.getDamageVsEntity(),
				Settings.sinisiteTools.getEnchantability());
		
		// armor
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);

		armorBronze = EnumHelper.addArmorMaterial("BRONZE", "bronze",
				Settings.bronzeArmor.getDurability(), new int[] {
                        Settings.bronzeArmor.getBootsReduction(),
                        Settings.bronzeArmor.getLegsReduction(),
                        Settings.bronzeArmor.getChestReduction(),
						Settings.bronzeArmor.getHelmReduction()
						},
				Settings.bronzeArmor.getEnchantability(), armorNoise, 0.0F);
		armorThyrium = EnumHelper.addArmorMaterial("THYRIUM", "thyrium",
				Settings.thyriumArmor.getDurability(), new int[] {
                        Settings.thyriumArmor.getBootsReduction(),
                        Settings.thyriumArmor.getLegsReduction(),
                        Settings.thyriumArmor.getChestReduction(),
						Settings.thyriumArmor.getHelmReduction()
						},
				Settings.thyriumArmor.getEnchantability(), armorNoise, 1.0F );
		armorSinisite = EnumHelper.addArmorMaterial("SINISITE", "sinisite",
				Settings.sinisiteArmor.getDurability(), new int[] {
		                Settings.sinisiteArmor.getBootsReduction(),
                        Settings.sinisiteArmor.getLegsReduction(),
                        Settings.sinisiteArmor.getChestReduction(),
						Settings.sinisiteArmor.getHelmReduction()
						},
				Settings.sinisiteArmor.getEnchantability(), armorNoise, 2.0F );
    } // end setToolAndArmorStats()
  
    
	public static void setRepairMaterials()
	{
		toolSteel.setRepairItem(new ItemStack(ModItems.steel_ingot));
		ArmorMaterialHelper.setRepairItem(armorSteel, new ItemStack(ModItems.steel_ingot));
		setSimpleOresRepairMaterials(); 
	} // end setRepairMaterials()
	
	public static void setSimpleOresRepairMaterials()
	{
		toolBronze.setRepairItem(new ItemStack(ModItems.bronze_ingot));
		toolThyrium.setRepairItem(new ItemStack(ModItems.thyrium_ingot));
		toolSinisite.setRepairItem(new ItemStack(ModItems.sinisite_ingot));
		
		ArmorMaterialHelper.setRepairItem(armorBronze, new ItemStack(ModItems.bronze_ingot));
		ArmorMaterialHelper.setRepairItem(armorThyrium, new ItemStack(ModItems.thyrium_ingot));
		ArmorMaterialHelper.setRepairItem(armorSinisite,new ItemStack(ModItems.sinisite_ingot));
	} // end setSimpleOresRepairMaterials()
	

	/**
	 * Add smelting recipes to GameRegistry.
	 */
	public static void addSmeltingRecipes() 
	{
		//Regular Furnace
		GameRegistry.addSmelting(ModItems.large_steel_chunk, new ItemStack(ModItems.steel_ingot), 0.4F);

		if (Content.use_simpleores) {
			addSimpleOresSmeltingRecipes();
		}		
	} // end addSmeltingRecipes
	
	
	/**
	 * Add SimpleOres smelting recipes to GameRegistry.
	 */
	public static void addSimpleOresSmeltingRecipes() 
	{
		if (! Content.use_simpleores) return;

		GameRegistry.addSmelting(ModItems.large_bronze_chunk, new ItemStack(ModItems.bronze_ingot), 0.3F);
		GameRegistry.addSmelting(ModItems.large_thyrium_chunk, new ItemStack(ModItems.thyrium_ingot), 0.6F);
		GameRegistry.addSmelting(ModItems.large_sinisite_chunk, new ItemStack(ModItems.sinisite_ingot), 1.0F);

	} // end addSimpleOresSmeltingRecipes()
	
	/**
	 * add Fusion smelting recipes
	 */
	public static void addFusionRecipes()
	{
		//Fusion Furnace
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of(Items.COAL),
				new ItemStack(ModItems.small_steel_chunk), 2.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of("gunpowder"), 
				new ItemStack(ModItems.medium_steel_chunk), 4.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of("dustRedstone"), 
				new ItemStack(ModItems.large_steel_chunk), 8.0F);
		if (Content.use_simpleores) {
			addSimpleOresFusionRecipes();
		}
	} // end addFusionRecipes
	
	/**
	 * add Fusion smelting recipes
	 */
	public static void addSimpleOresFusionRecipes()
	{
		if (! Content.use_simpleores) return;
		
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial.of(Items.DYE, 1, 15),
				new ItemStack(ModItems.small_bronze_chunk), 2.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial
						.of("gunpowder"), new ItemStack(
						ModItems.medium_bronze_chunk), 3.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial
						.of("dustRedstone"), new ItemStack(
						ModItems.large_bronze_chunk), 10.0F);

		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
				FusionMaterial.of("ingotAdamantium"), FusionMaterial
						.of("dustRedstone"), new ItemStack(
						ModItems.small_thyrium_chunk), 6.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
				FusionMaterial.of("ingotAdamantium"), FusionMaterial.of(
						"gemLapis"), new ItemStack(
						ModItems.medium_thyrium_chunk), 10.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
				FusionMaterial.of("ingotAdamantium"), FusionMaterial
						.of("dustGlowstone"), new ItemStack(
						ModItems.large_thyrium_chunk), 30.0F);

		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
				FusionMaterial.of("ingotMythril"), FusionMaterial
						.of("dustGlowstone"), new ItemStack(
						ModItems.small_sinisite_chunk), 12.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
				FusionMaterial.of("ingotMythril"), FusionMaterial
						.of(Items.BLAZE_POWDER), new ItemStack(
						ModItems.medium_sinisite_chunk), 20.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
				FusionMaterial.of("ingotMythril"), FusionMaterial
						.of(Items.GHAST_TEAR), new ItemStack(
						ModItems.large_sinisite_chunk), 60.0F);
		
	} // end addSimpleOresFusionRecipes()

//	public static void doCustomFusionRecipes()
//	{
//		// avoid NPE
//		if (Settings.numCustomRecipes == 0 || Settings.customFusionRecipes == null) {
//			return;
//		}
//		for (int ii=0; ii < Settings.customFusionRecipes.length; ii++)
//		{
//			ConfigFusionRecipe r = Settings.customFusionRecipes[ii];
//			ItemStack outStack = new ItemStack(FusionMaterial.of(r.getOutput()).getItem());
//			
//			FusionFurnaceRecipes.addSmelting(FusionMaterial.of(r.getInput1()), 
//										     FusionMaterial.of(r.getInput2()), 
//										     FusionMaterial.of(r.getCatalyst()),
//											 outStack, 1.0F);
//			LogHelper.info(ModInfo.ID, r.getName() + " registered.");
//		} // end-for
//	} // end doCustomFusionRecipes()

	/**
	 * Loads Fusion Achievements.
	 */
//	public static void doAchievements()
//	{
//		fusionAch = new Achievement("achievement.fusionAch", "fusionAch", 9, 7, fusion_furnace, AchievementList.BUILD_FURNACE).setSpecial().registerStat();
//		steelAch = new Achievement("achievement.steelAch", "steelAch", 8, 9, steel_ingot, fusionAch).registerStat();
//		steelChestplateAch = new Achievement("achievement.steelChestplateAch", "steelChestplateAch", 8, 11, steel_chestplate, steelAch).registerStat();
//	}
	
//	public static void doAchievements()
//	{
//		bronzeAch = new Achievement("achievement.bronzeAch", "bronzeAch", 10, 11, bronze_ingot, Content.fusionAch).registerStat();
//		bronzeHelmetAch = new Achievement("achievement.bronzeHelmetAch", "bronzeHelmetAch", 10, 9, bronze_helmet, bronzeAch).registerStat();
//		thyriumAch = new Achievement("achievement.thyriumAch", "thyriumAch", 13, 11, thyrium_ingot, bronzeAch).registerStat();
//		thyriumAxeAch = new Achievement("achievement.thyriumAxeAch", "thyriumAxeAch", 12, 9, thyrium_axe, thyriumAch).registerStat();
//		thyriumBowAch = new Achievement("achievement.thyriumBowAch", "thyriumBowAch", 14, 9, thyrium_bow, thyriumAch).registerStat();
//		sinisiteAch = new Achievement("achievement.sinisiteAch", "sinisiteAch", 16, 11, sinisite_ingot, thyriumAch).setSpecial().registerStat();
//		sinisiteSwordAch = new Achievement("achievement.sinisiteSwordAch", "sinisiteSwordAch", 15, 9, sinisite_sword, sinisiteAch).registerStat();
//		sinisiteBowAch = new Achievement("achievement.sinisiteBowAch", "sinisiteBowAch", 17, 9, sinisite_bow, sinisiteAch).registerStat();
//	}
		
//	public static void setAchievementTriggers()
//	{
//		//Crafting Triggers
//		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.fusion_furnace).getItem(), Content.fusionAch);
//		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.steel_chestplate).getItem(), Content.steelChestplateAch);
//		
//		//Smelting Triggers
//		StatTriggersHelper.addSmeltingTrigger(new ItemStack(Content.steel_ingot).getItem(), Content.steelAch);
//	}
//	public static void setAchievementTriggers()
//	{
//		//Smelting Triggers
//		StatTriggersHelper.addSmeltingTrigger(bronze_ingot, bronzeAch);
//		StatTriggersHelper.addSmeltingTrigger(thyrium_ingot, thyriumAch);
//		StatTriggersHelper.addSmeltingTrigger(sinisite_ingot, sinisiteAch);
//		
//		//Crafting Triggers
//		StatTriggersHelper.addCraftingTrigger(bronze_helmet, bronzeHelmetAch);
//		StatTriggersHelper.addCraftingTrigger(thyrium_axe, thyriumAxeAch);
//		StatTriggersHelper.addCraftingTrigger(thyrium_bow, thyriumBowAch);
//		StatTriggersHelper.addCraftingTrigger(sinisite_sword, sinisiteSwordAch);
//		StatTriggersHelper.addCraftingTrigger(sinisite_bow, sinisiteBowAch);
//	}


} // end class
