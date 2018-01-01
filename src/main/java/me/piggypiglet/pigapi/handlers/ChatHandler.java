package me.piggypiglet.pigapi.handlers;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.chat.TextComponent;

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
    public void sendMessage(Enum msg, Enum link, Enum hover, boolean prefix) {
        TextComponent txt = new TextComponent(cc(prefix ? config.getMessage(this.prefix) + config.getMessage(msg) : config.getMessage(msg)));
        if (link != null) {
            txt.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cc(config.getMessage(link))));
        }
        if (hover != null) {
            txt.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(cc(config.getMessage(hover))).create()));
        }
        user.spigot().sendMessage(txt);
    }
    public String cc(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
