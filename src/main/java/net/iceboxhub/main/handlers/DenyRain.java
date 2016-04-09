package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DenyRain implements Listener{
	@SuppressWarnings("unused")
	private IceBoxHub plugin;

	public DenyRain(IceBoxHub hub) {
		this.plugin = hub;
	}
	
	@EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
		if(event.getWorld().isThundering()){
			event.setCancelled(true);
		}
    }
}
