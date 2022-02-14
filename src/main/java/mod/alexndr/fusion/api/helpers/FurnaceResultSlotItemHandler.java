package mod.alexndr.fusion.api.helpers;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceTileEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Based on vanilla FurnaceResultSlot class, but for SlotItemHandlers.
 *
 */
public class FurnaceResultSlotItemHandler extends SlotItemHandler
{
    private final Player player;
    private int removeCount;
    private final Container tileish;
    
    public FurnaceResultSlotItemHandler(Player player, IItemHandler itemHandler, Container tilecontainer,
    									int index, int xPosition, int yPosition)
    {
        super(itemHandler, index, xPosition, yPosition);
        this.player = player;
        this.tileish = tilecontainer;
    }

    /**
     * No, you can't stick items in the output slot.
     */
    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return false;
    }

    
    @Override
    public ItemStack remove(int amount)
    {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
         }
        return super.remove(amount);
    }

    @Override
    protected void onQuickCraft(ItemStack stack, int amount)
    {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }

    @Override
    protected void checkTakeAchievements(ItemStack stack)
    {
        stack.onCraftedBy(this.player.level, this.player, this.removeCount);
        if (this.player instanceof ServerPlayer && this.tileish instanceof AbstractAlloyFurnaceTileEntity) 
        {
        	((AbstractAlloyFurnaceTileEntity)this.tileish).grantExperience(this.player);
        }
        this.removeCount = 0;
        ForgeEventFactory.firePlayerSmeltedEvent(this.player, stack);
    } // end onCrafting

    @Override
    public void onTake(Player thePlayer, ItemStack stack)
    {
        this.checkTakeAchievements(stack);
        super.onTake(thePlayer, stack);
    }
     
} // end class
