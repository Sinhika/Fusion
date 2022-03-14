package mod.alexndr.fusion.api.content;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.items.wrapper.RangedWrapper;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public abstract class AbstractAlloyFurnaceTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider
{

    public static final int INPUT1_SLOT = 0;
    public static final int INPUT2_SLOT = 1;
    public static final int CATALYST_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;
    public static final int FUEL_SLOT = 4;

    // TODO - make configurable.
    protected final double BURN_TIME_MODIFIER = 1.875F;
    protected final int DEFAULT_ALLOY_TIME = 600;
    
    protected static final String INVENTORY_TAG = "inventory";
    protected static final String SMELT_TIME_LEFT_TAG = "smeltTimeLeft";
    protected static final String MAX_SMELT_TIME_TAG = "maxSmeltTime";
    protected static final String FUEL_BURN_TIME_LEFT_TAG = "fuelBurnTimeLeft";
    protected static final String MAX_FUEL_BURN_TIME_TAG = "maxFuelBurnTime";
    
    // TODO - change to int in 1.17.1
    public short smeltTimeProgress = 0;
    public short maxSmeltTime = -1;
    
    public int fuelBurnTimeLeft = -1;
    public int maxFuelBurnTime = -1;
    protected boolean lastBurning = false;
    
    private final Map<ResourceLocation, Integer> recipe2xp_map = Maps.newHashMap();

    // used for improved fusion furnaces 
    protected boolean hasFuelMultiplier = false;
    protected double fuelMultiplier = 1.0;
    protected int YieldChance = 0;
    protected int YieldAmount = 0;
    protected Random generator = new Random();
    
    // implement recipe-caching like all the cool kids.
    protected IFusionRecipe cachedRecipe;
    protected ItemStack failedMatch1 = ItemStack.EMPTY;
    protected ItemStack failedMatch2 = ItemStack.EMPTY;
    protected ItemStack failedMatchC = ItemStack.EMPTY;
    
    public final ItemStackHandler inventory = new ItemStackHandler(5)
    {
        /**
         * this is where the CLIENT checks to see if item is valid to insert in slot. 
         * Be relaxed in checks, don't cross the streams! (i.e, don't call server-side code here!)
         */
        @Override
        public boolean isItemValid(final int slot, @Nonnull final ItemStack stack)
        {
            switch (slot)
            {
            case FUEL_SLOT:
                return isFuel(stack);
            case INPUT1_SLOT:
            case INPUT2_SLOT:
                return isInput(stack);
//              return true;
            case CATALYST_SLOT:
                 return isCatalyst(stack);
//                return true;
            case OUTPUT_SLOT:
                return isOutput(stack);
            default:
                return false;
            } // end-switch
        } // end ItemStackHandler.isItemValid()

        @Override
        protected void onContentsChanged(final int slot)
        {
            super.onContentsChanged(slot);
            // Mark the tile entity as having changed whenever its inventory changes.
            // "markDirty" tells vanilla that the chunk containing the tile entity has
            // changed and means the game will save the chunk to disk later.
            setChanged();
        } // end ItemStackHandler.onContentsChanged()
    };
    
    private final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalUp = LazyOptional.of(() -> new RangedWrapper(this.inventory, CATALYST_SLOT, CATALYST_SLOT + 1));
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalLeft = LazyOptional.of(() -> new RangedWrapper(this.inventory, INPUT1_SLOT, INPUT1_SLOT + 1));
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalRight = LazyOptional.of(() -> new RangedWrapper(this.inventory, INPUT2_SLOT, INPUT2_SLOT + 1));
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalDown = LazyOptional.of(() -> new RangedWrapper(this.inventory, OUTPUT_SLOT, OUTPUT_SLOT + 1));
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalBack = LazyOptional.of(() -> new RangedWrapper(this.inventory, FUEL_SLOT, FUEL_SLOT + 1));

    public AbstractAlloyFurnaceTileEntity(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
        this.fuelMultiplier = 1.0;
        this.hasFuelMultiplier = false;
    }

    /**
     * @return If the stack is not empty and has an alloying recipe associated with it
     */
    protected boolean isInput(final ItemStack stack)
    {
            if (stack.isEmpty())
                return false;
            boolean is_input = FusionRecipe.isInput(stack, this.level);
    //        Fusion.LOGGER.debug(Fusion.MODID + ": isInput() returns " + is_input);
            return is_input;
        }

    protected boolean isCatalyst(final ItemStack stack)
    {
            if (stack.isEmpty())
                return false;
            boolean is_cata = FusionRecipe.isCatalyst(stack, this.level); 
   //        Fusion.LOGGER.debug(Fusion.MODID + ": isCatalyst() returns " + is_cata);
            return is_cata;
        }

    /**
     * @return If the stack's item is equal to the result of smelting our input
     */
    
    protected boolean isOutput(final ItemStack stack)
    {
        final Optional<ItemStack> result = getResult(inventory.getStackInSlot(INPUT1_SLOT),
                inventory.getStackInSlot(INPUT2_SLOT), inventory.getStackInSlot(CATALYST_SLOT));
        return result.isPresent() && ItemStack.isSame(result.get(), stack);
    }

    public boolean isFuel(ItemStack stack)
    {
        return FurnaceTileEntity.isFuel(stack);
    }
    
    public boolean isBurning()
    {
        return this.fuelBurnTimeLeft > 0;
    }

    /**
     * @return The smelting recipe for the input stack
     */
    private Optional<IFusionRecipe> getRecipe(final ItemStack input1, final ItemStack input2, final ItemStack catalyst)
    {
        if (input1.isEmpty() || input2.isEmpty() || catalyst.isEmpty() 
                || (input1 == failedMatch1 && input2 == failedMatch2 && catalyst == failedMatchC))
        {
            return Optional.empty();
        }
        // Due to vanilla's code we need to pass an IInventory into 
        // RecipeManager#getRecipe so we make one here.
        return getRecipe(new Inventory(input1, input2, catalyst));
    }

    /**
     * TODO implement recipe caching
     * @return The alloying recipe for the inventory
     */
    private Optional<IFusionRecipe> getRecipe(final IInventory inv)
    {        
        RecipeWrapper inv0 = new RecipeWrapper(new InvWrapper(inv));
        if (cachedRecipe != null && cachedRecipe.matches(inv0, level))
        {
            return Optional.of(cachedRecipe);
        }
        else
        {
            IFusionRecipe rec 
                = level.getRecipeManager().getRecipeFor(ModRecipeTypes.FUSION_TYPE, inv0, level).orElse(null);
            if (rec == null) 
            {
                failedMatch1 = inv.getItem(INPUT1_SLOT);
                failedMatch2 = inv.getItem(INPUT2_SLOT);
                failedMatchC = inv.getItem(CATALYST_SLOT);
            }
            else {
                failedMatch1 = ItemStack.EMPTY;
                failedMatch2 = ItemStack.EMPTY;
                failedMatchC = ItemStack.EMPTY;
            }
            cachedRecipe = rec;
            return Optional.ofNullable(rec);
        } // end-else
    } // end getRecipe(IInventory)

    /**
     * @return The result of smelting the input stack
     */
    private Optional<ItemStack> getResult(final ItemStack input1, final ItemStack input2, final ItemStack catalyst)
    {
        RecipeWrapper inv0 = new RecipeWrapper(new InvWrapper(new Inventory(input1, input2, catalyst)));
        Optional<ItemStack> maybe_result = getRecipe(input1, input2, catalyst).map(recipe -> recipe.assemble(inv0));

        return Optional.of(maybe_result.orElse(ItemStack.EMPTY));
    }

    public void setRecipeUsed(@Nullable IRecipe<?> recipe)
    {
        if (recipe != null)
        {
            this.recipe2xp_map.compute(recipe.getId(), (p_214004_0_, p_214004_1_) -> {
                return 1 + (p_214004_1_ == null ? 0 : p_214004_1_);
            });
        }
    } // end setRecipeUsed()
    
    /**
     * Given a stack of fuel, gets the burn duration of one item.
     * @param fuelstack - fuel items to be checked.
     * @return burn duration in ticks.
     */
    protected int getBurnDuration(ItemStack fuelstack) 
    {
        int returnval = 0;
        
        // ForgeHooks.getBurnTime() handles empty stack case, so we don't have to.
        if (!hasFuelMultiplier)
        {
            returnval = (int) Math.ceil(((double)ForgeHooks.getBurnTime(fuelstack, null)) * BURN_TIME_MODIFIER);
        }
        else {
            // improved fuel efficiency processing here.
            returnval = (int) Math.ceil(((double) ForgeHooks.getBurnTime(fuelstack, null)) * fuelMultiplier  * BURN_TIME_MODIFIER);
        }
        // LOGGER.debug("[" + getDisplayName().getString() + "]VeryAbstractFurnaceTileEntity.getBurnDuration: returns " + returnval + " for " + fuelstack.toString());
        return returnval;
    } // end getBurnDuration
    
    /**
     * Is it physically possible to put the smelting result in the output slot and do we have inputs at all?
     * @param result - hypothetical smelting product.
     * @return true if result can be added to output slot, false if it cannot.
     */
    protected boolean canSmelt(ItemStack result)
    {
        if (!this.inventory.getStackInSlot(INPUT1_SLOT).isEmpty() && !this.inventory.getStackInSlot(INPUT2_SLOT).isEmpty()
                && !this.inventory.getStackInSlot(CATALYST_SLOT).isEmpty() && !result.isEmpty())
        {
            ItemStack outstack = inventory.getStackInSlot(OUTPUT_SLOT);
            if (outstack.isEmpty())
            {
                return true;
            }
            else if (!outstack.sameItem(result))
            {
                return false;
            }
            else
            { // Forge fix: make furnace respect stack sizes in furnace recipes
                return (outstack.getCount() + result.getCount() <= outstack.getMaxStackSize());
            }
 
        } // end-if not output empty and not result empty.
        else
        {
            return false;
        }
    } // end canSmelt()
    
    /**
     * Mimics the code in {@link AbstractFurnaceTileEntity#getTotalCookTime()}
     *
     * @return The custom smelt time or DEFAULT_ALLOY_TIME if there is no recipe for the input
     */
    private short getAlloyTime(final ItemStack input1, final ItemStack input2, final ItemStack catalyst)
    {
        Optional<IFusionRecipe> maybeRecipe = getRecipe(input1, input2, catalyst); 
        if (maybeRecipe.isPresent()) {
            return (short) ((FusionRecipe) maybeRecipe.get()).getCookTime(); 
        }
        else {
            return DEFAULT_ALLOY_TIME;
        }
    } // end getAlloyTime

    protected void smelt(ItemStack result)  // result = itemstack1
    {
        if (!result.isEmpty() && this.canSmelt(result))
        {
            final ItemStack input1 = inventory.getStackInSlot(INPUT1_SLOT).copy();
            final ItemStack input2 = inventory.getStackInSlot(INPUT2_SLOT).copy();
            final ItemStack catalyst = inventory.getStackInSlot(CATALYST_SLOT).copy();
            ItemStack outstack = inventory.getStackInSlot(OUTPUT_SLOT).copy();
            
            if (outstack.isEmpty())
            {
                inventory.setStackInSlot(OUTPUT_SLOT, result.copy());
            }
            else if (outstack.getItem() == result.getItem())
            {
                outstack.grow(result.getCount());
                inventory.setStackInSlot(OUTPUT_SLOT, outstack);
            }
            if (!this.level.isClientSide) 
            {
                this.setRecipeUsed(getRecipe(input1, input2, catalyst).orElse(null));
            }
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
        } // end-if canSmelt result
    } // end burn()
    
    /**
     * Called every tick to update our tile entity
     */
    @Override
    public void tick()
    {
        // Fuel burning code
        boolean hasFuel = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --fuelBurnTimeLeft;
        }
        
        if (!this.level.isClientSide) 
        {
            // Alloying code
            ItemStack input1 = inventory.getStackInSlot(INPUT1_SLOT).copy();
            ItemStack input2 = inventory.getStackInSlot(INPUT2_SLOT).copy();
            ItemStack catalyst = inventory.getStackInSlot(CATALYST_SLOT).copy();
            ItemStack fuel = inventory.getStackInSlot(FUEL_SLOT).copy();
            ItemStack result = getResult(input1, input2, catalyst).orElse(ItemStack.EMPTY);
            
            if ((this.isBurning() || !fuel.isEmpty()) && 
                    (!input1.isEmpty() && !input2.isEmpty() && !catalyst.isEmpty()))
            {
                if (!this.isBurning() && this.canSmelt(result))
                {
                    this.fuelBurnTimeLeft = this.getBurnDuration(fuel);
                    this.maxFuelBurnTime = this.fuelBurnTimeLeft;
                    if (this.isBurning())
                    {
                        flag1 = true;
                        if (fuel.hasContainerItem()) 
                        {
                            inventory.setStackInSlot(FUEL_SLOT, fuel.getContainerItem());
                        }
                        else if (!fuel.isEmpty()) 
                        {
                            fuel.shrink(1);
                            inventory.setStackInSlot(FUEL_SLOT, fuel); // Update the data
                        }
                    } // end-if isBurning
                } // end-if !isBurning but canSmelt
                if (this.isBurning() && this.canSmelt(result))
                {
                    if (this.smeltTimeProgress <= 0) // Item has not been smelted before
                    { 
                        this.maxSmeltTime = getAlloyTime(input1, input2, catalyst);
                        this.smeltTimeProgress = 0;
                    } 
                    ++this.smeltTimeProgress;
                    if (this.smeltTimeProgress >= this.maxSmeltTime) 
                    {
//                        LOGGER.debug("tick: smeltTimeProgress=" + this.smeltTimeProgress + ", maxSmeltTime=" + this.maxSmeltTime);
//                        LOGGER.debug("tick: fuelBurnTimeLeft=" + this.fuelBurnTimeLeft + ", maxFuelBurnTime=" + this.maxFuelBurnTime);
                        this.smelt(result);
                        this.smeltTimeProgress = 0;
                        if (!inventory.getStackInSlot(INPUT1_SLOT).isEmpty()
                            && !inventory.getStackInSlot(INPUT2_SLOT).isEmpty()
                            && !inventory.getStackInSlot(CATALYST_SLOT).isEmpty())
                        {
                            this.maxSmeltTime = 
                                    this.getAlloyTime(inventory.getStackInSlot(INPUT1_SLOT), 
                                            inventory.getStackInSlot(INPUT2_SLOT), 
                                            inventory.getStackInSlot(CATALYST_SLOT));
                        }
                        else {
                            this.maxSmeltTime = 0;
                        }
                        flag1 = true;
                    } // end-if progess == maxTime
                } // end-if burning and canBurn
                else {
                    this.smeltTimeProgress = 0;
                }
            } // end-if isBurning & fuel & inputs
            else if (! this.isBurning() && this.smeltTimeProgress > 0)
            {
                this.smeltTimeProgress = (short) MathHelper.clamp(this.smeltTimeProgress - 2, 0, this.maxSmeltTime);
            } // end-else if ! burning & smeltTimeProgress
            if (hasFuel != this.isBurning())
            {
                flag1 = true;
                final BlockState newState = this.getBlockState().setValue(BlockStateProperties.LIT, this.isBurning());
        
                // Flag 2: Send the change to clients
                level.setBlock(worldPosition, newState, 3);
            }
        } // end-if ! clientSide

        if (flag1) {
            this.setChanged();
         }
    } // end tick()

    /**
     * Retrieves the Optional handler for the capability requested on the specific side.
     *
     * @param cap  The capability to check
     * @param side The Direction to check from. CAN BE NULL! Null is defined to represent 'internal' or 'self'
     * @return The requested an optional holding the requested capability.
     */
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side)
    {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) 
        {
            if (side == null)
                return inventoryCapabilityExternal.cast();
            
            /* fix side for any rotation... */
            Direction actual_facing = this.getBlockState().getValue(HorizontalBlock.FACING);
            Direction default_facing = Direction.NORTH;
            
            Direction true_side;
            if (side == Direction.UP || side == Direction.DOWN)
            {
                true_side = side;
            }
            else if (actual_facing.getOpposite() == default_facing) {
                true_side = side.getOpposite();
            }
            else if (actual_facing.getClockWise() == default_facing) {
                true_side = side.getClockWise();
            }
            else if (actual_facing.getCounterClockWise() == default_facing) {
                true_side = side.getCounterClockWise();
            }
            else {
                true_side = side;
            }
            switch (true_side) {
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

    /**
     * Read saved data from disk into the tile.
     */
    @Override
    public void load(BlockState stateIn, CompoundNBT compound)
    {
        super.load(stateIn, compound);
        this.inventory.deserializeNBT(compound.getCompound(INVENTORY_TAG));
        this.smeltTimeProgress = compound.getShort(SMELT_TIME_LEFT_TAG);
        this.maxSmeltTime = compound.getShort(MAX_SMELT_TIME_TAG);
        this.fuelBurnTimeLeft = compound.getInt(FUEL_BURN_TIME_LEFT_TAG);
        this.maxFuelBurnTime = compound.getInt(MAX_FUEL_BURN_TIME_TAG);
 
        // We set this in read() instead of the constructor so that TileEntities
        // constructed from NBT (saved tile entities) have this set to the proper value
        if (this.hasLevel() && !this.level.isClientSide) {
            lastBurning = this.isBurning();
        }
        
        // get recipe2xp map
        int ii = compound.getShort("RecipesUsedSize");
        for(int jj = 0; jj < ii; ++jj) {
           ResourceLocation resourcelocation 
               = new ResourceLocation(compound.getString("RecipeLocation" + jj));
           int kk = compound.getInt("RecipeAmount" + jj);
           this.recipe2xp_map.put(resourcelocation, kk);
        }
        
        // blockstate?
        if (this.hasLevel()) {
            this.level.setBlockAndUpdate(getBlockPos(), this.getBlockState().setValue(AbstractAlloyFurnaceBlock.LIT, Boolean.valueOf(this.isBurning())));
        }

    } // end read()

    /**
     * Write data from the tile into a compound tag for saving to disk.
     */
    @Nonnull
    @Override
    public CompoundNBT save(final CompoundNBT compound)
    {
        super.save(compound);
        compound.put(INVENTORY_TAG, this.inventory.serializeNBT());
        compound.putShort(SMELT_TIME_LEFT_TAG, this.smeltTimeProgress);
        compound.putShort(MAX_SMELT_TIME_TAG, this.maxSmeltTime);
        compound.putInt(FUEL_BURN_TIME_LEFT_TAG, this.fuelBurnTimeLeft);
        compound.putInt(MAX_FUEL_BURN_TIME_TAG, this.maxFuelBurnTime);
        
        // write recipe2xp map
        compound.putShort("RecipesUsedSize", (short)this.recipe2xp_map.size());
        int ii = 0;
        for(Entry<ResourceLocation, Integer> entry : this.recipe2xp_map.entrySet()) 
        {
           compound.putString("RecipeLocation" + ii, entry.getKey().toString());
           compound.putInt("RecipeAmount" + ii, entry.getValue());
           ++ii;
        }
        return compound;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket()
    {
        return new SUpdateTileEntityPacket(getBlockPos(), -1, save(new CompoundNBT()));
    }

    /**
     * Called when you receive a TileEntityData packet for the location this
     * TileEntity is currently in. On the client, the NetworkManager will always
     * be the remote server. On the server, it will be whomever is responsible for
     * sending the packet.
     *
     * @param net The NetworkManager the packet originated from
     * @param pkt The data packet
     */
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt)
    {
        CompoundNBT nbtTag = pkt.getTag();
        this.load(getBlockState(), nbtTag);
    }


    /**
     * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the
     * chunk or when many blocks change at once.
     * This compound comes back to you client-side in {@link #handleUpdateTag}
     * The default implementation ({@link TileEntity#handleUpdateTag}) calls {@link #writeInternal)}
     * which doesn't save any of our extra data so we override it to call {@link #write} instead
     */
    @Nonnull
    public CompoundNBT getUpdateTag()
    {
        return this.save(new CompoundNBT());
    }

    /**
     * Called when the chunk's TE update tag, gotten from {@link #getUpdateTag()}, is received on the client.
     * Used to handle this tag in a special way. By default this simply calls {@link #readFromNBT(NBTTagCompound)}.
     *
     * @param tag The {@link NBTTagCompound} sent from {@link #getUpdateTag()}
     */
    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag)
    {
        this.load(state, tag);
    }
    
    @Override
    protected void invalidateCaps()
    {
        super.invalidateCaps();
        // We need to invalidate our capability references so that any cached references (by other mods) don't
        // continue to reference our capabilities and try to use them and/or prevent them from being garbage collected
        inventoryCapabilityExternal.invalidate();
        inventoryCapabilityExternalUp.invalidate();
        inventoryCapabilityExternalDown.invalidate();
        inventoryCapabilityExternalBack.invalidate();
        inventoryCapabilityExternalLeft.invalidate();
        inventoryCapabilityExternalRight.invalidate();
    }


    public abstract Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player);

    public abstract ITextComponent getDisplayName();

    public void grantExperience(PlayerEntity player)
    {
        List<IRecipe<?>> list = Lists.newArrayList();

        for (Entry<ResourceLocation, Integer> entry : this.recipe2xp_map.entrySet())
        {
            player.level.getRecipeManager().byKey(entry.getKey()).ifPresent((p_213993_3_) -> {
                list.add(p_213993_3_);
                spawnExpOrbs(player, entry.getValue(), ((FusionRecipe) p_213993_3_).getExperience());
            });
        }
        player.awardRecipes(list);
        this.recipe2xp_map.clear();
    }
    
    private static void spawnExpOrbs(PlayerEntity player, int pCount, float experience)
    {
        if (experience == 0.0F) {
            pCount = 0;
        }
        else if (experience < 1.0F)
        {
            int i = MathHelper.floor((float) pCount * experience);
            if (i < MathHelper.ceil((float) pCount * experience)
                    && Math.random() < (double) ((float) pCount * experience - (float) i))
            {
                ++i;
            }
            pCount = i;
        }

        while (pCount > 0)
        {
            int j = ExperienceOrbEntity.getExperienceValue(pCount);
            pCount -= j;
            player.level.addFreshEntity(new ExperienceOrbEntity(player.level, player.getX(), player.getY() + 0.5D,
                    player.getZ() + 0.5D, j));
        }
    } // end spawnExpOrbs()

} // end-class
