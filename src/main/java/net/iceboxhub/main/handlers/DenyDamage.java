package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class DenyDamage implements Listener {
	@SuppressWarnings("unused")
	private IceBoxHub plugin;

	public DenyDamage(IceBoxHub hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
			event.setCancelled(true);
	}

	@EventHandler
	public void onVoidDamage(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (p.getLocation().getY() <= 0.0D) {
			//Location loc = new Location(Bukkit.getWorld("Lobby1"), 0.5, 32, 0.5);
			//p.teleport(loc);
		}
	}

	@EventHandler
	public void noPetDamage(EntityDamageByEntityEvent e) {
		e.setCancelled(true);
	}

}