package team.teampotato.memorycleanermissnotoredict.fabric;

import net.fabricmc.api.ClientModInitializer;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;
import team.teampotato.memorycleanermissnotoredict.fabric.command.ClientCommand;

public class MCMODModClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MCMODModClient.initClient();
        ClientCommand.registerClientCommand();
    }
}
