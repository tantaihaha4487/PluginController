package xyz.tantaihaha.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tantaihaha.engine.dowload;

import java.net.MalformedURLException;

public class tantaihahaCoommand implements CommandExecutor {
    private String LernSpigotURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern.jar";
    private String LernPaperURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern-2.jar";
    private String PluginControllerURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/PluginController.jar";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("tantaihaha")) {
            if(args[0].equalsIgnoreCase("dowload")) {

                if(args[1].equalsIgnoreCase("LernSpigot")) {
                    sender.sendMessage("strat dowload LernSpigot.jar..");

                    try {
                        dowload.dowloadPlugin(LernSpigotURL, "Lern", sender);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                if(args[1].equalsIgnoreCase("LernPaper")) {
                    sender.sendMessage("strat dowload LernPaper.jar..");
                    try {
                        dowload.dowloadPlugin(LernPaperURL, "LernPaper", sender);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                if(args[1].equalsIgnoreCase("All")) {
                    sender.sendMessage("strat dowload All plugin..");
                    try {
                        dowload.dowloadPlugin(LernSpigotURL, "Lern", sender);
                        dowload.dowloadPlugin(LernPaperURL, "LernPaper", sender);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        return true;
    }

}
