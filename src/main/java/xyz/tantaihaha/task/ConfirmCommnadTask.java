package xyz.tantaihaha.task;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.tantaihaha.Main;

import java.util.HashMap;

public class ConfirmCommnadTask {
    private static Main plugin;
    public static HashMap<String, Integer> taskManager = new HashMap<>();//Key:"Run", Values:Disable = 0, Enable = 1

    public ConfirmCommnadTask(Main plugin) {
        ConfirmCommnadTask.plugin = plugin;
        taskManager.put("Run", 0);
    }
    public static void removeTask(CommandSender sender) {
        int sec = 15;
        BukkitScheduler sh = plugin.getServer().getScheduler();
        sh.runTaskLater(plugin, () -> {
            if(taskManager.get("Run").equals(1)) {
                sender.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "[TIME OUT]!");
                taskManager.replace("Run", 0);
            }
        }, sec * 20);
    }
}
