package team.teampotato.memorycleanermissnotoredict.command;

import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class ServerCommand {
    public static void registerServerCommand() {
        CommandRegistrationEvent.EVENT.register((dispatcher, selection) -> {
            dispatcher.register(CommandManager.literal("mcmodserver")
                    .executes(context -> {
                        System.gc();
                        context.getSource().sendFeedback(new TranslatableText("[Memory Clearer Miss-not Ore Dict] (Server) Memory cleaning completed!").formatted(Formatting.GREEN), false);
                        return 1;
                    })
            );
        });
    }
}
