package me.piggypiglet.pigapi.handlers;

import me.piggypiglet.pigapi.objects.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class ConfigHandler {
    private ChatHandler chat;
    private FileConfiguration config;

    public ConfigHandler(JavaPlugin main) {
        chat = new ChatHandler(main, null, null);
        config = new Config(main, main.getDataFolder().getPath(), "lang.yml").getConfig();
    }
    public String getMessage(Enum msg) {
        return chat.cc(config.getString(msg.toString(), "Warning! " + msg.toString() + " is not set in lang.yml"));
    }
}
