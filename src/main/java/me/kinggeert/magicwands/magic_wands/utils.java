package me.kinggeert.magicwands.magic_wands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class utils {

    static Plugin plugin = Magic_wands.getPlugin();

    public static Location relativeCoord(Player player, Double x, Double y, Double z) {
        Location location = player.getLocation();
        Vector vector = new Vector(x, y, z);
        double length = vector.length();
        vector = vector.add(player.getLocation().toVector());
        length = length/vector.length();
        double rx = location.getBlockX() + vector.getBlockX()*length;
        double ry = location.getBlockY() + vector.getBlockY()*length;
        double rz = location.getBlockZ() + vector.getBlockZ()*length;
        return new Location(player.getWorld(), rx, ry, rz );
    }
}
