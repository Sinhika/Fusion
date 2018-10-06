package alexndr.plugins.Fusion.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import alexndr.plugins.Fusion.ModInfo;
import alexndr.plugins.Fusion.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class BronzeConditionFactory implements IConditionFactory 
{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");

		if (key.equals(ModInfo.ID + ":bronze_ingot_enabled")) {
			return () -> Settings.bronzeIngot.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":bronze_block_enabled")) {
			return () -> Settings.bronzeBlock.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":bronze_tools_enabled")) {
			return () -> Settings.bronzeTools.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":bronze_armor_enabled")) {
			return () -> Settings.bronzeArmor.isEnabled() == value;
		}
		return null;
	} // end parse()

} // end class
