package mod.alexndr.fusion.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.content.FusionFurnaceContainer;
import mod.alexndr.fusion.content.FusionFurnaceTileEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FusionFurnaceScreen extends ContainerScreen<FusionFurnaceContainer>
{
    private static final ResourceLocation BACKGROUND_TEXTURE = 
            new ResourceLocation(Fusion.MODID, "textures/gui/container/fusion_furnace_gui.png");
    
    public FusionFurnaceScreen(final FusionFurnaceContainer screenContainer, PlayerInventory inv, 
                               ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, 
                                                   final int mouseY)
    {
    	GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int startX = this.guiLeft;
        int startY = this.guiTop;
        
        // Screen#blit draws a part of the current texture (assumed to be 256x256) to the screen
        // The parameters are (x, y, u, v, width, height)
        this.blit(startX, startY, 0, 0, this.xSize, this.ySize);
        
        final FusionFurnaceTileEntity tileEntity = this.container.tileEntity;

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        int i1;

        if (tileEntity.isBurning())
        {
            i1 = this.getBurnLeftScaled(12); //Flames
            this.blit(k + 105, l + 55 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
            
            i1 = this.getBurnLeftScaled(12); //Flames
            this.blit(k + 55, l + 55 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.getCookProgressScaled(24); //Left Arrow
        this.blit(k + 51, l + 34, 176, 14, i1 + 1, 16);
        
        i1 = this.getCookProgressScaled(24); //Right Arrow
        this.blit(k + 100, l + 34, 176, 31, 23, 16);
        
        i1 = this.getCookProgressScaled(24); //Right Arrow Grey Overlay
        this.blit(k + 100, l + 34, 176, 47, 23 - i1, 16);
        
        i1 = this.getCookProgressScaled(30); //Bubbles
        this.blit(k + 64, l + 4 + 29 - i1, 176, 92 - i1, 12, 29);
        
        i1 = this.getCookProgressScaled(30); //Bubbles
        this.blit(k + 98, l + 4 + 29 - i1, 188, 92 - i1, 12, 29);
    } // end drawGuiContainerBackgroundLayer()
    
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        int forbidden_area = 54;
        
        // Copied from AbstractFurnaceScreen#drawGuiContainerForegroundLayer
        String s = this.title.getFormattedText();
        String [] s2 = s.split("\\s+", 2);
        int left_offset = this.xSize / 2 - forbidden_area/2 - this.font.getStringWidth(s2[0]);
        int right_offset = this.xSize / 2 + forbidden_area/2;
        this.font.drawString(s2[0], (float) left_offset, 6.0F, 0x404040);
        this.font.drawString(s2[1], (float) right_offset, 6.0F, 0x404040);
        //this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 0x404040);
        
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 0x404040);

    } // end ()

    /**
     * 
     * @param pixels width of graphic progress bar
     * @return scaled progress in pixels
     */
    private int getCookProgressScaled(int pixels)
    {
        final FusionFurnaceTileEntity tileEntity = this.container.tileEntity;
        final short smeltTimeLeft = tileEntity.smeltTimeLeft;
        final short maxSmeltTime = tileEntity.maxSmeltTime;
        if (smeltTimeLeft <= 0 || maxSmeltTime <= 0)
            return 0;
        return (maxSmeltTime - smeltTimeLeft) * pixels / maxSmeltTime;
    }

    private int getBurnLeftScaled(int pixels)
    {
        final FusionFurnaceTileEntity tileEntity = this.container.tileEntity;
        if (tileEntity.maxFuelBurnTime <= 0)
            return 0;
        return tileEntity.fuelBurnTimeLeft * (pixels + 2) / tileEntity.maxFuelBurnTime;
    }

} // end class
