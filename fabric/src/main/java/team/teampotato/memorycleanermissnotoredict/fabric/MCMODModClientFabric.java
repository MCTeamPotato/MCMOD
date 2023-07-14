package team.teampotato.memorycleanermissnotoredict.fabric;

import net.fabricmc.api.ClientModInitializer;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;

public class MCMODModClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MCMODModClient.initClient();
        EventHandlerImpl.registerClient();
    }
}
