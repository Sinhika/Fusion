package alexndr.plugins.Fusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import mcjty.lib.tools.ItemStackTools;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author AleXndrTheGr8st, zo201
 */
public class FusionFurnaceRecipes 
{
	// private static FusionMaterial material;
	
	private static final ArrayList<RecipeEntry> recipeList = Lists.newArrayList();
	private static final HashMap<ItemStack, Float> experienceMap = new HashMap<ItemStack, Float>();
	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	/**
	 * Adds a smelting recipe to the Fusion Furnace. FusionMaterial version, supports OreDictionary. Inputs 1 and 2 are interchangeable.
	 * @param input1 FusionMaterial for input1.
	 * @param input2 FusionMaterial for input2.
	 * @param catalyst FusionMaterial for the catalyst.
	 * @param output ItemStack for the output.
	 * @param experience Float amount of experience to give when the output is taken from the furnace.
	 */
    public static void addSmelting(FusionMaterial input1, FusionMaterial input2,
                    FusionMaterial catalyst, ItemStack output, float experience)
    {
        recipeList.add(new RecipeEntry(input1, input2, catalyst, output));
        setExperience(ItemStackTools.safeCopy(output), experience);
    }

	
	/**
	 * Adds a smelting recipes to the Fusion Furnace. ItemStack version, does not support OreDictionary. Inputs 1 and 2 are interchangeable. 
	 * @param input1 ItemStack for input1.
	 * @param input2 ItemStack for input2.
	 * @param catalyst ItemStack for the catalyst.
	 * @param output ItemStack for the output.
	 * @param experience Float amount of experience to give when the output is taken from the furnace.
	 */
    public static void addSmelting(ItemStack input1, ItemStack input2, ItemStack catalyst,
                    ItemStack output, float experience)
    {
        addSmelting(FusionMaterial.of(input1), FusionMaterial.of(input2),
                        FusionMaterial.of(catalyst), output, experience);
    }

	
	public static ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		for(RecipeEntry e : recipeList)
		{
			if(e.matches(input1, input2, catalyst))
				return e.getOutput();
		}
		return ItemStackTools.getEmptyStack();
	}
	
	public static void setExperience(ItemStack output, float experience)
	{
		if(!experienceMap.containsKey(output))
			experienceMap.put(ItemStackTools.safeCopy(output), experience);
	}
	
	public static ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		for(RecipeEntry e : recipeList)
		{
			if(e.matches(input1, input2, catalyst))
				return e.applyFusion(input1, input2, catalyst);
		}
		return ItemStackTools.getEmptyStack();
	}
	
	public static float getExperience(ItemStack item)
	{
		Float exp = experienceMap.get(item);
		return exp == null ? 0 : exp;
	}
	
	public static boolean isItemCatalyst(ItemStack item)
	{
		for(RecipeEntry e : recipeList)
		{
			if(e.isItemCatalyst(item))
				return true;
		}
		return false;
	}
	
	public static boolean isItemInput(ItemStack item)
	{
		for(RecipeEntry e : recipeList)
		{
			if(e.isItemInput(item))
				return true;
		}
		return false;
	}
	
	public static List<RecipeEntry> getRecipeList()
	{
		return recipeList;
	}
	
	public static Map<ItemStack, Float> getExperienceList()
	{
		return experienceMap;
	}
	
	public static boolean matches(ItemStack target, ItemStack stack)
	{
	    if (ItemStack.areItemsEqual(target, stack)) {
	        return true;
	    }
	    if ((target.getMetadata() == WILDCARD_VALUE) 
	                    && ItemStack.areItemsEqualIgnoreDurability(target, stack))
	    {
            return true;
        }
		return false;
	}
} // end class
