package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionFurnaceTileEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTiles
{
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = 
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Fusion.MODID);

    // tile entity type
    // We don't have a datafixer for our TileEntities, so we pass null into build.
    public static RegistryObject<BlockEntityType<FusionFurnaceTileEntity>> FUSION_FURNACE =
            TILE_ENTITY_TYPES.register("fusion_furnace", 
                    () -> BlockEntityType.Builder.of(FusionFurnaceTileEntity::new, 
                            ModBlocks.fusion_furnace.get()).build(null));
} // end class
