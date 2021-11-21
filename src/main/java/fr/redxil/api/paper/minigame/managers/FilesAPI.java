/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.minigame.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public enum FilesAPI {

    CONFIG("config.yml"),
    LANG("lang.yml");

    private final String fileName;

    FilesAPI(String fileName) {
        this.fileName = fileName;
    }

    public File getFile(JavaPlugin plugin) {
        return new File(plugin.getDataFolder(), fileName);
    }

    public FileConfiguration getConfig(JavaPlugin plugin) {
        return YamlConfiguration.loadConfiguration(getFile(plugin));
    }

    public void save(FileConfiguration config, JavaPlugin plugin) {
        try {
            config.save(getFile(plugin));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }
}
