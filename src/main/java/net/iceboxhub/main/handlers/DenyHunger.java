package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class DenyHunger implements Listener{
	
	@SuppressWarnings("unused")
	private IceBoxHub plugin;
	public DenyHunger(IceBoxHub listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void noHunger(FoodLevelChangeEvent event){
		event.setCancelled(true);
	}

}