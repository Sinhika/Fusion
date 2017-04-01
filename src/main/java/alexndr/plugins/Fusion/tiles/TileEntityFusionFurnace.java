package alexndr.plugins.Fusion.tiles;

import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import mcjty.lib.tools.ItemStackTools;
import mcjty.lib.tools.MathTools;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

/**
 * @author AleXndrTheGr8st
 */
public class TileEntityFusionFurnace extends TileEntitySimpleFurnace
{
	protected static final int NDX_LEFT_SLOT = 0;
	protected static final int NDX_FUEL_SLOT = 1;
	protected static final int NDX_OUTPUT_SLOT = 2;
    protected static final int NDX_RIGHT_SLOT = 3;
    protected static final int NDX_CATALYST_SLOT = 4;
    
    protected static boolean initDone = false;
	
	protected static final int[] slots_input1 = new int[] {NDX_LEFT_SLOT};
	protected static final int[] slots_input2 = new int[] {NDX_RIGHT_SLOT};
	protected static final int[] slots_fuel = new int[] {NDX_FUEL_SLOT};
	protected static final int[] slots_output = new int [] {NDX_OUTPUT_SLOT};
	
	public static void initThis()
	{
		if (initDone) return;
		
		slotsTop = new int[] {NDX_CATALYST_SLOT}; 		// slots_catalyst
		slotsBottom = new int[] {NDX_OUTPUT_SLOT, NDX_FUEL_SLOT}; // slots_output, slots_fuel
		// slotsSides = new int[] {0, 3};  // slots_input1, slots_input2
		
		initDone = true;
	}
	
	public TileEntityFusionFurnace() 
	{
		super("container.fusion_furnace", 600, 
			  "fusion:fusion_furnace_gui", 5);
		initThis();
	} // end ctor()
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
        ItemStack itemstack = (ItemStack)this.getStackInSlot(index);
        boolean flag = ItemStackTools.isValid(stack) && stack.isItemEqual(itemstack) 
                && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.furnaceItemStacks.set(index, stack);
        
        if (ItemStackTools.getStackSize(stack) > this.getInventoryStackLimit())
        {
            ItemStackTools.setStackSize(stack, this.getInventoryStackLimit());
        }
        
        // Fusion Furnace has 3 (!) input stacks to account for.
        if ((index == NDX_LEFT_SLOT || index == NDX_RIGHT_SLOT || index == NDX_CATALYST_SLOT) && !flag)
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

