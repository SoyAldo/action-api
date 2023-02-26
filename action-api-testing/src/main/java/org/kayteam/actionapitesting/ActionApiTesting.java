package org.kayteam.actionapitesting;

import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.actionapi.ActionManager;
import org.kayteam.actionapitesting.commands.ActionApiTestingCommand;

import java.io.File;

public final class ActionApiTesting extends JavaPlugin {


    private final Yaml settings = new Yaml(this, "settings");
    ActionManager actionManager = new ActionManager( this );

    @Override
    public void onEnable() {

        registerFiles();

        registerManagers();

        registerCommands();

    }

    @Override
    public void onDisable() { }

    public void onReload() {

        try {

            settings.reload();

            actionManager.reloadManager();

        } catch ( Exception ignore ) { }

    }

    private void registerFiles() {

        settings.register();

    }

    public Yaml getSettings() {
        return settings;
    }

    private void registerManagers() {
        actionManager.registerManager();
    }

    private void registerCommands() {

        getCommand( "ActionApiTesting" ).setExecutor( new ActionApiTestingCommand( this ) );

        getCommand( "ActionApiTesting" ).setTabCompleter( new ActionApiTestingCommand( this ) );

    }

    public ActionManager getActionManager() {

        return actionManager;

    }

}