package me.piggypiglet.pigapi.objects;

import org.bukkit.command.CommandSender;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public abstract class CMD {
    public String cmd = "null";
    public boolean def = false;

    public abstract void execute(CommandSender sender, String[] args);

    public void run(CommandSender sender, String[] args) {
        execute(sender, args);
    }
}
