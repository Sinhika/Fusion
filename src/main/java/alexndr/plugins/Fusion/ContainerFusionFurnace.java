package alexndr.plugins.Fusion;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Lots of cutting & pasting fron ContainerFurnace here, except for the parts that aren't.
 * @author AleXndrTheGr8st
 */
public class ContainerFusionFurnace extends Container
{
	private TileEntityFusionFurnace furnace;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	private int lastTotalCookTime = 0;
	
	public ContainerFusionFurnace(InventoryPlayer inventoryplayer, TileEntityFusionFurnace tileentity)
	{
        this.furnace = tileentity;
        this.addSlotToContainer(new Slot(tileentity, 0, 33, 35)); //Input1
        this.addSlotToContainer(new SlotFurnaceFuel(tileentity, 1, 79, 62));
        this.addSlotToContainer(new SlotFusionFurnace(inventoryplayer.player, tileentity, 2, 79, 34)); //Output
        this.addSlotToContainer(new Slot(tileentity, 3, 126, 34)); //Input2
        this.addSlotToContainer(new Slot(tileentity, 4, 79, 7)); //Catalyst
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryplayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 142));
        }
	}
	
	@Override
    public void onCraftGuiOpened(ICrafting listener)
    {
        super.onCraftGuiOpened(listener);
        listener.sendAllWindowProperties(this, this.furnace);
    }


//    @Override
//	public void addCraftingToCrafters(ICrafting par1ICrafting)
//    {
//        super.addCraftingToCrafters(par1ICrafting);
//        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
//        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
//        par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentBurnTime);
//    }
    
    @Override
	public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.furnace.getField(2))
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.getField(2));
            }

            if (this.lastBurnTime != this.furnace.getField(0))
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.getField(0));
            }

            if (this.lastItemBurnTime != this.furnace.getField(1))
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.getField(1));
            }
            if (this.lastTotalCookTime != this.furnace.getField(3))
            {
                icrafting.sendProgressBarUpdate(this, 3, this.furnace.getField(3));
            }
        } // end if

        this.lastCookTime = this.furnace.getField(2);
        this.lastBurnTime = this.furnace.getField(0);
        this.lastItemBurnTime = this.furnace.getField(1);
        this.lastTotalCookTime = this.furnace.getField(3);
    } // end detectAndSendChanges()
    
    @Override
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.furnace.setField(id, data);
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return this.furnace.isUseableByPlayer(player);
	}
	
    @Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index)
    {
    	ItemStack itemstack = null;
    	Slot slot = (Slot)this.inventorySlots.get(index);
    	
    	if(slot != null && slot.getHasStack())
    	{
    		ItemStack stackInSlot = slot.getStack();
    		itemstack = stackInSlot.copy();
    		
    		if(index == 2)
    		{
    			if(!this.mergeItemStack(stackInSlot, 5, 39, true))
    				return null;
    			slot.onSlotChange(stackInSlot, itemstack);
    		}
    		else if(index >= 5)
    		{
    			if(TileEntityFusionFurnace.isItemFuel(stackInSlot))
    			{
    				if(!this.mergeItemStack(stackInSlot, 1, 2, false))
    				{
    					try
    					{
    						if(!this.mergeItemStack(stackInSlot, 0, 1, false) && !this.mergeItemStack(stackInSlot, 3, 4, false) || !FusionFurnaceRecipes.isItemInput(stackInSlot))
    						{
    							try
    							{
    								if(!this.mergeItemStack(stackInSlot, 4, 5, false) || !FusionFurnaceRecipes.isItemCatalyst(stackInSlot))
    									return null;
    							}
    							catch(Exception e)
    							{
    								return null;
    							}
    						}
    					}
    					catch(Exception e)
    					{
    						return null;
    					}
    				}
    			}
    			else if(FusionFurnaceRecipes.isItemCatalyst(stackInSlot))
    			{
    				if(!this.mergeItemStack(stackInSlot, 4, 5, false))
    					return null;
    			}
    			else if(FusionFurnaceRecipes.isItemInput(stackInSlot))
    			{
    				if(!this.mergeItemStack(stackInSlot, 0, 1, false) && !this.mergeItemStack(stackInSlot, 3, 4, false))
    					return null;
    			}
    			else if(index < 32)
    			{
    				if(!this.mergeItemStack(stackInSlot, 32, 41, false))
    					return null;
    			}
    			else if(index < 41 && !this.mergeItemStack(stackInSlot, 5, 32, false))
    				return null;
    		}
    		else if(!this.mergeItemStack(stackInSlot, 5, 41, false))
    			return null;
    		
    		if(stackInSlot.stackSize == 0)
    			slot.putStack((ItemStack)null);
    		else
    			slot.onSlotChanged();
    		
    		if(stackInSlot.stackSize == itemstack.stackSize)
    			return null;
    		slot.onPickupFromSlot(par1EntityPlayer, stackInSlot);
    	}
    	return itemstack;
    }
} // end class
