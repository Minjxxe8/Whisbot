package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Pong! Shibaaaal").queue();
    }

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Pong!";
    }
}
