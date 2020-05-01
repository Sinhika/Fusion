package mod.alexndr.fusion.client.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import mod.alexndr.fusion.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class FusionFurnaceRecipeCategory implements IRecipeCategory<IFusionRecipe>
{
    public static final ResourceLocation UID = new ResourceLocation(Fusion.MODID, "alloying");
    
    private final static int INPUT1_SLOT = 0;
    private final static int INPUT2_SLOT = 1;
    private final static int CATALYST_SLOT = 2;
    private final static int OUTPUT_SLOT = 3;
    
    private final IDrawable background;
    private final String localizedName;
    
    private final ResourceLocation backgroundLocation;
    private final IDrawableAnimated flame;
    private final IDrawableAnimated arrow_left;
    private final IDrawableAnimated arrow_right;
    private final IDrawableAnimated bubble_left;
    private final IDrawableAnimated bubble_right;
    private final IDrawable icon;
    
    public FusionFurnaceRecipeCategory(IGuiHelper guiHelper)
    {
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(ModBlocks.fusion_furnace.get()));
        localizedName = I18n.format("fusion.jei.fusion_category");
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
    public void draw(IFusionRecipe recipe, double mouseX, double mouseY)
    {
        flame.draw(23, 51);
        flame.draw(73, 51);
        arrow_left.draw(19, 30);
        arrow_right.draw(68, 30);
        bubble_left.draw(32, 0);
        bubble_right.draw(66, 0);
        
        float experience = recipe.getExperience();
        if (experience > 0) {
            String experienceString = I18n.format("gui.jei.category.fusion.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            FontRenderer fontRenderer = minecraft.fontRenderer;
            int stringWidth = fontRenderer.getStringWidth(experienceString);
            fontRenderer.drawString(experienceString, background.getWidth() - stringWidth, 0, 0xFF808080);
        }
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends IFusionRecipe> getRecipeClass()
    {
        return IFusionRecipe.class;
    }

    @Override
    public String getTitle() {
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

    @Override
    public void setIngredients(IFusionRecipe recipe, IIngredients ingredients)
    {
        List<Ingredient> inputs = new ArrayList<Ingredient>(recipe.getIngredients());
        inputs.add(Ingredient.fromStacks(recipe.getCatalyst()));
        ingredients.setInputIngredients(inputs);
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, IFusionRecipe recipe, IIngredients ingredients)
    {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        guiItemStacks.init(INPUT1_SLOT, true, 0, 30);
        guiItemStacks.init(INPUT2_SLOT, true, 93, 30);
        guiItemStacks.init(CATALYST_SLOT, true, 46, 2);
        guiItemStacks.init(OUTPUT_SLOT, false, 46, 28);
        
        guiItemStacks.set(ingredients);
    }

} // end class
