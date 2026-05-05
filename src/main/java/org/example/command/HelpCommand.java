package org.example.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class HelpCommand implements ICommand{

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Mdrrr noob").queue();
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("You need help ? Noob.");
        event.getChannel().sendMessage("You should've pick Mercy.....").queue();
        embed.setColor(new Color(255, 20, 147));

        embed.addField("!help", "Help you -_-", false);
        embed.addField("!ping", "PONG !", false);
        embed.addField("!joke", "Give you a joke hahahaha", false);
        embed.addField("!poll", "Give you a pool with reaction 😜", false);
        embed.addField("!mercy", "Hihi", false);

        // Footer et timestamp
        embed.setFooter("Whisbot", event.getJDA().getSelfUser().getEffectiveAvatarUrl());
        embed.setTimestamp(Instant.now());

        // Envoi de l'embed
        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Affiche la liste des commandes disponibles.";
    }
}
