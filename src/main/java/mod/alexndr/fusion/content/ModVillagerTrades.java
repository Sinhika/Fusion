package mod.alexndr.fusion.content;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mod.alexndr.fusion.init.ModItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;

public class ModVillagerTrades
{
    public static void ArmorerTrades(VillagerTradesEvent evt)
    {
        Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
        
        // novice trades
        trades.get(1).add(new BasicItemListing( new ItemStack(Items.EMERALD, 3), 
                new ItemStack(ModItems.bronze_helmet.get()), 12, 1, 0.2F));
        trades.get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),
                new ItemStack(ModItems.bronze_chestplate.get()), 12, 1, 0.2F));
        trades.get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),
                new ItemStack(ModItems.bronze_leggings.get()), 12, 1, 0.2F));
        trades.get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2),
                new ItemStack(ModItems.bronze_boots.get()), 12, 1, 0.2F));
 
        // apprentice trades
        trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.bronze_ingot.get(), 4),
                new ItemStack(Items.EMERALD), 12, 10, 0.05F));
        trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.steel_ingot.get(), 4),
                new ItemStack(Items.EMERALD), 12, 10, 0.05F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 3), 
                new ItemStack(ModItems.steel_leggings.get()), 12, 5, 0.2F));
        trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.steel_boots.get()), 12, 5, 0.2F));
        
        // journeyman trades
        trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.steel_helmet.get()), 12, 10, 0.2F));
        trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3),
                new ItemStack(ModItems.steel_chestplate.get()), 12, 10, 0.2F));
        
        // expert trades
        trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_leggings.get(), 
                14, 3, 15, 0.2F));
        trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_boots.get(), 
                8, 3, 15, 0.2F));
        
        // master trades
        trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_helmet.get(), 
                8, 3, 30, 0.2F));
        trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_chestplate.get(), 
                16, 3, 30, 0.2F));

    } // end ArmorerTrades()
    
    public static void ToolsmithTrades(VillagerTradesEvent evt)
    {
        Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
        // novice - nothing added.

        // apprentice
        trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.bronze_ingot.get(), 4),
                new ItemStack(Items.EMERALD), 12, 10, 0.05F));
        trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.steel_ingot.get(), 4),
                new ItemStack(Items.EMERALD), 12, 10, 0.05F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.bronze_axe.get()), 12, 1, 0.2F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.bronze_shovel.get()), 12, 1, 0.2F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.bronze_hoe.get()), 12, 1, 0.2F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.bronze_pickaxe.get()), 12, 1, 0.2F));
        
        // journeyman
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.steel_axe.get()), 12, 10, 0.2F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.steel_shovel.get()), 12, 10, 0.2F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.steel_hoe.get()), 12, 10, 0.2F));
        trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                new ItemStack(ModItems.steel_pickaxe.get()), 12, 10, 0.2F));
       
        // expert trades
        trades.get(3).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_axe.get(), 
                2, 3, 20, 0.2F));
        trades.get(3).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_shovel.get(), 
                3, 3, 20, 0.2F));
        trades.get(3).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_pickaxe.get(), 
                3, 3, 20, 0.2F));
        
        
        // master trades
        trades.get(5).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.thyrium_pickaxe.get(), 
                13, 3, 30, 0.2F));
    } // end ArmorerTrades()
   
    public static void WeaponsmithTrades(VillagerTradesEvent evt)
    {
        Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
        // novice
        trades.get(1).add(new BasicItemListing( new ItemStack(Items.EMERALD, 3), 
                new ItemStack(ModItems.steel_axe.get()), 12, 1, 0.2F));
        trades.get(1).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.steel_sword.get(), 
                2, 3, 1, 0.05F));
       
        // apprentice
        trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.bronze_ingot.get(), 4),
                new ItemStack(Items.EMERALD), 12, 10, 0.05F));
        trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.steel_ingot.get(), 4),
                new ItemStack(Items.EMERALD), 12, 10, 0.05F));
        
        // journeyman
        trades.get(3).add(new BasicItemListing(new ItemStack(ModItems.thyrium_ingot.get()),
                new ItemStack(Items.EMERALD), 12, 20, 0.05F));
        
        // expert trades
        trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.thyrium_axe.get(), 
                12, 3, 15, 0.2F));
        
        // master trades
        trades.get(5).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.thyrium_sword.get(), 
                8, 3, 30, 0.2F));

    } // end ArmorerTrades()
   
} // end class
