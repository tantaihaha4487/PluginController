package xyz.tantaihaha.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class checkInfo {
    private static final File path = new File("data/info.json");

    public static class getInfo{
        public static String getLastUpdate() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("info");
            Object dateObj = new JsonParser().parse(info.toString());
            JsonObject dateJsonObj = (JsonObject) dateObj;

            return dateJsonObj.get("last-update").getAsString();
        }
    }

    private static class getLernPaper{
        public static String getLastUpdate() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernPaper");
            Object dateObj = new JsonParser().parse(info.toString());
            JsonObject dateJsonObj = (JsonObject) dateObj;

            return dateJsonObj.get("last-update").getAsString();
        }
        public static String getFileName() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernPaper");
            Object fileObj = new JsonParser().parse(info.toString());
            JsonObject fileJsonObj = (JsonObject) fileObj;

            return fileJsonObj.get("file-name").getAsString();
        }
        public static String getMinecraftVersion() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernPaper");
            Object verObj = new JsonParser().parse(info.toString());
            JsonObject verJsonObj = (JsonObject) verObj;

            return verJsonObj.get("mc-ver").getAsString();
        }
        public static URL getURL() throws FileNotFoundException, MalformedURLException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernPaper");
            Object urlObj = new JsonParser().parse(info.toString());
            JsonObject urlJsonObj = (JsonObject) urlObj;
            String urlStr = urlJsonObj.get("url").getAsString();

            return new URL(urlStr);
        }
    }
    private static class getLernSpigot{
        public static String getLastUpdate() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernSpigot");
            Object dateObj = new JsonParser().parse(info.toString());
            JsonObject dateJsonObj = (JsonObject) dateObj;

            return dateJsonObj.get("last-update").getAsString();
        }
        public static String getFileName() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernSpigot");
            Object fileObj = new JsonParser().parse(info.toString());
            JsonObject fileJsonObj = (JsonObject) fileObj;

            return fileJsonObj.get("file-name").getAsString();
        }
        public static String getMinecraftVersion() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernSpigot");
            Object verObj = new JsonParser().parse(info.toString());
            JsonObject verJsonObj = (JsonObject) verObj;

            return verJsonObj.get("mc-ver").getAsString();
        }
        public static URL getURL() throws FileNotFoundException, MalformedURLException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("LernSpigot");
            Object urlObj = new JsonParser().parse(info.toString());
            JsonObject urlJsonObj = (JsonObject) urlObj;
            String urlStr = urlJsonObj.get("url").getAsString();

            return new URL(urlStr);
        }
    }

    private static class getPluginController{
        public static String getLastUpdate() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("PluginController");
            Object dateObj = new JsonParser().parse(info.toString());
            JsonObject dateJsonObj = (JsonObject) dateObj;

            return dateJsonObj.get("last-update").getAsString();
        }
        public static String getFileName() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("PluginController");
            Object fileObj = new JsonParser().parse(info.toString());
            JsonObject fileJsonObj = (JsonObject) fileObj;

            return fileJsonObj.get("file-name").getAsString();
        }
        public static String getMinecraftVersion() throws FileNotFoundException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("PluginController");
            Object verObj = new JsonParser().parse(info.toString());
            JsonObject verJsonObj = (JsonObject) verObj;

            return verJsonObj.get("mc-ver").getAsString();
        }
        public static URL getURL() throws FileNotFoundException, MalformedURLException {
            Object infoObj = new JsonParser().parse(new FileReader(path));
            JsonObject infoJsonObj = (JsonObject) infoObj;
            JsonElement info = infoJsonObj.get("PluginController");
            Object urlObj = new JsonParser().parse(info.toString());
            JsonObject urlJsonObj = (JsonObject) urlObj;
            String urlStr = urlJsonObj.get("url").getAsString();


            return new URL(urlStr);
        }
    }

}