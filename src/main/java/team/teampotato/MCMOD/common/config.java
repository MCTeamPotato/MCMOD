package team.teampotato.MCMOD.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.fabricmc.api.ModInitializer;
import team.teampotato.MCMOD.MCMOD;
import net.fabricmc.loader.api.FabricLoader;

public class config implements ModInitializer {
    @Override
    public void onInitialize() {
        Registry();
    }

    public static boolean autoClear;
    public static long clearTime;
    public static boolean command;
    public static final String JSON = "config.json";


    public static void Registry() {
        File configFolder = new File(FabricLoader.getInstance().getConfigDir().toFile(), MCMOD.MOD_NAME);
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }

        File configFile = new File(configFolder, JSON);
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
                autoClear = getBooleanOrDefault(config, "AutoClear");
                command = getBooleanOrDefault(config, "command");
                clearTime = getLongOrDefault(config, "ClearTime");
            } catch (IOException e) {
                e.printStackTrace();
                MCMOD.LOGGER.error("Failed to load configuration file: " + e.getMessage());
            }
        } else {
            try {
                MCMOD.LOGGER.info("Generating configuration file...");
                configFile.createNewFile();
                JsonObject config = new JsonObject();
                config.addProperty("AutoClear", true);
                config.addProperty("command", true);
                config.addProperty("ClearTime", 8);

                try (FileWriter writer = new FileWriter(configFile)) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    writer.write(gson.toJson(config));
                }
            } catch (IOException e) {
                e.printStackTrace();
                MCMOD.LOGGER.info("Error generating configuration file: " + e.getMessage());
            }
        }
    }

    private static boolean getBooleanOrDefault(JsonObject obj, String key) {
        if (obj.has(key)) {
            try {
                return obj.get(key).getAsBoolean();
            } catch (Exception e) {
                MCMOD.LOGGER.error("GetConfigError " + e);
                // 异常处理，比如记录日志或返回默认值
            }
        }
        return true; // 默认返回值
    }


    private static long getLongOrDefault(JsonObject obj, String key) {
        return obj.has(key) ? obj.get(key).getAsLong() : (long) 8;
    }

}
