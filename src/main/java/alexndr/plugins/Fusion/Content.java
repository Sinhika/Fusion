package alexndr.plugins.Fusion;

import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.logger.LogHelper;
import alexndr.plugins.Fusion.crafting.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.crafting.FusionMaterial;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	public static boolean use_simpleores = false;
	
	//Tool Materials
	public static ToolMaterial toolSteel;
	public static ToolMaterial toolBronze, toolThyrium, toolSinisite;
	
	//Armor Materials
	public static ArmorMaterial armorSteel;
	public static ArmorMaterial armorBronze, armorThyrium, armorSinisite;
	
	/**
	 * Because many other mods provide copper and tin, enable support for Copper & Tin blocks & items
	 * if they exist in the ore dictionary.
	 * 
	 * @return true if copper or tin exists in the ore dictionary, false if not.
	 */
	public static boolean hasLimitedSimpleOres()
	{
    	return (OreDictionary.doesOreNameExist("ingotCopper") 
    			|| OreDictionary.doesOreNameExist("ingotTin"));
	}
	
	/**
	 * Loads all the Fusion content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		use_simpleores = Loader.isModLoaded("simpleores") && Settings.enableSimpleOres;	
		
		setToolAndArmorStats();
		
		try {
			ModItems.configureItems();
			ModBlocks.configureBlocks();
			ModItems.configureTools();
			ModItems.configureArmor();
			if (use_simpleores || Content.hasLimitedSimpleOres()) {
				ModItems.configureSimpleOresItems();
				ModBlocks.configureSimpleOresBlocks();
				ModItems.configureSimpleOresArmor();
				ModItems.configureSimpleOresTools();
			}
			LogHelper.verbose("Fusion",
					"Content pre-init completed successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Fusion",
					"Content pre-init failed. This is a serious problem!");
			e.printStackTrace();
		}
		
	} // end ()
	
    protected static void setToolAndArmorStats()
    {
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);
		
    	toolSteel = EnumHelper.addToolMaterial("STEEL", Settings.steelTools.getHarvestLevel(), Settings.steelTools.getUses(), 
    											Settings.steelTools.getHarvestSpeed(), Settings.steelTools.getDamageVsEntity(), 
    											Settings.steelTools.getEnchantability());
        armorSteel = EnumHelper.addArmorMaterial("STEEL", "steel",
                        Settings.steelArmor.getDurability(),
                        new int[] { Settings.steelArmor.getBootsReduction(),
                                    Settings.steelArmor.getLegsReduction(),
                                    Settings.steelArmor.getChestReduction(),
                                    Settings.steelArmor.getHelmReduction() },
                        Settings.steelArmor.getEnchantability(), armorNoise, 0.5F);
		setSimpleOresToolAndArmorStats();
    } // end setToolAndArmorStats()

    protected static void setSimpleOresToolAndArmorStats()
    {
		toolBronze = EnumHelper.addToolMaterial("BRONZE",
				Settings.bronzeTools.getHarvestLevel(),
				Settings.bronzeTools.getUses(),
				Settings.bronzeTools.getHarvestSpeed(),
				Settings.bronzeTools.getDamageVsEntity(),
				Settings.bronzeTools.getEnchantability());
		toolThyrium = EnumHelper.addToolMaterial("THYRIUM",
				Settings.thyriumTools.getHarvestLevel(),
				Settings.thyriumTools.getUses(),
				Settings.thyriumTools.getHarvestSpeed(),
				Settings.thyriumTools.getDamageVsEntity(),
				Settings.thyriumTools.getEnchantability());
		toolSinisite = EnumHelper.addToolMaterial("SINISITE",
				Settings.sinisiteTools.getHarvestLevel(),
				Settings.sinisiteTools.getUses(),
				Settings.sinisiteTools.getHarvestSpeed(),
				Settings.sinisiteTools.getDamageVsEntity(),
				Settings.sinisiteTools.getEnchantability());
		
		// armor
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);

		armorBronze = EnumHelper.addArmorMaterial("BRONZE", "bronze",
				Settings.bronzeArmor.getDurability(), new int[] {
                        Settings.bronzeArmor.getBootsReduction(),
                        Settings.bronzeArmor.getLegsReduction(),
                        Settings.bronzeArmor.getChestReduction(),
						Settings.bronzeArmor.getHelmReduction()
						},
				Settings.bronzeArmor.getEnchantability(), armorNoise, 0.0F);
		armorThyrium = EnumHelper.addArmorMaterial("THYRIUM", "thyrium",
				Settings.thyriumArmor.getDurability(), new int[] {
                        Settings.thyriumArmor.getBootsReduction(),
                        Settings.thyriumArmor.getLegsReduction(),
                        Settings.thyriumArmor.getChestReduction(),
						Settings.thyriumArmor.getHelmReduction()
						},
				Settings.thyriumArmor.getEnchantability(), armorNoise, 1.0F );
		armorSinisite = EnumHelper.addArmorMaterial("SINISITE", "sinisite",
				Settings.sinisiteArmor.getDurability(), new int[] {
		                Settings.sinisiteArmor.getBootsReduction(),
                        Settings.sinisiteArmor.getLegsReduction(),
                        Settings.sinisiteArmor.getChestReduction(),
						Settings.sinisiteArmor.getHelmReduction()
						},
				Settings.sinisiteArmor.getEnchantability(), armorNoise, 2.0F );
    } // end setToolAndArmorStats()
  
    
	public static void setRepairMaterials()
	{
		toolSteel.setRepairItem(new ItemStack(ModItems.steel_ingot));
		ArmorMaterialHelper.setRepairItem(armorSteel, new ItemStack(ModItems.steel_ingot));
		setSimpleOresRepairMaterials(); 
	} // end setRepairMaterials()
	
	public static void setSimpleOresRepairMaterials()
	{
		toolBronze.setRepairItem(new ItemStack(ModItems.bronze_ingot));
		toolThyrium.setRepairItem(new ItemStack(ModItems.thyrium_ingot));
		toolSinisite.setRepairItem(new ItemStack(ModItems.sinisite_ingot));
		
		ArmorMaterialHelper.setRepairItem(armorBronze, new ItemStack(ModItems.bronze_ingot));
		ArmorMaterialHelper.setRepairItem(armorThyrium, new ItemStack(ModItems.thyrium_ingot));
		ArmorMaterialHelper.setRepairItem(armorSinisite,new ItemStack(ModItems.sinisite_ingot));
	} // end setSimpleOresRepairMaterials()
	

	/**
	 * Add smelting recipes to GameRegistry.
	 */
	public static void addSmeltingRecipes() 
	{
		//Regular Furnace
		GameRegistry.addSmelting(ModItems.large_steel_chunk, new ItemStack(ModItems.steel_ingot), 0.4F);

		if (Content.use_simpleores || Content.hasLimitedSimpleOres()) {
			addSimpleOresSmeltingRecipes();
		}		
	} // end addSmeltingRecipes
	
	
	/**
	 * Add SimpleOres smelting recipes to GameRegistry.
	 */
	public static void addSimpleOresSmeltingRecipes() 
	{
		if (! (Content.use_simpleores || Content.hasLimitedSimpleOres() )) return;

		GameRegistry.addSmelting(ModItems.large_bronze_chunk, new ItemStack(ModItems.bronze_ingot), 0.3F);
		if (Content.use_simpleores) {
			GameRegistry.addSmelting(ModItems.large_thyrium_chunk, new ItemStack(ModItems.thyrium_ingot), 0.6F);
			GameRegistry.addSmelting(ModItems.large_sinisite_chunk, new ItemStack(ModItems.sinisite_ingot), 1.0F);
		}

	} // end addSimpleOresSmeltingRecipes()
	
	/**
	 * add Fusion smelting recipes
	 */
	public static void addFusionRecipes()
	{
		//Fusion Furnace
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of(Items.COAL),
				new ItemStack(ModItems.small_steel_chunk), 2.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of("gunpowder"), 
				new ItemStack(ModItems.medium_steel_chunk), 4.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotIron"),
				FusionMaterial.of(Items.COAL), FusionMaterial.of("dustRedstone"), 
				new ItemStack(ModItems.large_steel_chunk), 8.0F);
		if (Content.use_simpleores || Content.hasLimitedSimpleOres()) 
		{
			addSimpleOresFusionRecipes();
		}
	} // end addFusionRecipes
	
	/**
	 * add Fusion smelting recipes
	 */
	public static void addSimpleOresFusionRecipes()
	{
		if (! (Content.use_simpleores || Content.hasLimitedSimpleOres()) ) return;
		
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial.of(Items.DYE, 1, 15),
				new ItemStack(ModItems.small_bronze_chunk), 2.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial
						.of("gunpowder"), new ItemStack(
						ModItems.medium_bronze_chunk), 3.0F);
		FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotTin"), FusionMaterial
						.of("dustRedstone"), new ItemStack(
						ModItems.large_bronze_chunk), 10.0F);
		
		if (Content.use_simpleores)
		{
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
					FusionMaterial.of("ingotAdamantium"), FusionMaterial
					.of("dustRedstone"), new ItemStack(
							ModItems.small_thyrium_chunk), 6.0F);
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
					FusionMaterial.of("ingotAdamantium"), FusionMaterial.of(
							"gemLapis"), new ItemStack(
									ModItems.medium_thyrium_chunk), 10.0F);
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotMythril"),
					FusionMaterial.of("ingotAdamantium"), FusionMaterial
					.of("dustGlowstone"), new ItemStack(
							ModItems.large_thyrium_chunk), 30.0F);

			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
					FusionMaterial.of("ingotMythril"), FusionMaterial
					.of("dustGlowstone"), new ItemStack(
							ModItems.small_sinisite_chunk), 12.0F);
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
					FusionMaterial.of("ingotMythril"), FusionMaterial
					.of(Items.BLAZE_POWDER), new ItemStack(
							ModItems.medium_sinisite_chunk), 20.0F);
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("gemOnyx"),
					FusionMaterial.of("ingotMythril"), FusionMaterial
					.of(Items.GHAST_TEAR), new ItemStack(
							ModItems.large_sinisite_chunk), 60.0F);
		} // end if full SimpleOres
	} // end addSimpleOresFusionRecipes()

//	public static void doCustomFusionRecipes()
//	{
//		// avoid NPE
//		if (Settings.numCustomRecipes == 0 || Settings.customFusionRecipes == null) {
//			return;
//		}
//		for (int ii=0; ii < Settings.customFusionRecipes.length; ii++)
//		{
//			ConfigFusionRecipe r = Settings.customFusionRecipes[ii];
//			ItemStack outStack = new ItemStack(FusionMaterial.of(r.getOutput()).getItem());
//			
//			FusionFurnaceRecipes.addSmelting(FusionMaterial.of(r.getInput1()), 
//										     FusionMaterial.of(r.getInput2()), 
//										     FusionMaterial.of(r.getCatalyst()),
//											 outStack, 1.0F);
//			LogHelper.info(ModInfo.ID, r.getName() + " registered.");
//		} // end-for
//	} // end doCustomFusionRecipes()


} // end class
