package mod.alexndr.fusion.config;

import mod.alexndr.fusion.Fusion;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    // general
    final ForgeConfigSpec.BooleanValue serverAddChestLoot;
    
    // fusion recipes
    final ForgeConfigSpec.BooleanValue serverEnableSteelMaking;
    final ForgeConfigSpec.BooleanValue serverEnableBronzeMaking;
    final ForgeConfigSpec.BooleanValue serverEnableSinisiteMaking;
    final ForgeConfigSpec.BooleanValue serverEnableThyriumMaking;
    
    // fusion recycling
    final ForgeConfigSpec.BooleanValue serverEnableVanillaRecycling;
    final ForgeConfigSpec.BooleanValue serverEnableSimpleOresRecycling;
    final ForgeConfigSpec.BooleanValue serverEnableNetherrocksRecycling;
    final ForgeConfigSpec.BooleanValue serverEnableFusionRecycling;
    
    // tool recipes
    final ForgeConfigSpec.BooleanValue serverEnableSteelTools;
    final ForgeConfigSpec.BooleanValue serverEnableBronzeTools;
    final ForgeConfigSpec.BooleanValue serverEnableSinisiteTools;
    final ForgeConfigSpec.BooleanValue serverEnableThyriumTools;

    // armor recipes
    final ForgeConfigSpec.BooleanValue serverEnableSteelArmor;
    final ForgeConfigSpec.BooleanValue serverEnableBronzeArmor;
    final ForgeConfigSpec.BooleanValue serverEnableSinisiteArmor;
    final ForgeConfigSpec.BooleanValue serverEnableThyriumArmor;
    
    // bow recipes
    final ForgeConfigSpec.BooleanValue serverEnableFusionBows;
    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverAddChestLoot = builder.comment("Allow Fusion loot to be added to chests?")
                .translation(Fusion.MODID + ".config.addChestLoot")
                .define("AddChestLoot", true);
        builder.pop();
        
        builder.push("Alloy Recipes");
        serverEnableSteelMaking = builder.comment("false disables alloy recipes")
                .translation(Fusion.MODID + ".config.enableSteelMaking")
                .define("EnableSteelMaking", true);
        serverEnableBronzeMaking = builder.comment("false disables alloy recipes")
                .translation(Fusion.MODID + ".config.enableBronzeMaking")
                .define("EnableBronzeMaking", true);
        serverEnableSinisiteMaking = builder.comment("false disables alloy recipes")
                .translation(Fusion.MODID + ".config.enableSinisiteMaking")
                .define("EnableSinisiteMaking", true);
        serverEnableThyriumMaking = builder.comment("false disables alloy recipes")
                .translation(Fusion.MODID + ".config.enableThyriumMaking")
                .define("EnableThyriumMaking", true);
        builder.pop();
        builder.push("Tools");
        serverEnableSteelTools = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableSteelTools")
                .define("EnableSteelTools", true);
        serverEnableBronzeTools = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableBronzeTools")
                .define("EnableBronzeTools", true);
        serverEnableSinisiteTools = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableSinisiteTools")
                .define("EnableSinisiteTools", true);
        serverEnableThyriumTools = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableThyriumTools")
                .define("EnableThyriumTools", true);
        builder.pop();
        builder.push("Armor");
        serverEnableSteelArmor = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableSteelArmor")
                .define("EnableSteelArmor", true);
        serverEnableBronzeArmor = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableBronzeArmor")
                .define("EnableBronzeArmor", true);
        serverEnableSinisiteArmor = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableSinisiteArmor")
                .define("EnableSinisiteArmor", true);
        serverEnableThyriumArmor = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableThyriumArmor")
                .define("EnableThyriumArmor", true);
        builder.pop();
        builder.push("Bows");
        serverEnableFusionBows = builder.comment("false disables recipes")
                .translation(Fusion.MODID + ".config.enableFusionBows")
                .define("EnableFusionBows", true);
        builder.pop();
        
        builder.push("Simple Fusion Recycling");
        serverEnableVanillaRecycling = builder.comment("Enable Simple Fusion Recycling recipes for vanilla metals?")
                .translation(Fusion.MODID + ".config.enableVanillaRecycling")
                .define("enableVanillaRecycling", true);
        serverEnableSimpleOresRecycling = builder.comment("Enable Simple Fusion Recycling recipes for Simple Ores?")
                .translation(Fusion.MODID + ".config.enableSimpleOresRecycling")
                .define("enableSimpleOresRecycling", true);
        serverEnableNetherrocksRecycling = builder.comment("Enable Simple Fusion Recycling recipes for Netherrocks?")
                .translation(Fusion.MODID + ".config.enableNetherrocksRecycling")
                .define("enableNetherrocksRecycling", false);
        serverEnableFusionRecycling = builder.comment("Enable Simple Fusion Recycling recipes for Fusion?")
                .translation(Fusion.MODID + ".config.enableFusionRecycling")
                .define("enableFusionRecycling", true);
        builder.pop();
        
    } // end ctor
    
} // end class
