package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTiles
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = 
            new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Fusion.MODID);

} // end class
