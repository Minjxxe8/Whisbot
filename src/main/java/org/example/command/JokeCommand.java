package org.example.command;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokeCommand implements ICommand {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://official-joke-api.appspot.com/random_joke"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                String setup = jsonObject.get("setup").getAsString();
                String punchline = jsonObject.get("punchline").getAsString();

                event.getChannel().sendMessage("MDMDMRR **" + setup + "**\n" + punchline).queue();
            } else {
                event.getChannel().sendMessage("My bad, ça charge pas").queue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            event.getChannel().sendMessage("Une erreur est survenue : " + e.getMessage()).queue();
        }
    }

    @Override
    public String getName() {
        return "joke";
    }

    @Override
    public String getDescription() {
        return "Donne une blague aléatoire.";
    }
}