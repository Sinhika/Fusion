package mod.alexndr.fusion.content;

import java.util.function.Supplier;

import mod.alexndr.fusion.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum FusionArmorMaterial implements IArmorMaterial 
{
    BRONZE("fusion:bronze", 16, new int [] {3,5,3,1}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 
            ()-> { return Ingredient.fromItems(ModItems.bronze_ingot.get());} );
    // TODO all the rest
    
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;
    
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
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }
    
    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn)
    {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }
    
    @Override
    public int getDurability(EquipmentSlotType slotIn)
    {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }
    
    @Override
    public int getEnchantability()
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
    public Ingredient getRepairMaterial()
    {
        return this.repairMaterial.getValue();
    }
    
    @Override
    public SoundEvent getSoundEvent()
    {
        return this.soundEvent;
    }
    @Override
    public float getToughness()
    {
        return this.toughness;
    }

} // end enum
