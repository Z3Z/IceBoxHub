package net.iceboxhub.main;

import java.util.Arrays;

import net.iceboxhub.main.handlers.ScoreBoardHandler;
import net.iceboxhub.main.utils.Packets;
import net.iceboxhub.main.utils.SimpleUtils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class PlayerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private IceBoxHub plugin;
	public PlayerJoin(IceBoxHub listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		event.setJoinMessage("");
		
		event.getPlayer().setFoodLevel(20);
		Packets.sendActionBar(event.getPlayer(), SimpleUtils.color("&aTEST"));
		Packets.sendTabTitle(event.getPlayer(), SimpleUtils.color("&c&lTEST"), SimpleUtils.color("&b&lTEST"));
		Packets.sendTitle(event.getPlayer(), SimpleUtils.color("&d&lTEST"), SimpleUtils.color("&e&lTEST"));
		
		//Location loc = new Location(Bukkit.getWorld("Lobby1"), 0.5, 32, 0.5);
		//e.getPlayer().teleport(loc);
		
		event.getPlayer().getInventory().clear();
		ScoreBoardHandler.makeScoreBoard(event.getPlayer());
		
		ItemStack selector = SimpleUtils.createItem(Material.COMPASS,1,0,SimpleUtils.color("&b&lGame Selector &8- &7&lRight Click"), Arrays.asList(SimpleUtils.color("&c&lLORE")));
		ItemStack skull = SimpleUtils.createSkull(event.getPlayer().getName(),SimpleUtils.color("&b&lProfile &8- &7&lRight Click"), Arrays.asList(SimpleUtils.color("&c&lLORE")));
		ItemStack gadgets = SimpleUtils.createItem(Material.CHEST,1,0,SimpleUtils.color("&b&lGadgets &8- &7&lRight Click"), Arrays.asList(SimpleUtils.color("&c&lLORE")));
		ItemStack cosmetics = SimpleUtils.createItem(Material.NAME_TAG,1,0,SimpleUtils.color("&b&lCosmetics &8- &7&lRight Click"), Arrays.asList(SimpleUtils.color("&c&lLORE")));
		ItemStack lobbyselector = SimpleUtils.createItem(Material.NETHER_STAR,1,0,SimpleUtils.color("&b&lLobby Selector &8- &7&lRight Click"), Arrays.asList(SimpleUtils.color("&c&lLORE")));
		
		event.getPlayer().getInventory().setItem(0, selector);
		event.getPlayer().getInventory().setItem(2, skull);
		event.getPlayer().getInventory().setItem(4, gadgets);
		event.getPlayer().getInventory().setItem(6, cosmetics);
		event.getPlayer().getInventory().setItem(8, lobbyselector);
	}

}