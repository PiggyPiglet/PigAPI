package me.piggypiglet.pigapi.handlers;

import me.piggypiglet.pigapi.objects.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CommandHandler implements CommandExecutor {
    private Command[] commands;

    public CommandHandler(Command[] commands) {
        this.commands = commands;
    }
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        for (Command command : commands) {
            if (args[0].equalsIgnoreCase(command.cmd)) {
                command.run(sender, args);
            }
        }
        return true;
    }
}
