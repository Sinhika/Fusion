package mod.alexndr.fusion.content;

import java.util.List;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.init.ModItems;
import mod.alexndr.simpleores.content.SimpleOresTiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

/**
 * Holds declarations for tool material tiers.
 * @author Sinhika
 *
 */
public final class FusionItemTiers
{
	public static final Tag.Named<Block> BRONZE_TAG = 
		BlockTags.createOptional(new ResourceLocation(Fusion.MODID, "needs_bronze_tool"));
	public static final Tag.Named<Block> STEEL_TAG = 
			BlockTags.createOptional(new ResourceLocation(Fusion.MODID, "needs_steel_tool"));
	public static final Tag.Named<Block> SINISITE_TAG = 
			BlockTags.createOptional(new ResourceLocation(Fusion.MODID, "needs_sinisite_tool"));
	public static final Tag.Named<Block> THYRIUM_TAG = 
			BlockTags.createOptional(new ResourceLocation(Fusion.MODID, "needs_thyrium_tool"));
	
	public static final Tier BRONZE = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.IRON.getLevel(), 800, 9.0F, 2.0F, 7, BRONZE_TAG, ()->Ingredient.of( ModItems.bronze_ingot.get())),
			new ResourceLocation(Fusion.MODID, "bronze"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
	
	public static final Tier STEEL = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.IRON.getLevel(), 700, 7.5F, 3.0F, 24, STEEL_TAG, ()->Ingredient.of( ModItems.steel_ingot.get())),
			new ResourceLocation(Fusion.MODID, "steel"), List.of(Tiers.IRON, BRONZE), List.of(Tiers.DIAMOND));
	
	public static final Tier THYRIUM = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.DIAMOND.getLevel(), 2000, 22.0F, 6.0F, 28, THYRIUM_TAG, ()->Ingredient.of( ModItems.thyrium_ingot.get())),
			new ResourceLocation(Fusion.MODID, "thyrium"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
	
	public static final Tier SINISITE = TierSortingRegistry.registerTier(
			new ForgeTier(5, 4100, 18.0F, 8.0F, 11, SINISITE_TAG, ()->Ingredient.of( ModItems.sinisite_ingot.get())),
			new ResourceLocation(Fusion.MODID, "thyrium"), List.of(Tiers.NETHERITE, SimpleOresTiers.ONYX), List.of());
	
} // end class
