package team.teampotato.memorycleanermissnotoredict.fabric;

import team.teampotato.memorycleanermissnotoredict.MCMODMod;
import net.fabricmc.api.ModInitializer;

public class MCMODModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MCMODMod.init();
    }
}
