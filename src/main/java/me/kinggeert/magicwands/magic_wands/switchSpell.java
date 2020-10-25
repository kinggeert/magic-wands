package me.kinggeert.magicwands.magic_wands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

public class switchSpell {

    static Plugin plugin = Magic_wands.getPlugin();
    static Integer spell;

    public static void Switch(Player player) {
        NamespacedKey key = new NamespacedKey(plugin, "70");
        Glow glow = new Glow(key);
        ItemStack wand = player.getInventory().getItemInMainHand();
        spell = spells.getSpell(wand);

        if (spell == 0) {
            String name = "fireball";
            ItemMeta meta = wand.getItemMeta();
            setSpell(meta, 1);
            meta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + name));
            player.sendMessage("Selected spell: " + name);
            wand.setItemMeta(meta);
        }
        else if (spell == 1) {
            String name = "explosion wave";
            ItemMeta meta = wand.getItemMeta();
            setSpell(meta, 2);
            meta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + name));
            player.sendMessage("Selected spell: " + name);
            wand.setItemMeta(meta);
        }
        else if (spell == 2) {
            String name = "fireball";
            ItemMeta meta = wand.getItemMeta();
            setSpell(meta, 1);
            meta.setLore(Collections.singletonList(ChatColor.AQUA + name));
            player.sendMessage("selected spell: " + name);
            wand.setItemMeta(meta);
        }
    }

    public static void setSpell(ItemMeta meta, Integer spell) {
        NamespacedKey key = new NamespacedKey(plugin, "70");
        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(key, PersistentDataType.INTEGER, spell);
    }
}
