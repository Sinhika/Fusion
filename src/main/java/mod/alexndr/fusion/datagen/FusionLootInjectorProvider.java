package mod.alexndr.fusion.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FusionLootInjectorProvider extends LootTableInjectorProvider
{

    public FusionLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        
        // abandoned mineshaft
        LootPool.Builder foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_shovel.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_shovel.get()).setWeight(2));
        addInjectionTable(Fusion.MODID, "abandoned_mineshaft", foo);
       
        // desert_pyramid
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.bronze_helmet.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_leggings.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_boots.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_sword.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_axe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(10)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
            .add(LootItem.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
            .add(LootItem.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(Fusion.MODID, "desert_pyramid", foo);
        
        // igloo_chest
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.steel_shovel.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "igloo_chest", foo);
                
        // jungle_temple
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.bronze_helmet.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_leggings.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_boots.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_sword.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_axe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_shovel.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_hoe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(10)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
            .add(LootItem.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
            .add(LootItem.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))));
        addInjectionTable(Fusion.MODID, "jungle_temple", foo);
              
        // simple_dungeon
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(5)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
            .add(LootItem.lootTableItem(ModItems.large_steel_chunk.get()).setWeight(5)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
            .add(LootItem.lootTableItem(ModItems.large_thyrium_chunk.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))))
            .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.steel_ingot.get()).setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
            .add(LootItem.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(Fusion.MODID, "simple_dungeon", foo);
        
        // shipwreck -- no steel, it rusted away
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(4)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
            .add(LootItem.lootTableItem(ModItems.large_thyrium_chunk.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))))
            .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(6)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.thyrium_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
            .add(LootItem.lootTableItem(ModItems.sinisite_ingot.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(Fusion.MODID, "shipwreck", foo);
        
        // spawn_bonus_chest
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.bronze_axe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "spawn_bonus_chest", foo);

        // stronghold
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.steel_helmet.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_chestplate.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_leggings.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_boots.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_sword.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_shovel.get()).setWeight(2));
        addInjectionTable(Fusion.MODID, "stronghold", foo);
        
        // village_armorer
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.bronze_helmet.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_chestplate.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_leggings.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_boots.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_helmet.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_chestplate.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_leggings.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_boots.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
            .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(5)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
        .add(LootItem.lootTableItem(ModItems.large_steel_chunk.get()).setWeight(2)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
        .add(LootItem.lootTableItem(ModItems.steel_ingot.get()).setWeight(5)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(Fusion.MODID, "village_armorer", foo);
        
        // village_fletcher
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.thyrium_rod.get()).setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(Fusion.MODID, "village_fletcher", foo);
        
        // village_mason
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "village_mason", foo);
        
        // village_shepherd
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.steel_shears.get()).setWeight(1));
        addInjectionTable(Fusion.MODID, "village_shepherd", foo);
        
        // village_toolsmith
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_pickaxe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_shovel.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.bronze_hoe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_pickaxe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_shovel.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.steel_hoe.get()).setWeight(2))
            .add(LootItem.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
            .add(LootItem.lootTableItem(ModItems.large_steel_chunk.get()).setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
            .add(LootItem.lootTableItem(ModItems.steel_ingot.get()).setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(Fusion.MODID, "village_toolsmith", foo);
        
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.bronze_sword.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.bronze_axe.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.steel_sword.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.steel_axe.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.large_bronze_chunk.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.large_steel_chunk.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                .add(LootItem.lootTableItem(ModItems.bronze_ingot.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                .add(LootItem.lootTableItem(ModItems.steel_ingot.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(Fusion.MODID, "village_weaponsmith", foo);
        
        return tables;
    } // end getTables()

} // end class
