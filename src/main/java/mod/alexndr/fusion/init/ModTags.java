package mod.alexndr.fusion.init;

import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{

    public static class Items
    {
        public static final TagKey<Item> INGOTS_COPPER = TagUtils.forgeTag("ingots/copper");
        public static final TagKey<Item> INGOTS_TIN = TagUtils.forgeTag("ingots/tin");
        public static final TagKey<Item> INGOTS_BRONZE = TagUtils.forgeTag("ingots/bronze");
        public static final TagKey<Item> INGOTS_STEEL = TagUtils.forgeTag("ingots/steel");
        public static final TagKey<Item> INGOTS_MYTHRIL = TagUtils.forgeTag("ingots/mythril");
        public static final TagKey<Item> GEMS_ONYX = TagUtils.forgeTag("gems/onyx");
        public static final TagKey<Item> INGOTS_ADAMANTIUM = TagUtils.forgeTag("ingots/adamantium");
        
        public static final TagKey<Item> BLOCK_BRONZE = TagUtils.forgeTag("storage_blocks/bronze");
        public static final TagKey<Item> BLOCK_STEEL = TagUtils.forgeTag("storage_blocks/steel");
        
    } // end class Items
    
    
    public static class Blocks
    {
        public static final TagKey<Block> BLOCK_BRONZE = TagUtils.forgeBlockTag("storage_blocks/bronze");
        public static final TagKey<Item> BLOCK_STEEL = TagUtils.forgeTag("storage_blocks/steel");
    } // end class Blocks

    
} // end class ModTags
