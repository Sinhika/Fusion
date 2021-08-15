package mod.alexndr.fusion.datagen;

import java.util.List;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends MiningBlockTags
{

	public ModBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
	{
		super(gen, Fusion.MODID, existingFileHelper);
	}

	@Override
	protected void addTags()
	{
        registerStorageBlockTags();
        registerMiningTags();
        registerBeaconTags();
	}

    private void registerBeaconTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "beacon_base_blocks"))
    		.add(ModBlocks.bronze_block.get())
    		.add(ModBlocks.sinisite_block.get())
    		.add(ModBlocks.steel_block.get())
    		.add(ModBlocks.thyrium_block.get());
    }

    private void registerMiningTags()
    {			
    	// (mineable, stone, iron, diamond, netherite)
    	this.registerMineableTags(
    			List.of(ModBlocks.bronze_block.get(), ModBlocks.sinisite_block.get(), ModBlocks.steel_block.get(), 
    					ModBlocks.thyrium_block.get(), ModBlocks.fusion_furnace.get()),  // mineable
    			List.of(ModBlocks.bronze_block.get(), ModBlocks.steel_block.get()),
    			List.of(ModBlocks.sinisite_block.get(), ModBlocks.thyrium_block.get()), List.of(), List.of());
    }
    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/bronze"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/steel"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/sinisite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/thyrium"));
        		
        this.tag(TagUtils.forgeBlockTag("storage_blocks/bronze"))
        	.add(ModBlocks.bronze_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/steel"))
        	.add(ModBlocks.steel_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/sinisite"))
        	.add(ModBlocks.sinisite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/thyrium"))
        	.add(ModBlocks.thyrium_block.get());
    }
    
    
} // end class
