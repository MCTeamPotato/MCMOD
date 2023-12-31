package team.teampotato.memorycleanermissnotoredict.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import team.teampotato.memorycleanermissnotoredict.MCMODMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import team.teampotato.memorycleanermissnotoredict.forge.event.EventHandlerClientImpl;

@Mod(MCMODMod.MOD_ID)
public class MCMODModForge {
    public MCMODModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MCMODMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        IEventBus modEventBus = EventBuses.getModEventBus(MCMODMod.MOD_ID).get();

        modEventBus.addListener(this::onInitialize);
        modEventBus.addListener(MCMODModClientForge::onInitializeClient);
        modEventBus.addListener(MCMODModServerForge::onInitializeServer);

        MinecraftForge.EVENT_BUS.register(EventHandlerClientImpl.class);
    }

    public void onInitialize(FMLCommonSetupEvent event) {
        MCMODMod.init();
    }
}
