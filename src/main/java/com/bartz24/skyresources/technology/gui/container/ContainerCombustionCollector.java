package com.bartz24.skyresources.technology.gui.container;

import com.bartz24.skyresources.base.gui.ContainerBase;
import com.bartz24.skyresources.base.gui.SlotSpecial;
import com.bartz24.skyresources.technology.tile.TileCombustionCollector;

import net.minecraft.inventory.IInventory;

public class ContainerCombustionCollector extends ContainerBase
{
	public ContainerCombustionCollector(IInventory playerInv,
			TileCombustionCollector te)
	{
		super(playerInv, te);

		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 0, 44, 53));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 1, 62, 53));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 2, 80, 53));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 3, 98, 53));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 4, 116, 53));
	}
}
