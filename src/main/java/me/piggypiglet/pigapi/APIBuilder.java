package me.piggypiglet.pigapi;

import me.piggypiglet.pigapi.handlers.ChatHandler;
import me.piggypiglet.pigapi.handlers.CommandHandler;
import me.piggypiglet.pigapi.handlers.ConfigHandler;
import me.piggypiglet.pigapi.objects.CMD;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class APIBuilder {
    private PigAPI api;
    private JavaPlugin main;
    private Enum messages;
    private CMD[] commands;

    public APIBuilder(JavaPlugin main) {
        api = PigAPI.getInstance();
        this.main = main;
    }
    public void setCommandClasses(CMD[] commands) {
        this.commands = commands;
    }
    public CommandHandler getCommandHandler() {
        return new CommandHandler(commands);
    }
    public ChatHandler getChatHandler(CommandSender user) {
        return new ChatHandler(main, null, user);
    }
    public ConfigHandler getConfigHandler() {
        return new ConfigHandler(main);
    }
}
