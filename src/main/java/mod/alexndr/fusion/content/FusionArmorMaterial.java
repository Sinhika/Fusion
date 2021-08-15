package mod.alexndr.fusion.content;

import java.util.function.Supplier;

import mod.alexndr.fusion.init.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum FusionArmorMaterial implements ArmorMaterial 
{
    BRONZE("fusion:bronze", 16, new int [] {1,3,5,3}, 7, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 
            ()-> { return Ingredient.of(ModItems.bronze_ingot.get());} ),
    SINISITE("fusion:sinisite", 56, new int [] {5,6,8,5}, 11, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 
            ()-> { return Ingredient.of(ModItems.sinisite_ingot.get());} ),
    THYRIUM("fusion:thyrium", 39, new int [] {3,6,7,4}, 28, SoundEvents.ARMOR_EQUIP_GENERIC, 1.0F, 
            ()-> { return Ingredient.of(ModItems.thyrium_ingot.get());} ),
    STEEL("fusion:steel", 20, new int [] {3,5,6,3}, 7, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 
            ()-> { return Ingredient.of(ModItems.steel_ingot.get());} );
    
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadedValue<Ingredient> repairMaterial;
    
    private FusionArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, 
            int enchantability,
            SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial)
    {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
    }
    
    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn)
    {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }
    
    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn)
    {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }
    
    @Override
    public int getEnchantmentValue()
    {
        return this.enchantability;
    }
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairMaterial.get();
    }
    
    @Override
    public SoundEvent getEquipSound()
    {
        return this.soundEvent;
    }
    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        // TODO Auto-generated method stub
        return 0;
    }

} // end enum
