package mod.alexndr.fusion.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();		

        // server side
        ModBlockTags blockTags = new ModBlockTags(packOutput, lookupProvider, existingFileHelper);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(),
            	new ModItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), event.getExistingFileHelper()));

        gen.addProvider(event.includeServer(), new Recipes(packOutput));
        gen.addProvider(event.includeServer(), new FusionRecipes(packOutput));
        
        gen.addProvider(event.includeServer(), 
            	new SimpleLootTableProvider(packOutput, List.of(
            			new LootTableProvider.SubProviderEntry(FusionLootTableSubprovider::new, LootContextParamSets.BLOCK),
                		new LootTableProvider.SubProviderEntry(FusionLootInjectorSubprovider::new, LootContextParamSets.CHEST)
            			)));
        
        // client side
        gen.addProvider(event.includeClient(), new FusionBlockStateProvider(packOutput, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new FusionItemModelProvider(packOutput, event.getExistingFileHelper()));
    } // end gatherData()

} // end-class FusionDataGenerator
