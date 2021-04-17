package mod.alexndr.fusion.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.ResourceLocation;

public class FusionLootTableProvider extends BlockLootTableProvider
{

    public FusionLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.bronze_block.get());
        standardDropTable(ModBlocks.steel_block.get());
        standardDropTable(ModBlocks.thyrium_block.get());
        standardDropTable(ModBlocks.sinisite_block.get());
        copyNameDropTable(ModBlocks.fusion_furnace.get(), ModBlocks.fusion_furnace.get().asItem());
        return tables;
    }

} // end class
