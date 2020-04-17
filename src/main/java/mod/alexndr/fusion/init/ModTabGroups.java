package mod.alexndr.fusion.init;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import mod.alexndr.fusion.Fusion;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public final class ModTabGroups
{
    public static final ItemGroup MOD_ITEM_GROUP =
            new ModTabGroup(Fusion.MODID, () -> new ItemStack(ModItems.steel_ingot.get()));
    
    public static final class ModTabGroup extends ItemGroup
    {

        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        /**
         * @param name  String: mod id
         * @param iconSupplier
         */
        public ModTabGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier)
        {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

    } // end ModTabGroup()
} // end class