		if(!this.getWorld().isRemote)
		{
            ItemStack fuelstack = (ItemStack)this.getStackInSlot(NDX_FUEL_SLOT);
            ItemStack leftstack = (ItemStack)this.getStackInSlot(NDX_LEFT_SLOT);
            ItemStack rightstack = (ItemStack)this.getStackInSlot(NDX_RIGHT_SLOT);
            ItemStack catastack = (ItemStack)this.getStackInSlot(NDX_CATALYST_SLOT);
            
            if (this.isBurning() || ItemStackTools.isValid(fuelstack) && ItemStackTools.isValid(leftstack)
                && ItemStackTools.isValid(rightstack) && ItemStackTools.isValid(catastack))
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(fuelstack);

                    if (this.isBurning())
                    {
                        flag1 = true;
                        if (ItemStackTools.isValid(fuelstack))
                        {
                            Item item = fuelstack.getItem();
                            ItemStackTools.incStackSize(fuelstack, -1);
                            if (ItemStackTools.isEmpty(fuelstack)) {
                                ItemStack item1 = item.getContainerItem(fuelstack);
                                this.furnaceItemStacks.set(NDX_FUEL_SLOT, item1);
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
                        this.totalCookTime = this.getCookTime(this.getStackInSlot(NDX_LEFT_SLOT));
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
                this.cookTime = MathTools.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
				BlockFusionFurnace.setState(this.isBurning(), this.getWorld(), this.pos);
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
        if (ItemStackTools.isValid(this.getStackInSlot(NDX_LEFT_SLOT))
                        && ItemStackTools.isValid(this.getStackInSlot(NDX_RIGHT_SLOT))
                        && ItemStackTools.isValid(this.getStackInSlot(NDX_CATALYST_SLOT)))
		{
			ItemStack result_stack = FusionFurnaceRecipes.getSmeltingResult(
			                                            this.getStackInSlot(NDX_LEFT_SLOT), 
														this.getStackInSlot(NDX_RIGHT_SLOT), 
														this.getStackInSlot(NDX_CATALYST_SLOT));
            if (ItemStackTools.isEmpty(result_stack)) {
                return false;
            }
            ItemStack outstack = (ItemStack)this.getStackInSlot(NDX_OUTPUT_SLOT);
            if (ItemStackTools.isEmpty(outstack)) return true;
            if (!outstack.isItemEqual(result_stack)) return false;
            
            int result = ItemStackTools.getStackSize(outstack) 
                    + ItemStackTools.getStackSize(result_stack);
            return (result <= getInventoryStackLimit() 
                     && result <= outstack.getMaxStackSize()); // Forge fix: make furnace respect stack sizes in furnace recipes
		}
		return false;
	} // end canSmelt()
	
	@Override
	public void smeltItem()
	{
		if(this.canSmelt())
		{
            ItemStack leftstack = (ItemStack)this.getStackInSlot(NDX_LEFT_SLOT);
            ItemStack rightstack = (ItemStack)this.getStackInSlot(NDX_RIGHT_SLOT);
            ItemStack catastack = (ItemStack)this.getStackInSlot(NDX_CATALYST_SLOT);
		    ItemStack itemstack = 
                 FusionFurnaceRecipes.applyFusion(this.getStackInSlot(NDX_LEFT_SLOT), 
                                                  this.getStackInSlot(NDX_RIGHT_SLOT), 
                                                  this.getStackInSlot(NDX_CATALYST_SLOT));
            ItemStack outstack = (ItemStack) this.getStackInSlot(NDX_OUTPUT_SLOT);
            
		    if (ItemStackTools.isEmpty(outstack)) {
		        this.furnaceItemStacks.set(NDX_OUTPUT_SLOT, ItemStackTools.safeCopy(itemstack));
		    }
		    else if (outstack.getItem() == itemstack.getItem())
		    {
		        ItemStackTools.incStackSize(outstack, ItemStackTools.getStackSize(itemstack));
		    }

		    if (ItemStackTools.isEmpty(leftstack)) {
		        this.furnaceItemStacks.set(NDX_LEFT_SLOT, ItemStackTools.getEmptyStack());
		    }
            if (ItemStackTools.isEmpty(rightstack)) {
                this.furnaceItemStacks.set(NDX_RIGHT_SLOT, ItemStackTools.getEmptyStack());
            }
            if (ItemStackTools.isEmpty(catastack)) {
                this.furnaceItemStacks.set(NDX_CATALYST_SLOT, ItemStackTools.getEmptyStack());
            }
		} // end-if canSmelt
	} // end smeltItem()
	
	
	/**
	 * Gets the burn time from an itemstack.
	 * @param burnItem The itemstack to get the burn time for.
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
		EnumFacing furnaceFace = this.getWorld().getBlockState(this.pos).getValue(SimpleFurnace.FACING);
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
				case EAST:
                    return slots_fuel;
				case WEST:
				    return slots_output;
				}
			case EAST:
				switch (furnaceFace) {
				case NORTH:
					return slots_input1;
				case SOUTH:
					return slots_input2;
				case WEST:
                    return slots_fuel;
				case EAST:
                    return slots_output;
				}
			case NORTH:
				switch (furnaceFace) {
				case WEST:
					return slots_input1;
				case EAST:
					return slots_input2;
				case SOUTH:
				    return slots_fuel;
				case NORTH:
				    return slots_output;
				}
			case SOUTH:
				switch (furnaceFace) {
				case WEST:
					return slots_input2;
				case EAST:
					return slots_input1;
				case NORTH:
                    return slots_fuel;
                case SOUTH:
                    return slots_output;
				}
		}
		return null;
	} // end getSlotsForFace()


	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return index != NDX_FUEL_SLOT || stack.getItem() == Items.BUCKET;
	}
	
	   net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	    net.minecraftforge.items.IItemHandler handlerLeftSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.EAST);
        net.minecraftforge.items.IItemHandler handlerRightSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);
        net.minecraftforge.items.IItemHandler handlerBackSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.SOUTH);
        net.minecraftforge.items.IItemHandler handlerFrontSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.NORTH);

	    @SuppressWarnings("unchecked")
	    @Override
	    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing)
	    {
	        if (facing != null && 
	             capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
	        {
	            if (facing == EnumFacing.DOWN)
	                return (T) handlerBottom;
	            else if (facing == EnumFacing.UP)
	                return (T) handlerTop;
	            else if (facing == EnumFacing.EAST)
	                return (T) handlerLeftSide;
	            else if (facing == EnumFacing.WEST)
	                return (T) handlerRightSide;
	            else if (facing == EnumFacing.SOUTH)
                    return (T) handlerBackSide;
	            else if (facing == EnumFacing.NORTH)
                    return (T) handlerFrontSide;
	            else
	                return null;
	        }   
	        return super.getCapability(capability, facing);
	    }

} // end class
