package com.bartz24.skyresources.plugin.forestry.gui;

import java.util.ArrayList;
import java.util.List;

import com.bartz24.skyresources.RandomHelper;
import com.bartz24.skyresources.References;
import com.bartz24.skyresources.base.gui.GuiHelper;
import com.bartz24.skyresources.plugin.forestry.gui.container.ContainerBeeAttractor;
import com.bartz24.skyresources.plugin.forestry.tile.TileBeeAttractor;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiBeeAttractor extends GuiContainer
{

	private IInventory playerInv;
	private TileBeeAttractor tile;

	public GuiBeeAttractor(IInventory playerInv, TileBeeAttractor te)
	{
		super(new ContainerBeeAttractor(playerInv, te));

		this.playerInv = playerInv;
		this.tile = te;

		this.xSize = 176;
		this.ySize = 189;
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager()
				.bindTexture(new ResourceLocation(References.ModID, "textures/gui/beeattractor.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.ModID, "textures/gui/guiicons.png"));
		if (tile.getEnergyStored() > 0)
		{
			int height = (int) (tile.getEnergyStored() * 58 / tile.getMaxEnergyStored());
			this.drawTexturedModalRect(22 + guiLeft, 30 + 58 - height + guiTop, 51, 59 - height, 8, height);
		}

		RandomHelper.renderGuiTank(tile.getTank().getFluid(), tile.getTank().getCapacity(),
				tile.getTank().getFluidAmount(), 142 + guiLeft, 30 + guiTop, 16, 59);

		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.ModID, "textures/gui/guiicons.png"));
		this.drawTexturedModalRect(142 + guiLeft, 30 + guiTop, 34, 0, 16, 59);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = tile.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(s, 88 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 3, 96, 4210752);

		if (GuiHelper.isMouseInRect(142 + guiLeft, 30 + guiTop, 16, 59, mouseX, mouseY))
		{
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			List list = new ArrayList();
			list.add("Seed Oil:");
			list.add(tile.getTank().getFluidAmount() + " mB / " + tile.getTank().getCapacity() + " mB");
			this.drawHoveringText(list, mouseX - k, mouseY - l, fontRenderer);
		} else if (GuiHelper.isMouseInRect(22 + guiLeft, 30 + guiTop, 8, 59, mouseX, mouseY))
		{
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			List list = new ArrayList();
			list.add(TextFormatting.RED + "Power:");
			list.add(TextFormatting.RED + (tile.getEnergyStored() + " FE / " + tile.getMaxEnergyStored() + " FE"));
			this.drawHoveringText(list, mouseX - k, mouseY - l, fontRenderer);
		}
	}

}
