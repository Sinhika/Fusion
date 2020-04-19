package mod.alexndr.fusion.content;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.alexndr.fusion.init.ModBlocks;
import mod.alexndr.fusion.init.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

public class FusionFurnaceTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider
{
    public static final int INPUT1_SLOT = 0;  // left
    public static final int FUEL_SLOT = 1;    // back
    public static final int OUTPUT_SLOT = 2;  // down
    public static final int INPUT2_SLOT = 3;  // right
    public static final int CATALYST_SLOT = 4;  // top

    private static final String INVENTORY_TAG = "inventory";
    private static final String SMELT_TIME_LEFT_TAG = "smeltTimeLeft";
    private static final String MAX_SMELT_TIME_TAG = "maxSmeltTime";
    private static final String FUEL_BURN_TIME_LEFT_TAG = "fuelBurnTimeLeft";
    private static final String MAX_FUEL_BURN_TIME_TAG = "maxFuelBurnTime";
 
    private static final double BURN_TIME_MODIFIER = 1.875F;
    
    public final ItemStackHandler inventory = new ItemStackHandler(5) 
    {
        @Override
        public boolean isItemValid(final int slot, @Nonnull final ItemStack stack)
        {
            switch (slot)
            {
                case FUEL_SLOT:
                    return FurnaceTileEntity.isFuel(stack);
                case INPUT1_SLOT:
                case INPUT2_SLOT:
                    return isInput(stack);
                case CATALYST_SLOT:
                    return isCatalyst(stack);
                case OUTPUT_SLOT:
                    return isOutput(stack);
                 default:
                     return false;
            } // end-switch
        } // end ItemStackHandler.isItemValid()
        
        @Override
        protected void onContentsChanged(final int slot) {
            super.onContentsChanged(slot);
            // Mark the tile entity as having changed whenever its inventory changes.
            // "markDirty" tells vanilla that the chunk containing the tile entity has
            // changed and means the game will save the chunk to disk later.
            FusionFurnaceTileEntity.this.markDirty();
        } // end ItemStackHandler.onContentsChanged()
    }; // end ItemStackHandler

    // Store the capability lazy optionals as fields to keep the amount of objects we use to a minimum
    private final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = 
            LazyOptional.of(() -> this.inventory);
    // Machines (hoppers, pipes) connected to this furnace's top can only insert/extract items from the catalyst slot
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalUp = 
            LazyOptional.of(() -> new RangedWrapper(this.inventory, CATALYST_SLOT, CATALYST_SLOT + 1));
    // Machines (hoppers, pipes) connected to this furnace's left can only insert/extract items from the input1 slot
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalLeft = 
            LazyOptional.of(() -> new RangedWrapper(this.inventory, INPUT1_SLOT, INPUT1_SLOT + 1));
    // Machines (hoppers, pipes) connected to this furnace's right can only insert/extract items from the input2 slot
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalRight = 
            LazyOptional.of(() -> new RangedWrapper(this.inventory, INPUT2_SLOT, INPUT2_SLOT + 1));
    // Machines (hoppers, pipes) connected to this furnace's bottom can only insert/extract items from the output slot
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalDown = 
            LazyOptional.of(() -> new RangedWrapper(this.inventory, OUTPUT_SLOT, OUTPUT_SLOT + 1));
    // Machines (hoppers, pipes) connected to this furnace's side can only insert/extract items from the fuel slots
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalBack = 
            LazyOptional.of(() -> new RangedWrapper(this.inventory, FUEL_SLOT, FUEL_SLOT + 1));

    public short smeltTimeLeft = -1;
    public short maxSmeltTime = -1;
    public short fuelBurnTimeLeft = -1;
    public short maxFuelBurnTime = -1;
    private boolean lastBurning = false;
    
    public FusionFurnaceTileEntity()
    {
        super(ModTiles.FUSION_FURNACE.get());
    }

    /**
     * @return If the stack is not empty and has an alloying recipe associated with it
     */
    private boolean isInput(final ItemStack stack) {
        if (stack.isEmpty())
            return false;
        // TODO: fix after implementing Fusion's alloy recipes.
//        return getRecipe(stack).isPresent();
        return false;
    }
    
    private boolean isCatalyst(final ItemStack stack) {
        if (stack.isEmpty())
            return false;
        // TODO: fix after implementing Fusion's alloy recipes.
//        return getRecipe(stack).isPresent();
        return false;
    }
    
