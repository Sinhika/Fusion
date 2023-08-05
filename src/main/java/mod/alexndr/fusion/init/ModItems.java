package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionArmorMaterial;
import mod.alexndr.fusion.content.FusionItemTiers;
import mod.alexndr.fusion.content.SinisiteBow;
import mod.alexndr.fusion.content.ThyriumBow;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fusion.MODID);

    // BASIC ITEMS
    // ingots, chunks, and nuggets
    public static final RegistryObject<Item> bronze_ingot = ITEMS.register("bronze_ingot", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> steel_ingot = ITEMS.register("steel_ingot", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> sinisite_ingot = ITEMS.register("sinisite_ingot", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> thyrium_ingot = ITEMS.register("thyrium_ingot", 
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> bronze_nugget = ITEMS.register("bronze_nugget", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> steel_nugget = ITEMS.register("steel_nugget", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> sinisite_nugget = ITEMS.register("sinisite_nugget", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> thyrium_nugget = ITEMS.register("thyrium_nugget", 
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> bronze_dust = ITEMS.register("bronze_dust", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> steel_dust = ITEMS.register("steel_dust", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> sinisite_dust = ITEMS.register("sinisite_dust", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> thyrium_dust = ITEMS.register("thyrium_dust", 
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> large_bronze_chunk = ITEMS.register("large_bronze_chunk", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> large_steel_chunk = ITEMS.register("large_steel_chunk", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> large_sinisite_chunk = ITEMS.register("large_sinisite_chunk", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> large_thyrium_chunk = ITEMS.register("large_thyrium_chunk", 
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> medium_bronze_chunk = ITEMS.register("medium_bronze_chunk", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> medium_steel_chunk = ITEMS.register("medium_steel_chunk", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> medium_sinisite_chunk = ITEMS.register("medium_sinisite_chunk", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> medium_thyrium_chunk = ITEMS.register("medium_thyrium_chunk", 
            () -> new Item(new Item.Properties()));
    
    // rods/parts
    public static final RegistryObject<Item> sinisite_rod = ITEMS.register("sinisite_rod", 
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> thyrium_rod = ITEMS.register("thyrium_rod", 
            () -> new Item(new Item.Properties()));
   
    // ARMORS
    // bronze
    public static final RegistryObject<ArmorItem> bronze_helmet = ITEMS.register("bronze_helmet",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> bronze_leggings = ITEMS.register("bronze_leggings",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> bronze_chestplate = ITEMS.register("bronze_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> bronze_boots = ITEMS.register("bronze_boots",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    
    // steel
    public static final RegistryObject<ArmorItem> steel_helmet = ITEMS.register("steel_helmet",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> steel_leggings = ITEMS.register("steel_leggings",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> steel_chestplate = ITEMS.register("steel_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> steel_boots = ITEMS.register("steel_boots",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    
    // sinsite
    public static final RegistryObject<ArmorItem> sinisite_helmet = ITEMS.register("sinisite_helmet",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> sinisite_leggings = ITEMS.register("sinisite_leggings",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> sinisite_chestplate = ITEMS.register("sinisite_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> sinisite_boots = ITEMS.register("sinisite_boots",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    
    // thyrium
    public static final RegistryObject<ArmorItem> thyrium_helmet = ITEMS.register("thyrium_helmet",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> thyrium_leggings = ITEMS.register("thyrium_leggings",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> thyrium_chestplate = ITEMS.register("thyrium_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<ArmorItem> thyrium_boots = ITEMS.register("thyrium_boots",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    
    // TOOLS
    // bronze
    public static final RegistryObject<SwordItem> bronze_sword = ITEMS.register("bronze_sword",
            () -> new SwordItem(FusionItemTiers.BRONZE, 3, -2.4F,
                                new Item.Properties()));
    public static final RegistryObject<PickaxeItem> bronze_pickaxe = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(FusionItemTiers.BRONZE, 1, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<AxeItem> bronze_axe = ITEMS.register("bronze_axe",
            () -> new AxeItem(FusionItemTiers.BRONZE, 6.0F, -3.1F,
                    new Item.Properties()));
    public static final RegistryObject<ShovelItem> bronze_shovel = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(FusionItemTiers.BRONZE, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final RegistryObject<HoeItem> bronze_hoe = ITEMS.register("bronze_hoe",
            () -> new HoeItem(FusionItemTiers.BRONZE, -1, -1.0F,
                    new Item.Properties()) {});
    
    // steel
    public static final RegistryObject<SwordItem> steel_sword = ITEMS.register("steel_sword",
            () -> new SwordItem(FusionItemTiers.STEEL, 3, -2.4F,
                                new Item.Properties()));
    public static final RegistryObject<PickaxeItem> steel_pickaxe = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(FusionItemTiers.STEEL, 1, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<AxeItem> steel_axe = ITEMS.register("steel_axe",
            () -> new AxeItem(FusionItemTiers.STEEL, 5.0F, -3.1F,
                    new Item.Properties()));
    public static final RegistryObject<ShovelItem> steel_shovel = ITEMS.register("steel_shovel",
            () -> new ShovelItem(FusionItemTiers.STEEL, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final RegistryObject<HoeItem> steel_hoe = ITEMS.register("steel_hoe",
            () -> new HoeItem(FusionItemTiers.STEEL, -3, -1.0F,
                    new Item.Properties()) {});
    
    // sinisite
    public static final RegistryObject<SwordItem> sinisite_sword = ITEMS.register("sinisite_sword",
            () -> new SwordItem(FusionItemTiers.SINISITE, 3, -2.4F,
                                new Item.Properties()));
    public static final RegistryObject<PickaxeItem> sinisite_pickaxe = ITEMS.register("sinisite_pickaxe",
            () -> new PickaxeItem(FusionItemTiers.SINISITE, 1, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<AxeItem> sinisite_axe = ITEMS.register("sinisite_axe",
            () -> new AxeItem(FusionItemTiers.SINISITE, 1.0F, -3.1F,
                    new Item.Properties()));
    public static final RegistryObject<ShovelItem> sinisite_shovel = ITEMS.register("sinisite_shovel",
            () -> new ShovelItem(FusionItemTiers.SINISITE, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final RegistryObject<HoeItem> sinisite_hoe = ITEMS.register("sinisite_hoe",
            () -> new HoeItem(FusionItemTiers.SINISITE, -3, 0.0F,
                    new Item.Properties()) {});
    
    // thyrium
    public static final RegistryObject<SwordItem> thyrium_sword = ITEMS.register("thyrium_sword",
            () -> new SwordItem(FusionItemTiers.THYRIUM, 3, -2.4F,
                                new Item.Properties()));
    public static final RegistryObject<PickaxeItem> thyrium_pickaxe = ITEMS.register("thyrium_pickaxe",
            () -> new PickaxeItem(FusionItemTiers.THYRIUM, 1, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<AxeItem> thyrium_axe = ITEMS.register("thyrium_axe",
            () -> new AxeItem(FusionItemTiers.THYRIUM, 3.0F, -3.1F,
                    new Item.Properties()));
    public static final RegistryObject<ShovelItem> thyrium_shovel = ITEMS.register("thyrium_shovel",
            () -> new ShovelItem(FusionItemTiers.THYRIUM, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final RegistryObject<HoeItem> thyrium_hoe = ITEMS.register("thyrium_hoe",
            () -> new HoeItem(FusionItemTiers.THYRIUM, -3, 0.0F,
                    new Item.Properties()) {});
    
    // shears
    public static final RegistryObject<ShearsItem> steel_shears = ITEMS.register("steel_shears",
            () -> new ShearsItem(new Item.Properties().durability(FusionItemTiers.STEEL.getUses())
                    ));
    public static final RegistryObject<ShearsItem> bronze_shears = ITEMS.register("bronze_shears",
            () -> new ShearsItem(new Item.Properties().durability(FusionItemTiers.BRONZE.getUses())
                    ));
    public static final RegistryObject<ShearsItem> sinisite_shears = ITEMS.register("sinisite_shears",
            () -> new ShearsItem(new Item.Properties().durability(FusionItemTiers.SINISITE.getUses())
                    ));
    public static final RegistryObject<ShearsItem> thyrium_shears = ITEMS.register("thyrium_shears",
            () -> new ShearsItem(new Item.Properties().durability(FusionItemTiers.THYRIUM.getUses())
                    ));

    // bows
    public static final RegistryObject<SinisiteBow> sinisite_bow = ITEMS.register("sinisite_bow",
            () -> new SinisiteBow(new Item.Properties().durability(1200)
                    ));
    public static final RegistryObject<ThyriumBow> thyrium_bow = ITEMS.register("thyrium_bow",
            () -> new ThyriumBow(new Item.Properties().durability(900)
                    ));
    
} // end class
