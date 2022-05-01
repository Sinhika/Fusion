package mod.alexndr.fusion.client.jei;

import java.util.Collection;

import mod.alexndr.simplecorelib.api.client.jei.AlternateFuelRecipe;
import net.minecraft.world.item.ItemStack;

public class FusionFurnaceFuelRecipe extends AlternateFuelRecipe
{

    public FusionFurnaceFuelRecipe(Collection<ItemStack> input, int burnTime)
    {
        super(input, burnTime);
        BURN_TIME_STANDARD = 100;
    }

} // end class
