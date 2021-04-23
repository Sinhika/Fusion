package mod.alexndr.fusion.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class FusionLootInjectorProvider extends LootTableInjectorProvider
{

    public FusionLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        
        // abandoned mineshaft
        LootPool.Builder foo = createChestPool(1, 1, 0.75F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_sword.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_shovel.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "abandoned_mineshaft", foo);
       
        // desert_pyramid
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(3, 7))))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(Fusion.MODID, "desert_pyramid", foo);
        
        // igloo_chest
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_shovel.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "igloo_chest", foo);
                
        // jungle_temple
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_hoe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_hoe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_hoe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(3, 7))))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 1))));
        addInjectionTable(Fusion.MODID, "jungle_temple", foo);
              
        // simple_dungeon
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_helmet.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_leggings.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_boots.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_helmet.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_chestplate.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_leggings.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_boots.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_sword.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
            .add(ItemLootEntry.lootTableItem(ModItems.large_thyrium_chunk.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 1))))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(Fusion.MODID, "simple_dungeon", foo);
        
        // spawn_bonus_chest
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_hoe.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "spawn_bonus_chest", foo);

        // stronghold
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_helmet.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_leggings.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_boots.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_helmet.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_chestplate.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_leggings.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_boots.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_sword.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_sword.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.sinisite_shovel.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "stronghold", foo);
        
        // village_armorer
        foo = createChestPool(1, 1, 0.25F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_helmet.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_leggings.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_boots.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_helmet.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_chestplate.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_leggings.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_boots.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
            .add(ItemLootEntry.lootTableItem(ModItems.large_thyrium_chunk.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 1))))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 3))));
        addInjectionTable(Fusion.MODID, "village_armorer", foo);
        
        // village_fletcher
        foo = createChestPool(1, 1, 0.25F)
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_bow.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_rod.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(Fusion.MODID, "village_fletcher", foo);
        
        // village_mason
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "village_mason", foo);
        
        // village_shepherd
        foo = createChestPool(1, 1, 0.25F)
            .add(ItemLootEntry.lootTableItem(ModItems.steel_shears.get()).setWeight(2));
        addInjectionTable(Fusion.MODID, "village_shepherd", foo);
        
        // village_toolsmith
        foo = createChestPool(1, 1, 0.25F)
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_hoe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_shovel.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_hoe.get()).setWeight(2))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_hoe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
            .add(ItemLootEntry.lootTableItem(ModItems.large_steel_chunk.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.large_thyrium_chunk.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 1))))
            .add(ItemLootEntry.lootTableItem(ModItems.bronze_ingot.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.steel_ingot.get()).setWeight(2)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 3))));
        addInjectionTable(Fusion.MODID, "village_toolsmith", foo);
        
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.bronze_sword.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.steel_sword.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.thyrium_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.thyrium_axe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.large_steel_chunk.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.large_thyrium_chunk.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.bronze_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.steel_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))));
        addInjectionTable(Fusion.MODID, "village_weaponsmith", foo);
        
        return tables;
    } // end getTables()

} // end class
