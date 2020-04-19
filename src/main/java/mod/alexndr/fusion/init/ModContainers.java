package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link ContainerType}s.
 * Suppliers that create ContainerTypes are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the ContainerType Registry Event is fired by Forge and it is time for the mod to
 * register its ContainerTypes, our ContainerTypes are created and registered by the DeferredRegister.
 * The ContainerType Registry Event will always be called after the Block and Item registries are filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModContainers
{
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = 
            new DeferredRegister<>(ForgeRegistries.CONTAINERS, Fusion.MODID);

    // TODO - comment back in when FusionFurnaceContainer is created.
//    public static RegistryObject<ContainerType<FusionFurnaceContainer>> FUSION_FURNACE =
//            CONTAINER_TYPES.register("fusion_furnace", 
//                    () -> IForgeContainerType.create(FusionFurnaceContainer::new));
} // end class
