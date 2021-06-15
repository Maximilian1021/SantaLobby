package me.maximilian1021.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static File getConf() {
        return new File("plugins/Lobbysystem", "config.yml");
    }

}
