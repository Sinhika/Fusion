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
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import alexndr.plugins.Fusion.modsupport.ModSupport;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	/**
	 * Loads all the Fusion content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		setToolAndArmorStats();
		ModSupport.setToolAndArmorStats();
		
		try {
			doItems();
			doBlocks();
			doTools();
			doArmor();
			doAchievements();
			ModSupport.ContentPreInit();
			
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
	}
	
	/**
	 * Loads Fusion Items.
	 */
	public static void doArmor()
	{
		steel_helmet = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("steel_helmet");
		steel_chestplate = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.CHEST).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("steel_chestplate");
		steel_leggings = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("steel_leggings");
		steel_boots = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("steel_boots");
	} // end doArmor()
	
	/**
	 * Loads Fusion Blocks.
	 */
	public static void doBlocks()
	{
		fusion_furnace = new BlockFusionFurnace(false).setConfigEntry(
				Settings.fusionFurnace).setUnlocalizedName("fusion_furnace");
		fusion_furnace_lit = new BlockFusionFurnace(true).setConfigEntry(
				Settings.fusionFurnace)
				.setUnlocalizedName("fusion_furnace_lit");
		steel_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.steelBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("steel_block").setCreativeTab(TabHelper.decorationsTab());
	}
	
	/**
	 * Loads Fusion Tools.
	 */
	public static void doItems()
	{
		steel_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.steelIngot)
				.setUnlocalizedName("steel_ingot").setCreativeTab(TabHelper.materialsTab());
		small_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.steelIngot).setUnlocalizedName("small_steel_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		medium_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.steelIngot).setUnlocalizedName("medium_steel_chunk")
				.setCreativeTab(TabHelper.materialsTab());
		large_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.steelIngot).setUnlocalizedName("large_steel_chunk")
				.setCreativeTab(TabHelper.materialsTab());
	}
	
	/**
	 * Loads Fusion Armor.
	 */
	public static void doTools()
	{
		steel_pickaxe = new SimplePickaxe(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_pickaxe");
		steel_axe = new SimpleAxe(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_axe");
		steel_shovel = new SimpleShovel(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_shovel");
		steel_hoe = new SimpleHoe(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_hoe");
		steel_sword = new SimpleSword(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("steel_sword");
		steel_shears = new SimpleShears(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_shears");
	}
	
	/**
	 * Loads Fusion Achievements.
	 */
	public static void doAchievements()
	{
		fusionAch = new Achievement("achievement.fusionAch", "fusionAch", 9, 7, fusion_furnace, AchievementList.BUILD_FURNACE).setSpecial().registerStat();
		steelAch = new Achievement("achievement.steelAch", "steelAch", 8, 9, steel_ingot, fusionAch).registerStat();
		steelChestplateAch = new Achievement("achievement.steelChestplateAch", "steelChestplateAch", 8, 11, steel_chestplate, steelAch).registerStat();
	}
	
	/**
	 * Sets tabs for Fusion content.
	 */
	public static void setTabs()
	{
		// TODO handle in BlockFusionFurnace class...
		// fusion_furnace.setCreativeTab(TabHelper.decorationsTab());
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
    } // end setToolAndArmorStats()
    
	public static void setAchievementTriggers()
	{
		//Crafting Triggers
		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.fusion_furnace).getItem(), Content.fusionAch);
		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.steel_chestplate).getItem(), Content.steelChestplateAch);
		
		//Smelting Triggers
		StatTriggersHelper.addSmeltingTrigger(new ItemStack(Content.steel_ingot).getItem(), Content.steelAch);
	}

	public static void setRepairMaterials()
	{
		toolSteel.setRepairItem(new ItemStack(Content.steel_ingot));
		armorSteel.customCraftingMaterial = Content.steel_ingot;
	}
	
	//Tool Materials
	public static ToolMaterial toolSteel;
	
	//Armor Materials
	public static ArmorMaterial armorSteel;
	
	//Armor
	public static Item steel_helmet;
	public static Item steel_chestplate;
	public static Item steel_leggings;
	public static Item steel_boots;
	
	//Blocks
	public static Block steel_block;
	public static Block fusion_furnace, fusion_furnace_lit;
	
	//Items
	public static Item steel_ingot;
	public static Item small_steel_chunk;
	public static Item medium_steel_chunk;
	public static Item large_steel_chunk;
	
	//Tools
	public static Item steel_pickaxe;
	public static Item steel_axe;
	public static Item steel_shovel;
	public static Item steel_sword;
	public static Item steel_hoe;
	public static Item steel_shears;
	
	//Achievements
	public static Achievement fusionAch, steelAch, steelChestplateAch;
}
