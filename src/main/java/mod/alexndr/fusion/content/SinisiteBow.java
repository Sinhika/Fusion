package mod.alexndr.fusion.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import mod.alexndr.fusion.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SinisiteBow extends BowItem
{
    public SinisiteBow(Properties builder)
    {
        super(builder);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft)
    {
        // add the default enchantments for Sinisite bow.
        Map<Enchantment,Integer> oldEnchants = EnchantmentHelper.getEnchantments(stack);
        stack = this.addSinisiteEnchantments(oldEnchants, stack);

        super.releaseUsing(stack, worldIn, entityLiving, timeLeft);
        
        // remove temporary intrinsic enchantments.
        EnchantmentHelper.setEnchantments(oldEnchants, stack);
    }

    /**
     * Sinisite bows do increased damage (more than Onyx bow): POWER_ARROWS; and 
     * have increased knockback: PUNCH.
     * 
     * @param oldEnch
     * @param stack
     * @return
     */
    private ItemStack addSinisiteEnchantments(Map<Enchantment,Integer> oldEnch, ItemStack stack)
    {
        if (stack.isEmpty()) return stack;

        Map<Enchantment,Integer> enchMap = new HashMap<>(oldEnch);

        // add intrinsic POWER enchantment only if bow does not already have
        // one >= 3.
        if (! (enchMap.containsKey(Enchantments.POWER_ARROWS) && enchMap.get(Enchantments.POWER_ARROWS) > 2) )
        {
            enchMap.put(Enchantments.POWER_ARROWS, 3);
        }

        // add intrinsic PUNCH enchantment only if bow does not already have.
        if (!enchMap.containsKey(Enchantments.PUNCH_ARROWS))
        {
            enchMap.put(Enchantments.PUNCH_ARROWS, 1);
        }
        
        // add intrinsic enchantments, if any.
        if (enchMap.size() > 0) {
            EnchantmentHelper.setEnchantments(enchMap, stack);
        }
        return stack;
    } // end addSinisiteEnchantments()
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((Component.translatable("tips.damage_tooltip")).withStyle(ChatFormatting.GREEN));
        tooltip.add((Component.translatable("tips.knockback_tooltip")).withStyle(ChatFormatting.GREEN));
    }
    
    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate)
    {
        return this.getRepairIngredient().test(pRepairCandidate) || super.isValidRepairItem(pStack, pRepairCandidate);
    }
    
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(ModItems.sinisite_rod.get());
    }

} // end class
