package mod.alexndr.fusion.init;

import java.util.function.ToIntFunction;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Fusion.MODID);
    
    // Metal Blocks
    // bronze
    public static final RegistryObject<Block> bronze_block = BLOCKS.register("bronze_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.TERRACOTTA_YELLOW)
                    .strength(5.0F, 10.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));
    // steel
    public static final RegistryObject<Block> steel_block = BLOCKS.register("steel_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.METAL)
                    .strength(7.0F, 12.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));
    
    // sinisite
    public static final RegistryObject<Block> sinisite_block = BLOCKS.register("sinisite_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.COLOR_BLUE)
                    .strength(10.0F, 24.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));
    
    // thyrium
    public static final RegistryObject<Block> thyrium_block = BLOCKS.register("thyrium_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.COLOR_CYAN)
                    .strength(7.0F, 12.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));
     
    // Furnace
    public static final RegistryObject<FusionFurnaceBlock> fusion_furnace = BLOCKS.register("fusion_furnace",
            () -> new FusionFurnaceBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F)
                    .lightLevel(lit_makes_light(13)).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    
    private static ToIntFunction<BlockState> lit_makes_light(int foo) {
        return (bar) -> {
           return bar.getValue(BlockStateProperties.LIT) ? foo : 0;
        };
     }    
} // end class
