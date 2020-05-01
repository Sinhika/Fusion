package mod.alexndr.fusion.config;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    final ForgeConfigSpec.BooleanValue serverEnableSteelMaking;
    final ForgeConfigSpec.BooleanValue serverEnableBronzeMaking;
    final ForgeConfigSpec.BooleanValue serverEnableSinisiteMaking;
    final ForgeConfigSpec.BooleanValue serverEnableThyriumMaking;
    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("Alloy Recipes");
        serverEnableSteelMaking = builder.comment("false disables alloy recipes")
                .translation(SimpleOres.MODID + ".config.enableSteelMaking")
                .define("EnableSteelMaking", true);
        serverEnableBronzeMaking = builder.comment("false disables alloy recipes")
                .translation(SimpleOres.MODID + ".config.enableBronzeMaking")
                .define("EnableBronzeMaking", true);
        serverEnableSinisiteMaking = builder.comment("false disables alloy recipes")
                .translation(SimpleOres.MODID + ".config.enableSinisiteMaking")
                .define("EnableSinisiteMaking", true);
        serverEnableThyriumMaking = builder.comment("false disables alloy recipes")
                .translation(SimpleOres.MODID + ".config.enableThyriumMaking")
                .define("EnableThyriumMaking", true);
        builder.pop();
    } // end ctor
    
} // end class
