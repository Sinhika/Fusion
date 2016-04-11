package alexndr.plugins.Fusion;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleBow;
import alexndr.api.content.items.SimpleBowEffects;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.registry.ContentCategories;

public class ContentSimpleOres 
{
	public static void doArmor()
	{
		bronze_helmet = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorBronze, SimpleArmor.Slots.HELM).setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("bronze_helmet");
		bronze_chestplate = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorBronze, SimpleArmor.Slots.CHEST).setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("bronze_chestplate");
		bronze_leggings = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorBronze, SimpleArmor.Slots.LEGS).setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("bronze_leggings");
		bronze_boots = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorBronze, SimpleArmor.Slots.BOOTS).setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("bronze_boots");
		thyrium_helmet = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorThyrium, SimpleArmor.Slots.HELM).setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("thyrium_helmet");
		thyrium_chestplate = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorThyrium, SimpleArmor.Slots.CHEST).setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("thyrium_chestplate");
		thyrium_leggings = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorThyrium, SimpleArmor.Slots.LEGS).setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("thyrium_leggings");
		thyrium_boots = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorThyrium, SimpleArmor.Slots.BOOTS).setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("thyrium_boots");
		sinisite_helmet = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorSinisite, SimpleArmor.Slots.HELM).setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("sinisite_helmet");
		sinisite_chestplate = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorSinisite, SimpleArmor.Slots.CHEST).setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("sinisite_chestplate");
		sinisite_leggings = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorSinisite, SimpleArmor.Slots.LEGS).setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("sinisite_leggings");
		sinisite_boots = new SimpleArmor(Fusion.plugin, ContentSimpleOres.armorSinisite, SimpleArmor.Slots.BOOTS).setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("sinisite_boots");
	}
	
	public static void doBlocks()
	{
		bronze_block = new SimpleBlock(Fusion.plugin, Material.iron, ContentCategories.Block.GENERAL).setConfigEntry(Settings.bronzeBlock).setStepSound(Block.soundTypeMetal).setUnlocalizedName("bronze_block");
		thyrium_block = new SimpleBlock(Fusion.plugin, Material.iron, ContentCategories.Block.GENERAL).setConfigEntry(Settings.thyriumBlock).setStepSound(Block.soundTypeMetal).setUnlocalizedName("thyrium_block");
		sinisite_block = new SimpleBlock(Fusion.plugin, Material.iron, ContentCategories.Block.GENERAL).setConfigEntry(Settings.sinisiteBlock).setStepSound(Block.soundTypeMetal).setUnlocalizedName("sinisite_block");
	}
	
	public static void doItems()
	{
		bronze_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("bronze_ingot");
		small_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("small_bronze_chunk");
		medium_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("medium_bronze_chunk");
		large_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("large_bronze_chunk");
		
		thyrium_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("thyrium_ingot");
		small_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("small_thyrium_chunk");
		medium_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("medium_thyrium_chunk");
		large_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("large_thyrium_chunk");

		sinisite_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("sinisite_ingot");
		small_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("small_sinisite_chunk");
		medium_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("medium_sinisite_chunk");
		large_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("large_sinisite_chunk");

		thyrium_rod = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("thyrium_rod");
		sinisite_rod = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("sinisite_rod");
	}
	
	public static void doTools()
	{
		bronze_pickaxe = new SimplePickaxe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_pickaxe");
		bronze_axe = new SimpleAxe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_axe");
		bronze_shovel = new SimpleShovel(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_shovel");
		bronze_hoe = new SimpleHoe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_hoe");
		bronze_sword = new SimpleSword(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("bronze_sword");

		thyrium_pickaxe = new SimplePickaxe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_pickaxe");
		thyrium_axe = new SimpleAxe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_axe");
		thyrium_shovel = new SimpleShovel(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_shovel");
		thyrium_hoe = new SimpleHoe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_hoe");
		thyrium_sword = new SimpleSword(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("thyrium_sword");

		sinisite_pickaxe = new SimplePickaxe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_pickaxe");
		sinisite_axe = new SimpleAxe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_axe");
		sinisite_shovel = new SimpleShovel(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_shovel");
		sinisite_hoe = new SimpleHoe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_hoe");
		sinisite_sword = new SimpleSword(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("sinisite_sword");

		thyrium_bow = new SimpleBow(Fusion.plugin, 900).setEffect(SimpleBowEffects.damageEffect, Settings.thyriumBowDamageModifier.asFloat())
				.addToolTip("tips.damageTooltip", EnumChatFormatting.GREEN).setZoomAmount(Settings.thyriumBowZoomAmount.asFloat())
				.addToolTip("tips.zoomTooltip").setRepairMaterial(new ItemStack(thyrium_rod)).setConfigEntry(Settings.thyriumBow).setUnlocalizedName("thyrium_bow");
		
		sinisite_bow = new SimpleBow(Fusion.plugin, 1200).setEffect(SimpleBowEffects.damageEffect, Settings.sinisiteBowDamageModifier.asFloat())
				.addToolTip("tips.damageTooltip", EnumChatFormatting.GREEN).setEffect(SimpleBowEffects.knockbackEffect, Settings.sinisiteBowKnockbackAmount.asInt())
				.addToolTip("tips.knockbackTooltip").setRepairMaterial(new ItemStack(sinisite_rod)).setConfigEntry(Settings.sinisiteBow).setUnlocalizedName("sinisite_bow");
	}
	
	public static void doAchievements()
	{
		bronzeAch = new Achievement("achievement.bronzeAch", "bronzeAch", 10, 11, bronze_ingot, Content.fusionAch).registerStat();
		bronzeHelmetAch = new Achievement("achievement.bronzeHelmetAch", "bronzeHelmetAch", 10, 9, bronze_helmet, bronzeAch).registerStat();
		thyriumAch = new Achievement("achievement.thyriumAch", "thyriumAch", 13, 11, thyrium_ingot, bronzeAch).registerStat();
		thyriumAxeAch = new Achievement("achievement.thyriumAxeAch", "thyriumAxeAch", 12, 9, thyrium_axe, thyriumAch).registerStat();
		thyriumBowAch = new Achievement("achievement.thyriumBowAch", "thyriumBowAch", 14, 9, thyrium_bow, thyriumAch).registerStat();
		sinisiteAch = new Achievement("achievement.sinisiteAch", "sinisiteAch", 16, 11, sinisite_ingot, thyriumAch).setSpecial().registerStat();
		sinisiteSwordAch = new Achievement("achievement.sinisiteSwordAch", "sinisiteSwordAch", 15, 9, sinisite_sword, sinisiteAch).registerStat();
		sinisiteBowAch = new Achievement("achievement.sinisiteBowAch", "sinisiteBowAch", 17, 9, sinisite_bow, sinisiteAch).registerStat();
	}
	
	public static void setRepairMaterials()
	{
		toolBronze.setRepairItem(new ItemStack(bronze_ingot));
		toolThyrium.setRepairItem(new ItemStack(thyrium_ingot));
		toolSinisite.setRepairItem(new ItemStack(sinisite_ingot));
		
		armorBronze.customCraftingMaterial = bronze_ingot;
		armorThyrium.customCraftingMaterial = thyrium_ingot;
		armorSinisite.customCraftingMaterial = sinisite_ingot;
	}
	
	public static void setToolAndArmorStats()
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
    	
		armorBronze = EnumHelper.addArmorMaterial("BRONZE", "bronze",
				Settings.bronzeArmor.getDurability(), new int[] {
						Settings.bronzeArmor.getHelmReduction(),
						Settings.bronzeArmor.getChestReduction(),
						Settings.bronzeArmor.getLegsReduction(),
						Settings.bronzeArmor.getBootsReduction() },
				Settings.bronzeArmor.getEnchantability());
		armorThyrium = EnumHelper.addArmorMaterial("THYRIUM", "thyrium",
				Settings.thyriumArmor.getDurability(), new int[] {
						Settings.thyriumArmor.getHelmReduction(),
						Settings.thyriumArmor.getChestReduction(),
						Settings.thyriumArmor.getLegsReduction(),
						Settings.thyriumArmor.getBootsReduction() },
				Settings.thyriumArmor.getEnchantability());
		armorSinisite = EnumHelper.addArmorMaterial("SINISITE", "sinisite",
				Settings.sinisiteArmor.getDurability(), new int[] {
						Settings.sinisiteArmor.getHelmReduction(),
						Settings.sinisiteArmor.getChestReduction(),
						Settings.sinisiteArmor.getLegsReduction(),
						Settings.sinisiteArmor.getBootsReduction() },
				Settings.sinisiteArmor.getEnchantability());
	}
	
	public static void setAchievementTriggers()
	{
		//Smelting Triggers
		StatTriggersHelper.addSmeltingTrigger(bronze_ingot, bronzeAch);
		StatTriggersHelper.addSmeltingTrigger(thyrium_ingot, thyriumAch);
		StatTriggersHelper.addSmeltingTrigger(sinisite_ingot, sinisiteAch);
		
		//Crafting Triggers
		StatTriggersHelper.addCraftingTrigger(bronze_helmet, bronzeHelmetAch);
		StatTriggersHelper.addCraftingTrigger(thyrium_axe, thyriumAxeAch);
		StatTriggersHelper.addCraftingTrigger(thyrium_bow, thyriumBowAch);
		StatTriggersHelper.addCraftingTrigger(sinisite_sword, sinisiteSwordAch);
		StatTriggersHelper.addCraftingTrigger(sinisite_bow, sinisiteBowAch);
	}
	
	//Blocks
	public static Block bronze_block, thyrium_block, sinisite_block;
	
	//Items
	public static Item bronze_ingot, sinisite_ingot, thyrium_ingot, thyrium_rod, sinisite_rod;
	public static Item small_bronze_chunk, small_thyrium_chunk, small_sinisite_chunk;
	public static Item medium_bronze_chunk, medium_thyrium_chunk, medium_sinisite_chunk;
	public static Item large_bronze_chunk, large_thyrium_chunk, large_sinisite_chunk;
	
	//Tools
	public static Item bronze_pickaxe, thyrium_pickaxe, sinisite_pickaxe;
	public static Item bronze_axe, thyrium_axe, sinisite_axe;
	public static Item bronze_shovel, thyrium_shovel, sinisite_shovel;
	public static Item bronze_sword, thyrium_sword, sinisite_sword;
	public static Item bronze_hoe, thyrium_hoe, sinisite_hoe;
	public static Item thyrium_bow, sinisite_bow;
	
	//Armor
	public static Item bronze_helmet, thyrium_helmet, sinisite_helmet;
	public static Item bronze_chestplate, thyrium_chestplate, sinisite_chestplate;
	public static Item bronze_leggings, thyrium_leggings, sinisite_leggings;
	public static Item bronze_boots, thyrium_boots, sinisite_boots;
	
	//Achievements
	public static Achievement bronzeAch, thyriumAch, sinisiteAch, bronzeHelmetAch, thyriumAxeAch, sinisiteSwordAch, thyriumBowAch, sinisiteBowAch;
	
	//Tool Materials
	public static ToolMaterial toolBronze, toolThyrium, toolSinisite;
	
	//Armor Materials
	public static ArmorMaterial armorBronze, armorThyrium, armorSinisite;
}
