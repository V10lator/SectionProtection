package com.puffybugs.SectPro.Listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.puffybugs.SectPro.SectPro;

public class BlockListener implements Listener{
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		Player player = event.getPlayer();
		Block block = event.getBlockPlaced();
		
		if(block.getTypeId() == SectPro.itemId[0] && block.getData() == SectPro.itemId[1]) {
			
			//Block is the type specified in the config!
			
			if(!SectPro.sneakOverride || !player.isSneaking()) {
				
				//Sneak overide is not enabled or the player is sneaking
				
				//TODO Find boundaries!
				
			}
			
		}
		
	}
	
}
