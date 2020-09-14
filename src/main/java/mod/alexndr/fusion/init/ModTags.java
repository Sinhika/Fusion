package mod.alexndr.fusion.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags
{

    public static class Items
    {
        public static final Tag<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final Tag<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final Tag<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
        
        public static final Tag<Item> BLOCK_BRONZE = forgeTag("storage_blocks/bronze");
        
//        private static Tag<Item> tag(String name) {
//            return new ItemTags.Wrapper(new ResourceLocation(OnlySilver.MODID, name));
//        }

        private static Tag<Item> forgeTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
        
    } // end class Items
    
    
    public static class Blocks
    {
        public static final Tag<Block> BLOCK_BRONZE = forgeTag("storage_blocks/bronze");
        
//        private static Tag<Block> tag(String name) {
//            return new BlockTags.Wrapper(new ResourceLocation(OnlySilver.MODID, name));
//        }

        private static Tag<Block> forgeTag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end class Blocks

    
} // end class ModTags
