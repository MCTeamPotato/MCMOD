package team.teampotato.MCMOD.server;

import net.fabricmc.api.DedicatedServerModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class CommandServer implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        command();
    }

    public static void command() {
          CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("mcmodserver")
                          .executes(context -> {
                              System.gc();
                              context.getSource().sendFeedback(Text.translatable("[Memory Clearer Miss-not Ore Dict] (Server) Memory cleaning completed!").formatted(Formatting.GREEN), false);
                              return 1;
                          })
          ));
      }
}
