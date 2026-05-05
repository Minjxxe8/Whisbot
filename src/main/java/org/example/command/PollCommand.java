package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PollCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        String rawContent = event.getMessage().getContentRaw();
        String content = rawContent.substring(5).trim();

        if (content.isEmpty()) {
            event.getChannel().sendMessage("❌ Utilisation incorrecte. Exemple : `!poll Le sondage ? | Oui | Non`").queue();
            return;
        }

        String[] options = content.split("\\|");

        if (options.length < 2) {
            event.getChannel().sendMessage("❌ Faut séparer avec `|` (au moins 2 options).").queue();
            return;
        }

        StringBuilder pollMessage = new StringBuilder("📊 **Sondage :** " + options[0].trim() + "\n\n");

        for (int i = 1; i < options.length; i++) {
            pollMessage.append("➡ ").append(options[i].trim()).append("\n");
        }

        event.getChannel().sendMessage(pollMessage.toString()).queue(message -> {
            message.addReaction(net.dv8tion.jda.api.entities.emoji.Emoji.fromUnicode("👍")).queue();
            message.addReaction(net.dv8tion.jda.api.entities.emoji.Emoji.fromUnicode("👎")).queue();
        });
    }

    @Override
    public String getName() {
        return "poll";
    }

    @Override
    public String getDescription() {
        return "Crée un sondage avec des réactions.";
    }
}