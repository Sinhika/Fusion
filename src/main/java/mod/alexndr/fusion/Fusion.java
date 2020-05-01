package mod.alexndr.fusion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import mod.alexndr.fusion.config.ConfigHolder;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModContainers;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.fusion.init.ModTiles;
import mod.alexndr.simpleores.api.config.FlagCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Fusion.MODID)
public class Fusion
{
    // modid 
    public static final String MODID = "fusion";
    public static boolean isSimpleOresLoaded = false;
    
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Fusion()
    {
        LOGGER.info("Hello from Fusion!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModContainers.CONTAINER_TYPES.register(modEventBus);
        ModTiles.TILE_ENTITY_TYPES.register(modEventBus);

        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        CraftingHelper.register(new FlagCondition.Serializer(FusionConfig.INSTANCE, 
                new ResourceLocation(Fusion.MODID, "flag")));    
    } // end ctor()


} // end class
