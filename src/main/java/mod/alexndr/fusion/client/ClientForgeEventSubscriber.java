package mod.alexndr.fusion.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.ThyriumBow;
import mod.alexndr.fusion.init.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
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
    public static void onFovEvent(final FOVUpdateEvent event)
    {
        Player player = event.getEntity();
        float baseFOV = event.getFov();
        if (player.isHolding(ModItems.thyrium_bow.get()) 
                && player.getMainHandItem().getItem() instanceof ThyriumBow)
        {
            ThyriumBow bow = (ThyriumBow) player.getMainHandItem().getItem();
            // int useRemaining = bow.getUseDuration(null) - player.getUseItemRemainingTicks();
            int useRemaining = player.getTicksUsingItem();
            float fov = baseFOV - (useRemaining * bow.getZoomAmount() / 20.0F);
            if (fov < baseFOV - bow.getZoomAmount()) {
                fov = (baseFOV - bow.getZoomAmount());
            }
            event.setNewfov(fov);
        }
        else {
            event.setNewfov(event.getFov());
        }
    } // end onFovEvent()
    
} // end class
