package mod.alexndr.fusion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Fusion.MODID)
public class Fusion
{
    // modid 
    public static final String MODID = "fusion";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Fusion()
    {
        LOGGER.info("Hello from Fusion!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
//
//        // Register Configs
//        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);

    } // end ctor()


} // end class
