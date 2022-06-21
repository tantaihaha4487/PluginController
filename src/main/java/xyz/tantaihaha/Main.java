package xyz.tantaihaha;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tantaihaha.Commands.confirmCommand;
import xyz.tantaihaha.Commands.tantaihahaCommand;
import xyz.tantaihaha.TabComplete.tantaihahaTabComplete;
import xyz.tantaihaha.utils.PluginCheck;
import xyz.tantaihaha.engine.download;
import xyz.tantaihaha.task.ConfirmCommnadTask;

import java.io.IOException;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new download(this);

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //Plugin Check
        PluginCheck.checkTantaiHahaPlugin();

        getCommand("tantaihaha").setExecutor(new tantaihahaCommand());
        getCommand("tantaihaha").setTabCompleter(new tantaihahaTabComplete());
        getCommand("y").setExecutor(new confirmCommand(this));
        getCommand("n").setExecutor(new confirmCommand(this));
        new ConfirmCommnadTask(this);
        try {
            download.autoUpdateSelf();

        } catch (IOException e) {
            getLogger().info(ChatColor.RED + "Update PluginController Failed .·´¯`(>_<)´¯`·. , Ignore it!");
        }
    }


}
