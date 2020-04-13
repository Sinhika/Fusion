package alexndr.plugins.Fusion.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import alexndr.plugins.Fusion.ModInfo;
import alexndr.plugins.Fusion.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class ThyriumConditionFactory implements IConditionFactory 
{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");

		if (key.equals(ModInfo.ID + ":thyrium_ingot_enabled")) {
			return () -> Settings.thyriumIngot.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":thyrium_block_enabled")) {
			return () -> Settings.thyriumBlock.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":thyrium_tools_enabled")) {
			return () -> Settings.thyriumTools.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":thyrium_armor_enabled")) {
			return () -> Settings.thyriumArmor.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":thyrium_bow_enabled")) {
			return () -> Settings.thyriumBow.isEnabled() == value;
		}
		return null;
	} // end parse()

} // end class
