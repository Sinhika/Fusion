package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionArmorMaterial;
import mod.alexndr.fusion.content.FusionItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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

    // BASIC ITEMS
    // ingots, chunks, and nuggets
    public static final RegistryObject<Item> bronze_ingot = ITEMS.register("bronze_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> steel_ingot = ITEMS.register("steel_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> sinisite_ingot = ITEMS.register("sinisite_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> thyrium_ingot = ITEMS.register("thyrium_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> bronze_nugget = ITEMS.register("bronze_nugget", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> steel_nugget = ITEMS.register("steel_nugget", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> sinisite_nugget = ITEMS.register("sinisite_nugget", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> thyrium_nugget = ITEMS.register("thyrium_nugget", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> large_bronze_chunk = ITEMS.register("large_bronze_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_steel_chunk = ITEMS.register("large_steel_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_sinisite_chunk = ITEMS.register("large_sinisite_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_thyrium_chunk = ITEMS.register("large_thyrium_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> medium_bronze_chunk = ITEMS.register("medium_bronze_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_steel_chunk = ITEMS.register("medium_steel_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_sinisite_chunk = ITEMS.register("medium_sinisite_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_thyrium_chunk = ITEMS.register("medium_thyrium_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // rods/parts
    public static final RegistryObject<Item> sinisite_rod = ITEMS.register("sinisite_rod", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> thyrium_rod = ITEMS.register("thyrium_rod", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
   
    // ARMORS
    // bronze
    public static final RegistryObject<ArmorItem> bronze_helmet = ITEMS.register("bronze_helmet",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> bronze_leggings = ITEMS.register("bronze_leggings",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> bronze_chestplate = ITEMS.register("bronze_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> bronze_boots = ITEMS.register("bronze_boots",
            () -> new ArmorItem(FusionArmorMaterial.BRONZE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // steel
    public static final RegistryObject<ArmorItem> steel_helmet = ITEMS.register("steel_helmet",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> steel_leggings = ITEMS.register("steel_leggings",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> steel_chestplate = ITEMS.register("steel_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> steel_boots = ITEMS.register("steel_boots",
            () -> new ArmorItem(FusionArmorMaterial.STEEL, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // sinsite
    public static final RegistryObject<ArmorItem> sinisite_helmet = ITEMS.register("sinisite_helmet",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> sinisite_leggings = ITEMS.register("sinisite_leggings",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> sinisite_chestplate = ITEMS.register("sinisite_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> sinisite_boots = ITEMS.register("sinisite_boots",
            () -> new ArmorItem(FusionArmorMaterial.SINISITE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // thyrium
    public static final RegistryObject<ArmorItem> thyrium_helmet = ITEMS.register("thyrium_helmet",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> thyrium_leggings = ITEMS.register("thyrium_leggings",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> thyrium_chestplate = ITEMS.register("thyrium_chestplate",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> thyrium_boots = ITEMS.register("thyrium_boots",
            () -> new ArmorItem(FusionArmorMaterial.THYRIUM, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // TOOLS
    // bronze
    public static final RegistryObject<SwordItem> bronze_sword = ITEMS.register("bronze_sword",
            () -> new SwordItem(FusionItemTier.BRONZE, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> bronze_pickaxe = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(FusionItemTier.BRONZE, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> bronze_axe = ITEMS.register("bronze_axe",
            () -> new AxeItem(FusionItemTier.BRONZE, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> bronze_shovel = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(FusionItemTier.BRONZE, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> bronze_hoe = ITEMS.register("bronze_hoe",
            () -> new HoeItem(FusionItemTier.BRONZE,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // steel
    public static final RegistryObject<SwordItem> steel_sword = ITEMS.register("steel_sword",
            () -> new SwordItem(FusionItemTier.STEEL, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> steel_pickaxe = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(FusionItemTier.STEEL, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> steel_axe = ITEMS.register("steel_axe",
            () -> new AxeItem(FusionItemTier.STEEL, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> steel_shovel = ITEMS.register("steel_shovel",
            () -> new ShovelItem(FusionItemTier.STEEL, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> steel_hoe = ITEMS.register("steel_hoe",
            () -> new HoeItem(FusionItemTier.STEEL,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // sinisite
    // thyrium
    
    // shears
    public static final RegistryObject<ShearsItem> steel_shears = ITEMS.register("steel_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(FusionItemTier.STEEL.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));

    // bows
    
} // end class
