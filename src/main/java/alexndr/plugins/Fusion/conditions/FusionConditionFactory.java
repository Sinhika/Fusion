package alexndr.plugins.Fusion.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import alexndr.plugins.Fusion.ModInfo;
import alexndr.plugins.Fusion.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class FusionConditionFactory implements IConditionFactory 
{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");

		if (key.equals(ModInfo.ID + ":fusion_furnace_enabled")) {
			return () -> Settings.fusionFurnace.isEnabled() == value;
		}

		return null;
	} // end parse()

} // end class