    /**
     * @return If the stack's item is equal to the result of smelting our input
     */
    private boolean isOutput(final ItemStack stack) {
        final Optional<ItemStack> result = 
                getResult(inventory.getStackInSlot(INPUT1_SLOT), inventory.getStackInSlot(INPUT2_SLOT),
                          inventory.getStackInSlot(CATALYST_SLOT));
        return result.isPresent() && ItemStack.areItemsEqual(result.get(), stack);
    }

    
    /**
     * @return The smelting recipe for the input stack
     */
    private Optional<FurnaceRecipe> getRecipe(final ItemStack input1, final ItemStack input2, 
                                              final ItemStack catalyst) 
    {
        // TODO: fix after implementing Fusion's alloy recipes.
        // Due to vanilla's code we need to pass an IInventory into RecipeManager#getRecipe so we make one here.
        // return getRecipe(new Inventory(input));
        return null;
    }
    
    /**
     * @return The alloying recipe for the inventory
     */
    private Optional<FurnaceRecipe> getRecipe(final IInventory inventory) {
        // TODO: fix after implementing Fusion's alloy recipes.
//        return world.getRecipeManager().getRecipe(IRecipeType.SMELTING, inventory, world);
        return null;
    }

    /**
     * @return The result of smelting the input stack
     */
    private Optional<ItemStack> getResult(final ItemStack input1, final ItemStack input2,
                                          final ItemStack catalyst) 
    {
        // TODO: fix after implementing Fusion's alloy recipes.
        return null;
    }

    public boolean isBurning() {
        return this.fuelBurnTimeLeft > 0;
    }

    @Override
    public void tick()
    {
        if (world == null || world.isRemote)
            return;

        // Fuel burning code

        boolean hasFuel = false;
        if (isBurning()) {
            hasFuel = true;
            --fuelBurnTimeLeft;
        }
        
        // Alloying code
        final ItemStack input1 = inventory.getStackInSlot(INPUT1_SLOT).copy();
        final ItemStack input2 = inventory.getStackInSlot(INPUT2_SLOT).copy();
        final ItemStack catalyst = inventory.getStackInSlot(CATALYST_SLOT).copy();
        
        final ItemStack result = getResult(input1, input2, catalyst).orElse(ItemStack.EMPTY);
        
        if (!result.isEmpty() && isInput(input1) && isInput(input2) && isCatalyst(catalyst)) 
        {
            final boolean canInsertResultIntoOutput = inventory.insertItem(OUTPUT_SLOT, result, true).isEmpty();
            if (canInsertResultIntoOutput) 
            {
                if (!hasFuel)
                    if (burnFuel())
                        hasFuel = true;
                if (hasFuel) 
                {
                    if (smeltTimeLeft == -1) 
                    { // Item has not been smelted before
                        smeltTimeLeft = maxSmeltTime = getAlloyTime(input1, input2, catalyst);
                    } 
                    else { // Item was already being smelted
                        --smeltTimeLeft;
                        if (smeltTimeLeft == 0) 
                        {
                            inventory.insertItem(OUTPUT_SLOT, result, false);
                            if (input1.hasContainerItem())
                                inventory.setStackInSlot(INPUT1_SLOT, input1.getContainerItem());
                            else {
                                input1.shrink(1);
                                inventory.setStackInSlot(INPUT1_SLOT, input1); // Update the data
                            }
                            if (input2.hasContainerItem())
                                inventory.setStackInSlot(INPUT2_SLOT, input2.getContainerItem());
                            else {
                                input2.shrink(1);
                                inventory.setStackInSlot(INPUT2_SLOT, input2); // Update the data
                            }
                            if (catalyst.hasContainerItem())
                                inventory.setStackInSlot(CATALYST_SLOT, catalyst.getContainerItem());
                            else {
                                catalyst.shrink(1);
                                inventory.setStackInSlot(CATALYST_SLOT, catalyst); // Update the data
                            }
                            smeltTimeLeft = -1; // Set to -1 so we smelt the next stack on the next tick
                        } // end-if 
                    } // end-else
                } 
                else // No fuel -> add to smelt time left to simulate cooling
                {
                    if (smeltTimeLeft < maxSmeltTime)
                        ++smeltTimeLeft;
                }
            } // end-if canInsert
        } // end-if valid inputs
        else // We have an invalid input stack (somehow)
        {
            smeltTimeLeft = maxSmeltTime = -1;
        }
     
        // Syncing code
        // If the burning state has changed.
        if (lastBurning != hasFuel) 
        { 
            // We use hasFuel because the current fuel may be all burnt out but we have 
            // more that will be used next tick

            // "markDirty" tells vanilla that the chunk containing the tile entity has
            // changed and means the game will save the chunk to disk later.
            this.markDirty();

            final BlockState newState = this.getBlockState()
                    .with(FusionFurnaceBlock.BURNING, hasFuel);

            // Flag 2: Send the change to clients
            world.setBlockState(pos, newState, 2);

            // Update the last synced burning state to the current burning state
            lastBurning = hasFuel;
        } // end-if
    } // end tick()

