package team.teampotato.memorycleanermissnotoredict.util;

import dev.architectury.platform.Platform;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import team.teampotato.memorycleanermissnotoredict.MCMODMod;
import team.teampotato.memorycleanermissnotoredict.config.ModConfigScreen;

public class ConfigUtil {
    public static ModConfigScreen configScreen;

    public static ModConfigScreen getConfig() {
        if (configScreen == null) {
            AutoConfig.register(ModConfigScreen.class, GsonConfigSerializer::new);
            configScreen = AutoConfig.getConfigHolder(ModConfigScreen.class).getConfig();
        }
        return configScreen;
    }

    public static void setConfigScreen() {
        Platform.getMod(MCMODMod.MOD_ID).registerConfigurationScreen(parent -> AutoConfig.getConfigScreen(ModConfigScreen.class, parent).get());
    }
}
