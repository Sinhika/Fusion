package mod.alexndr.fusion.datagen;

import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;

public class FusionLootTableSubprovider extends SimpleBlockLootSubProvider
{

    @Override
	protected void generate() 
    {
        dropSelf(ModBlocks.bronze_block.get());
        dropSelf(ModBlocks.bronze_bricks.get());
        dropSelf(ModBlocks.bronze_brick_stairs.get());
        dropSlab(ModBlocks.bronze_brick_slab.get());
        dropSelf(ModBlocks.bronze_bars.get());
        doorDropTable(ModBlocks.bronze_door.get());
        doorDropTable(ModBlocks.steel_door.get());
        doorDropTable(ModBlocks.sinisite_door.get());
        doorDropTable(ModBlocks.thyrium_door.get());
        dropSelf(ModBlocks.steel_block.get());
        dropSelf(ModBlocks.steel_bricks.get());
        dropSelf(ModBlocks.steel_brick_stairs.get());
        dropSlab(ModBlocks.steel_brick_slab.get());
        dropSelf(ModBlocks.steel_bars.get());
        dropSelf(ModBlocks.sinisite_block.get());
        dropSelf(ModBlocks.sinisite_bricks.get());
        dropSelf(ModBlocks.sinisite_brick_stairs.get());
        dropSlab(ModBlocks.sinisite_brick_slab.get());
        dropSelf(ModBlocks.sinisite_bars.get());
        dropSelf(ModBlocks.thyrium_block.get());
        dropSelf(ModBlocks.thyrium_bricks.get());
        dropSelf(ModBlocks.thyrium_brick_stairs.get());
        dropSlab(ModBlocks.thyrium_brick_slab.get());
        dropSelf(ModBlocks.thyrium_bars.get());
        dropNameableBlockEntity(ModBlocks.fusion_furnace.get());
        dropSelf(ModBlocks.bronze_pressure_plate.get());
        dropSelf(ModBlocks.steel_pressure_plate.get());
        dropSelf(ModBlocks.sinisite_pressure_plate.get());
        dropSelf(ModBlocks.thyrium_pressure_plate.get());
    }

} // end class
