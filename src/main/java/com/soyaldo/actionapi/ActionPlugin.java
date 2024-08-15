package com.soyaldo.actionapi;

import com.soyaldo.actionapi.action.ActionManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ActionPlugin extends JavaPlugin {

    // Files
    private FileConfiguration settings;
    private FileConfiguration messages;
    // Managers
    private final ActionManager actionManager = new ActionManager(this);

    @Override
    public void onEnable() {
        // Files
        // Managers
        actionManager.registerManager();
        // Commands
        // Copyright
    }

    @Override
    public void onDisable() {
        // Copyright
    }

    public void onReload() {
        // Files
        // Managers
        actionManager.reloadManager();
    }

}