package me.kinggeert.magicwands.magic_wands;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class spells {

    static Plugin plugin = Magic_wands.getPlugin();

    public static void spells(Player player) {
        ItemStack wand = player.getInventory().getItemInMainHand();
        Integer spell = getSpell(wand);

        if (spell == 1){
            Entity arrow = player.getWorld().spawn(player.getEyeLocation().add(player.getLocation().getDirection().multiply(1)), Arrow.class);
                NamespacedKey key = new NamespacedKey(plugin, "fireball");
                arrow.setVelocity(player.getLocation().getDirection().multiply(5));
                arrow.setGravity(false);
                PersistentDataContainer data = arrow.getPersistentDataContainer();
                data.set(key, PersistentDataType.INTEGER, 1);
            ((Arrow)arrow).setDamage(0);
        }

        else if (spell == 2) {
            player.sendMessage("explosion wave");
        }
    }



    public static Integer getSpell(ItemStack item) {
        NamespacedKey key = new NamespacedKey(plugin, "70");
        PersistentDataContainer data = item.getItemMeta().getPersistentDataContainer();
        if (!data.has(key, PersistentDataType.INTEGER)) {
            data.set(key, PersistentDataType.INTEGER, 0);
        }
        return data.get(key, PersistentDataType.INTEGER);
    }
}
