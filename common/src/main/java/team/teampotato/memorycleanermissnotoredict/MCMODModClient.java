package team.teampotato.memorycleanermissnotoredict;

import team.teampotato.memorycleanermissnotoredict.command.ClientCommand;
import team.teampotato.memorycleanermissnotoredict.util.ConfigUtil;
import team.teampotato.memorycleanermissnotoredict.util.CleanMemoryUtil;

public class MCMODModClient {
    public static void initClient() {
        MCMODMod.LOGGER.info(MCMODMod.MOD_NAME + " Running on client");
        ConfigUtil.setConfigScreen();
        CleanMemoryUtil.autoCleanMemory();
        ClientCommand.registerClientCommand();
    }
}
