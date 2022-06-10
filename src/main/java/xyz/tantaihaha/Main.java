package xyz.tantaihaha;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tantaihaha.Commands.confirmCommand;
import xyz.tantaihaha.Commands.tantaihahaCommand;
import xyz.tantaihaha.TabComplete.tantaihahaTabComplete;
import xyz.tantaihaha.engine.PluginCheck;
import xyz.tantaihaha.engine.dowload;
import xyz.tantaihaha.task.ConfirmCommnadTask;
import xyz.tantaihaha.utils.Info;

import java.io.FileNotFoundException;
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
            dowload.dowloadInfo();

        } catch (IOException e) {
            getLogger().info(ChatColor.RED + "Update PluginController Failed .·´¯`(>_<)´¯`·. , Ignore it!");
        }
        PluginCheck.checkTantaiHahaPlugin();
    }


}
