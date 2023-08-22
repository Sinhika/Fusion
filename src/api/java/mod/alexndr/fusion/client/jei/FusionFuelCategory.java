package mod.alexndr.fusion.client.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.simplecorelib.api.client.jei.VeryAbstractFurnaceVariantCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class FusionFuelCategory extends VeryAbstractFurnaceVariantCategory<FusionFurnaceFuelRecipe>
{
	public static final ResourceLocation UID = new ResourceLocation(Fusion.MODID, "fusion_furnace_fuel");
	
	public FusionFuelCategory(IGuiHelper guiHelper)
	{
		super(guiHelper);
		localizedName = Component.translatable("gui.jei.category.fusion_furnace_fuel");
	}

	
	@Override
    public RecipeType<FusionFurnaceFuelRecipe> getRecipeType()
    {
        return JEIFusionPlugin.FUSION_FUEL_RECIPE_TYPE;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FusionFurnaceFuelRecipe recipe, IFocusGroup focuses)
    {
        super.setRecipe(builder, recipe, focuses);
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 17).addItemStacks(recipe.getInputs());
    }

    @Override
	public void draw(FusionFurnaceFuelRecipe recipe,  IRecipeSlotsView recipeSlotsView,  GuiGraphics guiGraphics, double mouseX, double mouseY) 
    {
        IDrawableAnimated flame = this.getFlame();
        flame.draw(guiGraphics, 1, 0);
        Minecraft minecraft = Minecraft.getInstance();
        this.smeltCountText = createSmeltCountText(recipe.getBurnTime());
       guiGraphics.drawString(minecraft.font, smeltCountText, 24, 13, 0xFF808080, false);
    }

} // end class
