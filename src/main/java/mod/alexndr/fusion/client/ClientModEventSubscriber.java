package mod.alexndr.fusion.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.client.gui.FusionFurnaceScreen;
import mod.alexndr.fusion.content.FusionFurnaceContainer;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModContainers;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.api.client.ClientUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        event.enqueueWork(() -> {
            ClientUtils.setupBowModelProperties(ModItems.sinisite_bow.get());
            ClientUtils.setupBowModelProperties(ModItems.thyrium_bow.get());
            MenuScreens.register((MenuType<FusionFurnaceContainer>) ModContainers.FUSION_FURNACE.get(), FusionFurnaceScreen::new);
            LOGGER.debug("Registered ContainerType Screens");
        });

        // doors with see-through windows.
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.bronze_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.steel_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.sinisite_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.thyrium_door.get(), (layer) -> layer 
                == RenderType.cutout());

        // bars, which are see-through between the bars, obviously.
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.bronze_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.steel_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.sinisite_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.thyrium_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        
   } // end onFMLClientSetupEvent


} // end class
