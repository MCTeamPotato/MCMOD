package team.teampotato.MCMOD.client;


import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class CommandClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        command();
    }

    public static void command() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            ClientCommandManager.literal("mcmodclient")
                    .executes(context -> {
                        MinecraftClient.getInstance().execute(() -> {//
                            if (MinecraftClient.getInstance().player != null) {
                                MinecraftClient.getInstance().player.sendMessage(Text.translatable("memoryclearermissnotoredict.manualclear").formatted(Formatting.GREEN), false);
                            }
                        });
                        MemoryClearClient.MCMOD();
                        return 1;
                    });
        });

    }
}
