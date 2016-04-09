package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class DenyBuilding implements Listener {
	@SuppressWarnings("unused")
	private IceBoxHub plugin;

	public DenyBuilding(IceBoxHub hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void onBreakEvent(BlockBreakEvent event) {
		if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			event.setCancelled(false);
		} else
			event.setCancelled(true);
	}

	@EventHandler
	public void onPlaceEvent(BlockPlaceEvent event) {
		if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			event.setCancelled(false);
		} else
			event.setCancelled(true);
		event.getPlayer().updateInventory();
	}

}