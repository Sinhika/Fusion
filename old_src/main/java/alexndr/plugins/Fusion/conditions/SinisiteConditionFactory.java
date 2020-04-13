package alexndr.plugins.Fusion.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import alexndr.plugins.Fusion.ModInfo;
import alexndr.plugins.Fusion.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class SinisiteConditionFactory implements IConditionFactory 
{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");

		if (key.equals(ModInfo.ID + ":sinisite_ingot_enabled")) {
			return () -> Settings.sinisiteIngot.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":sinisite_block_enabled")) {
			return () -> Settings.sinisiteBlock.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":sinisite_tools_enabled")) {
			return () -> Settings.sinisiteTools.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":sinisite_armor_enabled")) {
			return () -> Settings.sinisiteArmor.isEnabled() == value;
		}
		if (key.equals(ModInfo.ID + ":sinisite_bow_enabled")) {
			return () -> Settings.sinisiteBow.isEnabled() == value;
		}
		return null;
	} // end parse()

} // end class
