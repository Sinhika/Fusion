package alexndr.plugins.Fusion;

import alexndr.api.logger.LogHelper;
import alexndr.api.registry.Plugin;
import alexndr.plugins.Fusion.helpers.FusionGuiHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * @author AleXndrTheGr8st
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
     acceptedMinecraftVersions=ModInfo.ACCEPTED_VERSIONS,
	 dependencies = ModInfo.DEPENDENCIES, updateJSON=ModInfo.VERSIONURL)
public class Fusion 
{
	@Mod.Instance
	public static Fusion INSTANCE;

	@SidedProxy(clientSide = "alexndr.plugins.Fusion.ProxyClient", 
				serverSide = "alexndr.plugins.Fusion.ProxyCommon")
	public static ProxyCommon proxy;

	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);

	/**
	 * Called during the PreInit phase.
	 * @param event FMLPreInitializationEvent
	 */
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		LogHelper.info("Loading Fusion...");
		proxy.PreInit(event);
	} // end PreInit()
	
	/**
	 * Called during the Init phase.
	 * @param event FMLInitializationEvent
	 */
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler) new FusionGuiHandler());
		proxy.Init(event);
	} // end Init()
	
	/**
	 * Called during the PostInit phase.
	 * @param event FMLPostIntializationEvent
	 */
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		proxy.PostInit(event);
		LogHelper.verbose("Fusion", FusionFurnaceRecipes.getRecipeList().size() + " Fusion Furnace recipes were loaded");
		LogHelper.info("Fusion loaded");
	}
    
} // end class
