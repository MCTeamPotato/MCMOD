package team.teampotato.memorycleanermissnotoredict.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import team.teampotato.memorycleanermissnotoredict.MCMODMod;

@Config(name = MCMODMod.MOD_ID)
public class ModConfigScreen implements ConfigData {
    public boolean autoCleanMemory = true;
    public boolean enableCommand = true;
    public long cleanupInterval = 8;
}
