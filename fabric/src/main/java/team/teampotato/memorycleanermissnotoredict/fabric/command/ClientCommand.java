package team.teampotato.memorycleanermissnotoredict.fabric.command;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import team.teampotato.memorycleanermissnotoredict.MCMODModClient;

public class ClientCommand {
    public static void registerClientCommand() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
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
