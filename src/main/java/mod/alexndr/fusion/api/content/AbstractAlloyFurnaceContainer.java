package mod.alexndr.fusion.api.content;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.api.helpers.FurnaceResultSlotItemHandler;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public abstract class AbstractAlloyFurnaceContainer<T extends AbstractAlloyFurnaceBlock> extends AbstractContainerMenu
{
    public static final int INPUT1_SLOT = 0;
    public static final int INPUT2_SLOT = 1;
    public static final int CATALYST_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;
    public static final int FUEL_SLOT = 4;

	public static final int DATA_FUEL_TIME_LEFT = 0;
	public static final int DATA_FUEL_TIME_MAX = 1;
	public static final int DATA_COOKING_PROGRESS = 2;
	public static final int DATA_COOKING_TOTAL_TIME = 3;
	public static final int NUM_DATA_VALUES = 4;

	protected final ItemStackHandler container;
	protected final Container tileContainer;
	protected final ContainerData data;
	protected final Level level;
   
	/**
	 * Client-side constructor. 
	 * @param menutype
	 * @param recipetype
	 * @param recipeBookType
	 * @param id
	 * @param inv
	 */
	protected AbstractAlloyFurnaceContainer(MenuType<?> type, int id, Inventory inv) 
	{
		this(type, id, inv, new ItemStackHandler(5), new SimpleContainerData(4), new SimpleContainer(5));
	} // end client ctor

	
    /**
     * Constructor called logical-server-side from {@link MythrilFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #ModFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
   public AbstractAlloyFurnaceContainer(MenuType<?> type, int id, final Inventory playerInventory,
    		 ItemStackHandler container, ContainerData containerdata, Container tilecontainer)
    {
        super(type, id);
		this.container = container;
		this.data = containerdata;
		this.level = playerInventory.player.level;
		this.tileContainer = tilecontainer;
		
        // Add tracking for data (Syncs to client/updates value when it changes)
		this.addDataSlots(containerdata);

        // Add all the slots for the tileEntity's inventory and the playerInventory to this container

        // Tile inventory slot(s)
        this.addSlot(new SlotItemHandler(container, AbstractAlloyFurnaceContainer.INPUT1_SLOT, 33, 35));
        this.addSlot(new SlotItemHandler(container, AbstractAlloyFurnaceContainer.INPUT2_SLOT, 126, 34));
        this.addSlot(new SlotItemHandler(container, AbstractAlloyFurnaceContainer.CATALYST_SLOT, 79, 7));
        this.addSlot(new FurnaceResultSlotItemHandler(playerInventory.player, container, 
                                            tilecontainer, AbstractAlloyFurnaceContainer.OUTPUT_SLOT, 79, 34));
        this.addSlot(new SlotItemHandler(container, AbstractAlloyFurnaceContainer.FUEL_SLOT, 79, 62));

        final int playerInventoryStartX = 8;
        final int playerInventoryStartY = 84;
        final int slotSizePlus2 = 18; // slots are 16x16, plus 2 (for spacing/borders) is 18x18

        // Player Top Inventory slots
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, playerInventoryStartX + (column * slotSizePlus2), playerInventoryStartY + (row * slotSizePlus2)));
            }
        }

        final int playerHotbarY = playerInventoryStartY + slotSizePlus2 * 3 + 4;
        // Player Hotbar slots
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, playerInventoryStartX + (column * slotSizePlus2), playerHotbarY));
        }
    }

    /**
     * Generic & dynamic version of {@link Container#transferStackInSlot(PlayerEntity, int)}.
     * Handle when the stack in slot {@code index} is shift-clicked.
     * Normally this moves the stack between the player inventory and the other inventory(s).
     *
     * @param player the player passed in
     * @param index  the index passed in
     * @return the {@link ItemStack}
     */
    @Nonnull
    @Override
    public ItemStack quickMoveStack(final Player player, final int index)
    {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            final ItemStack slotStack = slot.getItem();
            returnStack = slotStack.copy();
    
            final int containerSlots = 
                    this.slots.size() - player.getInventory().items.size();
            if (index < containerSlots) 
            {
                if (!moveItemStackTo(slotStack, containerSlots, this.slots.size(), true)) 
                {
                    return ItemStack.EMPTY;
                }
            } 
            else if (!moveItemStackTo(slotStack, 0, containerSlots, false)) 
            {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0) 
            {
                slot.set(ItemStack.EMPTY);
            } 
            else {
                slot.setChanged();
            }
            if (slotStack.getCount() == returnStack.getCount()) 
            {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return returnStack;
    } // end transferStackInSlot()

    @Override
    public boolean stillValid(@Nonnull final Player player)
    {
    	return this.tileContainer.stillValid(player);
    }

	public int getBurnProgress(int pixels) 
	{
		int i = this.data.get(DATA_COOKING_PROGRESS);
		int j = this.data.get(DATA_COOKING_TOTAL_TIME);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}

	public int getLitProgress(int pixels) 
	{
		int i = this.data.get(DATA_FUEL_TIME_MAX);
		int j = this.data.get(DATA_FUEL_TIME_LEFT);
		if (i == 0)
		{
			i = AbstractAlloyFurnaceTileEntity.DEFAULT_ALLOY_TIME;
		}
		return  j * pixels / i;
	}

	public boolean isLit() {
		return this.data.get(DATA_FUEL_TIME_LEFT) > 0;
	}


} // end class