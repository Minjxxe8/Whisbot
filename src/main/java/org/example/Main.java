package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.listener.CommandListener;

public class Main {
    static void main(String[] args) {
        try {
            JDABuilder builder = JDABuilder.createDefault(BotConfig.TOKEN)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .addEventListeners(new CommandListener());

            builder.build();
            System.out.println("Le bot est en ligne !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
