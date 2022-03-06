package xyz.tantaihaha.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tantaihaha.Main;
import xyz.tantaihaha.task.ConfirmCommnadTask;

public class confirmCommand implements CommandExecutor{

    private Main plugin;


    public confirmCommand(Main plugin) {
        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("y")) {
            if(ConfirmCommnadTask.taskManager.get("Run").equals(1)) {
                Bukkit.getServer().reload();
                sender.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + "Reload Complete!");
                ConfirmCommnadTask.taskManager.replace("Run", 0);
            }
            else {sender.sendMessage(ChatColor.RED + "Use after Download only!");}
        }
        if(cmd.getName().equalsIgnoreCase("n")) {
            if(ConfirmCommnadTask.taskManager.get("Run").equals(1)) {
                sender.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + "Reload Complete!");
                ConfirmCommnadTask.taskManager.replace("Run", 0);
            }
            else {sender.sendMessage(ChatColor.RED + "Use after Download only!");}
        }
        return true;
    }
}
