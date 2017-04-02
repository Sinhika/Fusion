package alexndr.plugins.Fusion.inventory;

import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import mcjty.lib.compat.CompatSlot;
import mcjty.lib.tools.ItemStackTools;
import mcjty.lib.tools.MathTools;
import mcjty.lib.tools.WorldTools;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/**
 * this class is the FusionFurnace version of SlotFurnaceOutput, and is almost
 * identical.
 * @author AleXndrTheGr8st
 */
public class SlotFusionFurnace extends CompatSlot
{
	/** The player that is using the GUI where this slot resides. */
    protected EntityPlayer thePlayer;
    protected int removeCount;

    public SlotFusionFurnace(EntityPlayer par1EntityPlayer, IInventory inventoryIn, 
    						 int index, int xPosition, int yPosition)
    {
        super(inventoryIn, index, xPosition, yPosition);
        this.thePlayer = par1EntityPlayer;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
	public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    @Override
	public ItemStack decrStackSize(int amount)
    {
        if (this.getHasStack())
        {
            this.removeCount += Math.min(amount, ItemStackTools.getStackSize(this.getStack()));
        }
        return super.decrStackSize(amount);
    }

    @Override
	public ItemStack onPickup(EntityPlayer playerIn, ItemStack stack)
    {
        this.onCrafting(stack);
        return super.onPickup(playerIn, stack);
     }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    @Override
	protected void onCrafting(ItemStack stack, int par2)
    {
        this.removeCount += par2;
        this.onCrafting(stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    @Override
	protected void onCrafting(ItemStack stack)
    {
        stack.onCrafting(this.thePlayer.getEntityWorld(), this.thePlayer, this.removeCount);

        if (!this.thePlayer.getEntityWorld().isRemote)
        {
            int i = this.removeCount;
            float f = FusionFurnaceRecipes.getExperience(stack);
            int j;

            if (f == 0.0F)
            {
                i = 0;
            }
            else if (f <= 100.0F)
            {
                j = MathTools.floor(i * f);

                if (j < MathTools.ceiling(i * f) && (float)Math.random() < i * f - j)
                {
                    ++j;
                }

                i = j;
            }

            while (i > 0)
            {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
				WorldTools.spawnEntity(this.thePlayer.getEntityWorld(), 
										new EntityXPOrb(this.thePlayer.getEntityWorld(),
														this.thePlayer.posX, 
														this.thePlayer.posY + 0.5D, 
														this.thePlayer.posZ + 0.5D, j));
            } // end-while
        }

        this.removeCount = 0;
        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, stack);

    } // end-if !isRemote
} // end onCrafting()
