package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs
{
//    public static final CreativeModeTab MOD_ITEM_GROUP =
//            new ModTabGroup(Fusion.MODID, () -> new ItemStack(ModItems.steel_ingot.get()));
//    
	// formerly MOD_ITEM_GROUP
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fusion.MODID);
	
	public static final RegistryObject<CreativeModeTab> SIMPLECORE_TAB = CREATIVE_MODE_TABS.register("fusion_tab",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("item_group." + Fusion.MODID + ".tab"))
				.icon(() -> new ItemStack(ModBlocks.fusion_furnace.get().asItem()))
				.displayItems((parameters, output) -> {
					output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
										.map(RegistryObject::get)
										.map(b -> (new ItemStack(b.asItem())))
										.toList()
										);
					output.acceptAll(ModItems.ITEMS.getEntries().stream()
							.map(RegistryObject::get)
							.map(b -> (new ItemStack(b)))
							.toList()
							);
				}).build());

} // end class
