package alexndr.plugins.Fusion.tiles;

import javax.annotation.Nullable;

import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.api.helpers.game.FurnaceHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.blocks.BlockFusionFurnace;
import alexndr.plugins.Fusion.inventory.ContainerFusionFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;

/**
 * @author AleXndrTheGr8st
 */
public class TileEntityFusionFurnace extends TileEntitySimpleFurnace
{
	public static final int NDX_INPUT1_SLOT = 0;
	public static final int NDX_FUEL_SLOT = 1;
	public static final int NDX_OUTPUT_SLOT = 2;
	public static final int NDX_INPUT2_SLOT = 3;
	public static final int NDX_CATALYST_SLOT = 4;
    
	public final static String tilename = "container.fusion_furnace";
	public final static String guiID = "fusion:fusion_furnace_gui";
	
    protected static int[] slotsTop = new int[] {NDX_CATALYST_SLOT};
	protected static int[] slotsLeft = new int[] {NDX_INPUT1_SLOT};
	protected static int[] slotsRight = new int[] {NDX_INPUT2_SLOT};
	protected static int[] slotsBottom = new int[] {NDX_FUEL_SLOT, NDX_OUTPUT_SLOT};
	
	public TileEntityFusionFurnace() 
	{
		super(TileEntityFusionFurnace.tilename, 600, TileEntityFusionFurnace.guiID, 5);
//		LogHelper.verbose("fusion", "finished TileEntityFusionFurnace ctor for " 
//				+ this.getDisplayName().getUnformattedText());
	} // end ctor()
	
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
	
	
    /**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections). Note that the Fusion Furnace has 3 input
	 * stacks to account for.
	 * 
	 * @see net.minecraft.inventory.IInventory#setInventorySlotContents(int,
	 *      net.minecraft.item.ItemStack)
	 */
	@Override
	public void setInventorySlotContents(int index, @Nullable ItemStack stack) 
	{
        ItemStack itemstack = (ItemStack)this.getStackInSlot(index);
        boolean flag = ! stack.isEmpty() && stack.isItemEqual(itemstack) 
                && ItemStack.areItemStackTagsEqual(stack, itemstack);
        
        FurnaceHelper.SetInSlot(this.furnaceItemStacks, index, stack);
        
        if (stack.getCount() > this.getInventoryStackLimit())
        {
        	stack.setCount(this.getInventoryStackLimit());
        }
        
        // Fusion Furnace has 3 (!) input stacks to account for.
        if ((index == NDX_INPUT1_SLOT || index == NDX_INPUT2_SLOT || index == NDX_CATALYST_SLOT) 
        		&& !flag)
        {
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
	} // end ()

	/* (non-Javadoc)
	 * @see alexndr.api.content.tiles.TileEntitySimpleFurnace#createContainer(net.minecraft.entity.player.InventoryPlayer, net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) 
	{
		return new ContainerFusionFurnace(playerInventory, this);
	}

	/* (non-Javadoc)
	 * @see alexndr.api.content.tiles.TileEntitySimpleFurnace#isItemValidForSlot(int, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
        if (index == TileEntityFusionFurnace.NDX_OUTPUT_SLOT)
        {
            return false;
        }
        else if (index != TileEntityFusionFurnace.NDX_FUEL_SLOT)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.getStackInSlot(TileEntityFusionFurnace.NDX_FUEL_SLOT);
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) 
            							&& itemstack.getItem() != Items.BUCKET;
        }
	} // end isItemValidForSlot()

	
	/* (non-Javadoc)
	 * @see net.minecraft.inventory.ISidedInventory#getSlotsForFace(net.minecraft.util.EnumFacing)
	 */
	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		switch (side)
		{
			case NORTH:
			case SOUTH:
			case DOWN :
				return slotsBottom;
			case UP :
				return slotsTop;
			case WEST:
				return slotsLeft;
			case EAST:
				return slotsRight;
		}
		return null;
	} // end getSlotsForFace()
	
	/* (non-Javadoc)
	 * @see net.minecraft.util.ITickable#update()
	 */
	@Override
	public void update()
	{
        boolean was_burning_flag = this.isBurning();
        boolean flag1 = false;
        int burnTime = 0;

        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

		if(!this.getWorld().isRemote)
		{
            ItemStack fuelstack = (ItemStack)this.getStackInSlot(NDX_FUEL_SLOT);
            if (!fuelstack.isEmpty()) 
			{
                burnTime = TileEntityFusionFurnace.getItemBurnTime(fuelstack);
            }
            flag1 = default_cooking_update(flag1, fuelstack, burnTime);

            if (was_burning_flag != this.isBurning())
            {
                flag1 = true;
				BlockFusionFurnace.setState(this.isBurning(), this.getWorld(), this.pos);
			}
		} // end-if
		
		if(flag1) {
			this.markDirty();
		}
	} // end update()

