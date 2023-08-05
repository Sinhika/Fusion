package mod.alexndr.fusion.api.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;

import mod.alexndr.fusion.api.content.AbstractAlloyFurnaceContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractAlloyFurnaceScreen<T extends AbstractAlloyFurnaceContainer>  extends AbstractContainerScreen<T>
{

    protected final ResourceLocation BACKGROUND_TEXTURE;
    protected final int FLAME_PIX = 12;
    protected final int BUBBLE_PIX = 30;
    protected final int ARROW_PIX = 24;
    
    private int displayNameColor = 0x404040;
    
    public AbstractAlloyFurnaceScreen(T screenContainer, Inventory inv, ResourceLocation texture, 
                                      Component titleIn, int nameColor)
    {
        super(screenContainer, inv, titleIn);
        BACKGROUND_TEXTURE = texture;
        displayNameColor = nameColor;
   }

    @Override
    public void render(GuiGraphics gg, final int mouseX, final int mouseY, final float partialTicks)
    {
       	this.renderBackground(gg);
    	super.render(gg, mouseX, mouseY, partialTicks);
    	this.renderTooltip(gg, mouseX, mouseY); // formerly renderHoveredTooltip
    }

    /**
     * Corresponds to AbstractFurnaceScreen.renderBg() in 1.16.1.
     * Formerly drawGuiContainerBackgroundLayer() in 1.15.2
     * @param matStack
     * @param partialTicks
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void renderBg(GuiGraphics gg, final float partialTicks, final int mouseX, final int mouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.BACKGROUND_TEXTURE);
        int startX = this.leftPos;
        int startY = this.topPos;
        
        // Screen#blit draws a part of the current texture (assumed to be 256x256) to the screen
        // The parameters are (x, y, u, v, width, height)
    	gg.blit(this.BACKGROUND_TEXTURE, startX, startY, 0, 0, this.imageWidth, this.imageHeight);
        
        int midX = (this.width - this.imageWidth) / 2;
        int midY = (this.height - this.imageHeight) / 2;
    
        if (this.menu.isLit())
        {
            int flameHeight = this.getFuelBurnTimeScaled(FLAME_PIX); //Flames
            gg.blit(this.BACKGROUND_TEXTURE, midX + 105, midY + 55 + 12 - flameHeight, 176, FLAME_PIX - flameHeight, 14, flameHeight + 2);
            
            flameHeight = this.getFuelBurnTimeScaled(FLAME_PIX); //Flames
            gg.blit(this.BACKGROUND_TEXTURE, midX + 55, midY + 55 + 12 - flameHeight, 176, FLAME_PIX - flameHeight, 14, flameHeight + 2);
        }
       	if (this.menu.getBurnProgress(FLAME_PIX) > 0) 
       	{
    		// Draw progress arrow
	        int arrowWidth = this.getSmeltTimeScaled(ARROW_PIX); //Left Arrow
	        gg.blit(this.BACKGROUND_TEXTURE, midX + 51, midY + 34, 176, 14, arrowWidth + 1, 16);
	        
	        arrowWidth = this.getSmeltTimeScaled(ARROW_PIX); //Right Arrow
	        gg.blit(this.BACKGROUND_TEXTURE, midX + 100, midY + 34, 176, 31, 23, 16);
	        
	        arrowWidth = this.getSmeltTimeScaled(ARROW_PIX); //Right Arrow Grey Overlay
	        gg.blit(this.BACKGROUND_TEXTURE, midX + 100, midY + 34, 176, 47, 23 - arrowWidth, 16);
	        
	        int bubbleHeight = this.getSmeltTimeScaled(BUBBLE_PIX); //Bubbles
	        gg.blit(this.BACKGROUND_TEXTURE, midX + 64, midY + 4 + 29 - bubbleHeight, 176, 92 - bubbleHeight, 12, 29);
	        
	        bubbleHeight = this.getSmeltTimeScaled(BUBBLE_PIX); //Bubbles
	        gg.blit(this.BACKGROUND_TEXTURE, midX + 98, midY + 4 + 29 - bubbleHeight, 188, 92 - bubbleHeight, 12, 29);
       	}
    } // end drawGuiContainerBackgroundLayer()

    /**
     * Probably corresponds to ContainerScreen.renderLabels() in 1.16.1.
     * Formerly drawGuiContainerForegroundLayer() in 1.15.2.
     * @param matStack
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void renderLabels(GuiGraphics gg, final int mouseX, final int mouseY)
    {
        int forbidden_area = 54;
        
        // Copied from AbstractFurnaceScreen#drawGuiContainerForegroundLayer
        String s = this.title.getString();
        String [] s2 = s.split("\\s+", 2);
        int left_offset = this.imageWidth / 2 - forbidden_area/2 - this.font.width(s2[0]);
        gg.drawString( this.font, s2[0], left_offset, 6, displayNameColor);
        // In some languages, the title is one word, not two.
        if (s2.length > 1)
        {
            int right_offset = this.imageWidth / 2 + forbidden_area/2;
            gg.drawString( this.font, s2[1], right_offset, 6, displayNameColor);
        }
        //this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 0x404040);
        
        gg.drawString( this.font, this.playerInventoryTitle.getString(), 8, (this.imageHeight - 96 + 2), displayNameColor);
    } // end ()

    private int getSmeltTimeScaled(int pixels)
    {
    	return this.menu.getBurnProgress(pixels);
    }

    private int getFuelBurnTimeScaled(int pixels)
    {
    	return this.menu.getLitProgress(pixels);    
    }

} // end-class