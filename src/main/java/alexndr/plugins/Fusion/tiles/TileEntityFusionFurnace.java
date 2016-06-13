package alexndr.plugins.Fusion.tiles;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import alexndr.plugins.Fusion.blocks.SimpleFurnace;

/**
 * @author AleXndrTheGr8st
 */
public class TileEntityFusionFurnace extends TileEntitySimpleFurnace
{
	protected static boolean initDone = false;
	
//	private static final int[] slots_catalyst = new int[] {4};
//	private static final int[] slots_output = new int[] {2, 1};
//	private static final int[] slots_fuel = new int[] {1};
//	private ItemStack[] furnaceItemStacks = new ItemStack[5];
	
	protected static final int[] slots_input1 = new int[] {0};
	protected static final int[] slots_input2 = new int[] {3};
	
	public static void initThis()
	{
		if (initDone) return;
		
		slotsBottom = new int[] {2, 1}; // slots_output, slots_fuel
		slotsSides = new int[] {0, 3};  // slots_input1, slots_input2
		slotsTop = new int[] {4}; 		// slots_catalyst
		
		initDone = true;
	}
	
	public TileEntityFusionFurnace() 
	{
		super("fusion:container.fusion_furnace", BlockFusionFurnace.class, 600, 
			  "fusion:fusion_furnace_gui", 5);
		if (! TileEntityFusionFurnace.initDone) {
			TileEntityFusionFurnace.initThis();
		}
	} // end ctor()
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks[index]) 
				&& ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks[index]);
        this.furnaceItemStacks[index] = stack;
        
        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
        
        // Fusion Furnace has 3 (!) input stacks to account for.
        if ((index == 0 || index == 3 || index == 4) && !flag)
        {
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
	} // end ()

	@Override
	public void update()
	{
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

		if(!this.worldObj.isRemote)
		{
            if (this.isBurning() || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null
            	 && this.furnaceItemStacks[3] != null && this.furnaceItemStacks[4] != null )
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

                    if (this.isBurning())
                    {
                        flag1 = true;
                        if (this.furnaceItemStacks[1] != null)
                        {
                            --this.furnaceItemStacks[1].stackSize;
                            if (this.furnaceItemStacks[1].stackSize == 0)
                            {
                                this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                            }
                        } // end-if
                    } // end-if
                } // end-if
                
                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks[0]);
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
				BlockFusionFurnace.setState(this.isBurning(), this.worldObj, this.pos);
			}
		} // end-if
		
		if(flag1)
			this.markDirty();
	} // end update()
	
	/**
	 * Returns true if the furnace can smelt at that time. ie. has inputs, catalyst, destination stack isn't full, etc.
	 * @return True if furnace can smelt.
	 */
	@Override
	protected boolean canSmelt()
	{
		if(this.furnaceItemStacks[0] != null && this.furnaceItemStacks[3] != null && this.furnaceItemStacks[4] != null)
		{
			ItemStack itemstack = FusionFurnaceRecipes.getSmeltingResult(this.furnaceItemStacks[0], 
														this.furnaceItemStacks[3], this.furnaceItemStacks[4]);
			if(itemstack == null) return false;
			if(this.furnaceItemStacks[2] == null) return true;
			if(!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
			int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize());
		}
		return false;
	} // end canSmelt()
	
	@Override
	public void smeltItem()
	{
		if(this.canSmelt())
		{
			ItemStack itemstack = FusionFurnaceRecipes.applyFusion(this.furnaceItemStacks[0], 
																this.furnaceItemStacks[3], this.furnaceItemStacks[4]);
			
			if(this.furnaceItemStacks[2] == null) {
				this.furnaceItemStacks[2] = itemstack.copy();
			}
			else if(this.furnaceItemStacks[2].isItemEqual(itemstack)) {
				furnaceItemStacks[2].stackSize += itemstack.stackSize;
			}
			
			// decrement input slots 0, 3, 4
			for (int ii=0; ii < 5; ii++)
			{
				// ignore fuel and output slots
				if (ii == 1 || ii == 2) continue;
				
				// decrement inputs
	            --this.furnaceItemStacks[ii].stackSize;
	            
	            // check for items contained in buckets
	            if (furnaceItemStacks[ii] != null && this.furnaceItemStacks[ii].stackSize <= 0) 
	            {
	            	// if we haz bucket, we gets bucket. If we no haz bucket, we get null.
					furnaceItemStacks[ii] = furnaceItemStacks[ii].getItem().getContainerItem(furnaceItemStacks[ii]);
	            }
			} // end-for

		} // end-if canSmelt
	} // end smeltItem()
	
	
	/**
	 * Gets the burn time from an itemstack.
	 * @param par1ItemStack The itemstack to get the burn time for.
	 * @return The burn time, in ticks, for the itemstack. Returns 0 if it's not a fuel source.
	 */
	public static int getItemBurnTime(ItemStack burnItem)
	{
		double burnTimeModifier = 1.875F;
		return (int) (TileEntitySimpleFurnace.getItemBurnTime(burnItem) * burnTimeModifier);
	} // end ()
	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		EnumFacing furnaceFace = this.worldObj.getBlockState(this.pos).getValue(SimpleFurnace.FACING);
		switch (side)
		{
			case DOWN :
				return slotsBottom;
			case UP :
				return slotsTop;
			case WEST:
				switch (furnaceFace) {
				case NORTH:
					return slots_input2;
				case SOUTH:
					return slots_input1;
				case WEST:
				case EAST:
					return slotsSides;
				}
			case EAST:
				switch (furnaceFace) {
				case NORTH:
					return slots_input1;
				case SOUTH:
					return slots_input2;
				case WEST:
				case EAST:
					return slotsSides;
				}
			case NORTH:
				switch (furnaceFace) {
				case NORTH:
				case SOUTH:
					return slotsSides;
				case WEST:
					return slots_input1;
				case EAST:
					return slots_input2;
				}
			case SOUTH:
				switch (furnaceFace) {
				case NORTH:
				case SOUTH:
					return slotsSides;
				case WEST:
					return slots_input2;
				case EAST:
					return slots_input1;
				}
		}
		return null;
	} // end getSlotsForFace()


	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return index != 1 || stack.getItem() == Items.BUCKET;
	}
	
} // end class
