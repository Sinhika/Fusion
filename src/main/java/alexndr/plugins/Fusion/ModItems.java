package alexndr.plugins.Fusion;

import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleBow;
import alexndr.api.content.items.SimpleBowEffects;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShears;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.modsupport.ContentSimpleOres;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems 
{
	//Armor
	public static SimpleArmor steel_helmet;
	public static SimpleArmor steel_chestplate;
	public static SimpleArmor steel_leggings;
	public static SimpleArmor steel_boots;
	
	// SimpleOres Armor
	public static SimpleArmor bronze_helmet;
	public static SimpleArmor thyrium_helmet;
	public static SimpleArmor sinisite_helmet;
	public static SimpleArmor bronze_chestplate, thyrium_chestplate, sinisite_chestplate;
	public static SimpleArmor bronze_leggings, thyrium_leggings, sinisite_leggings;
	public static SimpleArmor bronze_boots, thyrium_boots, sinisite_boots;
	
	//Items
	public static SimpleItem steel_ingot;
	public static SimpleItem small_steel_chunk;
	public static SimpleItem medium_steel_chunk;
	public static SimpleItem large_steel_chunk;
	
	// SimpleOres Items
	public static SimpleItem bronze_ingot, sinisite_ingot, thyrium_ingot, thyrium_rod, sinisite_rod;
	public static SimpleItem small_bronze_chunk, small_thyrium_chunk, small_sinisite_chunk;
	public static SimpleItem medium_bronze_chunk, medium_thyrium_chunk, medium_sinisite_chunk;
	public static SimpleItem large_bronze_chunk, large_thyrium_chunk, large_sinisite_chunk;
	
	//Tools
	public static SimplePickaxe steel_pickaxe;
	public static SimpleAxe steel_axe;
	public static SimpleShovel steel_shovel;
	public static SimpleSword steel_sword;
	public static SimpleHoe steel_hoe;
	public static SimpleShears steel_shears;

	// SimpleOres Tools
	public static SimplePickaxe bronze_pickaxe, thyrium_pickaxe, sinisite_pickaxe;
	public static SimpleAxe bronze_axe, thyrium_axe, sinisite_axe;
	public static SimpleShovel bronze_shovel, thyrium_shovel, sinisite_shovel;
	public static SimpleSword bronze_sword, thyrium_sword, sinisite_sword;
	public static SimpleHoe bronze_hoe, thyrium_hoe, sinisite_hoe;
	
	public static SimpleBow thyrium_bow, sinisite_bow;
	
	/**
	 * Loads Fusion Items.
	 */
	public static void doItems()
	{
		steel_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.steelIngot)
				.setUnlocalizedName("steel_ingot").setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		small_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.steelIngot).setUnlocalizedName("small_steel_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		medium_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.steelIngot).setUnlocalizedName("medium_steel_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		large_steel_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.steelIngot).setUnlocalizedName("large_steel_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}

	/**
	 * Loads Fusion Armor.
	 */
	public static void doArmor()
	{
		steel_helmet = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("steel_helmet");
		steel_chestplate = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.CHEST).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("steel_chestplate");
		steel_leggings = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("steel_leggings");
		steel_boots = new SimpleArmor(Fusion.plugin, Content.armorSteel,
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.steelArmor)
				.setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("steel_boots");
	} // end doArmor()

	/**
	 * Loads Fusion Tools.
	 */
	public static void doTools()
	{
		steel_pickaxe = new SimplePickaxe(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("steel_pickaxe");
		steel_axe = new SimpleAxe(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("steel_axe");
		steel_shovel = new SimpleShovel(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("steel_shovel");
		steel_hoe = new SimpleHoe(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("steel_hoe");
		steel_sword = new SimpleSword(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin)).setUnlocalizedName("steel_sword");
		steel_shears = new SimpleShears(Fusion.plugin, toolSteel).setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("steel_shears");
	}
	
	public static void doItems()
	{
		bronze_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.bronzeIngot)
				.setUnlocalizedName("bronze_ingot").setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		small_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("small_bronze_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		medium_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("medium_bronze_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		large_bronze_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.bronzeIngot).setUnlocalizedName("large_bronze_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));

		thyrium_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("thyrium_ingot")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		small_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("small_thyrium_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		medium_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("medium_thyrium_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		large_thyrium_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.thyriumIngot).setUnlocalizedName("large_thyrium_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));

		sinisite_ingot = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("sinisite_ingot")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		small_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("small_sinisite_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		medium_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("medium_sinisite_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		large_sinisite_chunk = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("large_sinisite_chunk")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));

		thyrium_rod = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.thyriumIngot)
				.setUnlocalizedName("thyrium_rod").setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		sinisite_rod = new SimpleItem(Fusion.plugin, ContentCategories.Item.INGOT)
				.setConfigEntry(Settings.sinisiteIngot).setUnlocalizedName("sinisite_rod")
				.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	} // end doItems()
	
	public static void doTools()
	{
		bronze_pickaxe = new SimplePickaxe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("bronze_pickaxe");
		bronze_axe = new SimpleAxe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("bronze_axe");
		bronze_shovel = new SimpleShovel(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("bronze_shovel");
		bronze_hoe = new SimpleHoe(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("bronze_hoe");
		bronze_sword = new SimpleSword(Fusion.plugin, toolBronze).setConfigEntry(Settings.bronzeTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin)).setUnlocalizedName("bronze_sword");

		thyrium_pickaxe = new SimplePickaxe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("thyrium_pickaxe");
		thyrium_axe = new SimpleAxe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("thyrium_axe");
		thyrium_shovel = new SimpleShovel(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("thyrium_shovel");
		thyrium_hoe = new SimpleHoe(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("thyrium_hoe");
		thyrium_sword = new SimpleSword(Fusion.plugin, toolThyrium).setConfigEntry(Settings.thyriumTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin)).setUnlocalizedName("thyrium_sword");

		sinisite_pickaxe = new SimplePickaxe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("sinisite_pickaxe");
		sinisite_axe = new SimpleAxe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("sinisite_axe");
		sinisite_shovel = new SimpleShovel(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("sinisite_shovel");
		sinisite_hoe = new SimpleHoe(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin)).setUnlocalizedName("sinisite_hoe");
		sinisite_sword = new SimpleSword(Fusion.plugin, toolSinisite).setConfigEntry(Settings.sinisiteTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin)).setUnlocalizedName("sinisite_sword");

		thyrium_bow = new SimpleBow(Fusion.plugin, 900)
				.setEffect(SimpleBowEffects.damageEffect, Settings.thyriumBow.getDamageModifier())
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.setZoomAmount(Settings.thyriumBow.getZoomAmount())
				.addToolTip("tips.zoomTooltip")
				.setRepairMaterial(new ItemStack(thyrium_rod))
				.setConfigEntry(Settings.thyriumBow)
				.setUnlocalizedName("thyrium_bow")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		
		sinisite_bow = new SimpleBow(Fusion.plugin, 1200)
				.setEffect(SimpleBowEffects.damageEffect, Settings.sinisiteBow.getDamageModifier())
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.setEffect(SimpleBowEffects.knockbackEffect, Settings.sinisiteBow.getKnockBackFactor())
				.addToolTip("tips.knockbackTooltip")
				.setRepairMaterial(new ItemStack(sinisite_rod))
				.setConfigEntry(Settings.sinisiteBow)
				.setUnlocalizedName("sinisite_bow")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	} // doTools()
	
	public static void doArmor()
	{
		bronze_helmet = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("bronze_helmet");
		bronze_chestplate = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("bronze_chestplate");
		bronze_leggings = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("bronze_leggings");
		bronze_boots = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorBronze, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.bronzeArmor).setType("bronze")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("bronze_boots");
		thyrium_helmet = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("thyrium_helmet");
		thyrium_chestplate = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("thyrium_chestplate");
		thyrium_leggings = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium,EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("thyrium_leggings");
		thyrium_boots = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorThyrium, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.thyriumArmor).setType("thyrium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("thyrium_boots");
		sinisite_helmet = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("sinisite_helmet");
		sinisite_chestplate = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("sinisite_chestplate");
		sinisite_leggings = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("sinisite_leggings");
		sinisite_boots = new SimpleArmor(Fusion.plugin,
				ContentSimpleOres.armorSinisite, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.sinisiteArmor).setType("sinisite")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("sinisite_boots");
	}
	
	/**
	 * register Items with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void register(IForgeRegistry<Item> registry) 
	{
	} // end register()

	/**
	 * register Item models with Forge.
	 */
	public static void registerModels() 
	{
	} // end registerModels()

	/**
	 * register ingots and suchlike with the ore dictionary.
	 */
	public static void registerOreDictionary()
	{
		OreDictionary.registerOre("ingotSteel", new ItemStack(steel_ingot));
		if (Content.use_simpleores) {
			OreDictionary.registerOre("ingotBronze", new ItemStack(bronze_ingot));
			OreDictionary.registerOre("ingotThyrium", new ItemStack(thyrium_ingot));
			OreDictionary.registerOre("ingotSinisite", new ItemStack(sinisite_ingot));
		}
	} // end registerOreDictionary()

} // end-class ModItems
