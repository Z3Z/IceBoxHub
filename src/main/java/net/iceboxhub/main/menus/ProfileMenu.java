package net.iceboxhub.main.menus;

import net.iceboxhub.main.IceBoxHub;
import net.iceboxhub.main.utils.SimpleUtils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ProfileMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private IceBoxHub plugin;
	public ProfileMenu(IceBoxHub listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player player){
		inv = Bukkit.createInventory(null, 45, SimpleUtils.color("&b&lProfile Menu"));
		Border();
		
		player.openInventory(inv);
	}
	
	public static void Border(){
		ItemStack border = SimpleUtils.createItem(Material.STAINED_GLASS_PANE, 1, 15, SimpleUtils.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		if(event.getInventory().getName().equals(SimpleUtils.color("&b&lProfile Menu"))){
			event.setCancelled(true);
			if(event.getWhoClicked() instanceof Player){
				if(!(event.getInventory() == null)){
					if(!(event.getCurrentItem() == null)){
						if(!(event.getCurrentItem().getType() == Material.AIR)){
							
							
							if(event.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(event.getCurrentItem().getItemMeta().getDisplayName().equals(SimpleUtils.color(" "))){
									event.setCancelled(true);
									player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
						}else{
							event.setCancelled(true);
							player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
						}
					}else{
						event.setCancelled(true);
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
					}
				}else{
					event.setCancelled(true);
				}
			}else{
				event.setCancelled(true);
			}
		}
	}

}