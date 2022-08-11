package mod.alexndr.fusion.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.alexndr.fusion.Fusion;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers
 * for data generation.
 * 
 * @author Sinhika
 */
@EventBusSubscriber(modid = Fusion.MODID, bus = MOD)
public class FusionDataGenerator
{

    /**
     * GatherDataEvent handler.
     * 
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new Recipes(gen));
        gen.addProvider(event.includeServer(), new FusionRecipes(gen));
        gen.addProvider(event.includeServer(), new SilentsRecipes(gen));
        gen.addProvider(event.includeServer(), new FusionLootTableProvider(gen));
        gen.addProvider(event.includeServer(), new FusionLootInjectorProvider(gen));
        gen.addProvider(event.includeServer(), new ModBlockTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), new ModItemTags(gen, event.getExistingFileHelper()));
        
        gen.addProvider(event.includeClient(), new FusionBlockStateProvider(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new FusionItemModelProvider(gen, event.getExistingFileHelper()));
    } // end gatherData()

} // end-class FusionDataGenerator
