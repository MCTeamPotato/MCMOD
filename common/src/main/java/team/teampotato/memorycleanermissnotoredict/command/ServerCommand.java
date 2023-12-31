package team.teampotato.memorycleanermissnotoredict.command;

import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ServerCommand {
    public static void registerServerCommand() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("mcmodserver").executes(context -> {
                        System.gc();
                        context.getSource().sendFeedback(() -> Text.translatable("[Memory Clearer Miss-not Ore Dict] (Server) Memory cleaning completed!").formatted(Formatting.GREEN), false);
                        return 1;
                    })
            );
        });
    }
}
