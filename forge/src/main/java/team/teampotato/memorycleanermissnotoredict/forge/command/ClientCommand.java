package team.teampotato.memorycleanermissnotoredict.forge.command;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;
import team.teampotato.memorycleanermissnotoredict.forge.forged.api.ClientCommandManager;

public class ClientCommand {
    public static void registerClientCommand() {
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("mcmodclient")
                .executes(context -> {
                    MinecraftClient.getInstance().execute(() -> {//
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
