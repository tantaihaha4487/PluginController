package xyz.tantaihaha.Commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.tantaihaha.engine.download;
import xyz.tantaihaha.task.ConfirmCommnadTask;

import java.net.MalformedURLException;

public class tantaihahaCommand implements CommandExecutor {
    private final String LernSpigotURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern.jar";
    private final String LernPaperURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern-2.jar";
    private final String PluginControllerURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/PluginController.jar";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("tantaihaha")) {
            if(args[0].equalsIgnoreCase("download")) {

                if(args[1].equalsIgnoreCase("LernSpigot")) {
                    sender.sendMessage("start download LernSpigot.jar..");

                    try {
                        download.downloadPlugin(LernSpigotURL, "Lern", sender);
                        confirmReloadButton(sender);
                        ConfirmCommnadTask.removeTask(sender);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                if(args[1].equalsIgnoreCase("LernPaper")) {
                    sender.sendMessage("start download LernPaper.jar..");
                    try {
                        download.downloadPlugin(LernPaperURL, "LernPaper", sender);
                        confirmReloadButton(sender);
                        ConfirmCommnadTask.removeTask(sender);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                if(args[1].equalsIgnoreCase("All")) {
                    sender.sendMessage("start download All plugin..");
                    try {
                        download.updateAll(sender);
                        confirmReloadButton(sender);
                        ConfirmCommnadTask.removeTask(sender);
                    } catch (Exception exception2) {
                        exception2.printStackTrace();
                    }

                }
            }
            if(args[0].equalsIgnoreCase("reload")) {
                Player p = (Player) sender;
                if(!p.isOp()) {p.sendMessage(ChatColor.RED + "You aren't admin!");
                return true;
                }
                else {
                    Bukkit.getServer().reload();
                    sender.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + "Reload Complete!");}
            }
            if(args[0].equalsIgnoreCase("noreload")) {
                Player p = (Player) sender;
                if(!p.isOp()) {p.sendMessage(ChatColor.RED + "You aren't admin!");
                    return true;
                }

                else {sender.sendMessage(ChatColor.GOLD + "Cancel Reload Complete!");}
            }
        }
        return true;
    }
    public void confirmReloadButton(CommandSender sender) {
        int senderType;
        if(!(sender instanceof Player)) {senderType = 0;}
        else {senderType = 1;}
        switch (senderType) {
            case 0:
                sender.sendMessage(ChatColor.AQUA + "Do you want to reload? (y:n)");
                ConfirmCommnadTask.taskManager.replace("Run", 1);
                break;
            case 1:
                Player p = (Player) sender;
                if(!p.isOp()) {p.sendMessage(ChatColor.RED + "You aren't admin!");
                    return;
                }
                p.sendMessage(ChatColor.AQUA + "Do you want to reload?");
                TextComponent yes = new TextComponent(ChatColor.GREEN + "[Yes]");
                yes.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tantaihaha reload"));
                TextComponent no = new TextComponent(ChatColor.RED.toString() + ChatColor.BOLD + "[No]");
                no.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tantaihaha noreload"));
                p.sendMessage(yes);
                p.sendMessage(no);
                break;
            default: {
                sender.sendMessage(ChatColor.AQUA + "Do you want to reload? (y:n)");
                ConfirmCommnadTask.taskManager.replace("Run", 1);
            }
        }
    }
}
