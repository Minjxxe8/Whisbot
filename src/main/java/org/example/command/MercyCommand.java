package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MercyCommand implements ICommand{
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("I'M NOT GONNA BE ANY KIND OF SUPPORT !").queue();
    }

    @Override
    public String getName() {
        return "mercy";
    }

    @Override
    public String getDescription() {
        return "YIHAAA";
    }
}
