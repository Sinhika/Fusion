package mod.alexndr.fusion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.fusion.config.ConfigHelper;
import mod.alexndr.fusion.config.ConfigHolder;
import mod.alexndr.fusion.config.FusionConfig;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModTabGroups;
import mod.alexndr.simplecorelib.api.config.FlagCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

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
                            new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP);
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
    public static void onModConfigEvent(final ModConfigEvent event)
    {
        final ModConfig config = event.getConfig();

        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
            ConfigHelper.bakeServer(config);
        }
    } // onModConfigEvent

 
    /**
     * Recipe Serializer event handler.
     * @param evt
     */
    @SubscribeEvent
    public static void onRegisterRecipeSerializers(RegistryEvent.Register<RecipeSerializer<?>> evt) 
    {
        CraftingHelper.register(new FlagCondition.Serializer(FusionConfig.INSTANCE, 
                new ResourceLocation(Fusion.MODID, "flag")));    
        
//        Registry.register(Registry.RECIPE_TYPE, IFusionRecipe.TYPE_ID, ModRecipeTypes.FUSION_TYPE);
        //evt.getRegistry().register(ModRecipeTypes.FUSION_SERIALIZER.setRegistryName(IFusionRecipe.TYPE_ID));
    } // end onRegisterRecipeSerializers
    
} // end class
