package team.teampotato.memorycleanermissnotoredict.forge.command;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import team.teampotato.memorycleanermissnotoredict.MCMODModClient;
import team.teampotato.memorycleanermissnotoredict.forge.forged.api.ClientCommandManager;
import team.teampotato.memorycleanermissnotoredict.forge.forged.api.ClientCommandRegistrationEvent;

public class ClientCommand {
    public static void registerClientCommand() {
        ClientCommandRegistrationEvent.EVENT.register((dispatcher, registryAccess) -> {
            ClientCommandManager.literal("mcmodclient")
                    .executes(context -> {
                        MinecraftClient.getInstance().execute(() -> {//
                            if (MinecraftClient.getInstance().player != null) {
                                MinecraftClient.getInstance().player.sendMessage(Text.translatable("memoryclearermissnotoredict.manualclear").formatted(Formatting.GREEN), false);
                            }
                        });
                        MCMODModClient.memoryClean();
                        return 1;
                    });
        });
    }
}
