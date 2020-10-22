package me.kinggeert.magicwands.magic_wands;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;


public final class Magic_wands extends JavaPlugin {



    @Override
    public void onEnable() {
        runnable();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void runnable() {
        new BukkitRunnable() {

            @Override
            public void run() {
                Bukkit.broadcastMessage("test");

            }
        }.runTaskTimerAsynchronously(this, 0, 20);
    }
}
