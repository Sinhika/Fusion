package mod.alexndr.fusion.client.jei;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.client.ClientModEventSubscriber;
import mod.alexndr.simplecorelib.api.client.jei.AlternateFuelRecipe;
import mod.alexndr.simplecorelib.api.client.jei.VeryAbstractFurnaceVariantCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class FusionFuelCategory extends VeryAbstractFurnaceVariantCategory<AlternateFuelRecipe>
{
	public static final ResourceLocation UID = new ResourceLocation(Fusion.MODID, "fusion_furnace_fuel");
	
	private final IDrawableStatic background;
	private final IDrawableStatic flameTransparentBackground;
	private final Component localizedName;


	public FusionFuelCategory(IGuiHelper guiHelper)
	{
		super(guiHelper);
		
		// width of the recipe depends on the text, which is different in each language
		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		
		Component smeltCountText = createSmeltCountText(100000);
		int stringWidth = fontRenderer.width(smeltCountText.getString());

		background = guiHelper.drawableBuilder(VeryAbstractFurnaceVariantCategory.RECIPE_GUI_VANILLA, 0, 134, 18, 34)
			.addPadding(0, 0, 0, stringWidth + 20)
			.build();

		flameTransparentBackground = ClientModEventSubscriber.textures.getFlameIcon();
		localizedName = new TranslatableComponent("gui.jei.category.fusion_furnace_fuel");
	}

	@Override
	public ResourceLocation getUid()
	{
		return UID;
	}

	@Override
	public Class<? extends AlternateFuelRecipe> getRecipeClass()
	{
		return AlternateFuelRecipe.class;
	}

	@Override
	public Component getTitle()
	{
		return localizedName;
	}

	@Override
	public IDrawable getBackground()
	{
		return background;
	}

	@Override
	public IDrawable getIcon()
	{
		return flameTransparentBackground;
	}

} // end class
