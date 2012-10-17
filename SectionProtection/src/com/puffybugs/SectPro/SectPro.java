package com.puffybugs.SectPro;

import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SectPro extends JavaPlugin{

	Server serv; //The server, used for methods such as getLogger()
	PluginDescriptionFile pdf; //plugin.yml, used for methods such as getName()
	
	@Override
	public void onEnable() {
		
		serv = getServer();
		pdf = getDescription();
		
		serv.getLogger().info(getName()+" version "+pdf.getVersion()+" has been enabled!");
		
	}
	
	@Override
	public void onDisable() {
		
		serv.getLogger().info(getName()+" version "+pdf.getVersion()+" has been disabled!");
		
	}
	
}
