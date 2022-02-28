package xyz.tantaihaha;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tantaihaha.Commands.tantaihahaCoommand;
import xyz.tantaihaha.TabComplete.tantaihahaTabComplete;
import xyz.tantaihaha.engine.dowload;

import java.io.IOException;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("tantaihaha").setExecutor(new tantaihahaCoommand());
        getCommand("tantaihaha").setTabCompleter(new tantaihahaTabComplete());
        ///UpdateLogic
        try {
            dowload.autoUpdateSelf();
        } catch (IOException e) {
            getLogger().info(ChatColor.RED + "Update PluginController Failed.·´¯`(>▂<)´¯`·. , Ignore it!");
        }
    }
}
