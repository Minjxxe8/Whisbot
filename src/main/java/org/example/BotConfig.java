package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class BotConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static final String TOKEN = dotenv.get("WHISBOT_TOKEN");
    public static final String PREFIX = dotenv.get("DISCORD_PREFIX", "!");
}
