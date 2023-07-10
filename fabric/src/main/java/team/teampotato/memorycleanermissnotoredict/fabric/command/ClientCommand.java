package team.teampotato.memorycleanermissnotoredict.fabric.command;

import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;

public class ClientCommand {
    public static void registerClientCommand() {
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("mcmodclient")
                .executes(context -> {
                    MinecraftClient.getInstance().execute(() -> {
                        if (MinecraftClient.getInstance().player != null) {
                            MinecraftClient.getInstance().player.sendMessage(new TranslatableText("memoryclearermissnotoredict.manualclear").formatted(Formatting.GREEN), false);
                        }
                    });
                    MCMODModClient.memoryClean();
                    return 1;
                })
        );
    }
}
