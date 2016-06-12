package alexndr.plugins.Fusion.gui;

import alexndr.plugins.Fusion.inventory.ContainerFusionFurnace;
import alexndr.plugins.Fusion.tiles.TileEntityFusionFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author AleXndrTheGr8st
 */
@SideOnly(Side.CLIENT)
public class GuiFusionFurnace extends GuiContainer
{
	protected TileEntityFusionFurnace furnaceInventory;
	protected final InventoryPlayer playerInventory;
	
	protected static final ResourceLocation guiTexture = new ResourceLocation("fusion:" + "textures/gui/container/fusion_furnace_gui.png");
	
	
	public GuiFusionFurnace(InventoryPlayer inventoryplayer, TileEntityFusionFurnace tileentity) 
	{
		super(new ContainerFusionFurnace(inventoryplayer, tileentity));
        this.playerInventory = inventoryplayer;
		this.furnaceInventory = tileentity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) 
	{
        String s = this.furnaceInventory.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
//		this.fontRendererObj.drawString("   Fusion             Furnace", this.xSize / 2 - this.fontRendererObj.getStringWidth("   Fusion             Furnace") / 2, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiTexture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.furnaceInventory.isBurning())
        {
            i1 = this.getBurnLeftScaled(12); //Flames
            this.drawTexturedModalRect(k + 105, l + 55 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
            
            i1 = this.getBurnLeftScaled(12); //Flames
            this.drawTexturedModalRect(k + 55, l + 55 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.getCookProgressScaled(24); //Left Arrow
        this.drawTexturedModalRect(k + 51, l + 34, 176, 14, i1 + 1, 16);
        
        i1 = this.getCookProgressScaled(24); //Right Arrow
        this.drawTexturedModalRect(k + 100, l + 34, 176, 31, 23, 16);
        
        i1 = this.getCookProgressScaled(24); //Right Arrow Grey Overlay
        this.drawTexturedModalRect(k + 100, l + 34, 176, 47, 23 - i1, 16);
        
        i1 = this.getCookProgressScaled(30); //Bubbles
        this.drawTexturedModalRect(k + 64, l + 4 + 29 - i1, 176, 92 - i1, 12, 29);
        
        i1 = this.getCookProgressScaled(30); //Bubbles
        this.drawTexturedModalRect(k + 98, l + 4 + 29 - i1, 188, 92 - i1, 12, 29);
	}
	
	protected int getCookProgressScaled(int pixels)
    {
        int i = this.furnaceInventory.getField(2);
        int j = this.furnaceInventory.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

	protected int getBurnLeftScaled(int pixels)
    {
        int i = this.furnaceInventory.getField(1);
        int m = this.furnaceInventory.getField(4);
        
        if (i == 0)
        {
            i = m;
        }
        return this.furnaceInventory.getField(0) * pixels / i;
    } // end ()

} // end class
