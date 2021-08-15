package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.Collection;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.items.wrapper.RecipeWrapper;

@JeiPlugin
public class JEIFusionPlugin implements IModPlugin
{
    private static final ResourceLocation ID = new ResourceLocation(Fusion.MODID, "main");
    
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    /**
     * Register the categories handled by this plugin.
     * These are registered before recipes so they can be checked for validity.
     */
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new FusionFurnaceRecipeCategory(guiHelper));    
    }

    /**
     * Register modded recipes.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        @SuppressWarnings("resource")
        Iterable<Recipe<?>> recipes = Minecraft.getInstance().level.getRecipeManager().getRecipes();
        Collection<Recipe<RecipeWrapper>> fusion_recipes = new ArrayList<Recipe<RecipeWrapper>> ();
        for (Recipe<?> recipe : recipes) {
            if (recipe.getType() == ModRecipeTypes.FUSION_TYPE) {
                fusion_recipes.add((Recipe<RecipeWrapper>) recipe);
            }
        } // end-for
        
        registration.addRecipes(fusion_recipes, FusionFurnaceRecipeCategory.UID);
    }

    /**
     * Register recipe catalysts.
     * Recipe Catalysts are ingredients that are needed in order to craft other things.
     * Vanilla examples of Recipe Catalysts are the Crafting Table and Furnace.
     */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
       registration.addRecipeCatalyst(new ItemStack(ModBlocks.fusion_furnace.get()), 
                                      FusionFurnaceRecipeCategory.UID);
    }

} // end-class
