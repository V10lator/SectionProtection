package com.puffybugs.SectPro;

import java.io.File;
import java.io.InputStream;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.puffybugs.SectPro.Listeners.BlockListener;

public class SectPro extends JavaPlugin{

	//Used for makeConfig() and getConfigValues()
	FileConfiguration config;
	File configFile;
	
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
		
		configFile = new File("plugins" + File.separator + pdf.getName() + File.separator + "config.yml");
		config = YamlConfiguration.loadConfiguration(configFile);

		InputStream defaultStream = this.getResource("config.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultStream);
			config.setDefaults(defaultConfig);
		}

		if (!configFile.exists()) {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
	}
	
	/** Gets the config values and assigns them to variables
	 * 
	 */
	private void getConfigValues() {
		
		//Gets the boundary blocks
		String itemIdRaw = config.getString("Block-ID");
		itemId[0] = Integer.valueOf(itemIdRaw.split("/")[0]);
		itemId[1] = Integer.valueOf(itemIdRaw.split("/")[1]);
		
		//Gets if Sneak Override has effect
		sneakOverride = config.getBoolean("Sneak-Override");
		
	}
	
}
