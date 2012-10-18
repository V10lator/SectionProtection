package com.puffybugs.SectPro;

import java.io.File;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import com.puffybugs.SectPro.Listeners.BlockListener;

public class SectPro extends JavaPlugin{
	
	//Config Values
	public final int[] itemId = new int[2];
	public boolean sneakOverride;
	
	@Override
	public void onEnable() {
		
		makeConfig();
		getConfigValues();
		getServer().getPluginManager().registerEvents(new BlockListener(this), this);
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
