package alexndr.plugins.Fusion.modsupport.jei;

import alexndr.plugins.Fusion.ModInfo;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class FusionFurnaceRecipeCategory extends BlankRecipeCategory<FusionFurnaceRecipeWrapper>
{
    public static final String UID = "fusion.furnace"; 
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

    public FusionFurnaceRecipeCategory(IGuiHelper guiHelper)
    {
        localizedName = I18n.translateToLocal("fusion.jei.fusionCategory");
        backgroundLocation = 
                        new ResourceLocation(alexndr.plugins.Fusion.ModInfo.ID, 
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
    public void drawExtras(Minecraft minecraft)
    {
        flame.draw(minecraft, 23, 51);
        flame.draw(minecraft, 73, 51);
        arrow_left.draw(minecraft, 19, 30);
        arrow_right.draw(minecraft, 68, 30);
        bubble_left.draw(minecraft, 32, 0);
        bubble_right.draw(minecraft, 66, 0);
    }

    @Override
    public String getUid()
    {
        return UID;
    }

    @Override
    public String getTitle()
    {
        return localizedName;
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, 
                          FusionFurnaceRecipeWrapper recipeWrapper,
                          IIngredients ingredients)
    {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        
        guiItemStacks.init(INPUT1_SLOT, true, 0, 30);
        guiItemStacks.init(INPUT2_SLOT, true, 93, 30);
        guiItemStacks.init(CATALYST_SLOT, true, 46, 2);
        guiItemStacks.init(OUTPUT_SLOT, false, 46, 28);
        
        guiItemStacks.set(ingredients);
        
//        List<List<ItemStack>> allTheInputs = ingredients.getInputs(ItemStack.class);
//        
//        guiItemStacks.set(INPUT1_SLOT, allTheInputs.get(INPUT1_SLOT));
//        guiItemStacks.set(INPUT2_SLOT, allTheInputs.get(INPUT2_SLOT));
//        guiItemStacks.set(CATALYST_SLOT, allTheInputs.get(CATALYST_SLOT));
//        
//        guiItemStacks.set(OUTPUT_SLOT, ingredients.getOutputs(ItemStack.class));
    } // setRecipe

	@Override
	public String getModName() {
		return ModInfo.NAME;
	}

} // end class
