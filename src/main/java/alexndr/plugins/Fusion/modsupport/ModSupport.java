package alexndr.plugins.Fusion.modsupport;

import net.minecraftforge.fml.common.Loader;
import alexndr.plugins.Fusion.Settings;

public class ModSupport 
{
	private static boolean use_simpleores = false;

	@SuppressWarnings("unused")
	private static boolean use_netherrocks = false;

	public static void preInit()
	{
		use_simpleores = Loader.isModLoaded("simpleores") 
							&& Settings.enableSimpleOres.asBoolean();	
		use_netherrocks = Loader.isModLoaded("netherrocks") 
							&& Settings.enableNetherrocks.asBoolean();
	} // end preInit()
	
	public static void ContentPreInit() {
		if(use_simpleores) {
			ContentSimpleOres.doItems();
			ContentSimpleOres.doBlocks();
			ContentSimpleOres.doArmor();
			ContentSimpleOres.doTools();
			ContentSimpleOres.doAchievements();
		}
		// TODO netherrocks
	} // end ContentPreInit()
	
	public static void Init() {
		if (use_simpleores) {
			ContentSimpleOres.setRepairMaterials(); 
			ContentSimpleOres.setAchievementTriggers();
		}
		// TODO add Netherrocks
	} // end Init()
	
	/** 
	 * checks if relevant SimpleCore mods loaded, and calls their 
	 * setToolAndArmorStats() methods.
	 */
	public static void setToolAndArmorStats() {
		if(use_simpleores) {
			ContentSimpleOres.setToolAndArmorStats();
		}
		// TODO Netherrocks
	} // end setToolAndArmorStats
	
	public static void doOreDictEntries() {
		if (use_simpleores) {
			RecipesSimpleOres.doOreDictRecipes();
		}
		// TODO Netherrocks
	} // end doOreDictEntries
	
	public static void doRecipes() {
		if (use_simpleores) {
			RecipesSimpleOres.doRecipes();
		}		
		// TODO Netherrocks
	} // end doRecipes()

} // end class
