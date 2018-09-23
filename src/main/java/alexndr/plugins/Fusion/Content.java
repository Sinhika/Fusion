package alexndr.plugins.Fusion;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShears;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import alexndr.plugins.Fusion.modsupport.ContentSimpleOres;
import alexndr.plugins.Fusion.modsupport.ModSupport;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;

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
			doItems();
			doBlocks();
			doTools();
			doArmor();
			// doAchievements();
			if(use_simpleores) {
				ContentSimpleOres.doItems();
				ContentSimpleOres.doBlocks();
				ContentSimpleOres.doArmor();
				ContentSimpleOres.doTools();
//				ContentSimpleOres.doAchievements();
			}
			
			// register tile entities
			GameRegistry.registerTileEntity(TileEntityFusionFurnace.class, "fusion_furnace");
			
			LogHelper.verbose("Fusion",
					"Content pre-init completed successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Fusion",
					"Content pre-init failed. This is a serious problem!");
			e.printStackTrace();
		}
		
	} // end ()
	
	/**
	 * Sets the tabs that the blocks/items will be in. Called during Init phase.
	 */
	public static void initialize()
	{
		try {
			setTabs();
			LogHelper.verbose("Fusion",
					"Successfully set tabs for all blocks/items");
		} catch (Exception e) {
			LogHelper.severe("Fusion",
							"Tabs were not successfully set for blocks/items. This is a serious problem!");
			e.printStackTrace();
		}
		if (use_simpleores) {
			ContentSimpleOres.setRepairMaterials(); 
		}
	} // end initialize() 
	
	
	/**
	 * Loads Fusion Achievements.
	 */
//	public static void doAchievements()
//	{
//		fusionAch = new Achievement("achievement.fusionAch", "fusionAch", 9, 7, fusion_furnace, AchievementList.BUILD_FURNACE).setSpecial().registerStat();
//		steelAch = new Achievement("achievement.steelAch", "steelAch", 8, 9, steel_ingot, fusionAch).registerStat();
//		steelChestplateAch = new Achievement("achievement.steelChestplateAch", "steelChestplateAch", 8, 11, steel_chestplate, steelAch).registerStat();
//	}
	
	/**
	 * Sets tabs for Fusion content.
	 */
	public static void setTabs()
	{
		// TODO handle in BlockFusionFurnace class...
		// fusion_furnace.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
	}
	
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
        
		if(use_simpleores) {
			ContentSimpleOres.setToolAndArmorStats();
		}

    } // end setToolAndArmorStats()
    
//	public static void setAchievementTriggers()
//	{
//		//Crafting Triggers
//		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.fusion_furnace).getItem(), Content.fusionAch);
//		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.steel_chestplate).getItem(), Content.steelChestplateAch);
//		
//		//Smelting Triggers
//		StatTriggersHelper.addSmeltingTrigger(new ItemStack(Content.steel_ingot).getItem(), Content.steelAch);
//	}

	public static void setRepairMaterials()
	{
		toolSteel.setRepairItem(new ItemStack(Content.steel_ingot));
		ArmorMaterialHelper.setRepairItem(armorSteel, new ItemStack(Content.steel_ingot));
	}
	
	//Achievements
	// public static Achievement fusionAch, steelAch, steelChestplateAch;
}
