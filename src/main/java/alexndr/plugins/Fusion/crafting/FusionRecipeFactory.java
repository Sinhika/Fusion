package alexndr.plugins.Fusion.crafting;

import com.google.gson.JsonObject;

import alexndr.plugins.Fusion.ModInfo;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class FusionRecipeFactory implements IRecipeFactory {

	@Override
	public FusionRecipe parse(JsonContext context, JsonObject json) 
	{
		String key = JsonUtils.getString(json, "type");
		if (key.equals(ModInfo.ID + ":crafting_fusion")) {
			// TODO check on validity of this. NOT VALID, DO SOMETHING ELSE
			// return (FusionRecipe) CraftingHelper.getRecipe(json, context);
		}
		return null;
	}

} // end class
