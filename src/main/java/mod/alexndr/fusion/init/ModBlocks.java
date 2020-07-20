package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
            () -> new Block(Block.Properties.create(Material.IRON,
                    MaterialColor.YELLOW_TERRACOTTA)
                    .hardnessAndResistance(5.0F, 10.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    // steel
    public static final RegistryObject<Block> steel_block = BLOCKS.register("steel_block",
            () -> new Block(Block.Properties.create(Material.IRON,
                    MaterialColor.IRON)
                    .hardnessAndResistance(7.0F, 12.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    
    // sinisite
    public static final RegistryObject<Block> sinisite_block = BLOCKS.register("sinisite_block",
            () -> new Block(Block.Properties.create(Material.IRON,
                    MaterialColor.BLUE)
                    .hardnessAndResistance(10.0F, 24.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    
    // thyrium
    public static final RegistryObject<Block> thyrium_block = BLOCKS.register("thyrium_block",
            () -> new Block(Block.Properties.create(Material.IRON,
                    MaterialColor.CYAN)
                    .hardnessAndResistance(7.0F, 12.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
     
    // Furnace
    public static final RegistryObject<FusionFurnaceBlock> fusion_furnace = BLOCKS.register("fusion_furnace",
            () -> new FusionFurnaceBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3.5F, 12.0F)
                    .setLightLevel((foo) -> { return 13;}).harvestTool(ToolType.PICKAXE)));
} // end class
