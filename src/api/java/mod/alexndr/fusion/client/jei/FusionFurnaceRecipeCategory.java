package mod.alexndr.fusion.client.jei;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.netherrocks.client.jei.NetherFurnaceFuelRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class FusionFurnaceRecipeCategory implements IRecipeCategory<IFusionRecipe>
{
    public static final ResourceLocation UID = new ResourceLocation(Fusion.MODID, "alloying");
    
//    private final static int INPUT1_SLOT = 0;
//    private final static int INPUT2_SLOT = 1;
//    private final static int CATALYST_SLOT = 2;
//    private final static int OUTPUT_SLOT = 3;
    
    private final IDrawable background;
    private final Component localizedName;
    
    private final ResourceLocation backgroundLocation;
    private final IDrawableAnimated flame;
    private final IDrawableAnimated arrow_left;
    private final IDrawableAnimated arrow_right;
    private final IDrawableAnimated bubble_left;
    private final IDrawableAnimated bubble_right;
    private final IDrawable icon;
    
    public FusionFurnaceRecipeCategory(IGuiHelper guiHelper)
    {
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.fusion_furnace.get()));
        localizedName = Component.translatable("fusion.jei.fusion_category");
        backgroundLocation = 
                        new ResourceLocation(Fusion.MODID, 
                                             "textures/gui/container/fusion_furnace_gui.png");
        background = guiHelper.createDrawable(backgroundLocation, 32, 4, 110, 74);
        IDrawableStatic flameDrawable = 
                        guiHelper.createDrawable(backgroundLocation, 176, 0, 14, 14);
        flame = guiHelper.createAnimatedDrawable(flameDrawable, 300, 
                                                 IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic arrowDrawable1 = 
                        guiHelper.createDrawable(backgroundLocation, 176, 14, 24, 17);
        this.arrow_left = guiHelper.createAnimatedDrawable(arrowDrawable1, 200, 
                                                IDrawableAnimated.StartDirection.LEFT, false);
        IDrawableStatic arrowDrawable2 = 
                        guiHelper.createDrawable(backgroundLocation, 176, 31, 24, 17);
        this.arrow_right = guiHelper.createAnimatedDrawable(arrowDrawable2, 200, 
                                                IDrawableAnimated.StartDirection.RIGHT, false);
        
        IDrawableStatic bubbleDrawable1 = 
                        guiHelper.createDrawable(backgroundLocation, 176, 64, 12, 28);
        this.bubble_left = guiHelper.createAnimatedDrawable(bubbleDrawable1, 200, 
                                                IDrawableAnimated.StartDirection.BOTTOM, false);
        
        IDrawableStatic bubbleDrawable2 = 
                        guiHelper.createDrawable(backgroundLocation, 188, 64, 12, 28);
        this.bubble_right = guiHelper.createAnimatedDrawable(bubbleDrawable2, 200, 
                                                IDrawableAnimated.StartDirection.BOTTOM, false);
    } // end ctor
    
    @Override
	public void draw(IFusionRecipe recipe,  IRecipeSlotsView recipeSlotsView,  GuiGraphics guiGraphics, double mouseX, double mouseY) 
    {
        flame.draw(guiGraphics, 23, 51);
        flame.draw(guiGraphics, 73, 51);
        arrow_left.draw(guiGraphics, 19, 30);
        arrow_right.draw(guiGraphics, 68, 30);
        bubble_left.draw(guiGraphics, 32, 0);
        bubble_right.draw(guiGraphics, 66, 0);
        
        float experience = recipe.getExperience();
        if (experience > 0) {
            String experienceString = I18n.get("gui.jei.category.fusion.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(experienceString);
            guiGraphics.drawString(fontRenderer, experienceString, background.getWidth() - stringWidth, 0, 0xFF808080);
        }
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon()
    {
        return icon;
    }

//    @Override
//    public void setIngredients(IFusionRecipe recipe, IIngredients ingredients)
//    {
//        List<Ingredient> inputs = new ArrayList<Ingredient>(recipe.getIngredients());
//        inputs.add(recipe.getCatalyst());
//        ingredients.setInputIngredients(inputs);
//        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
//    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, IFusionRecipe recipe, IFocusGroup focuses)
    {
        builder.addSlot(INPUT, 0, 30).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(INPUT, 93, 30).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(INPUT, 46, 2).addIngredients(recipe.getCatalyst());
        builder.addSlot(OUTPUT,46, 28).addItemStack(recipe.getResultItem(null));
    }

    @Override
    public RecipeType<IFusionRecipe> getRecipeType()
    {
        return JEIFusionPlugin.FUSION_RECIPE_TYPE;
    }

    
} // end class
