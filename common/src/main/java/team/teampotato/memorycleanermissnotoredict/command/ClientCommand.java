package team.teampotato.memorycleanermissnotoredict.command;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import team.teampotato.memorycleanermissnotoredict.util.ConfigUtil;
import team.teampotato.memorycleanermissnotoredict.event.ClientCommandRegistrationEvent;
import team.teampotato.memorycleanermissnotoredict.util.CleanMemoryUtil;

public class ClientCommand {
    public static void registerClientCommand() {
        ClientCommandRegistrationEvent.EVENT.register((dispatcher) -> {
            ClientCommandRegistrationEvent.literal("mcmodclient").executes(context -> {
                if (ConfigUtil.getConfig().enableCommand) {
                    context.getSource().arch$sendSuccess(Text.translatable("memoryclearermissnotoredict.manualclear").formatted(Formatting.GREEN), false);
                    CleanMemoryUtil.memoryClean();
                }
                return 0;
            });
        });
    }
}
