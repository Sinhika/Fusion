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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems 
{
	//Armor
	public static SimpleArmor steel_helmet =
			new SimpleArmor("steel_helmet", Fusion.plugin, Content.armorSteel, EntityEquipmentSlot.HEAD);
	public static SimpleArmor steel_chestplate =
			new SimpleArmor("steel_chestplate", Fusion.plugin, Content.armorSteel, EntityEquipmentSlot.CHEST);
	public static SimpleArmor steel_leggings =
			new SimpleArmor("steel_leggings", Fusion.plugin, Content.armorSteel, EntityEquipmentSlot.LEGS);
	public static SimpleArmor steel_boots =
			new SimpleArmor("steel_boots", Fusion.plugin, Content.armorSteel, EntityEquipmentSlot.FEET);
	
	// SimpleOres Armor
	public static SimpleArmor bronze_helmet =
			new SimpleArmor("bronze_helmet", Fusion.plugin, Content.armorBronze, EntityEquipmentSlot.HEAD);
	public static SimpleArmor bronze_chestplate =
			new SimpleArmor("bronze_chestplate", Fusion.plugin, Content.armorBronze, EntityEquipmentSlot.CHEST);
	public static SimpleArmor bronze_leggings =
			new SimpleArmor("bronze_leggings", Fusion.plugin, Content.armorBronze, EntityEquipmentSlot.LEGS);
	public static SimpleArmor bronze_boots =
			new SimpleArmor("bronze_boots", Fusion.plugin, Content.armorBronze, EntityEquipmentSlot.FEET);

	public static SimpleArmor thyrium_helmet =
			new SimpleArmor("thyrium_helmet", Fusion.plugin, Content.armorThyrium, EntityEquipmentSlot.HEAD);
	public static SimpleArmor thyrium_chestplate =
			new SimpleArmor("thyrium_chestplate", Fusion.plugin, Content.armorThyrium, EntityEquipmentSlot.CHEST);
	public static SimpleArmor thyrium_leggings =
			new SimpleArmor("thyrium_leggings", Fusion.plugin, Content.armorThyrium, EntityEquipmentSlot.LEGS);
	public static SimpleArmor thyrium_boots =
			new SimpleArmor("thyrium_boots", Fusion.plugin, Content.armorThyrium, EntityEquipmentSlot.FEET);

	public static SimpleArmor sinisite_helmet =
			new SimpleArmor("sinisite_helmet", Fusion.plugin, Content.armorSinisite, EntityEquipmentSlot.HEAD);
	public static SimpleArmor sinisite_chestplate =
			new SimpleArmor("sinisite_chestplate", Fusion.plugin, Content.armorSinisite, EntityEquipmentSlot.CHEST);
	public static SimpleArmor sinisite_leggings =
			new SimpleArmor("sinisite_leggings", Fusion.plugin, Content.armorSinisite, EntityEquipmentSlot.LEGS);
	public static SimpleArmor sinisite_boots =
			new SimpleArmor("sinisite_boots", Fusion.plugin, Content.armorSinisite, EntityEquipmentSlot.FEET);
	
	//Items
	public static SimpleItem steel_ingot = new SimpleItem("steel_ingot", Fusion.plugin);
	public static SimpleItem small_steel_chunk = new SimpleItem("small_steel_chunk", Fusion.plugin);
	public static SimpleItem medium_steel_chunk = new SimpleItem("medium_steel_chunk", Fusion.plugin);
	public static SimpleItem large_steel_chunk = new SimpleItem("large_steel_chunk", Fusion.plugin );
	
	// SimpleOres Items
	public static SimpleItem bronze_ingot = new SimpleItem("bronze_ingot", Fusion.plugin);
	public static SimpleItem small_bronze_chunk = new SimpleItem("small_bronze_chunk", Fusion.plugin );
	public static SimpleItem medium_bronze_chunk = new SimpleItem("medium_bronze_chunk", Fusion.plugin );
	public static SimpleItem large_bronze_chunk = new SimpleItem("large_bronze_chunk", Fusion.plugin );
	
	public static SimpleItem sinisite_ingot = new SimpleItem("sinisite_ingot", Fusion.plugin );
	public static SimpleItem small_sinisite_chunk = new SimpleItem("small_sinisite_chunk", Fusion.plugin );
	public static SimpleItem medium_sinisite_chunk = new SimpleItem("medium_sinisite_chunk", Fusion.plugin );
	public static SimpleItem large_sinisite_chunk = new SimpleItem("large_sinisite_chunk", Fusion.plugin );
	public static SimpleItem sinisite_rod = new SimpleItem("sinisite_rod", Fusion.plugin );

	public static SimpleItem thyrium_ingot = new SimpleItem("thyrium_ingot", Fusion.plugin );
	public static SimpleItem small_thyrium_chunk = new SimpleItem("small_thyrium_chunk", Fusion.plugin );
	public static SimpleItem medium_thyrium_chunk = new SimpleItem("medium_thyrium_chunk", Fusion.plugin );
	public static SimpleItem large_thyrium_chunk = new SimpleItem("large_thyrium_chunk", Fusion.plugin );
	public static SimpleItem thyrium_rod = new SimpleItem("thyrium_rod", Fusion.plugin );
	
	//Tools
	public static SimplePickaxe steel_pickaxe = 
			new SimplePickaxe("steel_pickaxe", Fusion.plugin, Content.toolSteel);
	public static SimpleAxe steel_axe =
			new SimpleAxe("steel_axe", Fusion.plugin, Content.toolSteel);
	public static SimpleShovel steel_shovel = 
			new SimpleShovel("steel_shovel", Fusion.plugin, Content.toolSteel);
	public static SimpleSword steel_sword = 
			new SimpleSword("steel_sword", Fusion.plugin, Content.toolSteel);
	public static SimpleHoe steel_hoe = 
			new SimpleHoe("steel_hoe", Fusion.plugin, Content.toolSteel);
	public static SimpleShears steel_shears = 
			new SimpleShears("steel_shears", Fusion.plugin, Content.toolSteel);

	// SimpleOres Tools
	public static SimpleAxe bronze_axe =
			new SimpleAxe("bronze_axe", Fusion.plugin, Content.toolBronze);
	public static SimplePickaxe bronze_pickaxe =
			new SimplePickaxe("bronze_pickaxe", Fusion.plugin, Content.toolBronze);
	public static SimpleShovel bronze_shovel =
			new SimpleShovel("bronze_shovel", Fusion.plugin, Content.toolBronze);
	public static SimpleSword bronze_sword =
			new SimpleSword("bronze_sword", Fusion.plugin, Content.toolBronze);
	public static SimpleHoe bronze_hoe =
			new SimpleHoe("bronze_hoe", Fusion.plugin, Content.toolBronze);

	public static SimpleAxe sinisite_axe =
			new SimpleAxe("sinisite_axe", Fusion.plugin, Content.toolSinisite);
	public static SimplePickaxe sinisite_pickaxe =
			new SimplePickaxe("sinisite_pickaxe", Fusion.plugin, Content.toolSinisite);
	public static SimpleShovel sinisite_shovel =
			new SimpleShovel("sinisite_shovel", Fusion.plugin, Content.toolSinisite);
	public static SimpleSword sinisite_sword =
			new SimpleSword("sinisite_sword", Fusion.plugin, Content.toolSinisite);
	public static SimpleHoe sinisite_hoe =
			new SimpleHoe("sinisite_hoe", Fusion.plugin, Content.toolSinisite);
	public static SimpleBow sinisite_bow = new SimpleBow("sinisite_bow", Fusion.plugin, 1200);
	
	public static SimpleAxe thyrium_axe =
			new SimpleAxe("thyrium_axe", Fusion.plugin, Content.toolThyrium);
	public static SimplePickaxe thyrium_pickaxe =
			new SimplePickaxe("thyrium_pickaxe", Fusion.plugin, Content.toolThyrium);
	public static SimpleShovel thyrium_shovel =
			new SimpleShovel("thyrium_shovel", Fusion.plugin, Content.toolThyrium);
	public static SimpleSword thyrium_sword =
			new SimpleSword("thyrium_sword", Fusion.plugin, Content.toolThyrium);
	public static SimpleHoe thyrium_hoe =
			new SimpleHoe("thyrium_hoe", Fusion.plugin, Content.toolThyrium);
	public static SimpleBow thyrium_bow = new SimpleBow("thyrium_bow", Fusion.plugin, 900);
	
	/**
	 * Loads Fusion Items.
	 */
	public static void configureItems()
	{
		if (Settings.steelIngot.isEnabled()) 
		{
			steel_ingot.setConfigEntry(Settings.steelIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			small_steel_chunk.setConfigEntry(Settings.steelIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			medium_steel_chunk.setConfigEntry(Settings.steelIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			large_steel_chunk.setConfigEntry(Settings.steelIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		}
	} // end-configureItems()

	public static void configureSimpleOresItems()
	{
		if (! Content.use_simpleores) return;

		if (Settings.bronzeIngot.isEnabled()) {
			bronze_ingot.setConfigEntry(Settings.bronzeIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			small_bronze_chunk.setConfigEntry(Settings.bronzeIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			medium_bronze_chunk.setConfigEntry(Settings.bronzeIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			large_bronze_chunk.setConfigEntry(Settings.bronzeIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		} // end-if bronze
		if (Settings.thyriumIngot.isEnabled()) {
			thyrium_ingot.setConfigEntry(Settings.thyriumIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			small_thyrium_chunk.setConfigEntry(Settings.thyriumIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			medium_thyrium_chunk.setConfigEntry(Settings.thyriumIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			large_thyrium_chunk.setConfigEntry(Settings.thyriumIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			thyrium_rod.setConfigEntry(Settings.thyriumIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		} // end-if thyrium
		if (Settings.sinisiteIngot.isEnabled()) {
			sinisite_ingot.setConfigEntry(Settings.sinisiteIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			small_sinisite_chunk.setConfigEntry(Settings.sinisiteIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			medium_sinisite_chunk.setConfigEntry(Settings.sinisiteIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			large_sinisite_chunk.setConfigEntry(Settings.sinisiteIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
			sinisite_rod.setConfigEntry(Settings.sinisiteIngot).setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
		} // end-if sinisite
		
	} // end configureSimpleOresItems()

	/**
	 * Loads Fusion Tools.
	 */
	public static void configureTools()
	{
		if (Settings.steelTools.isEnabled()) 
		{
			steel_pickaxe.setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			steel_axe.setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			steel_shovel.setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			steel_hoe.setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			steel_sword.setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			steel_shears.setConfigEntry(Settings.steelTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		} // end-if steelTools
	} // end configureTools()
	
	
	public static void configureSimpleOresTools()
	{
		if (! Content.use_simpleores) return;
		
		if (Settings.bronzeTools.isEnabled())
		{
			bronze_pickaxe.setConfigEntry(Settings.bronzeTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			bronze_axe.setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			bronze_shovel.setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			bronze_hoe.setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			bronze_sword.setConfigEntry(Settings.bronzeTools).setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		} // end-if bronzeTools
		if (Settings.thyriumTools.isEnabled())
		{
			thyrium_pickaxe.setConfigEntry(Settings.thyriumTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			thyrium_axe.setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			thyrium_shovel.setConfigEntry(Settings.thyriumTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			thyrium_hoe.setConfigEntry(Settings.thyriumTools).setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			thyrium_sword.setConfigEntry(Settings.thyriumTools)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		} // end-if thyriumTools
		if (Settings.sinisiteTools.isEnabled())
		{
			sinisite_pickaxe.setConfigEntry(Settings.sinisiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			sinisite_axe.setConfigEntry(Settings.sinisiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			sinisite_shovel.setConfigEntry(Settings.sinisiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			sinisite_hoe.setConfigEntry(Settings.sinisiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			sinisite_sword.setConfigEntry(Settings.sinisiteTools)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
		if (Settings.thyriumBow.isEnabled()) 
		{
			thyrium_bow.setEffect(SimpleBowEffects.damageEffect, Settings.thyriumBow.getDamageModifier())
					.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
					.setZoomAmount(Settings.thyriumBow.getZoomAmount()).addToolTip("tips.zoomTooltip")
					.setRepairMaterial(new ItemStack(thyrium_rod)).setConfigEntry(Settings.thyriumBow)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
		if (Settings.sinisiteBow.isEnabled()) 
		{
			sinisite_bow.setEffect(SimpleBowEffects.damageEffect, Settings.sinisiteBow.getDamageModifier())
					.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
					.setEffect(SimpleBowEffects.knockbackEffect, Settings.sinisiteBow.getKnockBackFactor())
					.addToolTip("tips.knockbackTooltip").setRepairMaterial(new ItemStack(sinisite_rod))
					.setConfigEntry(Settings.sinisiteBow).setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
	} // configureSimpleOresTools()
	
	/**
	 * Loads Fusion Armor.
	 */
	public static void configureArmor()
	{
		if (Settings.steelArmor.isEnabled()) 
		{
			steel_helmet.setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			steel_chestplate.setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			steel_leggings.setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			steel_boots.setConfigEntry(Settings.steelArmor).setType("steel").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		} // end-if steelArmor
	} // end doArmor()

	public static void configureSimpleOresArmor()
	{
		if (! Content.use_simpleores) return;
		if (Settings.bronzeArmor.isEnabled()) 
		{
			bronze_helmet.setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			bronze_chestplate.setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			bronze_leggings.setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			bronze_boots.setConfigEntry(Settings.bronzeArmor).setType("bronze").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		} // end-if bronzeArmor
		if (Settings.thyriumArmor.isEnabled())
		{
			thyrium_helmet.setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			thyrium_chestplate.setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			thyrium_leggings.setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			thyrium_boots.setConfigEntry(Settings.thyriumArmor).setType("thyrium").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		} // end-if thyriumArmor
		if (Settings.sinisiteArmor.isEnabled())
		{
			sinisite_helmet.setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			sinisite_chestplate.setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			sinisite_leggings.setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			sinisite_boots.setConfigEntry(Settings.sinisiteArmor).setType("sinisite").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		} // end-if sinisiteArmor
	} // end configureSimpleOresArmor()
	
	/**
	 * register Items with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void register(IForgeRegistry<Item> registry) 
	{
		if (Settings.steelIngot.isEnabled()) {
			registry.registerAll(steel_ingot, small_steel_chunk, medium_steel_chunk, 
								 large_steel_chunk);
		}
		if (Settings.steelArmor.isEnabled()) {
			registry.registerAll(steel_helmet, steel_boots, steel_chestplate, steel_leggings);
		}
		if (Settings.steelTools.isEnabled()) {
			registry.registerAll(steel_axe, steel_hoe, steel_pickaxe, steel_shears, 
								 steel_shovel, steel_sword);
		}
		if (Content.use_simpleores) 
		{
			if (Settings.bronzeIngot.isEnabled()) {
				registry.registerAll(bronze_ingot, large_bronze_chunk, medium_bronze_chunk, 
									 small_bronze_chunk);
			}
			if (Settings.bronzeArmor.isEnabled()) {
				registry.registerAll(bronze_boots, bronze_chestplate, bronze_helmet, bronze_leggings);
			}
			if (Settings.bronzeTools.isEnabled()) {
				registry.registerAll(bronze_axe, bronze_hoe, bronze_pickaxe, bronze_shovel, bronze_sword);
			}
			if (Settings.sinisiteIngot.isEnabled()) {
				registry.registerAll(sinisite_ingot, large_sinisite_chunk, medium_sinisite_chunk, 
						 small_sinisite_chunk, sinisite_rod);
			}
			if (Settings.sinisiteArmor.isEnabled()) {
				registry.registerAll(sinisite_boots, sinisite_chestplate, sinisite_helmet, 
						sinisite_leggings);
			}
			if (Settings.sinisiteTools.isEnabled()) {
				registry.registerAll(sinisite_axe, sinisite_hoe, sinisite_pickaxe, sinisite_shovel, 
										sinisite_sword);
			}
			if (Settings.sinisiteBow.isEnabled()) {
				registry.register(sinisite_bow);
			}
			if (Settings.thyriumIngot.isEnabled()) {
				registry.registerAll(thyrium_ingot, large_thyrium_chunk, medium_thyrium_chunk, 
						 small_thyrium_chunk, thyrium_rod);
			}
			if (Settings.thyriumArmor.isEnabled()) {
				registry.registerAll(thyrium_boots, thyrium_chestplate, thyrium_helmet, 
						thyrium_leggings);
			}
			if (Settings.thyriumTools.isEnabled()) {
				registry.registerAll(thyrium_axe, thyrium_hoe, thyrium_pickaxe, thyrium_shovel, 
						thyrium_sword);
			}
			if (Settings.thyriumBow.isEnabled()) {
				registry.register(thyrium_bow);
			}
		} // end-if use_simpleores
	} // end register()

	/**
	 * register Item models with Forge.
	 */
	public static void registerModels() 
	{
		if (Settings.steelIngot.isEnabled()) {
			steel_ingot.registerItemModel();
			small_steel_chunk.registerItemModel();
			medium_steel_chunk.registerItemModel();
			large_steel_chunk.registerItemModel();
		}
		if (Settings.steelArmor.isEnabled()) {
			steel_boots.registerItemModel();
			steel_chestplate.registerItemModel();
			steel_helmet.registerItemModel();
			steel_leggings.registerItemModel();
		}
		if (Settings.steelTools.isEnabled()) {
			steel_axe.registerItemModel();
			steel_pickaxe.registerItemModel();
			steel_shears.registerItemModel();
			steel_shovel.registerItemModel();
			steel_sword.registerItemModel();
			steel_hoe.registerItemModel();
		}
		if (Content.use_simpleores) 
		{
			if (Settings.bronzeIngot.isEnabled()) {
				bronze_ingot.registerItemModel();
				small_bronze_chunk.registerItemModel();
				medium_bronze_chunk.registerItemModel();
				large_bronze_chunk.registerItemModel();
			}
			if (Settings.bronzeArmor.isEnabled()) {
				bronze_boots.registerItemModel();
				bronze_chestplate.registerItemModel();
				bronze_helmet.registerItemModel();
				bronze_leggings.registerItemModel();
			}
			if (Settings.bronzeTools.isEnabled()) {
				bronze_axe.registerItemModel();
				bronze_pickaxe.registerItemModel();
				bronze_shovel.registerItemModel();
				bronze_sword.registerItemModel();
				bronze_hoe.registerItemModel();
			}
			if (Settings.sinisiteIngot.isEnabled()) {
				sinisite_ingot.registerItemModel();
				small_sinisite_chunk.registerItemModel();
				medium_sinisite_chunk.registerItemModel();
				large_sinisite_chunk.registerItemModel();
				sinisite_rod.registerItemModel();
			}
			if (Settings.sinisiteArmor.isEnabled()) {
				sinisite_boots.registerItemModel();
				sinisite_chestplate.registerItemModel();
				sinisite_helmet.registerItemModel();
				sinisite_leggings.registerItemModel();
			}
			if (Settings.sinisiteTools.isEnabled()) {
				sinisite_axe.registerItemModel();
				sinisite_pickaxe.registerItemModel();
				sinisite_shovel.registerItemModel();
				sinisite_sword.registerItemModel();
				sinisite_hoe.registerItemModel();
			}
			if (Settings.sinisiteBow.isEnabled()) {
				sinisite_bow.registerItemModel();
			}
			if (Settings.thyriumIngot.isEnabled()) {
				thyrium_ingot.registerItemModel();
				small_thyrium_chunk.registerItemModel();
				medium_thyrium_chunk.registerItemModel();
				large_thyrium_chunk.registerItemModel();
				thyrium_rod.registerItemModel();
			}
			if (Settings.thyriumArmor.isEnabled()) {
				thyrium_boots.registerItemModel();
				thyrium_chestplate.registerItemModel();
				thyrium_helmet.registerItemModel();
				thyrium_leggings.registerItemModel();
			}
			if (Settings.thyriumTools.isEnabled()) {
				thyrium_axe.registerItemModel();
				thyrium_pickaxe.registerItemModel();
				thyrium_shovel.registerItemModel();
				thyrium_sword.registerItemModel();
				thyrium_hoe.registerItemModel();
			}
			if (Settings.thyriumBow.isEnabled()) {
				thyrium_bow.registerItemModel();
			}
		} // end-if use_simpleores
	} // end registerModels()

	/**
	 * register ingots and suchlike with the ore dictionary.
	 */
	public static void registerOreDictionary()
	{
		if (Settings.steelIngot.isEnabled()) {
			OreDictionary.registerOre("ingotSteel", new ItemStack(steel_ingot));
		}
		if (Content.use_simpleores) {
			if (Settings.bronzeIngot.isEnabled()) {
				OreDictionary.registerOre("ingotBronze", new ItemStack(bronze_ingot));
			}
			if (Settings.thyriumIngot.isEnabled()) {
				OreDictionary.registerOre("ingotThyrium", new ItemStack(thyrium_ingot));
			}
			if (Settings.sinisiteIngot.isEnabled()) {
				OreDictionary.registerOre("ingotSinisite", new ItemStack(sinisite_ingot));
			}
		} // end-if use_simpleores
	} // end registerOreDictionary()

} // end-class ModItems
