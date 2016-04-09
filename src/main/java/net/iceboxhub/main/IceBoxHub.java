package net.iceboxhub.main;

import net.iceboxhub.main.bungee.BungeeUtils;
import net.iceboxhub.main.handlers.DenyBuilding;
import net.iceboxhub.main.handlers.ChatHandler;
import net.iceboxhub.main.handlers.DenyDamage;
import net.iceboxhub.main.handlers.DenyHunger;
import net.iceboxhub.main.handlers.MenuOpeners;
import net.iceboxhub.main.handlers.JumpHandler;
import net.iceboxhub.main.handlers.ScoreBoardHandler;
import net.iceboxhub.main.handlers.DenyRain;
import net.iceboxhub.main.menus.CosmeticMenu;
import net.iceboxhub.main.menus.GadgetMenu;
import net.iceboxhub.main.menus.GameMenu;
import net.iceboxhub.main.menus.LobbyMenu;
import net.iceboxhub.main.menus.ProfileMenu;
import net.iceboxhub.main.utils.Packets;
import net.iceboxhub.main.utils.SimpleUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class IceBoxHub extends JavaPlugin implements Listener{
	
	public void onEnable(){
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	    console.sendMessage(SimpleUtils.color("&e[&bIceBoxMC&e] &aThe Hub Plugin Has Been Enabled!"));
		registerListeners();
		registerCommands();
	}
	
	public void onDisable(){
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		console.sendMessage(SimpleUtils.color("&e[&bIceBoxMC&e] &cThe Hub Plugin Has Been Disabled!"));
	}
	
	public void registerListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new BungeeUtils(this), this);
		pm.registerEvents(new SimpleUtils(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerQuit(this), this);
		pm.registerEvents(new DenyBuilding(this), this);
		pm.registerEvents(new ChatHandler(this), this);
		pm.registerEvents(new DenyDamage(this), this);
		pm.registerEvents(new DenyHunger(this), this);
		pm.registerEvents(new JumpHandler(this), this);
		pm.registerEvents(new DenyRain(this), this);
		pm.registerEvents(new MenuOpeners(this), this);
		pm.registerEvents(new GameMenu(this), this);
		pm.registerEvents(new CosmeticMenu(this), this);
		pm.registerEvents(new GadgetMenu(this), this);
		pm.registerEvents(new LobbyMenu(this), this);
		pm.registerEvents(new ProfileMenu(this), this);
		pm.registerEvents(new ScoreBoardHandler(this), this);
		pm.registerEvents(new Packets(this), this);
	}
	
	public void registerCommands(){
		//getCommand("test").setExecutor(new PlayerJoin(this));
	}
}