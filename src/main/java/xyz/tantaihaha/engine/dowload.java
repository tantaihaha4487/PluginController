package xyz.tantaihaha.engine;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dowload {
    public static void dowloadFile(String web, String path, CommandSender sender) throws MalformedURLException {
        URL url = new URL(web);
        try{
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            FileOutputStream stream = new FileOutputStream(path);
        } catch (Exception exception1) {
            sender.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Path or URL not found!");

        }
        try {
            BufferedInputStream bufferedInputStream = new  BufferedInputStream(url.openStream());
            FileOutputStream stream = new FileOutputStream(path);

            int count = 0;
            byte[] bytes = new byte[1024];

            while((count = bufferedInputStream.read(bytes)) != -1) {
                sender.sendMessage(ChatColor.AQUA.toString() + count + ">> KB downloaded:" + new File(path).length()/1024);
                stream.write(bytes, 0, count);
            }
            sender.sendMessage(ChatColor.GREEN + "Download Done!");
        } catch (Exception exception) {
            sender.sendMessage(ChatColor.RED + "Error to Download File!");
            return;
        }
    }
    public static void autoUpdateSelf() throws IOException {
        BufferedInputStream bufferedInputStream = new  BufferedInputStream(new URL("https://github.com/tantaihaha4487/ReleaseFile/raw/main/PluginController.jar").openStream());
        FileOutputStream stream = new FileOutputStream("plugins/PluginController.jar");

        int count = 0;
        byte[] bytes = new byte[1024];

        while((count = bufferedInputStream.read(bytes)) != -1) {
            stream.write(bytes, 0, count);
        }
        Bukkit.getLogger().info(ChatColor.GREEN + "Update Done!");

    }
}
