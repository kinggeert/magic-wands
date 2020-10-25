package me.kinggeert.magicwands.magic_wands;

import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTick extends BukkitRunnable {

   Plugin plugin = Magic_wands.getPlugin();

   @Override
   public void run() {
      for (World world: plugin.getServer().getWorlds()) {
         for (Entity arrow: world.getEntities()) {
            if (arrow.getType() == EntityType.ARROW) {
               PersistentDataContainer data = arrow.getPersistentDataContainer();
               NamespacedKey key = new NamespacedKey(plugin, "fireball");
               if (data.has(key, PersistentDataType.INTEGER)) {
                  world.spawnParticle(Particle.LAVA, arrow.getLocation(), 3);
               }
            }
         }
      }
   }
}
