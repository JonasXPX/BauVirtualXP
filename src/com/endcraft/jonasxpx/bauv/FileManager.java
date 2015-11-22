package com.endcraft.jonasxpx.bauv;

import static com.endcraft.jonasxpx.bauv.BauVirtualXP.dataFolder;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {

	public static YamlConfiguration getFileByPlayerName(String name){
		File local = new File(dataFolder + "/Chests/"+ name.toLowerCase().charAt(0));
		if(!local.exists()) local.mkdirs();
		return YamlConfiguration.loadConfiguration(new File(local  + "/" + name.toLowerCase() + ".vb"));
	}
	
	public static File getFile(String name){
		return new File(dataFolder + "/Chests/"+ name.toLowerCase().charAt(0) + "/" + name.toLowerCase() + ".vb");
	}
}
