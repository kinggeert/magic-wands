package me.kinggeert.magicwands.magic_wands;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class Listeners implements Listener {

    Plugin plugin = Magic_wands.getPlugin();
    Long timer = 1L;

    @EventHandler()
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NamespacedKey key = new NamespacedKey(plugin, "70");
        if (player.getInventory().getItemInMainHand() == null) {
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER)) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                if (timer < System.currentTimeMillis()) {
                    timer = System.currentTimeMillis() + 10;
                    switchSpell.Switch(player);
                }
            }
            if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR) {
                if (timer < System.currentTimeMillis()) {
                    timer = System.currentTimeMillis() + 10;
                    spells.spells(player);
                }
            }
        }
    }

    @EventHandler()
    public void onProjectileHit(ProjectileHitEvent event) {
        Entity arrow = event.getEntity();
        if (arrow.getType() == EntityType.ARROW) {
            NamespacedKey key = new NamespacedKey(plugin, "fireball");
            if (arrow.getPersistentDataContainer().has(key, PersistentDataType.INTEGER)) {
                arrow.getWorld().createExplosion(arrow.getLocation(), 5);
//                Bukkit.getServer().getPluginManager().callEvent(EntityExplodeEvent, );
                arrow.getWorld().spawnParticle(Particle.FLAME, arrow.getLocation(), 200);
                arrow.getWorld().spawnParticle(Particle.LAVA, arrow.getLocation(), 20);
                arrow.remove();
            }
        }
    }
}
