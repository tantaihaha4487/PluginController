package xyz.tantaihaha;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tantaihaha.Commands.confirmCommand;
import xyz.tantaihaha.Commands.tantaihahaCommand;
import xyz.tantaihaha.TabComplete.tantaihahaTabComplete;
import xyz.tantaihaha.engine.dowload;
import xyz.tantaihaha.task.ConfirmCommnadTask;

import java.io.IOException;

public class Main extends JavaPlugin {
    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        new dowload(this);

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("tantaihaha").setExecutor(new tantaihahaCommand());
        getCommand("tantaihaha").setTabCompleter(new tantaihahaTabComplete());
        getCommand("y").setExecutor(new confirmCommand(this));
        getCommand("n").setExecutor(new confirmCommand(this));
        new ConfirmCommnadTask(this);
        try {
            dowload.autoUpdateSelf();
        } catch (IOException e) {
            getLogger().info(ChatColor.RED + "Update PluginController Failed.·´¯`(>▂<)´¯`·. , Ignore it!");
        }
        checkTantaiHahaPlugin();
    }

    private static void checkTantaiHahaPlugin() {
        if (Bukkit.getPluginManager().getPlugin("LernPaper") != null) {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.AQUA + "LernPaper is Enable!");
        } else {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.RED + "LernPaper Not found!, /tantaihaha download <Plugin>, To Download");
        }
        if (Bukkit.getPluginManager().getPlugin("LernSpigot") != null) {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.AQUA + "LernSpigot is Enable!");
        } else {
            Bukkit.getLogger().info(ChatColor.GOLD + "[TantaiHaha] " + ChatColor.RED + "LernSpigot Not found!, /tantaihaha download <Plugin>, To Download");
        }
    }
}
