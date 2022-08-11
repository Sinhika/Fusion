package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import mod.alexndr.fusion.api.helpers.ErrorUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public final class FusionFuelRecipeMaker
{
	private static final Logger LOGGER = LogManager.getLogger();
	
	private FusionFuelRecipeMaker() {}

	public static List<FusionFurnaceFuelRecipe> getFuelRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers)
	{
		Collection<ItemStack> allItemStacks = ingredientManager.getAllIngredients(VanillaTypes.ITEM_STACK);
		List<FusionFurnaceFuelRecipe> fuelRecipes = new ArrayList<>();
		for (ItemStack stack : allItemStacks)
		{
			int burnTime = getBurnTime(stack);
			if (burnTime > 0)
			{
				fuelRecipes.add(new FusionFurnaceFuelRecipe(Collections.singleton(stack), burnTime));
			}
		}
		return fuelRecipes;
	}

	private static int getBurnTime(ItemStack itemStack)
	{
		try
		{
			return (int) Math.ceil(((double) ForgeHooks.getBurnTime(itemStack, null)) * AbstractAlloyFurnaceTileEntity.BURN_TIME_MODIFIER);
		} 
		catch (RuntimeException | LinkageError e)
		{
			String itemStackInfo = ErrorUtil.getItemStackInfo(itemStack);
			LOGGER.error("Failed to check if item is fuel {}.", itemStackInfo, e);
			return 0;
		}
	}
} // end class
