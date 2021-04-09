package mod.alexndr.fusion.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ThyriumBow extends BowItem
{

    public ThyriumBow(Properties builder)
    {
        super(builder);
    }

    @Override
    public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
    {
        // add the default enchantments for Sinisite bow.
        Map<Enchantment,Integer> oldEnchants = EnchantmentHelper.getEnchantments(stack);
        stack = this.addThyriumEnchantments(oldEnchants, stack);

        super.releaseUsing(stack, worldIn, entityLiving, timeLeft);
        
        // remove temporary intrinsic enchantments.
        EnchantmentHelper.setEnchantments(oldEnchants, stack);
    } // end releaseUsing()
    
    /**
     * Thyrium bows do increased damage (same as Onyx bow): POWER_ARROWS; and 
     * have better zoom (TODO).
     * 
     * @param oldEnch
     * @param stack
     * @return
     */
    private ItemStack addThyriumEnchantments(Map<Enchantment,Integer> oldEnch, ItemStack stack)
    {
        if (stack.isEmpty()) return stack;

        Map<Enchantment,Integer> enchMap = new HashMap<>(oldEnch);

        // add intrinsic POWER enchantment only if bow does not already have
        // one >= 2.
        if (! (enchMap.containsKey(Enchantments.POWER_ARROWS) && enchMap.get(Enchantments.POWER_ARROWS) > 1))
        {
            enchMap.put(Enchantments.POWER_ARROWS, 2);
        }

        // add intrinsic enchantments, if any.
        if (enchMap.size() > 0) {
            EnchantmentHelper.setEnchantments(enchMap, stack);
        }
        return stack;
    } // end addThyriumEnchantments()

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslationTextComponent("tips.damage_tooltip")).withStyle(TextFormatting.GREEN));
        tooltip.add((new TranslationTextComponent("tips.zoom_tooltip")).withStyle(TextFormatting.GREEN));
    }
    
} // end class
