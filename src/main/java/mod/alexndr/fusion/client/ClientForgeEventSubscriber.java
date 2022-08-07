package mod.alexndr.fusion.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.SinisiteBow;
import mod.alexndr.fusion.content.ThyriumBow;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.api.client.ClientUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
@EventBusSubscriber(modid=Fusion.MODID, bus=EventBusSubscriber.Bus.FORGE, value=Dist.CLIENT)
public class ClientForgeEventSubscriber
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(Fusion.MODID + " Client Forge Event Subscriber");

    /**
     * Catch and handle improved FOV for thyrium bows here.
     * @param event
     */
    @SubscribeEvent
    public static void onFovEvent(final ComputeFovModifierEvent event)
    {
        ClientUtils.handleFovEvent(event, p -> p instanceof ThyriumBow, ModItems.thyrium_bow.get().getZoomAmount());
        ClientUtils.handleFovEvent(event, p -> p instanceof SinisiteBow, 0.165F);
        
    } // end onFovEvent()
    
} // end class
