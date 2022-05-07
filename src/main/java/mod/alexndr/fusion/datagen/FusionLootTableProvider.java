package mod.alexndr.fusion.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

public class FusionLootTableProvider extends BlockLootTableProvider
{

    public FusionLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.bronze_block.get());
        standardDropTable(ModBlocks.bronze_bricks.get());
        standardDropTable(ModBlocks.bronze_brick_stairs.get());
        slabDropTable(ModBlocks.bronze_brick_slab.get());
        standardDropTable(ModBlocks.bronze_bars.get());
        doorDropTable(ModBlocks.bronze_door.get());
        standardDropTable(ModBlocks.steel_block.get());
        standardDropTable(ModBlocks.steel_bricks.get());
        standardDropTable(ModBlocks.steel_brick_stairs.get());
        slabDropTable(ModBlocks.steel_brick_slab.get());
        standardDropTable(ModBlocks.steel_bars.get());
        standardDropTable(ModBlocks.sinisite_block.get());
        standardDropTable(ModBlocks.sinisite_bricks.get());
        standardDropTable(ModBlocks.sinisite_brick_stairs.get());
        slabDropTable(ModBlocks.sinisite_brick_slab.get());
        standardDropTable(ModBlocks.sinisite_bars.get());
        standardDropTable(ModBlocks.thyrium_block.get());
        standardDropTable(ModBlocks.thyrium_bricks.get());
        standardDropTable(ModBlocks.thyrium_brick_stairs.get());
        slabDropTable(ModBlocks.thyrium_brick_slab.get());
        standardDropTable(ModBlocks.thyrium_bars.get());
        copyNameDropTable(ModBlocks.fusion_furnace.get(), ModBlocks.fusion_furnace.get().asItem());
        return tables;
    }

} // end class
