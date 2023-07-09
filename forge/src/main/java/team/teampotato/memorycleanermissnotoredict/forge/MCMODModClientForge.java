package team.teampotato.memorycleanermissnotoredict.forge;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;
import team.teampotato.memorycleanermissnotoredict.config.ConfigUtil;
import team.teampotato.memorycleanermissnotoredict.forge.command.ClientCommand;

public class MCMODModClientForge {
    public static void onInitializeClient(FMLClientSetupEvent event) {
        MCMODModClient.initClient();
        if (ConfigUtil.getConfig().enableCommand) {
            ClientCommand.registerClientCommand();
        }
    }
}
