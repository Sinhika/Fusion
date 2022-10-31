package mod.alexndr.fusion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.content.ModVillagerTrades;
import mod.alexndr.fusion.loot.FusionInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
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
    
    /**
     * Intercept villager trades list and modify it.
     */
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent evt)
    {
        if (evt.getType() == VillagerProfession.ARMORER)
        {
            ModVillagerTrades.ArmorerTrades(evt);
        } // end if ARMORER
        
        else if (evt.getType() == VillagerProfession.TOOLSMITH)
        {
            ModVillagerTrades.ToolsmithTrades(evt);
        } // end-if TOOLSMITH
        else if (evt.getType() == VillagerProfession.WEAPONSMITH)
        {
            ModVillagerTrades.WeaponsmithTrades(evt);
        } // end-if WEAPONSMITH
    } // end onVillagerTrades()
    
} // end class
