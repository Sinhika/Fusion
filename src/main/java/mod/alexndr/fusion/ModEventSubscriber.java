package mod.alexndr.fusion;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.config.ConfigHelper;
import mod.alexndr.fusion.config.ConfigHolder;
import mod.alexndr.fusion.helpers.FusionLootModifiers;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModRecipeTypes;
import mod.alexndr.fusion.init.ModTabGroups;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Fusion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Fusion.MODID + " Mod Event Subscriber");

    /**
     * FMLCommonSetupEvent handler.
     */
    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        Fusion.isSimpleOresLoaded = ModList.get().isLoaded("simpleores");
        LOGGER.info("Simple Ores is" + (Fusion.isSimpleOresLoaded ? " " : " not ") + "loaded.");
        LOGGER.debug("Common setup done");
    }
    
    
    /**
     * This method will be called by Forge when it is time for the mod to register its Items.
     * This method will always be called after the Block registry method.
     */
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        // We need to go over the entire registry so that we include any potential Registry Overrides
        // Automatically register BlockItems for all our Blocks
        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                // You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
                // .filter(block -> needsItemBlock(block))
                // Register the BlockItem for the block
                .forEach(block -> {
                    // Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
                    final Item.Properties properties = 
                            new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Set the new BlockItem's registry name to the block's registry name
                    blockItem.setRegistryName(block.getRegistryName());
                    // Register the BlockItem
                    registry.register(blockItem);
                });
        LOGGER.debug("Registered BlockItems");
    }  // end onRegisterItems()

    
    /**
     * ModConfig.ModConfigEvent handler.
     * @param event
     */
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
    {
        final ModConfig config = event.getConfig();

        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
            ConfigHelper.bakeServer(config);
        }
    } // onModConfigEvent

    /**
     * Register<GlobalLootModifierSerializer<?>> event handler.
     * @param event
     */
    @SubscribeEvent
    public static void onRegisterModifierSerializers(
            @Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event)
    {
        event.getRegistry().register(
                new FusionLootModifiers.ShearsLootModifier.Serializer().setRegistryName(
                        new ResourceLocation(Fusion.MODID, "mod_shears_harvest")) );
    } // end registerModifierSerializers


    /**
     * Recipe Serializer event handler.
     * @param evt
     */
    @SubscribeEvent
    public static void onRegisterRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> evt) 
    {
        ResourceLocation id = new ResourceLocation(Fusion.MODID, "alloying");
        Registry.register(Registry.RECIPE_TYPE, id, ModRecipeTypes.FUSION_TYPE);
        evt.getRegistry().register(ModRecipeTypes.FUSION_SERIALIZER.setRegistryName(id));
    } // end onRegisterRecipeSerializers
    
} // end class
