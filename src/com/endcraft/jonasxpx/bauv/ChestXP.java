package com.endcraft.jonasxpx.bauv;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ChestXP {

	private Player player;
	
	public ChestXP(Player player){
		this.player = player;
	}
	
	
	public void openInventory(){
		Inventory inv = Bukkit.createInventory(player, 54, "Bau Virtual XP");
		FileConfiguration config = FileManager.getFileByPlayerName(player.getName());
		for(int x = 0; x <= 53; x++){
			if(!config.contains("Slot." + x)){
				continue;
			}
			inv.setItem(x, config.getItemStack("Slot." + x));
		}
		player.openInventory(inv);
		BauVirtualXP.wait.add(player.getName().toLowerCase());
		player.getWorld().playSound(player.getLocation(), Sound.CHEST_OPEN, 0.7F, 1.6F);
	}
	
	public static void saveInventory( Inventory inv){
		if(!inv.getTitle().equalsIgnoreCase("Bau Virtual XP")){return;}
		((Player)inv.getHolder()).getWorld().playSound(((Player)inv.getHolder()).getLocation(), Sound.CHEST_CLOSE, 0.7F, 1.5F);
		 String playerName = ((Player)inv.getHolder()).getName().toLowerCase();
		 FileConfiguration config = FileManager.getFileByPlayerName(playerName);
		
				for(int x = 0; x <= 53; x++){
					if(inv.getItem(x) == null){
						config.set("Slot." + x, null);
						continue;
					}
					if(inv.getItem(x).hasItemMeta())
					if(inv.getItem(x).getItemMeta().hasDisplayName()){
						ItemMeta meta = inv.getItem(x).getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace('�', '?'));
						inv.getItem(x).setItemMeta(meta);
					}
					config.set("Slot." + x, inv.getItem(x));
				}	
				try {
					config.save(FileManager.getFile(playerName));
				} catch (IOException e) {e.printStackTrace();}
				BauVirtualXP.wait.remove(playerName);
			
	}
	
}
