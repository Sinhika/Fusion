package mod.alexndr.fusion.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
//  public static void bakeClient(final ModConfig config) { }

    public static void bakeServer(final ModConfig config)
    {
        // recipe flags
        FusionConfig.INSTANCE.putFlag("steel_making", ConfigHolder.SERVER.serverEnableSteelMaking.get());
        FusionConfig.INSTANCE.putFlag("bronze_making", ConfigHolder.SERVER.serverEnableBronzeMaking.get());
        FusionConfig.INSTANCE.putFlag("sinisite_making", ConfigHolder.SERVER.serverEnableSinisiteMaking.get());
        FusionConfig.INSTANCE.putFlag("thyrium_making", ConfigHolder.SERVER.serverEnableThyriumMaking.get());
    } // end bakeServer()

} // end class
