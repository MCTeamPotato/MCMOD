package team.teampotato.memorycleanermissnotoredict.forge;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;

public class MCMODModClientForge {
    public static void onInitializeClient(FMLClientSetupEvent event) {
        MCMODModClient.initClient();
    }
}
