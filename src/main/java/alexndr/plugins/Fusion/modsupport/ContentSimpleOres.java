package alexndr.plugins.Fusion.modsupport;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
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
import alexndr.plugins.Fusion.Content;
import alexndr.plugins.Fusion.Fusion;
import alexndr.plugins.Fusion.Settings;

public class ContentSimpleOres 
{
	public static void doArmor()
	{
		bronze_helmet = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("bronze_helmet");
		bronze_chestplate = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("bronze_chestplate");
		bronze_leggings = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("bronze_leggings");
		bronze_boots = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("bronze_boots");
		thyrium_helmet = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("thyrium_helmet");
		thyrium_chestplate = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("thyrium_chestplate");
		thyrium_leggings = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium,EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("thyrium_leggings");
		thyrium_boots = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("thyrium_boots");
		sinisite_helmet = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("sinisite_helmet");
		sinisite_chestplate = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("sinisite_chestplate");
		sinisite_leggings = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("sinisite_leggings");
		sinisite_boots = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("sinisite_boots");
	}
	
	public static void doBlocks()
	{
		bronze_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.bronzeBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("bronze_block").setCreativeTab(TabHelper.decorationsTab());
		thyrium_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.thyriumBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("thyrium_block").setCreativeTab(TabHelper.decorationsTab());
		sinisite_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.sinisiteBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("sinisite_block").setCreativeTab(TabHelper.decorationsTab());
	}
	
	public static void doItems()
	{
		bronze_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.bronzeIngot)
				.setUnlocalizedName("bronze_ingot").setCreativeTab(TabHelper.materialsTab());
		small_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("small_bronze_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		medium_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("medium_bronze_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		large_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("large_bronze_chunk")
				.setCreativeTab(TabHelper.materialsTab());

		thyrium_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("thyrium_ingot")
				.setCreativeTab(TabHelper.materialsTab());
		small_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("small_thyrium_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		medium_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("medium_thyrium_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		large_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("large_thyrium_chunk")
				.setCreativeTab(TabHelper.materialsTab());

		sinisite_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("sinisite_ingot")
				.setCreativeTab(TabHelper.materialsTab());
		small_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("small_sinisite_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		medium_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("medium_sinisite_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		large_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("large_sinisite_chunk")
				.setCreativeTab(TabHelper.materialsTab());

		thyrium_rod = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot)
				.setUnlocalizedName("thyrium_rod").setCreativeTab(TabHelper.materialsTab());
		sinisite_rod = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("sinisite_rod")
				.setCreativeTab(TabHelper.materialsTab());
	} // end doItems()
	
	public static void doTools()
	{
		bronze_pickaxe = new SimplePickaxe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_pickaxe");
		bronze_axe = new SimpleAxe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_axe");
		bronze_shovel = new SimpleShovel(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_shovel");
		bronze_hoe = new SimpleHoe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("bronze_hoe");
		bronze_sword = new SimpleSword(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("bronze_sword");

		thyrium_pickaxe = new SimplePickaxe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_pickaxe");
		thyrium_axe = new SimpleAxe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_axe");
		thyrium_shovel = new SimpleShovel(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_shovel");
		thyrium_hoe = new SimpleHoe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("thyrium_hoe");
		thyrium_sword = new SimpleSword(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("thyrium_sword");

		sinisite_pickaxe = new SimplePickaxe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_pickaxe");
		sinisite_axe = new SimpleAxe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_axe");
		sinisite_shovel = new SimpleShovel(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_shovel");
		sinisite_hoe = new SimpleHoe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("sinisite_hoe");
		sinisite_sword = new SimpleSword(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("sinisite_sword");

		thyrium_bow = new SimpleBow(Fusion.plugin, 900)
				.setEffect(SimpleBowEffects.damageEffect,
						Settings.thyriumBowDamageModifier.asFloat())
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.setZoomAmount(Settings.thyriumBowZoomAmount.asFloat())
				.addToolTip("tips.zoomTooltip")
				.setRepairMaterial(new ItemStack(thyrium_rod))
				.setConfigEntry(Settings.thyriumBow)
				.setUnlocalizedName("thyrium_bow").setCreativeTab(TabHelper.combatTab());
		
		sinisite_bow = new SimpleBow(Fusion.plugin, 1200)
				.setEffect(SimpleBowEffects.damageEffect,
						Settings.sinisiteBowDamageModifier.asFloat())
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.setEffect(SimpleBowEffects.knockbackEffect,
						Settings.sinisiteBowKnockbackAmount.asInt())
				.addToolTip("tips.knockbackTooltip")
				.setRepairMaterial(new ItemStack(sinisite_rod))
				.setConfigEntry(Settings.sinisiteBow)
				.setUnlocalizedName("sinisite_bow").setCreativeTab(TabHelper.combatTab());
	} // doTools()
	
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
