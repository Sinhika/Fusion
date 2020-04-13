package alexndr.plugins.Fusion.modsupport.jei;

import alexndr.plugins.Fusion.RecipeEntry;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;

//public class FusionFurnaceRecipeHandler extends CompatRecipeHandler<RecipeEntry>
public class FusionFurnaceRecipeHandler implements IRecipeWrapperFactory<RecipeEntry>
{
   private final IJeiHelpers jeiHelpers;
 
   public FusionFurnaceRecipeHandler(IJeiHelpers jeiHelpers)
   {
       this.jeiHelpers = jeiHelpers;
   }

    @Override
    public IRecipeWrapper getRecipeWrapper(RecipeEntry recipe)
    {
        return new FusionFurnaceRecipeWrapper(jeiHelpers, recipe);
    }

//    @Override
//    public boolean isRecipeValid(RecipeEntry recipe)
//    {
//        if (ItemStackTools.isEmpty(recipe.getOutput())) return false;
//        if (recipe.catalyst.matches(ItemStackTools.getEmptyStack())) {
//            return false;
//        }
//        if (recipe.input1.matches(ItemStackTools.getEmptyStack())) {
//            return false;
//        }
//        if (recipe.input2.matches(ItemStackTools.getEmptyStack())) {
//            return false;
//        }
//        return true;
//    } // end isRecipeValid()

} // end class