    /**
     * Mimics the code in {@link AbstractFurnaceTileEntity#func_214005_h()}
     *
     * @return The custom smelt time or 200 if there is no recipe for the input
     */
    private short getAlloyTime(final ItemStack input1,final ItemStack input2,final ItemStack catalyst) 
    {
        return getRecipe(input1, input2, catalyst)
                .map(AbstractCookingRecipe::getCookTime)
                .orElse(200)
                .shortValue();
    }

    /**
     * @return If the fuel was burnt
     */
    private boolean burnFuel() 
    {
        final ItemStack fuelStack = inventory.getStackInSlot(FUEL_SLOT).copy();
        if (!fuelStack.isEmpty()) 
        {
            final int burnTime = (int) (ForgeHooks.getBurnTime(fuelStack) * BURN_TIME_MODIFIER);
            if (burnTime > 0) {
                fuelBurnTimeLeft = maxFuelBurnTime = ((short) burnTime);
                if (fuelStack.hasContainerItem())
                    inventory.setStackInSlot(FUEL_SLOT, fuelStack.getContainerItem());
                else {
                    fuelStack.shrink(1);
                    inventory.setStackInSlot(FUEL_SLOT, fuelStack); // Update the data
                }
                return true;
            }
        } // end-if
        fuelBurnTimeLeft = maxFuelBurnTime = -1;
        return false;
    } // end burnFuel()

    /**
     * Retrieves the Optional handler for the capability requested on the specific side.
     *
     * @param cap  The capability to check
     * @param side The Direction to check from. CAN BE NULL! Null is defined to represent 'internal' or 'self'
     * @return The requested an optional holding the requested capability.
     */
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, 
                                             @Nullable final Direction side) 
    {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) 
        {
            if (side == null)
                return inventoryCapabilityExternal.cast();
            switch (side) {
                case DOWN:
                    return inventoryCapabilityExternalDown.cast();
                case UP:
                    return inventoryCapabilityExternalUp.cast();
                case NORTH:
                case SOUTH:
                    return inventoryCapabilityExternalBack.cast();
                case WEST:
                    return inventoryCapabilityExternalRight.cast();
                case EAST:
                    return inventoryCapabilityExternalLeft.cast();
            }
        }
        return super.getCapability(cap, side);
    } // end getCapability()

    @Override
    public void onLoad() {
        super.onLoad();
        // We set this in onLoad instead of the constructor so that TileEntities
        // constructed from NBT (saved tile entities) have this set to the proper value
        if (world != null && !world.isRemote)
            lastBurning = isBurning();
    }

    /**
     * Read saved data from disk into the tile.
     */
    @Override
    public void read(final CompoundNBT compound) {
        super.read(compound);
        this.inventory.deserializeNBT(compound.getCompound(INVENTORY_TAG));
        this.smeltTimeLeft = compound.getShort(SMELT_TIME_LEFT_TAG);
        this.maxSmeltTime = compound.getShort(MAX_SMELT_TIME_TAG);
        this.fuelBurnTimeLeft = compound.getShort(FUEL_BURN_TIME_LEFT_TAG);
        this.maxFuelBurnTime = compound.getShort(MAX_FUEL_BURN_TIME_TAG);
    }
    
    /**
     * Write data from the tile into a compound tag for saving to disk.
     */
    @Nonnull
    @Override
    public CompoundNBT write(final CompoundNBT compound) {
        super.write(compound);
        compound.put(INVENTORY_TAG, this.inventory.serializeNBT());
        compound.putShort(SMELT_TIME_LEFT_TAG, this.smeltTimeLeft);
        compound.putShort(MAX_SMELT_TIME_TAG, this.maxSmeltTime);
        compound.putShort(FUEL_BURN_TIME_LEFT_TAG, this.fuelBurnTimeLeft);
        compound.putShort(MAX_FUEL_BURN_TIME_TAG, this.maxFuelBurnTime);
        return compound;
    }

    /**
     * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the
     * chunk or when many blocks change at once.
     * This compound comes back to you client-side in {@link #handleUpdateTag}
     * The default implementation ({@link TileEntity#handleUpdateTag}) calls {@link #writeInternal)}
     * which doesn't save any of our extra data so we override it to call {@link #write} instead
     */
    @Nonnull
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    /**
     * Invalidates our tile entity
     */
    @Override
    public void remove() {
        super.remove();
        // We need to invalidate our capability references so that any cached references (by other mods) don't
        // continue to reference our capabilities and try to use them and/or prevent them from being garbage collected
        inventoryCapabilityExternal.invalidate();
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.fusion_furnace.get().getTranslationKey());
    }

    /**
     * Called from {@link NetworkHooks#openGui}
     * (which is called from {@link ElectricFurnaceBlock#onBlockActivated} on the logical server)
     *
     * @return The logical-server-side Container for this TileEntity
     */
    @Nonnull
    @Override
    public Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player) 
    {
        return new FusionFurnaceContainer(windowId, inventory, this);
    }

} // end class
