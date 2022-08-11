package mod.alexndr.fusion.datagen;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FusionBlockStateProvider extends SimpleBlockStateProvider
{

    public FusionBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Fusion.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // MODELS
        // ITEM MODELS
        this.itemModels().basicItem(ModBlocks.bronze_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.steel_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.sinisite_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.thyrium_door.get().asItem());
        
        this.basicBlockItem(ModBlocks.bronze_bars.get());
        this.basicBlockItem(ModBlocks.steel_bars.get());
        this.basicBlockItem(ModBlocks.thyrium_bars.get());
        this.basicBlockItem(ModBlocks.sinisite_bars.get());
        
       // BLOCKSTATES - doors
        this.doorBlockWithRenderType(ModBlocks.bronze_door.get(), modLoc("block/bronze_door_bottom"), modLoc("block/bronze_door_top"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.steel_door.get(), modLoc("block/steel_door_lower"), modLoc("block/steel_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.sinisite_door.get(), modLoc("block/sinisite_door_bottom"), modLoc("block/sinisite_door_top"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.thyrium_door.get(), modLoc("block/thyrium_door_bottom"),modLoc("block/thyrium_door_top"), "cutout");
        
        // BLOCKSTATES - bars
        this.buildBarsBlockState(ModBlocks.bronze_bars.get(), modLoc("block/bronze_bars"));
        this.buildBarsBlockState(ModBlocks.steel_bars.get(), modLoc("block/steel_bars"));
        this.buildBarsBlockState(ModBlocks.thyrium_bars.get(), modLoc("block/thyrium_bars"));
        this.buildBarsBlockState(ModBlocks.sinisite_bars.get(), modLoc("block/sinisite_bars"));
        
    } // end registerStatesAndModels()

} // end class
