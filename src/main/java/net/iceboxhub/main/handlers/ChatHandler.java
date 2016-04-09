package net.iceboxhub.main.handlers;

import java.util.ArrayList;
import java.util.List;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener {
	@SuppressWarnings("unused")
	private IceBoxHub plugin;

	public ChatHandler(IceBoxHub hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String msg = event.getMessage();

		String[] messages = msg.split(" ");
		List<String> players = new ArrayList<String>();
		for (Player p : Bukkit.getOnlinePlayers()) {
			players.add(p.getName());
		}

		for (String s : messages) {
			if (players.contains(s)) {
				event.setMessage(event.getMessage().replace(
						s,
						ChatColor.translateAlternateColorCodes('&', "&b@" + s
								+ "&r")));
				Bukkit.getPlayerExact(s).playSound(
						Bukkit.getPlayerExact(s).getLocation(),
						Sound.ENTITY_IRONGOLEM_DEATH, 1.0F, 1.0F);
			}
		}
	}

}