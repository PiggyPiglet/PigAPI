package me.piggypiglet.pigapi.objects;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Config {
    private File file;
    private FileConfiguration fileConfig;

    public Config(JavaPlugin main, String path, String fileName) {
        file = new File(path, fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (main.getResource(fileName) != null) {
                main.saveResource(fileName, false);
            } else {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        FileConfiguration fileConfig = new YamlConfiguration();
        try {
            fileConfig.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fileConfig = fileConfig;
    }
    public FileConfiguration getConfig() {
        return fileConfig;
    }
    public void save() {
        try {
            fileConfig.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
