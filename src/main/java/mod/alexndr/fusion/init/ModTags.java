package mod.alexndr.fusion.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ModTags
{

    public static class Items
    {
        public static final ITag.INamedTag<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final ITag.INamedTag<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final ITag.INamedTag<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
        
        public static final ITag.INamedTag<Item> BLOCK_BRONZE = forgeTag("storage_blocks/bronze");
        
        private static ITag.INamedTag<Item> forgeTag(String name) {
            return ItemTags.makeWrapperTag("forge:" + name);
        }
    } // end class Items
    
    
    public static class Blocks
    {
        public static final ITag.INamedTag<Block> BLOCK_BRONZE = forgeTag("storage_blocks/bronze");
        

        private static ITag.INamedTag<Block> forgeTag(String name) {
            return BlockTags.makeWrapperTag("forge:" + name);
        }
    } // end class Blocks

    
} // end class ModTags
