package alexndr.plugins.Fusion;

import java.util.List;

import com.google.common.collect.Lists;

import alexndr.api.logger.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author AleXndrTheGr8st, zot201
 * Huge thanks to zot201 for all the help with the Fusion Furnace.
 */
public abstract class FusionMaterial 
{
	/**
	 * Creates a new NullMaterial.
	 * @return NullMaterial.
	 */
	public static FusionMaterial of()
	{
		return new NullMaterial();
	}
	
	/**
	 * Creates a new DictMaterial for OreDictionary materials.
	 * @param ore The OreDictionary string to be used.
	 * @param amount The stacksize of the item/block.
	 * @return DictMaterial.
	 */
	public static FusionMaterial of(String ore, int amount)
	{
		// actually check ore dictionary for material...
		if (OreDictionary.doesOreNameExist(ore)) {
			return new DictMaterial(ore, amount);
		} // end-if
		
		ResourceLocation ore_name = new ResourceLocation(ore);
		
		// is this a block name?
		// Note: block registry has default key Blocks.AIR
		if (Block.REGISTRY.getObject(ore_name) != Blocks.AIR)
		{
			Block B = Block.REGISTRY.getObject(ore_name);
			return of(B, amount);
		}
		// or an item name?
		else if (Item.REGISTRY.getObject(ore_name) != null)
		{
			Item I = Item.REGISTRY.getObject(ore_name);
			return of (I, amount);
		}
		// fail-safe case
		else { 
			LogHelper.severe(ModInfo.ID, "Material " + ore + " does not exist! Cannot create recipe.");
			return new NullMaterial();
		}
	} // end of(String, int)
	
	/**
	 * Creates a new StackMaterial for ItemStack materials.
	 * @param stack The itemstack that you want to use.
	 * @return StackMaterial.
	 */
	public static FusionMaterial of(ItemStack stack)
	{
		return new StackMaterial(stack);
	}
	
	/**
	 * Creates a new DictMaterial from an OreDictionary string. Stacksize is set to 1.
	 * @param ore The OreDictionary string to be used.
	 * @return DictMaterial.
	 */
	public static FusionMaterial of(String ore){return of(ore, 1);} 
	
	/**
	 * Creates a new StackMaterial from an item, a stacksize, and the metadata of the item.
	 * @param item The item to use.
	 * @param amount The stacksize of the item.
	 * @param meta The metadata of the item.
	 * @return StackMaterial.
	 */
    public static FusionMaterial of(Item item, int amount, int meta)
    {
        return of(new ItemStack(item, amount, meta));
    }

	
	/**
	 * Creates a new StackMaterial from an item and a stacksize. Metadata is set to 0.
	 * @param item The item to use.
	 * @param amount The stacksize of the item.
	 * @return StackMaterial.
	 */
    public static FusionMaterial of(Item item, int amount)
    {
        return of(new ItemStack(item, amount, 0));
    }

	/**
	 * Creates a new StackMaterial from an item. Stacksize is set to 1. Metadata is set to 0.
	 * @param item The item to use.
	 * @return StackMaterial.
	 */
    public static FusionMaterial of(Item item)
    {
        return of(new ItemStack(item, 1, 0));
    }

	/**
	 * Creates a new StackMaterial from a block, a stacksize and the metadata of the block.
	 * @param block The block to use.
	 * @param amount The stacksize of the block.
	 * @param meta The metadata of the block.
	 * @return StackMaterial.
	 */
    public static FusionMaterial of(Block block, int amount, int meta)
    {
        return of(new ItemStack(block, amount, meta));
    }

	/**
	 * Creates a new StackMaterial from a block and a stacksize. Metadata is set to 0.
	 * @param block The block to use.
	 * @param amount The stacksize of the block.
	 * @return StackMaterial.
	 */
    public static FusionMaterial of(Block block, int amount)
    {
        return of(new ItemStack(block, amount, 0));
    }

	/**
	 * Creates a new StackMaterial from a block. Stacksize is set to 1. Metadata is set to 0.
	 * @param block The block to use.
	 * @return StackMaterial.
	 */
    public static FusionMaterial of(Block block)
    {
        return of(new ItemStack(block, 1, 0));
    }

	public abstract boolean matches(ItemStack item);
	public abstract void decrStackSize(ItemStack item);
	public abstract List<ItemStack> itemsList();
	public abstract int getAmount();
	public abstract int getMeta();
	public abstract String getOre();
	public abstract Item getItem();
	
	/**
	 * A null material
	 * @author AleXndrTheGr8st, zot201
	 */
	public static class NullMaterial extends FusionMaterial
	{
		NullMaterial(){}
		
		@Override
		public boolean matches(ItemStack item) 
		{
		    return item.isEmpty();
		}

		@Override
		public void decrStackSize(ItemStack item) {}

		@Override
		public List<ItemStack> itemsList() 
		{
			return Lists.newArrayList();
		}

		@Override
		public int getAmount() {return 0;}

		@Override
		public int getMeta() {return 0;}

		@Override
		public String getOre() {return null;}

		@Override
		public Item getItem() {return null;}
	}
	
	/**
	 * An OreDictionary material.
	 * @author AleXndrTheGr8st, zot201
	 */
	public static class DictMaterial extends FusionMaterial
	{
		public final String ore;
		public final int amount;
		
		DictMaterial(String ore, int amount)
		{
			if(amount < 0)
				throw new IllegalArgumentException(Integer.valueOf(amount).toString());
			
			this.ore = ore;
			this.amount = amount;
		}

		@Override
		public boolean matches(ItemStack item) 
		{
			if(item.isEmpty() || item.getCount() < this.amount)
				return false;
			
			for(ItemStack stack : OreDictionary.getOres(ore, false))
			{
				if(FusionFurnaceRecipes.matches(stack, item))
					return true;
			}
			return false;
		}

		@Override
		public void decrStackSize(ItemStack item) 
		{
			item.shrink(amount);
		}

		@Override
		public List<ItemStack> itemsList() 
		{
			return OreDictionary.getOres(ore);
		}

		@Override
		public int getAmount() 
		{
			return amount;
		}
		
		@Override
		public String getOre()
		{
			return ore;
		}

		@Override
		public int getMeta() {return 0;}

		@Override
		public Item getItem() {return null;}
	}
	
	/**
	 * An ItemStack material.
	 * @author AleXndrTheGr8st, zot201
	 */
	public static class StackMaterial extends FusionMaterial
	{
		private final ItemStack stack;
		
		StackMaterial(ItemStack stack)
		{
			if(stack.isEmpty())
				throw new IllegalArgumentException(stack.toString());
			this.stack = stack.copy();
		}

		@Override
		public boolean matches(ItemStack item) 
		{
            if(item.isEmpty() 
               || item.getCount() < stack.getCount())
            {
				return false;
            }
			return FusionFurnaceRecipes.matches(stack, item);
		}

		@Override
		public void decrStackSize(ItemStack item) 
		{
			item.shrink(stack.getCount());
		}

		@Override
		public List<ItemStack> itemsList() 
		{
			return Lists.newArrayList(stack.copy());
		}

		@Override
		public int getAmount() 
		{
			return stack.getCount();
		}
		
		@Override
		public Item getItem()
		{
			return stack.getItem();
		}
		
		@Override
		public int getMeta()
		{
			return stack.getItemDamage();
		}

		@Override
		public String getOre() {return null;}
	}
} // end class
