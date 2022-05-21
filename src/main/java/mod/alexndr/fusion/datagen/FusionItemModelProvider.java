package mod.alexndr.fusion.datagen;

import mod.alexndr.fusion.Fusion;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FusionItemModelProvider extends ItemModelProvider
{

    public FusionItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, Fusion.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        // shears
        this.withExistingParent("bronze_shears", "handheld").texture("layer0",
                new ResourceLocation(Fusion.MODID, "item/bronze_shears"));
        this.withExistingParent("sinisite_shears", "handheld").texture("layer0",
                new ResourceLocation(Fusion.MODID, "item/sinisite_shears"));
        this.withExistingParent("thyrium_shears", "handheld").texture("layer0",
                new ResourceLocation(Fusion.MODID, "item/thyrium_shears"));
        
        // doors
        this.withExistingParent("steel_door", "generated").texture("layer0",
                new ResourceLocation(Fusion.MODID, "item/steel_door"));
        this.withExistingParent("sinisite_door", "generated").texture("layer0",
                new ResourceLocation(Fusion.MODID, "item/sinisite_door"));
        this.withExistingParent("thyrium_door", "generated").texture("layer0",
                new ResourceLocation(Fusion.MODID, "item/thyrium_door"));
     } // end registerModels()

} // end class
