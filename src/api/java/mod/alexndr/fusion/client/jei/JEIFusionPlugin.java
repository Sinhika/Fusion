package mod.alexndr.fusion.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import mod.alexndr.fusion.client.gui.FusionFurnaceScreen;
import mod.alexndr.fusion.content.FusionFurnaceContainer;
import mod.alexndr.fusion.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class JEIFusionPlugin implements IModPlugin
{
    private static final ResourceLocation ID = new ResourceLocation(Fusion.MODID, "fusion_furnace_plugin");
    
    public static final RecipeType<IFusionRecipe> FUSION_RECIPE_TYPE 
                     = RecipeType.create(Fusion.MODID, "alloying", FusionRecipe.class);
    public static final RecipeType<FusionFurnaceFuelRecipe> FUSION_FUEL_RECIPE_TYPE
            = RecipeType.create(Fusion.MODID, "fusion_furnace_fuel", FusionFurnaceFuelRecipe.class);
    
    /**
     * Register recipe catalysts.
     * Recipe Catalysts are ingredients that are needed in order to craft other things.
     * Vanilla examples of Recipe Catalysts are the Crafting Table and Furnace.
     */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
//       registration.addRecipeCatalyst(new ItemStack(ModBlocks.fusion_furnace.get()), FusionFurnaceRecipeCategory.UID, FusionFuelCategory.UID);
       registration.addRecipeCatalyst(new ItemStack(ModBlocks.fusion_furnace.get()), FUSION_RECIPE_TYPE, FUSION_FUEL_RECIPE_TYPE);
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
        registration.addRecipeCategories(new FusionFuelCategory(guiHelper));
    }

    
    /**
     * Register modded recipes.
     */
    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
		@SuppressWarnings("resource")
        ClientLevel world = Minecraft.getInstance().level;
		if (world == null) {
			throw new NullPointerException("Minecraft world must not be null");
		}
		RecipeManager recipeManager = world.getRecipeManager();
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
		IIngredientManager ingredientManager = registration.getIngredientManager();

        registration.addRecipes(JEIFusionPlugin.FUSION_RECIPE_TYPE, 
                                FusionRecipeMaker.getFusionRecipes(recipeManager));
		registration.addRecipes(JEIFusionPlugin.FUSION_FUEL_RECIPE_TYPE, 
		                        FusionFuelRecipeMaker.getFuelRecipes(ingredientManager, jeiHelpers));
		registration.addIngredientInfo(new ItemStack(ModBlocks.fusion_furnace.get().asItem()), VanillaTypes.ITEM, 
		        new TranslatableComponent("fusion.fusion_furnace.info"));
    }
    
	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration)
	{
		registration.addRecipeTransferHandler(FusionFurnaceContainer.class, JEIFusionPlugin.FUSION_RECIPE_TYPE, 0, 3, 5, 36);
		registration.addRecipeTransferHandler(FusionFurnaceContainer.class, JEIFusionPlugin.FUSION_FUEL_RECIPE_TYPE, 4, 1, 5, 36);
	}


	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration)
	{
//		registration.addRecipeClickArea(FusionFurnaceScreen.class, 2, 2, 70, 31, FusionFurnaceRecipeCategory.UID, FusionFuelCategory.UID);
//		registration.addRecipeClickArea(FusionFurnaceScreen.class, 105, 2, 70, 31, FusionFurnaceRecipeCategory.UID, FusionFuelCategory.UID);
      registration.addRecipeClickArea(FusionFurnaceScreen.class, 2, 2, 70, 31, JEIFusionPlugin.FUSION_RECIPE_TYPE);
      registration.addRecipeClickArea(FusionFurnaceScreen.class, 105, 2, 70, 31, JEIFusionPlugin.FUSION_FUEL_RECIPE_TYPE);
	    
	}

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    
} // end-class
