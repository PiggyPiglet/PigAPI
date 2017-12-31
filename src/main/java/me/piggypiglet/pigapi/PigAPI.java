package me.piggypiglet.pigapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class PigAPI extends JavaPlugin {
    private static PigAPI instance;

    public static PigAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
