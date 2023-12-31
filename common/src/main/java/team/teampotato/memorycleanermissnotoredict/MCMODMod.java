package team.teampotato.memorycleanermissnotoredict;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.teampotato.memorycleanermissnotoredict.util.ConfigUtil;

public class MCMODMod {
    public static final String MOD_NAME = "Memory Clearer Miss-not Ore Dict";
    public static final String MOD_ID = "memorycleanermissnotoredict";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final long clearTime = ConfigUtil.getConfig().cleanupInterval * 60 * 1000;
    
    public static void init() {
        LOGGER.info("[Memory Clearer Miss-not Ore Dict] Memory Clearer Miss-not Ore Dict is loaded!");
    }
}
