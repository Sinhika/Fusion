package alexndr.plugins.Fusion;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.APISettings;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;

/**
 * @author AleXndrTheGr8st
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	 dependencies = "required-after:simplecore, after:simpleores, after:netherrocks", 
	 updateJSON=ModInfo.VERSIONURL)
public class Fusion 
{
	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);
	
	@SidedProxy(clientSide = "alexndr.plugins.Fusion.ProxyClient", serverSide = "alexndr.plugins.Fusion.ProxyCommon")
	public static ProxyCommon proxy;
	
	public static Fusion INSTANCE;
	
	//Tool Materials
	public static ToolMaterial toolSteel;
	
	//Armor Materials
	public static ArmorMaterial armorSteel;
	
	@SuppressWarnings("unused")
	private static SimpleTab simpleMachines;
	
	/**
	 * Called during the PreInit phase.
	 * @param event FMLPreInitializationEvent
	 */
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		LogHelper.info("Loading Fusion...");
		
		//Configuration
		ContentRegistry.registerPlugin(plugin);
		Settings.createOrLoadSettings(event);
		
		//Content
		if (! TabHelper.wereTabsInitialized()) {
			SimpleCoreAPI.tabPreInit();
		}
		tabPreInit();
		
		setToolAndArmorStats();
		if(Loader.isModLoaded("simpleores") && Settings.enableSimpleOres.asBoolean()) {
			ContentSimpleOres.setToolAndArmorStats();
		}
		Content.preInitialize();
		Recipes.preInitialize();
	} // end PreInit()
	
	/**
	 * Called during the Init phase.
	 * @param event FMLInitializationEvent
	 */
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		INSTANCE = this;
		
		proxy.Init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler) new FusionGuiHandler());
		
		//Content
		Content.initialize();
		Recipes.initialize();
		setRepairMaterials();
		setAchievementTriggers();
		if(Loader.isModLoaded("simpleores") && Settings.enableSimpleOres.asBoolean())
		{
			ContentSimpleOres.setRepairMaterials(); 
			ContentSimpleOres.setAchievementTriggers();
		}
	} // end Init()
	
	/**
	 * Called during the PostInit phase.
	 * @param event FMLPostIntializationEvent
	 */
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		LogHelper.verbose("Fusion", FusionFurnaceRecipes.getRecipeList().size() + " Fusion Furnace recipes were loaded");
		LogHelper.info("Fusion loaded");
	}
	
	private static void setAchievementTriggers()
	{
		//Crafting Triggers
		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.fusion_furnace).getItem(), Content.fusionAch);
		StatTriggersHelper.addCraftingTrigger(new ItemStack(Content.steel_chestplate).getItem(), Content.steelChestplateAch);
		
		//Smelting Triggers
		StatTriggersHelper.addSmeltingTrigger(new ItemStack(Content.steel_ingot).getItem(), Content.steelAch);
	}
	
	private static void setRepairMaterials()
	{
		toolSteel.setRepairItem(new ItemStack(Content.steel_ingot));
		armorSteel.customCraftingMaterial = Content.steel_ingot;
	}
	
    private static void setToolAndArmorStats()
    {
    	toolSteel = EnumHelper.addToolMaterial("STEEL", Settings.steelTools.getHarvestLevel(), Settings.steelTools.getUses(), 
    											Settings.steelTools.getHarvestSpeed(), Settings.steelTools.getDamageVsEntity(), 
    											Settings.steelTools.getEnchantability());
    	armorSteel = EnumHelper.addArmorMaterial("STEEL", "steel", Settings.steelArmor.getDurability(), 
    											new int[] {Settings.steelArmor.getHelmReduction(), 
    													   Settings.steelArmor.getChestReduction(), 
    													   Settings.steelArmor.getLegsReduction(), 
    													   Settings.steelArmor.getBootsReduction()}, 
    													   Settings.steelArmor.getEnchantability());
    }
    
    private static void tabPreInit()
    {
		LogHelper.verbose("Creating tabs");
		if(APISettings.tabs.asBoolean() && APISettings.separateTabs.asBoolean()) 
		{
			simpleMachines = new SimpleTab(Fusion.plugin, "SimpleMachines", 
										   ContentCategories.CreativeTab.OTHER);
		} //
    } // end tabPreInit()
    
} // end class
