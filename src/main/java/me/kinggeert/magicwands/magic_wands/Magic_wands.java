package me.kinggeert.magicwands.magic_wands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public final class Magic_wands extends JavaPlugin {



    @Override
    public void onEnable() {
        runnable();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("getwand")) {
            if (sender instanceof Player) {
                ItemStack item = new ItemStack(Material.BLAZE_ROD);
                ((Player) sender).getInventory().addItem(item);
            }
        }
        return super.onCommand(sender, command, label, args);
    }
}
