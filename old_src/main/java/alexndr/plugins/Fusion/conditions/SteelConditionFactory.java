package alexndr.plugins.Fusion.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import alexndr.plugins.Fusion.ModInfo;
import alexndr.plugins.Fusion.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class SteelConditionFactory implements IConditionFactory 
{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");

		if (key.equals(ModInfo.ID + ":steel_ingot_enabled")) {
			return () -> Settings.steelIngot.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":steel_block_enabled")) {
			return () -> Settings.steelBlock.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":steel_tools_enabled")) {
			return () -> Settings.steelTools.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":steel_armor_enabled")) {
			return () -> Settings.steelArmor.isEnabled() == value;
		}
		return null;
	} // end parse()

} // end class
