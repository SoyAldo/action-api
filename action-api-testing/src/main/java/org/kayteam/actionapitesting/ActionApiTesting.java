package org.kayteam.actionapitesting;

import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.actionapi.ActionManager;
import org.kayteam.actionapitesting.commands.ActionApiTestingCommand;

import java.io.File;

public final class ActionApiTesting extends JavaPlugin {

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

            getConfig().load( new File( getDataFolder() + "config.yml") );

        } catch ( Exception ignore ) { }

    }

    private void registerFiles() {

        File file = new File( getDataFolder() , "config.yml" );

        if ( ! file.exists() ) {

            saveResource( "config.yml" , true );

        }

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