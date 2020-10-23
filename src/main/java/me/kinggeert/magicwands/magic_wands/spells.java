package me.kinggeert.magicwands.magic_wands;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class spells {

    static Plugin plugin = Magic_wands.getPlugin();

    public static Integer getSpell(ItemStack item) {
        NamespacedKey key = new NamespacedKey(plugin, "70");
        PersistentDataContainer data = item.getItemMeta().getPersistentDataContainer();
        if (!data.has(key, PersistentDataType.INTEGER)) {
            data.set(key, PersistentDataType.INTEGER, 0);
        }
        return data.get(key, PersistentDataType.INTEGER);
    }
}
