package mod.alexndr.fusion.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;

public class ModTags
{

    public static class Items
    {
        public static final Tag.Named<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final Tag.Named<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final Tag.Named<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
        public static final Tag.Named<Item> INGOTS_MYTHRIL = forgeTag("ingots/mythril");
        public static final Tag.Named<Item> GEMS_ONYX = forgeTag("gems/onyx");
        public static final Tag.Named<Item> INGOTS_ADAMANTIUM = forgeTag("ingots/adamantium");
        
        public static final Tag.Named<Item> BLOCK_BRONZE = forgeTag("storage_blocks/bronze");
        public static final Tag.Named<Item> BLOCK_STEEL = forgeTag("storage_blocks/steel");
        
        private static Tag.Named<Item> forgeTag(String name) {
            return ItemTags.bind("forge:" + name);
        }
    } // end class Items
    
    
    public static class Blocks
    {
        public static final Tag.Named<Block> BLOCK_BRONZE = forgeTag("storage_blocks/bronze");
        

        private static Tag.Named<Block> forgeTag(String name) {
            return BlockTags.bind("forge:" + name);
        }
    } // end class Blocks

    
} // end class ModTags
