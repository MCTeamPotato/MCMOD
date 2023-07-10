package team.teampotato.memorycleanermissnotoredict.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import team.teampotato.memorycleanermissnotoredict.MCMODMod;

@Config(name = MCMODMod.MOD_ID)
public class ModConfigScreen implements ConfigData {

    @Comment("Whether to enable countdown auto-clean")
    @ConfigEntry.Gui.Tooltip
    public boolean autoCleanMemory = true;

    @Comment("Whether to enable the client manual cleanup command")
    @ConfigEntry.Gui.Tooltip
    public boolean enableCommand = true;

    @Comment("Clear interval time in minutes (default is 8)")
    @ConfigEntry.Gui.Tooltip
    public long cleanupInterval = 8;
}
