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
import net.minecraftforge.fml.common.registry.GameRegistry;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import alexndr.plugins.SimpleOres.ModInfo;

/**
 * @author AleXndrTheGr8st
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	 dependencies = "required-after:simplecore", updateJSON=ModInfo.VERSIONURL)
public class Fusion 
{
	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);
	
	@SidedProxy(clientSide = "alexndr.plugins.Fusion.ProxyClient", serverSide = "alexndr.plugins.Fusion.ProxyCommon")
	public static ProxyCommon proxy;
	public static Fusion INSTANCE = new Fusion();
	
	//Tool Materials
	public static ToolMaterial toolSteel;
	
	//Armor Materials
	public static ArmorMaterial armorSteel;
	
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
		setToolAndArmorStats();
		if(Loader.isModLoaded("simpleores") && Settings.enableSimpleOres.asBoolean()) {
			ContentSimpleOres.setToolAndArmorStats();
		}
		
		Content.preInitialize();
		Recipes.preInitialize();
	}
	
	/**
	 * Called during the Init phase.
	 * @param event FMLInitializationEvent
	 */
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		INSTANCE = this;
		
		//Registers
		GameRegistry.registerTileEntity(TileEntityFusionFurnace.class, "fusionFurnace");
		NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler) proxy);
		
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
} // end class
