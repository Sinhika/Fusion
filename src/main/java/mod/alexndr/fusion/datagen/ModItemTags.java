package mod.alexndr.fusion.datagen;

import java.util.concurrent.CompletableFuture;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{
    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, Fusion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
        super.addTags(lookupProvider);
        registerDoorsSlabsAndStairs();
        registerDustTags();
        registerStorageBlockTags();
        registerIngotNuggetTags();
        registerToolTags(ModItems.ITEMS);
        registerArmorTags(ModItems.ITEMS);
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
    		.add(ModBlocks.bronze_door.get().asItem())
            .add(ModBlocks.steel_door.get().asItem())
            .add(ModBlocks.sinisite_door.get().asItem())
            .add(ModBlocks.thyrium_door.get().asItem());
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
