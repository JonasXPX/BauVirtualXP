package com.endcraft.jonasxpx.bauv;

import java.io.File;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;

public class BauVirtualXP extends JavaPlugin{

	public static File dataFolder;
	public static List<String> wait = Lists.newArrayList();
	
	@Override
	public void onEnable() {
		dataFolder = getDataFolder();
		getServer().getPluginManager().registerEvents(new OnCloseChest(), this);
		getCommand("bau").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.hasPermission("bauvirtualxp.use")){
			sender.sendMessage("§cVocê não pode usar este comando!.");
			return true;
		}
		if(wait.contains(sender.getName().toLowerCase())){
			sender.sendMessage("§cAguarde...");
			return true;
		}
		new ChestXP((Player)sender).openInventory();
		return false;
	}
}
