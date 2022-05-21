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
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void registerStatesAndModels()
    {
        // MODELS
        // ITEM MODELS
        // BLOCKSTATES
        this.doorBlock(ModBlocks.steel_door.get(), new ResourceLocation(Fusion.MODID, "block/steel_door_lower"),
                new ResourceLocation(Fusion.MODID, "block/steel_door_upper"));
        this.doorBlock(ModBlocks.sinisite_door.get(), new ResourceLocation(Fusion.MODID, "block/sinisite_door_bottom"),
                new ResourceLocation(Fusion.MODID, "block/sinisite_door_top"));
        this.doorBlock(ModBlocks.thyrium_door.get(), new ResourceLocation(Fusion.MODID, "block/thyrium_door_bottom"),
                new ResourceLocation(Fusion.MODID, "block/thyrium_door_top"));
        
    } // end registerStatesAndModels()

} // end class
