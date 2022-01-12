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
        registerStorageBlockTags();
        registerIngotNuggetTags();
        registerMiscTags();
    }

    
    private void registerIngotNuggetTags()
    {
    	// ingots
        this.tag(TagUtils.forgeTag("ingots"))
	        .addTag(TagUtils.forgeTag("ingots/bronze"))
	        .addTag(TagUtils.forgeTag("ingots/steel"))
	        .addTag(TagUtils.forgeTag("ingots/sinisite"))
	        .addTag(TagUtils.forgeTag("ingots/thyrium"));
        
	    this.tag(TagUtils.forgeTag("ingots/bronze"))
	        .add(ModItems.bronze_ingot.get());
	    this.tag(TagUtils.forgeTag("ingots/steel"))
	        .add(ModItems.steel_ingot.get());
	    this.tag(TagUtils.forgeTag("ingots/sinisite"))
	        .add(ModItems.sinisite_ingot.get());
	    this.tag(TagUtils.forgeTag("ingots/thyrium"))
	        .add(ModItems.thyrium_ingot.get());
    	
	    // nuggets
        this.tag(TagUtils.forgeTag("nuggets"))
	        .addTag(TagUtils.forgeTag("nuggets/bronze"))
	        .addTag(TagUtils.forgeTag("nuggets/steel"))
	        .addTag(TagUtils.forgeTag("nuggets/sinisite"))
	        .addTag(TagUtils.forgeTag("nuggets/thyrium"));
    
	    this.tag(TagUtils.forgeTag("nuggets/bronze"))
	        .add(ModItems.bronze_nugget.get());
	    this.tag(TagUtils.forgeTag("nuggets/steel"))
	        .add(ModItems.steel_nugget.get());
	    this.tag(TagUtils.forgeTag("nuggets/sinisite"))
	        .add(ModItems.sinisite_nugget.get());
	    this.tag(TagUtils.forgeTag("nuggets/thyrium"))
	        .add(ModItems.thyrium_nugget.get());
	    
    } // end registerIngotNuggetTags()
    
    
    private void registerMiscTags()
    {
    	this.tag(TagUtils.forgeTag("shears"))
			.add(ModItems.steel_shears.get());
    } // end registerMiscTags()
    
    
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
    } // end registerDoorsSlabsAndStairs()

    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeTag("storage_blocks"))
        	.addTag(TagUtils.forgeTag("storage_blocks/bronze"))
        	.addTag(TagUtils.forgeTag("storage_blocks/steel"))
        	.addTag(TagUtils.forgeTag("storage_blocks/sinisite"))
        	.addTag(TagUtils.forgeTag("storage_blocks/thyrium"));
        		
        this.tag(TagUtils.forgeTag("storage_blocks/bronze"))
        	.add(ModBlocks.bronze_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/steel"))
        	.add(ModBlocks.steel_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/sinisite"))
        	.add(ModBlocks.sinisite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/thyrium"))
        	.add(ModBlocks.thyrium_block.get().asItem());
    } // end registerStorageBlockTags()
    
    

} // end class
