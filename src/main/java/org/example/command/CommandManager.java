package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, ICommand> commands = new HashMap<>();

    public CommandManager() {
        registerCommand(new PingCommand());
        registerCommand(new HelpCommand());
        registerCommand(new MercyCommand());
        registerCommand(new JokeCommand());
        registerCommand(new PollCommand());
    }

    private void registerCommand(ICommand command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public void handle(MessageReceivedEvent event, String commandName, String[] args) {
        ICommand cmd = commands.get(commandName.toLowerCase());
        if (cmd != null) {
            cmd.execute(event, args);
        }
        else {
            event.getChannel().sendMessage("La vie j'ai pas `" + commandName + "`, tu t'es trompé de commande frérot.").queue();
        }
    }
}
