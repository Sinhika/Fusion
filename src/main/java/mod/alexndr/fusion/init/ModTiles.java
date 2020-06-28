package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTiles
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = 
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Fusion.MODID);

    // tile entity type
    // We don't have a datafixer for our TileEntities, so we pass null into build.
    public static RegistryObject<TileEntityType<FusionFurnaceTileEntity>> FUSION_FURNACE =
            TILE_ENTITY_TYPES.register("fusion_furnace", 
                    () -> TileEntityType.Builder.create(FusionFurnaceTileEntity::new, 
                            ModBlocks.fusion_furnace.get()).build(null));
} // end class
