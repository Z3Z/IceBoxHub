package net.iceboxhub.main.handlers;

import net.iceboxhub.main.IceBoxHub;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class JumpHandler implements Listener {
	@SuppressWarnings("unused")
	private IceBoxHub plugin;

	public JumpHandler(IceBoxHub hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setAllowFlight(true);
		player.setFlying(false);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerFly(PlayerToggleFlightEvent event) {
		final Player player = event.getPlayer();
		if (player.getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
			player.setAllowFlight(false);
			player.setFlying(false);
			player.setVelocity(player.getLocation().getDirection().multiply(2.0D)
					.setY(1D));
			player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 15);
			player.playEffect(player.getLocation(), Effect.COLOURED_DUST, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 15);
			player.playEffect(player.getLocation(), Effect.COLOURED_DUST, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 15);
			player.playEffect(player.getLocation(), Effect.COLOURED_DUST, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playEffect(player.getLocation(), Effect.LAVA_POP, 15);
			player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_BLAST, 10.0F, 10.0F);
			player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_LAUNCH, 10.0F, 10.0F);
			player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_TWINKLE, 10.0F, 10.0F);
			player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_LARGE_BLAST, 10.0F,
					10.0F);
		}
	}

	@EventHandler
	public void move(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if ((event.getPlayer().getGameMode() != GameMode.CREATIVE)
				&& (player.getLocation().getBlock().getRelative(BlockFace.DOWN)
						.getType() != Material.AIR)) {
			player.setAllowFlight(true);
		}
	}
}