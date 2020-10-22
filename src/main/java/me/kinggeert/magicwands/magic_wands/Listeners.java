package me.kinggeert.magicwands.magic_wands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class Listeners implements Listener {

    Plugin plugin = Magic_wands.getPlugin();
    Integer timer = null;

    @EventHandler()
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NamespacedKey key = new NamespacedKey(plugin, "70");
        Glow glow = new Glow(key);
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(glow)) {
                player.sendMessage("right click");
            }
        }
        if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(glow)) {
                player.sendMessage("left click");
            }
        }
    }
}
