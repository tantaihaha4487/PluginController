package xyz.tantaihaha.TabComplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class tantaihahaTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tantaihaha")) {
            if (args.length == 1) {
                List<String> Argument1 = new ArrayList<>();
                Argument1.add("download");
                return Argument1;
            }
            if(args[0].equalsIgnoreCase("download")) {
                if (args[1].length() == 0) {
                    List<String> Argument2 = new ArrayList<>();
                    Argument2.add("LernSpigot");
                    Argument2.add("LernPaper");
                    Argument2.add("All");
                    return Argument2;
                }
            }
            else {return null;}
        }
        return null;
    }
}
