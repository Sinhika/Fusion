package mod.alexndr.fusion.client.jei;

import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.client.ClientModEventSubscriber;
import mod.alexndr.simplecorelib.api.client.jei.VeryAbstractFurnaceVariantCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class FusionFuelCategory extends VeryAbstractFurnaceVariantCategory<FusionFurnaceFuelRecipe>
{
	public static final ResourceLocation UID = new ResourceLocation(Fusion.MODID, "fusion_furnace_fuel");
	
	public FusionFuelCategory(IGuiHelper guiHelper)
	{
		super(guiHelper);
		localizedName = new TranslatableComponent("gui.jei.category.fusion_furnace_fuel");
	}

	
	@Override
    public RecipeType<FusionFurnaceFuelRecipe> getRecipeType()
    {
        return JEIFusionPlugin.FUSION_FUEL_RECIPE_TYPE;
    }


    @Override
	public ResourceLocation getUid()
	{
		return UID;
	}

	@Override
	public Class<? extends FusionFurnaceFuelRecipe> getRecipeClass()
	{
		return FusionFurnaceFuelRecipe.class;
	}


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FusionFurnaceFuelRecipe recipe, IFocusGroup focuses)
    {
        super.setRecipe(builder, recipe, focuses);
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 17).addItemStacks(recipe.getInputs());
    }

    @Override
    public void draw(FusionFurnaceFuelRecipe recipe, PoseStack poseStack, double mouseX, double mouseY) 
    {
        IDrawableAnimated flame = this.getFlame();
        flame.draw(poseStack, 1, 0);
        Minecraft minecraft = Minecraft.getInstance();
        this.smeltCountText = createSmeltCountText(recipe.getBurnTime());
        minecraft.font.draw(poseStack, smeltCountText, 24, 13, 0xFF808080);
    }

} // end class
