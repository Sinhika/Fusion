package alexndr.plugins.Fusion;

import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import alexndr.plugins.Fusion.modsupport.ContentSimpleOres;
import alexndr.plugins.Fusion.modsupport.RecipesSimpleOres;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
	// STORAGE BLOCKS
	public static SimpleBlock steel_block = 
			new SimpleBlock("steel_block", Fusion.plugin, Material.IRON, ContentCategories.Block.GENERAL)
						.setStepSound(SoundType.METAL);
	
	public static SimpleBlock bronze_block;
	public static SimpleBlock thyrium_block;
	public static SimpleBlock sinisite_block;
	
	// MACHINES
	public static BlockFusionFurnace fusion_furnace = 
			new BlockFusionFurnace(false).setUnlocalizedName("fusion_furnace");
	public static BlockFusionFurnace fusion_furnace_lit = 
			new BlockFusionFurnace(true).setUnlocalizedName("fusion_furnace_lit");

	/**
	 * Loads Fusion Blocks.
	 */
	public static void configureBlocks()
	{
		if (Settings.fusionFurnace.isEnabled()) {
			fusion_furnace.setConfigEntry( Settings.fusionFurnace)
			.setCreativeTab(TabHelper.redstoneTab(SimpleCoreAPI.plugin));
			fusion_furnace_lit.setConfigEntry(Settings.fusionFurnace);
		}
		if (Settings.steelBlock.isEnabled()) {
			steel_block.setConfigEntry(Settings.steelBlock)
				   .setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
	} // end configureBlocks()
	
	public static void configureSimpleOresBlocks()
	{
		bronze_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.bronzeBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("bronze_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		thyrium_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.thyriumBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("thyrium_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		sinisite_block = new SimpleBlock(Fusion.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.sinisiteBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("sinisite_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
	}
	
	/**
	 * Register blocks with Forge.
	 * 
	 * @param registry Forge block registry interface.
	 */
	public static void register(IForgeRegistry<Block> registry) 
	{
	} // end register()
	
	/**
	 * register ItemBlocks with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
	} // end registerItemBlocks()

	/**
	 * register models of ItemBlocks with Forge.
	 */
	public static void registerModels() 
	{
	} // end registerModels()
	
	/**
	 * ore dictionary registrations for blocks.
	 */
	public static void registerOreDictionary()
	{
		OreDictionary.registerOre("blockSteel", new ItemStack(ModBlocks.steel_block));
		if (Content.use_simpleores) {
			OreDictionary.registerOre("blockBronze", new ItemStack(ContentSimpleOres.bronze_block));
			OreDictionary.registerOre("blockThyrium", new ItemStack(ContentSimpleOres.thyrium_block));
			OreDictionary.registerOre("blockSinisite", new ItemStack(ContentSimpleOres.sinisite_block));
		}

	} // end registerOreDictionary()

} // end-class ModBlocks
