package mod.alexndr.fusion.content;

import java.util.function.Supplier;

import mod.alexndr.fusion.init.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;

public enum FusionItemTier implements Tier 
{
    BRONZE(2, 800, 9.0F, 2.0F, 7, ()->{ return Ingredient.of( ModItems.bronze_ingot.get()); }),
    SINISITE(5, 4100, 18.0F, 8.0F, 11, ()->{ return Ingredient.of( ModItems.sinisite_ingot.get()); }),
    THYRIUM(3, 2000, 22.0F, 6.0F, 28, ()->{ return Ingredient.of( ModItems.thyrium_ingot.get()); }),
    STEEL(2, 700, 7.5F, 3.0F, 24, ()->{ return Ingredient.of( ModItems.steel_ingot.get()); });
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    private FusionItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
            int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
    }
    
    @Override
    public int getUses() {
       return this.maxUses;
    }

    @Override
    public float getSpeed() {
       return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
       return this.attackDamage;
    }

    @Override
    public int getLevel() {
       return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
       return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
       return this.repairMaterial.get();
    }
} // end class
