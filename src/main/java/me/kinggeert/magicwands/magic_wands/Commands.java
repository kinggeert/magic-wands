package me.kinggeert.magicwands.magic_wands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

public class Commands implements CommandExecutor {

    Plugin plugin = Magic_wands.getPlugin();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("getwand")) {
            if (sender instanceof Player) {
                NamespacedKey key = new NamespacedKey(plugin, "70");
                Glow glow = new Glow(key);
                ItemStack item = new ItemStack(Material.BLAZE_ROD);
                ItemMeta meta = item.getItemMeta();
                meta.addEnchant(glow, 0, true);
                meta.setDisplayName(ChatColor.DARK_PURPLE + "Magic Wand");
                meta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "No spell selected"));
                item.setItemMeta(meta);
                ((Player) sender).getInventory().addItem(item);
                sender.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "'oops' said a god 'I droppen my wand'");
                return true;
            }
            sender.sendMessage("This command is player only.");
        }
    return false;
    }
}
