package xyz.tantaihaha.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import xyz.tantaihaha.utils.pluginList;

public class PluginCheck {
    public static void checkTantaiHahaPlugin() {
        if (pluginList.getLernPapaer() != null) {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.AQUA + "LernPaper is Enable!");
        } else {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.RED + "LernPaper Not found!, /tantaihaha download <Plugin>, To Download");
        }
        if (pluginList.getLernSpgot() != null) {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.AQUA + "LernSpigot is Enable!");
        } else {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.RED + "LernSpigot Not found!, /tantaihaha download <Plugin>, To Download");
        }
    }
}
