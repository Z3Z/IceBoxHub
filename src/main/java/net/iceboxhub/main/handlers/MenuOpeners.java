package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;
import net.iceboxhub.main.menus.CosmeticMenu;
import net.iceboxhub.main.menus.GadgetMenu;
import net.iceboxhub.main.menus.GameMenu;
import net.iceboxhub.main.menus.LobbyMenu;
import net.iceboxhub.main.menus.ProfileMenu;
import net.iceboxhub.main.utils.SimpleUtils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MenuOpeners implements Listener {
	@SuppressWarnings("unused")
	private IceBoxHub plugin;

	public MenuOpeners(IceBoxHub hub) {
		this.plugin = hub;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void gameMenu(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (event.getPlayer().getItemInHand() != null) {
				if (event.getPlayer().getItemInHand().getType() == Material.COMPASS) {
					if(event.getPlayer().getItemInHand().hasItemMeta()){
						if(event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(SimpleUtils.color("&b&lGame Selector &8- &7&lRight Click"))){
							GameMenu.Menu(event.getPlayer());
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void profileMenu(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (event.getPlayer().getItemInHand() != null) {
				if (event.getPlayer().getItemInHand().getType() == Material.SKULL_ITEM) {
					if(event.getPlayer().getItemInHand().hasItemMeta()){
						if(event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(SimpleUtils.color("&b&lProfile &8- &7&lRight Click"))){
							ProfileMenu.Menu(event.getPlayer());
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void gadgetMenu(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (event.getPlayer().getItemInHand() != null) {
				if (event.getPlayer().getItemInHand().getType() == Material.CHEST) {
					if(event.getPlayer().getItemInHand().hasItemMeta()){
						if(event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(SimpleUtils.color("&b&lGadgets &8- &7&lRight Click"))){
							GadgetMenu.Menu(event.getPlayer());
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void cosmeticMenu(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (event.getPlayer().getItemInHand() != null) {
				if (event.getPlayer().getItemInHand().getType() == Material.NAME_TAG) {
					if(event.getPlayer().getItemInHand().hasItemMeta()){
						if(event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(SimpleUtils.color("&b&lCosmetics &8- &7&lRight Click"))){
							CosmeticMenu.Menu(event.getPlayer());
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void lobbyMenu(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (event.getPlayer().getItemInHand() != null) {
				if (event.getPlayer().getItemInHand().getType() == Material.NETHER_STAR) {
					if(event.getPlayer().getItemInHand().hasItemMeta()){
						if(event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(SimpleUtils.color("&b&lLobby Selector &8- &7&lRight Click"))){
							LobbyMenu.Menu(event.getPlayer());
						}
					}
				}
			}
		}
	}
}