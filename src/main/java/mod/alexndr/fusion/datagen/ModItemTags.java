package mod.alexndr.fusion.datagen;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider
{
    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), 
                              Fusion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        registerDoorsSlabsAndStairs();
        registerDustTags();
    }

    private void registerDustTags()
    {
        this.tag(TagUtils.forgeTag("dusts"))
            .addTag(TagUtils.forgeTag("dusts/bronze"))
            .addTag(TagUtils.forgeTag("dusts/steel"))
            .addTag(TagUtils.forgeTag("dusts/sinisite"))
            .addTag(TagUtils.forgeTag("dusts/thyrium"));
        
        this.tag(TagUtils.forgeTag("dusts/bronze"))
            .add(ModItems.bronze_dust.get());
        this.tag(TagUtils.forgeTag("dusts/steel"))
            .add(ModItems.steel_dust.get());
        this.tag(TagUtils.forgeTag("dusts/sinisite"))
            .add(ModItems.sinisite_dust.get());
        this.tag(TagUtils.forgeTag("dusts/thyrium"))
            .add(ModItems.thyrium_dust.get());
            
    } // end registerDustTags()
    
    private void registerDoorsSlabsAndStairs()
    {
    	this.tag(TagUtils.modTag("minecraft", "doors"))
    		.add(ModBlocks.bronze_door.get().asItem());
    	this.tag(TagUtils.modTag("minecraft","stairs"))
			.add(ModBlocks.bronze_brick_stairs.get().asItem())
			.add(ModBlocks.steel_brick_stairs.get().asItem())
			.add(ModBlocks.sinisite_brick_stairs.get().asItem())
			.add(ModBlocks.thyrium_brick_stairs.get().asItem());
    	this.tag(TagUtils.modTag("minecraft","slabs"))
			.add(ModBlocks.steel_brick_slab.get().asItem())
			.add(ModBlocks.bronze_brick_slab.get().asItem())
			.add(ModBlocks.sinisite_brick_slab.get().asItem())
			.add(ModBlocks.thyrium_brick_slab.get().asItem());
    }

} // end class
