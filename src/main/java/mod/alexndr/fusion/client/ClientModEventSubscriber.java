package mod.alexndr.fusion.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.client.gui.FusionFurnaceScreen;
import mod.alexndr.fusion.init.ModContainers;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.SimpleCoreLib;
import mod.alexndr.simplecorelib.client.ClientUtils;
import mod.alexndr.simplecorelib.client.gui.SimpleSpriteUploader;
import mod.alexndr.simplecorelib.client.gui.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
@EventBusSubscriber(modid=Fusion.MODID, bus=EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
public class ClientModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Fusion.MODID + " Client Mod Event Subscriber");
    public static Textures textures;

    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) 
    {
        ClientUtils.setupBowModelProperties(ModItems.sinisite_bow.get());
        ClientUtils.setupBowModelProperties(ModItems.thyrium_bow.get());

        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        event.enqueueWork(() -> {
            MenuScreens.register(ModContainers.FUSION_FURNACE.get(), FusionFurnaceScreen::new);
            LOGGER.debug("Registered ContainerType Screens");
        });
   }

    @SubscribeEvent
    public static void onRegisterClientReloadListenersEvent(final RegisterClientReloadListenersEvent event)
    {
    	if (ModList.get().isLoaded("jei"))
    	{
	    	// add things to texture atlas.
	    	Minecraft minecraft = Minecraft.getInstance();
	    	SimpleSpriteUploader spriteUploader = new SimpleSpriteUploader(minecraft.textureManager, SimpleCoreLib.SIMPLE_TEXTURE_ATLAS);
	    	textures = new Textures(spriteUploader);
	    	event.registerReloadListener(spriteUploader);
    	}
    } // end onRegisterClientReloadListenersEvent

} // end class
