package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            new DeferredRegister<>(ForgeRegistries.ITEMS, Fusion.MODID);

    // ingots, chunks, and nuggets
    public static final RegistryObject<Item> bronze_ingot = ITEMS.register("bronze_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> steel_ingot = ITEMS.register("steel_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> sinisite_ingot = ITEMS.register("sinisite_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> thyrium_ingot = ITEMS.register("thyrium_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
} // end class
