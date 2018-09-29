package alexndr.plugins.Fusion.inventory;

import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

/**
 * this class is the FusionFurnace version of SlotFurnaceOutput, and is almost
 * identical.
 * @author AleXndrTheGr8st
 */
public class SlotFusionFurnace extends SlotFurnaceOutput
{
	/** The player that is using the GUI where this slot resides. */
    protected EntityPlayer thePlayer;
    protected int removeCount;

    public SlotFusionFurnace(EntityPlayer player, IInventory inventoryIn, 
    						 int index, int xPosition, int yPosition)
    {
        super(player, inventoryIn, index, xPosition, yPosition);
         this.thePlayer = player;
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
            else if (f < 1.0F)
            {
                j = MathHelper.floor((float)i * f);

                if (j < MathHelper.ceil((float)i * f) && Math.random() < (double)((float)i * f - (float)j))
                {
                    ++j;
                }

                i = j;
            }

            while (i > 0)
            {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.thePlayer.world.spawnEntity(new EntityXPOrb(this.thePlayer.world, 
                		this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
            } // end-while
        }

        this.removeCount = 0;
        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, stack);

    } // end-if !isRemote
} // end onCrafting()
