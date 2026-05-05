package org.example.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.BotConfig;
import org.example.command.CommandManager;

import java.util.Arrays;

public class CommandListener extends ListenerAdapter {
    private final CommandManager commandManager = new CommandManager();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String messageRaw = event.getMessage().getContentRaw();

        if (messageRaw.startsWith(BotConfig.PREFIX)) {
            String[] parts = messageRaw.substring(BotConfig.PREFIX.length()).split("\\s+");
            String commandName = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            commandManager.handle(event, commandName, args);
        }
    }
}
