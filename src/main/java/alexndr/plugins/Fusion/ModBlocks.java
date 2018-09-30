package alexndr.plugins.Fusion;

import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
	// STORAGE BLOCKS
	public static SimpleBlock steel_block = 
			new SimpleBlock("steel_block", Fusion.plugin, Material.IRON, ContentCategories.Block.GENERAL)
					.setStepSound(SoundType.METAL);
	
	public static SimpleBlock bronze_block = 
			new SimpleBlock("bronze_block", Fusion.plugin, Material.IRON,ContentCategories.Block.GENERAL)
					.setStepSound(SoundType.METAL);
	public static SimpleBlock thyrium_block = 
			new SimpleBlock("thyrium_block", Fusion.plugin, Material.IRON, ContentCategories.Block.GENERAL)
					.setStepSound(SoundType.METAL);
	public static SimpleBlock sinisite_block = 
			new SimpleBlock("sinisite_block", Fusion.plugin, Material.IRON, ContentCategories.Block.GENERAL)
					.setStepSound(SoundType.METAL);
	
	// MACHINES
	public static BlockFusionFurnace fusion_furnace = 
			new BlockFusionFurnace("fusion_furnace", Fusion.plugin, false);
	public static BlockFusionFurnace fusion_furnace_lit = 
			new BlockFusionFurnace("fusion_furnace_lit", Fusion.plugin, true);

	/**
	 * Loads Fusion Blocks.
	 */
	public static void configureBlocks()
	{
		if (Settings.fusionFurnace.isEnabled()) {
			fusion_furnace.setConfigEntry( Settings.fusionFurnace)
				.setStepSound(SoundType.STONE)
				.setCreativeTab(TabHelper.redstoneTab(SimpleCoreAPI.plugin));
			fusion_furnace_lit.setConfigEntry(Settings.fusionFurnace)
				.setStepSound(SoundType.STONE).setDropItem(true)
				.setItemToDrop(fusion_furnace.getItemToDrop());
			BlockFusionFurnace.setUnlit_furnace(fusion_furnace);
			BlockFusionFurnace.setLit_furnace(fusion_furnace_lit);
		}
		if (Settings.steelBlock.isEnabled()) {
			steel_block.setConfigEntry(Settings.steelBlock)
				   .setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
	} // end configureBlocks()
	
	public static void configureSimpleOresBlocks()
	{
		if (! Content.use_simpleores) return;
		if (Settings.bronzeBlock.isEnabled()) {
			bronze_block.setConfigEntry(Settings.bronzeBlock).setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.thyriumBlock.isEnabled()) {
			thyrium_block.setConfigEntry(Settings.thyriumBlock).setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.sinisiteBlock.isEnabled()) {
			sinisite_block.setConfigEntry(Settings.sinisiteBlock).setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
	} // end configureSimpleOresBlocks()
	
	/**
	 * Register blocks with Forge.
	 * 
	 * @param registry Forge block registry interface.
	 */
	public static void register(IForgeRegistry<Block> registry) 
	{
		if (Settings.steelBlock.isEnabled())  registry.register(steel_block);
		if (Content.use_simpleores) {
			if (Settings.bronzeBlock.isEnabled()) registry.register(bronze_block);
			if (Settings.sinisiteBlock.isEnabled()) registry.register(sinisite_block);
			if (Settings.thyriumBlock.isEnabled()) registry.register(thyrium_block);
		} // end-if use_simpleores
		if (Settings.fusionFurnace.isEnabled()) {
			registry.register(fusion_furnace);
			registry.register(fusion_furnace_lit);
			TileEntity.register(TileEntityFusionFurnace.tilename, TileEntityFusionFurnace.class);
		} // end-if fusionFurnace
	} // end register()
	
	/**
	 * register ItemBlocks with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
		if (Settings.steelBlock.isEnabled())  registry.register(steel_block.createItemBlock());
		if (Content.use_simpleores) {
			if (Settings.bronzeBlock.isEnabled()) registry.register(bronze_block.createItemBlock());
			if (Settings.sinisiteBlock.isEnabled()) registry.register(sinisite_block.createItemBlock());
			if (Settings.thyriumBlock.isEnabled()) registry.register(thyrium_block.createItemBlock());
		} // end-if use_simpleores
		if (Settings.fusionFurnace.isEnabled()) {
			registry.register(fusion_furnace.createItemBlock());
		} // end-if fusionFurnace
	} // end registerItemBlocks()

	/**
	 * register models of ItemBlocks with Forge.
	 */
	public static void registerModels() 
	{
		if (Settings.steelBlock.isEnabled()) 
			steel_block.registerItemModel(Item.getItemFromBlock(steel_block));
		
		if (Content.use_simpleores) {
			if (Settings.bronzeBlock.isEnabled())
				bronze_block.registerItemModel(Item.getItemFromBlock(bronze_block));
			if (Settings.sinisiteBlock.isEnabled())
				sinisite_block.registerItemModel(Item.getItemFromBlock(sinisite_block));
			if (Settings.thyriumBlock.isEnabled())
				thyrium_block.registerItemModel(Item.getItemFromBlock(thyrium_block));
		} // end-if use_simpleores
		if (Settings.fusionFurnace.isEnabled()) {
			fusion_furnace.registerItemModel(Item.getItemFromBlock(fusion_furnace));
		}
	} // end registerModels()
	
	/**
	 * ore dictionary registrations for blocks.
	 */
	public static void registerOreDictionary()
	{
		if (Settings.steelBlock.isEnabled()) {
			OreDictionary.registerOre("blockSteel", new ItemStack(ModBlocks.steel_block));
		}
		if (Content.use_simpleores) {
			if (Settings.bronzeBlock.isEnabled()) {
				OreDictionary.registerOre("blockBronze", new ItemStack(ModBlocks.bronze_block));
			}
			if (Settings.thyriumBlock.isEnabled()) {
				OreDictionary.registerOre("blockThyrium", new ItemStack(ModBlocks.thyrium_block));
			}
			if (Settings.sinisiteBlock.isEnabled()) {
				OreDictionary.registerOre("blockSinisite", new ItemStack(ModBlocks.sinisite_block));
			}
		} // end-if use_simpleores
	} // end registerOreDictionary()

} // end-class ModBlocks
