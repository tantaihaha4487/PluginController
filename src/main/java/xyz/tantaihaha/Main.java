package xyz.tantaihaha;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tantaihaha.Commands.tantaihahaCommand;
import xyz.tantaihaha.TabComplete.tantaihahaTabComplete;
import xyz.tantaihaha.engine.dowload;
import xyz.tantaihaha.task.ConfirmCommnadTask;

import java.io.IOException;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("tantaihaha").setExecutor(new tantaihahaCommand());
        getCommand("tantaihaha").setTabCompleter(new tantaihahaTabComplete());
        new ConfirmCommnadTask(this);
        try {
            dowload.autoUpdateSelf();
        } catch (IOException e) {
            getLogger().info(ChatColor.RED + "Update PluginController Failed.·´¯`(>▂<)´¯`·. , Ignore it!");
        }
    }
}
