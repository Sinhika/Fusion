package alexndr.plugins.Fusion;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import alexndr.api.helpers.game.RenderItemHelper;
import alexndr.plugins.Fusion.modsupport.ModSupport;

public class ProxyClient extends alexndr.plugins.Fusion.ProxyCommon
{
	RenderItemHelper renderHelper = new RenderItemHelper(Fusion.plugin);

	@Override
	public void PreInit(FMLPreInitializationEvent event) 
	{
		super.PreInit(event);
		if(event.getSide() == Side.CLIENT) 
		{
			renderHelper.renderItemsAndBlocks();
			renderHelper.renderItemStuff(event);
			ModSupport.ClientPreInit(renderHelper);
		}	
	} // end PreInit()

	@Override
	public void Init(FMLInitializationEvent event) {
		super.Init(event);
	} // end Init()

	@Override
	public void PostInit(FMLPostInitializationEvent event) {
		super.PostInit(event);
	}

} // end class
