package alexndr.plugins.Fusion;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
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
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	private static boolean simpleores = Loader.isModLoaded("simpleores") && Settings.enableSimpleOres.asBoolean();
	@SuppressWarnings("unused")
	private static boolean netherrocks = Loader.isModLoaded("netherrocks") && Settings.enableNetherrocks.asBoolean();
	
	/**
	 * Loads all the Fusion content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		try {
			doItems();
			LogHelper.verbose("Fusion", "All items were added successfully");
		} catch (Exception e) {
			LogHelper.severe("Fusion",
							"Items were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doBlocks();
			LogHelper.verbose("Fusion", "All blocks were added successfully");
		} catch (Exception e) {
			LogHelper.severe("Fusion",
							"Blocks were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doTools();
			LogHelper.verbose("Fusion", "All tools were added successfully");
		} catch (Exception e) {
			LogHelper.severe("Fusion",
							"Tools were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doArmor();
			LogHelper.verbose("Fusion", "All armor was added successfully");
		} catch (Exception e) {
			LogHelper.severe("Fusion",
							"Armor was not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doAchievements();
			LogHelper.verbose("Fusion",
					"All achievements were added successfully");
		} catch (Exception e) {
			LogHelper.severe("Fusion",
							"Achievements were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		
		// register tile entities
		GameRegistry.registerTileEntity(TileEntityFusionFurnace.class, "fusion_furnace");
		
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
		steel_helmet = new SimpleArmor(Fusion.plugin, Fusion.armorSteel, SimpleArmor.Slots.HELM).setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("steel_helmet");
		steel_chestplate = new SimpleArmor(Fusion.plugin, Fusion.armorSteel, SimpleArmor.Slots.CHEST).setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("steel_chestplate");
		steel_leggings = new SimpleArmor(Fusion.plugin, Fusion.armorSteel, SimpleArmor.Slots.LEGS).setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("steel_leggings");
		steel_boots = new SimpleArmor(Fusion.plugin, Fusion.armorSteel, SimpleArmor.Slots.BOOTS).setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("steel_boots");
		
		if(simpleores) ContentSimpleOres.doArmor();
	}
	
	/**
	 * Loads Fusion Blocks.
	 */
	public static void doBlocks()
	{
		fusion_furnace = new BlockFusionFurnace(false).setConfigEntry(Settings.fusionFurnace).setUnlocalizedName("fusion_furnace");
		fusion_furnace_lit = new BlockFusionFurnace(true).setConfigEntry(Settings.fusionFurnace).setUnlocalizedName("fusion_furnace_lit");
		steel_block = new SimpleBlock(Fusion.plugin, Material.iron, ContentCategories.Block.GENERAL).setConfigEntry(Settings.steelBlock).setStepSound(Block.soundTypeMetal).setUnlocalizedName("steel_block");

		if(simpleores) ContentSimpleOres.doBlocks();
	}
	
	/**
	 * Loads Fusion Tools.
	 */
	public static void doItems()
	{
		steel_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.steelIngot).setUnlocalizedName("steel_ingot");
		small_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.steelIngot).setUnlocalizedName("small_steel_chunk");
		medium_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.steelIngot).setUnlocalizedName("medium_steel_chunk");
		large_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.steelIngot).setUnlocalizedName("large_steel_chunk");
		
		if(simpleores) ContentSimpleOres.doItems();
	}
	
	/**
	 * Loads Fusion Armor.
	 */
	public static void doTools()
	{
		steel_pickaxe = new SimplePickaxe(Fusion.plugin, Fusion.toolSteel).setConfigEntry(Settings.steelTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_pickaxe");
		steel_axe = new SimpleAxe(Fusion.plugin, Fusion.toolSteel).setConfigEntry(Settings.steelTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_axe");
		steel_shovel = new SimpleShovel(Fusion.plugin, Fusion.toolSteel).setConfigEntry(Settings.steelTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_shovel");
		steel_hoe = new SimpleHoe(Fusion.plugin, Fusion.toolSteel).setConfigEntry(Settings.steelTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_hoe");
		steel_sword = new SimpleSword(Fusion.plugin, Fusion.toolSteel).setConfigEntry(Settings.steelTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("steel_sword");
		steel_shears = new SimpleShears(Fusion.plugin, Fusion.toolSteel).setConfigEntry(Settings.steelTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("steel_shears");
		
		if(simpleores) ContentSimpleOres.doTools();
	}
	
	/**
	 * Loads Fusion Achievements.
	 */
	public static void doAchievements()
	{
		fusionAch = new Achievement("achievement.fusionAch", "fusionAch", 9, 7, fusion_furnace, AchievementList.buildFurnace).setSpecial().registerStat();
		steelAch = new Achievement("achievement.steelAch", "steelAch", 8, 9, steel_ingot, fusionAch).registerStat();
		steelChestplateAch = new Achievement("achievement.steelChestplateAch", "steelChestplateAch", 8, 11, steel_chestplate, steelAch).registerStat();

		if(simpleores)
			ContentSimpleOres.doAchievements();
	}
	
	/**
	 * Sets tabs for Fusion content.
	 */
	public static void setTabs()
	{
		// TODO handle in BlockFusionFurnace class...
		// fusion_furnace.setCreativeTab(TabHelper.decorationsTab());
	}
	
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
