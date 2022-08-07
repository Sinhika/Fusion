package mod.alexndr.fusion.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.alexndr.fusion.Fusion;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.data.event.GatherDataEvent;

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
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
            gen.addProvider(new FusionRecipes(gen));
            gen.addProvider(new SilentsRecipes(gen));
            gen.addProvider(new FusionLootTableProvider(gen));
            gen.addProvider(new FusionLootInjectorProvider(gen));
            gen.addProvider(new ModBlockTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new ModItemTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new FusionBlockStateProvider(gen, event.getExistingFileHelper()));
            gen.addProvider(new FusionItemModelProvider(gen, event.getExistingFileHelper()));
        }
    } // end gatherData()

} // end-class FusionDataGenerator
