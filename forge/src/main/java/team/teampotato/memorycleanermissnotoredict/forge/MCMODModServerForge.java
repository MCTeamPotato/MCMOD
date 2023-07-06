package team.teampotato.memorycleanermissnotoredict.forge;

import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import team.teampotato.memorycleanermissnotoredict.MCMODModServer;

public class MCMODModServerForge {
    public static void onInitializeServer(FMLDedicatedServerSetupEvent event) {
        MCMODModServer.initServer();
    }
}
