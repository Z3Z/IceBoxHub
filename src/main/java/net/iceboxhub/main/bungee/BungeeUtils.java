package net.iceboxhub.main.bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class BungeeUtils implements Listener, PluginMessageListener {

	private static IceBoxHub plugin;

	public BungeeUtils(IceBoxHub hub) {
		BungeeUtils.plugin = hub;
	}
	
	public void onEnable(){
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(plugin,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", this);
	}
	
	@SuppressWarnings("unused")
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    ByteArrayDataInput in = ByteStreams.newDataInput(message);
	    String subchannel = in.readUTF();
	    if (subchannel.equals("BungeeCord")) {
	      // Use the code sample in the 'Response' sections below to read
	      // the data.
	    	String server = in.readUTF(); // Name of server, as given in the arguments
			int playercount = in.readInt();
	    }
	  }

	public static void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void sendMessage(Player player, String playerName, String Message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Message");
			out.writeUTF(playerName);
			out.writeUTF(Message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void playerCountOfServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("PlayerCount");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void kickPlayer(Player player, String playerName, String kickMessage) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("KickPlayer");
			out.writeUTF(playerName);
			out.writeUTF(kickMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
}