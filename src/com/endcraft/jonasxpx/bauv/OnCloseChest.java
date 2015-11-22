package com.endcraft.jonasxpx.bauv;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class OnCloseChest implements Listener{

	
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		ChestXP.saveInventory(e.getInventory());
	}
}
