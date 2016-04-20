package alexndr.plugins.Fusion;

import alexndr.api.helpers.game.RenderItemHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ProxyClient extends alexndr.plugins.Fusion.ProxyCommon
{

	@Override
	public void PreInit(FMLPreInitializationEvent event) {
		super.PreInit(event);
	}

	@Override
	public void Init(FMLInitializationEvent event) {
		super.Init(event);
		
		//Registers
		if(event.getSide() == Side.CLIENT) 
		{
			RenderItemHelper.renderItemsAndBlocks(Fusion.plugin);
		}
		
	} // end Init()

	@Override
	public void PostInit(FMLPostInitializationEvent event) {
		super.PostInit(event);
	}

} // end class
