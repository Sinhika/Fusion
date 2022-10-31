package mod.alexndr.fusion.datagen;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
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
        doorStatesAndModels();
        barStatesAndModels();
        pressurePlateStatesAndModels();
    } // end registerStatesAndModels()

    
    /**
     * generate this mod's bar models and blockstates and item models.
     */
    private void barStatesAndModels()
    {
        this.basicBlockItem(ModBlocks.bronze_bars.get());
        this.basicBlockItem(ModBlocks.steel_bars.get());
        this.basicBlockItem(ModBlocks.thyrium_bars.get());
        this.basicBlockItem(ModBlocks.sinisite_bars.get());
        
        // BLOCKSTATES - bars
        this.buildBarsBlockState(ModBlocks.bronze_bars.get(), modLoc("block/bronze_bars"));
        this.buildBarsBlockState(ModBlocks.steel_bars.get(), modLoc("block/steel_bars"));
        this.buildBarsBlockState(ModBlocks.thyrium_bars.get(), modLoc("block/thyrium_bars"));
        this.buildBarsBlockState(ModBlocks.sinisite_bars.get(), modLoc("block/sinisite_bars"));

    } // end barStatesAndModels
    
    /**
    * generate this mod's door models and blockstates and/or item models.
    */
   private void doorStatesAndModels()
   {
       // MODELS
       // ITEM MODELS
       this.itemModels().basicItem(ModBlocks.bronze_door.get().asItem());
       this.itemModels().basicItem(ModBlocks.steel_door.get().asItem());
       this.itemModels().basicItem(ModBlocks.sinisite_door.get().asItem());
       this.itemModels().basicItem(ModBlocks.thyrium_door.get().asItem());

       // BLOCKSTATES - doors
       this.doorBlockWithRenderType(ModBlocks.bronze_door.get(), modLoc("block/bronze_door_lower"), modLoc("block/bronze_door_upper"), "cutout");
       this.doorBlockWithRenderType(ModBlocks.steel_door.get(), modLoc("block/steel_door_lower"), modLoc("block/steel_door_upper"), "cutout");
       this.doorBlockWithRenderType(ModBlocks.sinisite_door.get(), modLoc("block/sinisite_door_bottom"), modLoc("block/sinisite_door_top"), "cutout");
       this.doorBlockWithRenderType(ModBlocks.thyrium_door.get(), modLoc("block/thyrium_door_bottom"),modLoc("block/thyrium_door_top"), "cutout");
       
  } // end doorStatesAndModels()
   

    /**
     * generate this mod's pressure plates models and blockstates and item models.
     */
    private void pressurePlateStatesAndModels()
    {
        // MODELS
        ModelFile bronzePlateModel = this.models().pressurePlate("bronze_plate", 
                new ResourceLocation(Fusion.MODID, "block/bronze_block"));
        ModelFile bronzePlateModel_down = this.models().pressurePlateDown("bronze_plate_down", 
                new ResourceLocation(Fusion.MODID, "block/bronze_block"));
        ModelFile steelPlateModel = this.models().pressurePlate("steel_plate", 
                new ResourceLocation(Fusion.MODID, "block/steel_block"));
        ModelFile steelPlateModel_down = this.models().pressurePlateDown("steel_plate_down", 
                new ResourceLocation(Fusion.MODID, "block/steel_block"));
        ModelFile sinisitePlateModel = this.models().pressurePlate("sinisite_plate", 
                new ResourceLocation(Fusion.MODID, "block/sinisite_block"));
        ModelFile sinisitePlateModel_down = this.models().pressurePlateDown("sinisite_plate_down", 
                new ResourceLocation(Fusion.MODID, "block/sinisite_block"));
        ModelFile thyriumPlateModel = this.models().pressurePlate("thyrium_plate", 
                new ResourceLocation(Fusion.MODID, "block/thyrium_block"));
        ModelFile thyriumPlateModel_down = this.models().pressurePlateDown("thyrium_plate_down", 
                new ResourceLocation(Fusion.MODID, "block/thyrium_block"));
        
        // ITEM MODELS
        this.itemModels().withExistingParent("bronze_pressure_plate", new ResourceLocation(Fusion.MODID, "block/bronze_plate"));
        this.itemModels().withExistingParent("steel_pressure_plate", new ResourceLocation(Fusion.MODID, "block/steel_plate"));
        this.itemModels().withExistingParent("sinisite_pressure_plate", new ResourceLocation(Fusion.MODID, "block/sinisite_plate"));
        this.itemModels().withExistingParent("thyrium_pressure_plate", new ResourceLocation(Fusion.MODID, "block/thyrium_plate"));

        // BLOCKSTATES
        this.buildWeightedPressurePlateBlockState(ModBlocks.bronze_pressure_plate.get(), bronzePlateModel, bronzePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.steel_pressure_plate.get(), steelPlateModel, steelPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.sinisite_pressure_plate.get(), sinisitePlateModel, sinisitePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.thyrium_pressure_plate.get(), thyriumPlateModel, thyriumPlateModel_down);
        
    } // end pressurePlateStatesAndModels()

} // end class
