package xyz.tantaihaha.engine;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.tantaihaha.Main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class download {
    private static Main plugin;
    private static final String LernSpigotURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern.jar";
    private static final String LernPaperURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/Lern-2.jar";
    private static final String PluginControllerURL = "https://github.com/tantaihaha4487/ReleaseFile/raw/main/PluginController.jar";
    private static final String infoURl =  "https://raw.githubusercontent.com/tantaihaha4487/ReleaseFile/main/info.json";
    public download(Main plugin) {
        download.plugin = plugin;}

    public static void download(@NotNull String path, @NotNull String FileName, @NotNull URL url, Boolean ShowPercent, CommandSender sender) {
        File file = new File(path + FileName);
        /*Process Here*/
    }
    public static void downloadPlugin(@NotNull String web, @NotNull String FileName, @NotNull CommandSender sender) throws MalformedURLException {
        URL url = new URL(web);
        String path = "plugins/" + FileName + ".jar";
        try {
            sender.sendMessage(ChatColor.AQUA + "Download " + FileName + "..");
            BufferedInputStream bufferedInputStream = new  BufferedInputStream(url.openStream());
            FileOutputStream stream = new FileOutputStream(path);
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            double size = (double) con.getContentLengthLong();

            double download1 = 0.0D;
            int read = 0;
            byte[] bytes = new byte[1024];
            int save = 0;

            while((read = bufferedInputStream.read(bytes)) != -1) {
                download1 += read;
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
        }
    }
    public static void autoUpdateSelf() throws IOException {
        if(plugin.getConfig().getBoolean("auto-update-controller")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(PluginControllerURL).openStream());
            FileOutputStream stream = new FileOutputStream("plugins/PluginController.jar");

            int count;
            byte[] bytes = new byte[1024];

            while ((count = bufferedInputStream.read(bytes)) != -1) {
                stream.write(bytes, 0, count);
            }
            Bukkit.getLogger().info(ChatColor.AQUA + "[PluginController] " + ChatColor.GREEN +"Update Done!");
        }
        else {
            Bukkit.getLogger().info(ChatColor.AQUA + "[PluginController] Auto Update is " + ChatColor.RED +"Disable");
        }
    }
    public static void updateAll(CommandSender sender) {
        try {
            download.downloadPlugin(LernSpigotURL, "Lern", sender);
            download.downloadPlugin(LernPaperURL, "LernPaper", sender);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
