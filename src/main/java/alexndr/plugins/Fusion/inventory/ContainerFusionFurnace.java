package alexndr.plugins.Fusion.inventory;

import alexndr.api.content.inventory.SimpleFurnaceContainer;
import alexndr.plugins.Fusion.crafting.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Lots of cutting & pasting fron ContainerFurnace here, except for the parts that aren't.
 * @author AleXndrTheGr8st
 */
public class ContainerFusionFurnace extends SimpleFurnaceContainer
{
	public ContainerFusionFurnace(InventoryPlayer player, TileEntityFusionFurnace tileentity)
	{
		super(player, tileentity);
	}

	/* (non-Javadoc)
	 * @see alexndr.api.content.inventory.SimpleFurnaceContainer#AddOwnSlots(net.minecraft.entity.player.InventoryPlayer)
	 */
	@Override
	protected void AddOwnSlots(InventoryPlayer player) 
	{
        this.addSlotToContainer(new Slot(tileFurnace, TileEntityFusionFurnace.NDX_INPUT1_SLOT, 33, 35));
        this.addSlotToContainer(new SlotFurnaceFuel(tileFurnace, TileEntityFusionFurnace.NDX_FUEL_SLOT, 79, 62));
        this.addSlotToContainer(new SlotFusionFurnace(player.player, tileFurnace, 
        											  TileEntityFusionFurnace.NDX_OUTPUT_SLOT, 79, 34));
        this.addSlotToContainer(new Slot(tileFurnace, TileEntityFusionFurnace.NDX_INPUT2_SLOT, 126, 34)); //Input2
        this.addSlotToContainer(new Slot(tileFurnace, TileEntityFusionFurnace.NDX_CATALYST_SLOT, 79, 7)); //Catalyst
	}


	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally
	 * this moves the stack between the player inventory and the other
	 * inventory(s).
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// output slot?
			if (index == TileEntityFusionFurnace.NDX_OUTPUT_SLOT)
			{
				if (!this.mergeItemStack(itemstack1, 5, 41, true))
				{
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			// player inv/hotbar slot?
			else if (index > TileEntityFusionFurnace.NDX_CATALYST_SLOT )
			{
				// inputs
				if(FusionFurnaceRecipes.isItemInput(itemstack1))
				{
					if(!this.mergeItemStack(itemstack1, 0, 1, false) 
							&& !this.mergeItemStack(itemstack1, 3, 4, false))
						return ItemStack.EMPTY;
				}
				// fusion furnace uses standard fuel.
				else if (TileEntityFurnace.isItemFuel(itemstack1))
				{
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return ItemStack.EMPTY;
					}
				}
				// catalysts
				else if(FusionFurnaceRecipes.isItemCatalyst(itemstack1))
				{
					if (!this.mergeItemStack(itemstack1, 4, 5, false))
						return ItemStack.EMPTY;
				}
				else if (index < 32)
				{
					if (!this.mergeItemStack(itemstack1, 32, 41, false))
					{
						return ItemStack.EMPTY;
					}
				}
				else if (index >= 32 && index < 41 && !this.mergeItemStack(itemstack1, 5, 32, false))
				{
					return ItemStack.EMPTY;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 5, 41, false))
			{
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount())
			{
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}
	
} // end class
