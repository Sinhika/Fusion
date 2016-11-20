package alexndr.plugins.Fusion.modsupport.jei;

import alexndr.plugins.Fusion.RecipeEntry;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class FusionFurnaceRecipeHandler implements IRecipeHandler<RecipeEntry>
{
   private final IJeiHelpers jeiHelpers;
    
   public FusionFurnaceRecipeHandler(IJeiHelpers jeiHelpers)
   {
        this.jeiHelpers = jeiHelpers;
   }

    @Override
    public Class<RecipeEntry> getRecipeClass()
    {
        return RecipeEntry.class;
    }

    @Override
    public String getRecipeCategoryUid()
    {
        return FusionFurnaceRecipeCategory.UID;
    }

    @Override
    public String getRecipeCategoryUid(RecipeEntry recipe)
    {
        return FusionFurnaceRecipeCategory.UID;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(RecipeEntry recipe)
    {
        return new FusionFurnaceRecipeWrapper(jeiHelpers, recipe);
    }

    @Override
    public boolean isRecipeValid(RecipeEntry recipe)
    {
        if (recipe.getOutput() == null) return false;
        if (recipe.catalyst.getItem() == null && recipe.catalyst.getOre() == null) {
            return false;
        }
        if (recipe.input1.getItem() == null && recipe.input1.getOre() == null) {
            return false;
        }
        if (recipe.input2.getItem() == null && recipe.input2.getOre() == null) {
            return false;
        }
        return true;
    } // end isRecipeValid()

} // end class
