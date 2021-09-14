package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.plugins.vanilla.cooking.fuel.FuelRecipe;
import mezz.jei.util.ErrorUtil;
import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public final class FusionFuelRecipeMaker
{
	private static final Logger LOGGER = LogManager.getLogger();
	
	private FusionFuelRecipeMaker() {
	}

	public static List<FuelRecipe> getFuelRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers)
	{
		IGuiHelper guiHelper = helpers.getGuiHelper();
		Collection<ItemStack> allItemStacks = ingredientManager.getAllIngredients(VanillaTypes.ITEM);
		List<FuelRecipe> fuelRecipes = new ArrayList<>();
		for (ItemStack stack : allItemStacks)
		{
			int burnTime = getBurnTime(stack);
			if (burnTime > 0)
			{
				fuelRecipes.add(new FuelRecipe(guiHelper, Collections.singleton(stack), burnTime));
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
