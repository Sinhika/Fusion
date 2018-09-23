package alexndr.plugins.Fusion;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import alexndr.plugins.Fusion.modsupport.ModSupport;

import com.google.common.collect.Lists;

@Mod.EventBusSubscriber
public class ProxyCommon
{
	public void PreInit(FMLPreInitializationEvent event)
	{	
		//Configuration
		ContentRegistry.registerPlugin(Fusion.plugin);
		Settings.createOrLoadSettings(event);
		
		//Content
		if (! TabHelper.wereTabsInitialized()) {
			SimpleCoreAPI.tabPreInit();
		}
		ModSupport.preInit();
		Content.preInitialize();
		Recipes.preInitialize();
	} // end PreInit

	public void Init(FMLInitializationEvent event)
	{
		Content.initialize();
		Recipes.initialize();
		
		setTabIcons();
		Content.setRepairMaterials();
//		Content.setAchievementTriggers();
		
		ModSupport.Init();
	} // end Init()

	public void PostInit(FMLPostInitializationEvent event)
	{
		ModSupport.PostInit();
		Recipes.postInitialize();
	} // end PostInit()
	/**
	 * sets tab icons, if they haven't been set by an earlier mod.
	 */
	private static void setTabIcons() {
		LogHelper.verbose("Fusion", "Setting tab icons");
		List<Item> list = Lists.newArrayList(Item.getItemFromBlock(Content.steel_block), 
								Item.getItemFromBlock(Content.steel_block), 
								Content.steel_ingot, Content.steel_pickaxe, 
								Content.steel_sword, 
								Item.getItemFromBlock(Content.fusion_furnace));
		SimpleCoreAPI.setTabIcons(list);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
   	 	//Registers
		ModBlocks.register(event.getRegistry());
	} // end registerBlocks()

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) 
	{
    	ModItems.register(event.getRegistry());
    	ModBlocks.registerItemBlocks(event.getRegistry());
        ModItems.registerOreDictionary();
        ModBlocks.registerOreDictionary();
	}

	public void registerItemRenderer(Plugin plugin, Item item, int meta, String id) {
	}

} // end class
