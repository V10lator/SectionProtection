package com.puffybugs.SectPro;

import java.io.File;

import org.bukkit.Server;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.puffybugs.SectPro.Listeners.BlockListener;

public class SectPro extends JavaPlugin{
	
	//Used in this class
	Server serv; //The server, used for methods such as getLogger()
	PluginDescriptionFile pdf; //plugin.yml, used for methods such as getName()
	
	//Config Values
	public static Integer[] itemId;
	public static boolean sneakOverride;
	
	@Override
	public void onEnable() {
		
		serv = getServer();
		pdf = getDescription();
		
		makeConfig();
		getConfigValues();
		
		serv.getPluginManager().registerEvents(new BlockListener(), this);
	}
	
	/** Makes the config
	 * 
	 */
	private void makeConfig() {
		
		File f = new File(getDataFolder(), "config.yml");
		if(!f.exists())
			saveDefaultConfig();
		
	}
	
	/** Gets the config values and assigns them to variables
	 * 
	 */
	private void getConfigValues() {
		
		Configuration config = getConfig();
		
		//Gets the boundary blocks
		String itemIdRaw = config.getString("Block-ID");
		String[] split = itemIdRaw.split("/");
		try
		{
			itemId[0] = Integer.valueOf(split[0]);
		}
		catch(NumberFormatException e)
		{
			itemId[0] = 0;
		}
		try
		{
			itemId[1] = Integer.valueOf(split[1]);
		}
		catch(NumberFormatException e)
		{
			itemId[1] = 0;
		}
		
		//Gets if Sneak Override has effect
		sneakOverride = config.getBoolean("Sneak-Override");
		
	}
	
}
