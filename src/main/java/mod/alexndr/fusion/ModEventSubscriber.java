package mod.alexndr.fusion;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Fusion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Fusion.MODID + " Mod Event Subscriber");

    /**
     * This method will be called by Forge when it is time for the mod to register its Items.
     * This method will always be called after the Block registry method.
     */
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        // TODO
        LOGGER.debug("Registered BlockItems");
    }  // end onRegisterItems()

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
    {
        final ModConfig config = event.getConfig();

        // Rebake the configs when they change
//        if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
//            ConfigHelper.bakeServer(config);
//        }
    } // onModConfigEvent

    @SubscribeEvent
    public static void onRegisterModifierSerializers(
            @Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event)
    {
        // TODO
    } // end registerModifierSerializers

    
} // end class
