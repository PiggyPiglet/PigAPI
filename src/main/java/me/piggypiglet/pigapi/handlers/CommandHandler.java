package me.piggypiglet.pigapi.handlers;

import me.piggypiglet.pigapi.objects.CMD;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CommandHandler implements CommandExecutor {
    private CMD[] commands;

    public CommandHandler(CMD[] commands) {
        this.commands = commands;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        for (CMD command : commands) {
            if (args.length == 0) {
                if (command.def) {
                    command.run(sender, args);
                }
            } else {
                if (command.cmd.equalsIgnoreCase(args[0])) {
                    command.run(sender, args);
                    return true;
                } else if (command.cmd.equalsIgnoreCase("*")) {
                    command.run(sender, args);
                }
            }
        }
        return true;
    }
}
