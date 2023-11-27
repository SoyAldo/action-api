package com.soyaldo.actionapitesting.utils;

import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.logging.Level;

public class Yaml {

    private final JavaPlugin javaPlugin;
    private final String directory;
    private final String name;
    private FileConfiguration fileConfiguration;
    private final InputStream defaultConfiguration;


    public Yaml(JavaPlugin javaPlugin, String directory, String name, InputStream defaultConfiguration) {
        this.javaPlugin = javaPlugin;
        this.directory = javaPlugin.getDataFolder().getPath() + File.separator + directory;
        this.name = name;
        this.defaultConfiguration = defaultConfiguration;
    }

    public Yaml(JavaPlugin javaPlugin, String directory, String name) {
        this.javaPlugin = javaPlugin;
        this.directory = javaPlugin.getDataFolder().getPath() + File.separator + directory;
        this.name = name;
        defaultConfiguration = null;
    }

    public Yaml(JavaPlugin javaPlugin, String name, InputStream defaultConfiguration) {
        this.javaPlugin = javaPlugin;
        this.directory = javaPlugin.getDataFolder().getPath();
        this.name = name;
        this.defaultConfiguration = defaultConfiguration;
    }

    public Yaml(JavaPlugin javaPlugin, String name) {
        this.javaPlugin = javaPlugin;
        this.directory = javaPlugin.getDataFolder().getPath();
        this.name = name;
        defaultConfiguration = null;
    }

    public Yaml(String directory, String name, InputStream defaultConfiguration) {
        this.javaPlugin = null;
        this.directory = directory;
        this.name = name;
        this.defaultConfiguration = defaultConfiguration;
    }

    public Yaml(String directory, String name) {
        this.javaPlugin = null;
        this.directory = directory;
        this.name = name;
        defaultConfiguration = null;
    }


    /**
     * Registrar el archivo.
     */
    public void register() {
        if (fileConfiguration == null) {
            reload();
        }
    }

    /**
     * Recarga el archivo.
     */
    public void reload() {
        File directory = new File(this.directory);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                javaPlugin.getLogger().info("Error: Fail in directory creation.");
            }
        }
        File file = new File(directory, name + ".yml");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    if (defaultConfiguration != null) {
                        OutputStream outputStream = new FileOutputStream(file);
                        ByteStreams.copy(defaultConfiguration, outputStream);
                    }
                }
            } catch (IOException | IllegalArgumentException e) {
                Bukkit.getLogger().log(Level.SEVERE, "Error: Local file failed in load.");
            }
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Guarda el archivo.
     */
    public void save() {
        try {
            File file = new File(directory, name + ".yml");
            fileConfiguration.save(file);
        } catch (IOException ignore) {
            Bukkit.getLogger().log(Level.SEVERE, "Error: File do not saved.");
        }
    }

    /**
     * Delete the file
     */
    public boolean delete() {
        // A File representing the directory is declared.
        File directory = new File(this.directory);
        // If the directory does not exist, return true.
        if (!directory.exists()) {
            return true;
        }
        // A File representing the file is declared.
        File file = new File(directory, name + ".yml");
        // If the file exists, what the delete method returns is returned.
        if (file.exists()) {
            return file.delete();
        }
        //If the file does not exist, return true.
        return true;
    }

    /**
     * Verify if the file exist
     *
     * @return true if exist or false if not
     */
    public boolean exist() {
        return new File(directory, name + ".yml").exists();
    }

    /**
     * Obtener el archivo de configuración.
     *
     * @return FileConfiguration
     */
    public FileConfiguration getFileConfiguration() {
        if (fileConfiguration == null) reload();
        return fileConfiguration;
    }

}