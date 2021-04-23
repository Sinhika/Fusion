package mod.alexndr.fusion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.loot.FusionInjectionLookup;
import mod.alexndr.simplecorelib.helpers.LootUtils;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fusion.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(Fusion.MODID + " Forge Event Subscriber");
    private static final FusionInjectionLookup lootLookupMap = new FusionInjectionLookup();
    
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (FusionConfig.addChestLoot)
        {
            LootUtils.LootLoadHandler(Fusion.MODID, event, lootLookupMap);
        } // end-if config allows
    } // end LootLoad()
    
} // end class
