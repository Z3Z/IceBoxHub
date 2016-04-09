package net.iceboxhub.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener{
	
	@SuppressWarnings("unused")
	private IceBoxHub plugin;
	public PlayerQuit(IceBoxHub listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		event.setQuitMessage("");
	}

}