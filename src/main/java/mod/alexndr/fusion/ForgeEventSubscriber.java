package mod.alexndr.fusion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.simplecorelib.loot.ChestLootHandler;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fusion.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Fusion.MODID + " Forge Event Subscriber");

    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (FusionConfig.addChestLoot)
        {
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();

            if (name.startsWith(prefix)) 
            {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                
                // village chests are a bit more complicated now, but use the old
                // village_blacksmith chest loot table anyway.
                if (file.startsWith("village/village_")) 
                {
                    String village = "village/";
                    file = file.substring(file.indexOf(village) + village.length());
                }
                else if (file.startsWith("stronghold_")) 
                {
                    file = "stronghold";
                }
                switch (file) {
                case "simple_dungeon":
                case "woodland_mansion":
                case "shipwreck_supply":
                case "shipwreck_map":
                case "shipwreck_treasure":
                case "buried_treasure":
                case "pillager_outpost":
                case "underwater_ruin_small":
                case "underwater_ruin_big":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(Fusion.MODID, "simple_dungeon"));
                    break;
                case "stronghold":
                case "village_weaponsmith":
                case "village_toolsmith":
                case "village_armorer":
                case "village_shepherd":
                case "village_mason":
                case "village_fletcher":
                case "desert_pyramid":
                case "abandoned_mineshaft":
                case "jungle_temple":
                case "spawn_bonus_chest":
                case "igloo_chest":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(Fusion.MODID, file));
                    break;
                default:
                    // cases deliberately ignored:
                    // dispensers, because you don't shoot ingots/ores/tools at people.
                    // other villagers
                    // the_end, because no end ores or metals.
                    // nether, because no nether alloys.
                    break;
                } // end-switch
            } // end-if chest loot
            
        } // end-if config allows
    } // end LootLoad()
    
} // end class
