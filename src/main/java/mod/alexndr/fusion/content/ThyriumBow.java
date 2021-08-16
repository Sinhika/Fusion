package mod.alexndr.fusion.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ThyriumBow extends BowItem
{
    private final float ZOOM_AMT = 0.35f;
    
    public ThyriumBow(Properties builder)
    {
        super(builder);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft)
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

    public float getZoomAmount() {
        return ZOOM_AMT;
    }
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslatableComponent("tips.damage_tooltip")).withStyle(ChatFormatting.GREEN));
        tooltip.add((new TranslatableComponent("tips.zoom_tooltip")).withStyle(ChatFormatting.GREEN));
    }
    
} // end class
