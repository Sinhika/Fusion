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
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.Content;
import alexndr.plugins.Fusion.Fusion;
import alexndr.plugins.Fusion.Settings;

public class ContentSimpleOres 
{
	
	
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
	
	public static void setRepairMaterials()
	{
		toolBronze.setRepairItem(new ItemStack(bronze_ingot));
		toolThyrium.setRepairItem(new ItemStack(thyrium_ingot));
		toolSinisite.setRepairItem(new ItemStack(sinisite_ingot));
		
		ArmorMaterialHelper.setRepairItem(armorBronze, new ItemStack(bronze_ingot));
		ArmorMaterialHelper.setRepairItem(armorThyrium, new ItemStack(thyrium_ingot));
		ArmorMaterialHelper.setRepairItem(armorSinisite,new ItemStack(sinisite_ingot));
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
	
	//Blocks
	
	//Achievements
//	public static Achievement bronzeAch, thyriumAch, sinisiteAch, bronzeHelmetAch, thyriumAxeAch, sinisiteSwordAch, thyriumBowAch, sinisiteBowAch;
	
}
