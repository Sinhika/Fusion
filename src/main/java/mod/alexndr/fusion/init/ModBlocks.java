package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionFurnaceBlock;
import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
                    .strength(5.0F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    // steel
    public static final RegistryObject<Block> steel_block = BLOCKS.register("steel_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.METAL)
                    .strength(7.0F, 12.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    
    // sinisite
    public static final RegistryObject<Block> sinisite_block = BLOCKS.register("sinisite_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.COLOR_BLUE)
                    .strength(10.0F, 24.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    
    // thyrium
    public static final RegistryObject<Block> thyrium_block = BLOCKS.register("thyrium_block",
            () -> new Block(Block.Properties.of(Material.METAL,
                    MaterialColor.COLOR_CYAN)
                    .strength(7.0F, 12.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
     
    // Furnace
    public static final RegistryObject<FusionFurnaceBlock> fusion_furnace = BLOCKS.register("fusion_furnace",
            () -> new FusionFurnaceBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
    
    // AESTHETICS STUFF
    // Blocks - bricks - Fusion
    public static RegistryObject<Block> bronze_bricks = BLOCKS.register("bronze_bricks",
            () -> new Block(Block.Properties.copy(bronze_block.get())));
    public static RegistryObject<Block> steel_bricks = BLOCKS.register("steel_bricks",
            () -> new Block(Block.Properties.copy(steel_block.get())));
    public static RegistryObject<Block> sinisite_bricks = BLOCKS.register("sinisite_bricks",
            () -> new Block(Block.Properties.copy(sinisite_block.get())));
    public static RegistryObject<Block> thyrium_bricks = BLOCKS.register("thyrium_bricks",
            () -> new Block(Block.Properties.copy(thyrium_block.get())));

    // Blocks - slabs - fusion
    public static RegistryObject<SlabBlock> bronze_brick_slab = BLOCKS.register("bronze_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(bronze_block.get())));
    public static RegistryObject<SlabBlock> steel_brick_slab = BLOCKS.register("steel_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(steel_block.get())));
    public static RegistryObject<SlabBlock> sinisite_brick_slab = BLOCKS.register("sinisite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(sinisite_block.get())));
    public static RegistryObject<SlabBlock> thyrium_brick_slab = BLOCKS.register("thyrium_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(thyrium_block.get())));

    // Blocks - stairs - fusion
    public static RegistryObject<StairBlock> bronze_brick_stairs = BLOCKS.register("bronze_brick_stairs", 
            () -> new StairBlock( () -> bronze_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(bronze_bricks.get())));
    public static RegistryObject<StairBlock> steel_brick_stairs = BLOCKS.register("steel_brick_stairs", 
            () -> new StairBlock( () -> steel_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(steel_bricks.get())));
    public static RegistryObject<StairBlock> sinisite_brick_stairs = BLOCKS.register("sinisite_brick_stairs", 
            () -> new StairBlock( () -> sinisite_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(sinisite_bricks.get())));
    public static RegistryObject<StairBlock> thyrium_brick_stairs = BLOCKS.register("thyrium_brick_stairs", 
            () -> new StairBlock( () -> thyrium_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(thyrium_bricks.get())));
    
    // Blocks - bars - fusion
    public static RegistryObject<IronBarsBlock> bronze_bars = BLOCKS.register("bronze_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> steel_bars = BLOCKS.register("steel_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> sinisite_bars = BLOCKS.register("sinisite_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> thyrium_bars = BLOCKS.register("thyrium_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));

    // Blocks - doors - fusion
    public static RegistryObject<DoorBlock> bronze_door = BLOCKS.register("bronze_door",
            () -> new DoorBlock(Block.Properties.copy(bronze_block.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> steel_door = BLOCKS.register("steel_door",
            () -> new DoorBlock(Block.Properties.copy(steel_block.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> thyrium_door = BLOCKS.register("thyrium_door",
            () -> new DoorBlock(Block.Properties.copy(thyrium_block.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> sinisite_door = BLOCKS.register("sinisite_door",
            () -> new DoorBlock(Block.Properties.copy(sinisite_block.get()).noOcclusion()));
    
    // Blocks - pressure plates
    public static final RegistryObject<MultifunctionPressurePlateBlock> bronze_pressure_plate = BLOCKS.register("bronze_pressure_plate", 
                    () -> new MultifunctionPressurePlateBlock(150, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
                                                              Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_ORANGE)
                                                                .noCollission().strength(0.5F).sound(SoundType.METAL)));
            
    public static final RegistryObject<MultifunctionPressurePlateBlock> steel_pressure_plate =  BLOCKS.register("steel_pressure_plate", 
                    () -> new MultifunctionPressurePlateBlock(150, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
                                                              Block.Properties.of(Material.METAL)
                                                                .noCollission().strength(0.5F).sound(SoundType.METAL)));
    
    public static final RegistryObject<MultifunctionPressurePlateBlock> sinisite_pressure_plate = BLOCKS.register("sinisite_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(75, MultifunctionPressurePlateBlock.Sensitivity.PLAYERS, 10, 
                    Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
                      .noCollission().strength(0.5F).sound(SoundType.METAL)));
    
    public static final RegistryObject<MultifunctionPressurePlateBlock> thyrium_pressure_plate = BLOCKS.register("thyrium_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(75, MultifunctionPressurePlateBlock.Sensitivity.LIVING_WEIGHTED, 10, 
                                                      Block.Properties.of(Material.METAL, MaterialColor.COLOR_CYAN)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL)));
          
} // end class
