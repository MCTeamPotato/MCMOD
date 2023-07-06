package team.teampotato.memorycleanermissnotoredict.fabric;

import net.fabricmc.api.DedicatedServerModInitializer;

import team.teampotato.memorycleanermissnotoredict.MCMODModServer;

public class MCMODModServerFabric implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        MCMODModServer.initServer();
    }
}
