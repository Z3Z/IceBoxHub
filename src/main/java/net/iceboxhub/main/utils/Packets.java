package net.iceboxhub.main.utils;

import java.lang.reflect.Field;

import net.iceboxhub.main.IceBoxHub;
import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import net.minecraft.server.v1_9_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_9_R1.PlayerConnection;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Packets implements Listener{
	
	@SuppressWarnings("unused")
	private static IceBoxHub plugin;
	public Packets(IceBoxHub listener) {
		Packets.plugin = listener;
	}
	
	public static void sendTabTitle(Player player, String header, String footer) {
		if (header == null) {
			header = "";
		}
		header = ChatColor.translateAlternateColorCodes('&', header);
		if (footer == null) {
			footer = "";
		}
		footer = ChatColor.translateAlternateColorCodes('&', footer);

		header = header.replaceAll("%player%", player.getDisplayName());
		footer = footer.replaceAll("%player%", player.getDisplayName());

		PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
		IChatBaseComponent tabTitle = ChatSerializer.a("{\"text\": \"" + header
				+ "\"}");
		IChatBaseComponent tabFoot = ChatSerializer.a("{\"text\": \"" + footer
				+ "\"}");
		PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(
				tabTitle);
		try {
			Field field = headerPacket.getClass().getDeclaredField("b");
			field.setAccessible(true);
			field.set(headerPacket, tabFoot);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.sendPacket(headerPacket);
		}
	}

	public static void sendTitle(Player player, String titlestr,
			String subtitlestr) {
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \""
				+ titlestr + "\"}");
		IChatBaseComponent chatSubTitle = ChatSerializer.a("{\"text\": \""
				+ subtitlestr + "\"}");
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(
				EnumTitleAction.SUBTITLE, chatSubTitle);
		PacketPlayOutTitle title = new PacketPlayOutTitle(
				EnumTitleAction.TITLE, chatTitle);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) player).getHandle().playerConnection
				.sendPacket(subtitle);
	}

	public static void sendActionBar(Player player, String message) {
		CraftPlayer p = (CraftPlayer) player;
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message
				+ "\"}");
		PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
	}
}