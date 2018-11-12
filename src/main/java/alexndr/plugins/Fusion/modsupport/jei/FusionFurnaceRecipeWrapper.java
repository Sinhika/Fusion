package alexndr.plugins.Fusion.modsupport.jei;

import java.util.ArrayList;
import java.util.List;

import alexndr.plugins.Fusion.crafting.RecipeEntry;
import alexndr.plugins.Fusion.crafting.FusionMaterial.DictMaterial;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class FusionFurnaceRecipeWrapper implements IRecipeWrapper
{
    private final RecipeEntry recipe;
    private final List<ItemStack> input1, input2, catalyst;
    
    public FusionFurnaceRecipeWrapper(IJeiHelpers jeiHelpers, RecipeEntry recipe)
    {
        this.recipe = recipe;
        
        IStackHelper stackHelper = jeiHelpers.getStackHelper();
        
        if (recipe.catalyst instanceof DictMaterial) {
            this.catalyst = stackHelper.toItemStackList(recipe.catalyst.getOre());
        }
        else {
            this.catalyst = stackHelper.toItemStackList(new ItemStack(recipe.catalyst.getItem(), 
                                                                 recipe.catalyst.getAmount()));
        }
        if (recipe.input1 instanceof DictMaterial) {
            this.input1 = stackHelper.toItemStackList(recipe.input1.getOre());
        }
        else {
            this.input1 = stackHelper.toItemStackList(new ItemStack(recipe.input1.getItem(), 
                                                                 recipe.input1.getAmount()));
        }
        if (recipe.input2 instanceof DictMaterial) {
            this.input2 = stackHelper.toItemStackList(recipe.input2.getOre());
        }
        else {
            this.input2 = stackHelper.toItemStackList(new ItemStack(recipe.input2.getItem(), 
                                                                 recipe.input2.getAmount()));
        }
        
    } // end ctor

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        // input lists, in order input1, input2, catalyst
        List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>(3);
        inputs.add(this.input1);
        inputs.add(this.input2);
        inputs.add(this.catalyst);
        
        ingredients.setInputLists(ItemStack.class, inputs);
        
        // set output - easy.
        ItemStack recipeOutput = recipe.getOutput();
        ingredients.setOutput(ItemStack.class, recipeOutput);
    } // end getIngredients()

} // end class