	/**
	 * Guts of fusion furnace alloying update. Must sort out cooking and smelting, and return a flag
	 * that indicates whether something changed.
	 * @param flag1 Flag to be set if changed.
	 * @param fuelStack stack of fuel items being burned.
	 * @param burnTime current burnTime of itemstackFuel
	 * @return true if state has changed, false if not.
	 */
	@Override
	protected boolean default_cooking_update(boolean flag1, ItemStack fuelStack, int burnTime)
	{
		ItemStack leftstack = (ItemStack)this.getStackInSlot(NDX_INPUT1_SLOT);
		ItemStack rightstack = (ItemStack)this.getStackInSlot(NDX_INPUT2_SLOT);
		ItemStack catastack = (ItemStack)this.getStackInSlot(NDX_CATALYST_SLOT);

		if (this.isBurning() || ! (fuelStack.isEmpty() || leftstack.isEmpty() 
				|| rightstack.isEmpty() || catastack.isEmpty()) ) 
		{
			if (!this.isBurning() && this.canSmelt())
			{
                this.furnaceBurnTime = burnTime;
                this.currentItemBurnTime = this.furnaceBurnTime;

				if (this.isBurning())
				{
					flag1 = true;
					if (!fuelStack.isEmpty())
					{
						Item item = fuelStack.getItem();
						fuelStack.shrink(1);
						if (fuelStack.isEmpty()) 
						{
							ItemStack item1 = item.getContainerItem(fuelStack);
							FurnaceHelper.SetInSlot(furnaceItemStacks, NDX_FUEL_SLOT, item1);
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
					this.totalCookTime = this.getCookTime(this.getStackInSlot(NDX_INPUT1_SLOT));
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
			this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
		}
		return flag1;
	} // end 


	/**
	 * Returns true if the furnace can smelt at that time. ie. has inputs, catalyst, destination stack isn't full, etc.
	 * @return True if furnace can smelt.
	 */
	@Override
	protected boolean canSmelt()
	{
        if (this.getStackInSlot(NDX_INPUT1_SLOT).isEmpty() 
        	|| this.getStackInSlot(NDX_INPUT2_SLOT).isEmpty() 
        	|| this.getStackInSlot(NDX_CATALYST_SLOT).isEmpty())
        {
            return false;
        }
        
        ItemStack result_stack = FusionFurnaceRecipes.getSmeltingResult(
        		this.getStackInSlot(NDX_INPUT1_SLOT), 
        		this.getStackInSlot(NDX_INPUT2_SLOT), 
        		this.getStackInSlot(NDX_CATALYST_SLOT));
        if (result_stack.isEmpty()) {
        	return false;
        }
        ItemStack outstack = (ItemStack)this.getStackInSlot(NDX_OUTPUT_SLOT);
        if (outstack.isEmpty()) return true;
        if (!outstack.isItemEqual(result_stack)) return false;

		int result = outstack.getCount() + result_stack.getCount();
		 // Forge fix: make furnace respect stack sizes in furnace recipes
		return result <= getInventoryStackLimit() && result <= outstack.getMaxStackSize();
	} // end canSmelt()
	
	@Override
	public void smeltItem()
	{
		if(this.canSmelt())
		{
		    ItemStack itemstack = 
                 FusionFurnaceRecipes.applyFusion(this.getStackInSlot(NDX_INPUT1_SLOT), 
                                                  this.getStackInSlot(NDX_INPUT2_SLOT), 
                                                  this.getStackInSlot(NDX_CATALYST_SLOT));
            ItemStack outstack = (ItemStack) this.getStackInSlot(NDX_OUTPUT_SLOT);
            
		    if (outstack.isEmpty()) {
		        FurnaceHelper.SetInSlot(furnaceItemStacks, NDX_OUTPUT_SLOT, itemstack.copy());
		    }
		    else if (outstack.getItem() == itemstack.getItem())
		    {
		    	outstack.grow(itemstack.getCount());
		    }
		    // this is done inside FusionFurnaceRecipes.applyFusion(), so DON'T decrement inputs here.
		    // Yes, it's crap design. Deal.
//		    this.decrStackSize(NDX_INPUT1_SLOT, 1);   
//		    this.decrStackSize(NDX_INPUT2_SLOT, 1);
//		    this.decrStackSize(NDX_CATALYST_SLOT, 1);
		} // end-if canSmelt
	} // end smeltItem()
	
	

	net.minecraftforge.items.IItemHandler handlerTop = 
			new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = 
			new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerLeftSide = 
			new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.EAST);
	net.minecraftforge.items.IItemHandler handlerRightSide = 
			new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);
	net.minecraftforge.items.IItemHandler handlerBackSide = 
			new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.SOUTH);
	net.minecraftforge.items.IItemHandler handlerFrontSide = 
			new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.NORTH);

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
