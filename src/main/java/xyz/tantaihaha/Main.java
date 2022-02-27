package xyz.tantaihaha;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.tantaihaha.Commands.tantaihahaCoommand;
import xyz.tantaihaha.TabComplete.tantaihahaTabComplete;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("tantaihaha").setExecutor(new tantaihahaCoommand());
        getCommand("tantaihaha").setTabCompleter(new tantaihahaTabComplete());

    }
}
