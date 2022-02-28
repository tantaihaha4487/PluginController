package xyz.tantaihaha.engine;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dowload {
    private static String LernSpigotURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern.jar";
    private static String LernPaperURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern-2.jar";
    private static String PluginControllerURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/PluginController.jar";

    public static void dowloadPlugin(@NotNull String web, @NotNull String FileName, @NotNull CommandSender sender) throws MalformedURLException {
        URL url = new URL(web);
        String path = "plugins/" + FileName + ".jar";
        try{
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            FileOutputStream stream = new FileOutputStream(path);
        } catch (Exception exception1) {
            sender.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Path or URL not found!");

        }
        try {
            sender.sendMessage(ChatColor.AQUA + "Dowload " + FileName + "..");
            BufferedInputStream bufferedInputStream = new  BufferedInputStream(url.openStream());
            FileOutputStream stream = new FileOutputStream(path);
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            double size = (double) con.getContentLengthLong();

            double download1 = 0.0D;
            int read = 0;
            byte[] bytes = new byte[1024];
            int save = 0;

            while((read = bufferedInputStream.read(bytes)) != -1) {
                download1 += (double)read;
                int percent = (int)(download1 * 100.0D / size);
                if (percent - save == 5) {
                    sender.sendMessage(ChatColor.GOLD + "Download: " + FileName + " " + ChatColor.GREEN + percent + "%");
                    save = percent;
                }
                stream.write(bytes, 0, read);
            }
            sender.sendMessage(ChatColor.GREEN + "Download " + FileName + " Done!");
        } catch (Exception exception) {
            sender.sendMessage(ChatColor.RED + "Error to " + FileName + " Download File!");
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
    public static void updateAll(CommandSender sender) {
        try {
            dowload.dowloadPlugin(LernSpigotURL, "Lern", sender);
            dowload.dowloadPlugin(LernPaperURL, "LernPaper", sender);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
