package mod.alexndr.fusion.content;

import java.util.function.Supplier;

import mod.alexndr.fusion.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

public enum FusionItemTier implements IItemTier 
{
    BRONZE(2, 800, 9.0F, 2.0F, 7, ()->{ return Ingredient.fromItems( ModItems.bronze_ingot.get()); }),
    SINISITE(5, 4100, 18.0F, 8.0F, 11, ()->{ return Ingredient.fromItems( ModItems.sinisite_ingot.get()); }),
    THYRIUM(3, 2000, 22.0F, 6.0F, 28, ()->{ return Ingredient.fromItems( ModItems.thyrium_ingot.get()); }),
    STEEL(2, 700, 7.5F, 3.0F, 24, ()->{ return Ingredient.fromItems( ModItems.steel_ingot.get()); });
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private FusionItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
            int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
    }
    
    @Override
    public int getMaxUses() {
       return this.maxUses;
    }

    @Override
    public float getEfficiency() {
       return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
       return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
       return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
       return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
       return this.repairMaterial.getValue();
    }
} // end class
