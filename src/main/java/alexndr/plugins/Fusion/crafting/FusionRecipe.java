package alexndr.plugins.Fusion.crafting;

import javax.annotation.Nonnull;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.IForgeRegistryEntry;

/**
 * Akin to ShapelessOreRecipe, but has 3 inputs: 2 ingredients and a "catalyst". We will
 * take advantage of Ingredient's already-existing code instead of re-implementing FusionMaterial.
 * @author Sinhika
 *
 */
public class FusionRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe 
{
    @Nonnull
    protected ItemStack output = ItemStack.EMPTY;
    protected NonNullList<Ingredient> input = NonNullList.create(); // TODO needs to be array[2]
    protected Ingredient catalyst;
    protected ResourceLocation group;
    protected boolean isSimple = true;

    public FusionRecipe(ResourceLocation group, NonNullList<Ingredient> input, @Nonnull Ingredient catalyst,
    		@Nonnull ItemStack result)
    {
        this.group = group;
        output = result.copy();
        this.input = input;
        this.catalyst = catalyst;
        for (Ingredient i : input)
            this.isSimple &= i.isSimple();
    } // end ctor with ingredient list
    
    public FusionRecipe(ResourceLocation group, @Nonnull ItemStack result, Object... recipe)
    {
        this.group = group;
        output = result.copy();
        // TODO how do we pick out catalyst?
        for (Object in : recipe) 
        {
            Ingredient ing = CraftingHelper.getIngredient(in);
            if (ing != null)
            {
                input.add(ing);
                this.isSimple &= ing.isSimple();
            }
            else
            {
                String ret = "Invalid fusion recipe: ";
                for (Object tmp :  recipe)
                {
                    ret += tmp + ", ";
                }
                ret += output;
                throw new RuntimeException(ret);
            }
        } // end-for
    } // end ctor with recipe object
    
    /**
     * Used to check if a recipe matches current crafting inventory
     */
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		// TODO Auto-generated method stub
		return false;
	}

    /**
     * Returns an Item that is the result of this recipe
     */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canFit(int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return null;
	}

} // end class
