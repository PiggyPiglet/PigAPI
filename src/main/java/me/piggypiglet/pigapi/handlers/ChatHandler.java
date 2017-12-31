package me.piggypiglet.pigapi.handlers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class ChatHandler {
    private ConfigHandler config;
    private CommandSender user;
    private Enum prefix;

    public ChatHandler(JavaPlugin main, Enum prefix, CommandSender user) {
        config = new ConfigHandler(main);
        this.user = user;
        this.prefix = prefix;
    }
    public String listToString(String[] str, boolean commaToNewLine) {
        if (commaToNewLine) {
            return Arrays.toString(str)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\n");
        } else {
            return Arrays.toString(str)
                    .replace("[", "")
                    .replace("]", "");
        }
    }
    public void sendMessage(Enum msg, boolean prefix) {
        String txt = prefix ? config.getMessage(this.prefix) + config.getMessage(msg) : config.getMessage(msg);
        user.sendMessage(txt);
    }
    public String cc(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
