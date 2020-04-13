package alexndr.plugins.Fusion;

import java.util.List;

import com.google.common.collect.Lists;

import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
		Content.preInitialize();
	} // end PreInit

	public void Init(FMLInitializationEvent event)
	{
		setTabIcons();
		Content.setRepairMaterials();
		Content.addSmeltingRecipes();
		Content.addFusionRecipes();
	} // end Init()

	public void PostInit(FMLPostInitializationEvent event)
	{
//		try {
//			if (Settings.customRecipes == true) {
//				Content.doCustomFusionRecipes();
//			}
//		}
//		catch (Exception e) {
//			LogHelper.severe("Fusion",
//					"Custom recipes were not added successfully. This is a problem!");
//			e.printStackTrace();
//		}
	} // end PostInit()
	
	/**
	 * sets tab icons, if they haven't been set by an earlier mod.
	 */
	private static void setTabIcons() {
		LogHelper.verbose("Fusion", "Setting tab icons");
		List<Item> list = Lists.newArrayList(Item.getItemFromBlock(ModBlocks.steel_block), 
								Item.getItemFromBlock(ModBlocks.steel_block), 
								ModItems.steel_ingot, ModItems.steel_pickaxe, 
								ModItems.steel_sword, 
								Item.getItemFromBlock(ModBlocks.fusion_furnace));
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
