package mod.alexndr.fusion.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
//  public static void bakeClient(final ModConfig config) { }

    public static void bakeServer(final ModConfig config)
    {
        // fusion alloy recipe flags
        FusionConfig.INSTANCE.putFlag("steel_making", ConfigHolder.SERVER.serverEnableSteelMaking.get());
        FusionConfig.INSTANCE.putFlag("bronze_making", ConfigHolder.SERVER.serverEnableBronzeMaking.get());
        FusionConfig.INSTANCE.putFlag("sinisite_making", ConfigHolder.SERVER.serverEnableSinisiteMaking.get());
        FusionConfig.INSTANCE.putFlag("thyrium_making", ConfigHolder.SERVER.serverEnableThyriumMaking.get());

        // fusion recycling recipe flags
        FusionConfig.INSTANCE.putFlag("recycle_vanilla", ConfigHolder.SERVER.serverEnableVanillaRecycling.get());
        FusionConfig.INSTANCE.putFlag("recycle_simpleores", ConfigHolder.SERVER.serverEnableSimpleOresRecycling.get());
        FusionConfig.INSTANCE.putFlag("recycle_netherrocks", ConfigHolder.SERVER.serverEnableNetherrocksRecycling.get());
        FusionConfig.INSTANCE.putFlag("recycle_fusion", ConfigHolder.SERVER.serverEnableFusionRecycling.get());
        
        // tool recipe flags
        FusionConfig.INSTANCE.putFlag("steel_tools", ConfigHolder.SERVER.serverEnableSteelTools.get());
        FusionConfig.INSTANCE.putFlag("bronze_tools", ConfigHolder.SERVER.serverEnableBronzeTools.get());
        FusionConfig.INSTANCE.putFlag("sinisite_tools", ConfigHolder.SERVER.serverEnableSinisiteTools.get());
        FusionConfig.INSTANCE.putFlag("thyrium_tools", ConfigHolder.SERVER.serverEnableThyriumTools.get());

        // armor recipe flags
        FusionConfig.INSTANCE.putFlag("steel_armor", ConfigHolder.SERVER.serverEnableSteelArmor.get());
        FusionConfig.INSTANCE.putFlag("bronze_armor", ConfigHolder.SERVER.serverEnableBronzeArmor.get());
        FusionConfig.INSTANCE.putFlag("sinisite_armor", ConfigHolder.SERVER.serverEnableSinisiteArmor.get());
        FusionConfig.INSTANCE.putFlag("thyrium_armor", ConfigHolder.SERVER.serverEnableThyriumArmor.get());

        // bow recipe flag
        FusionConfig.INSTANCE.putFlag("fusion_bows", ConfigHolder.SERVER.serverEnableFusionBows.get());
        
    } // end bakeServer()

} // end class
