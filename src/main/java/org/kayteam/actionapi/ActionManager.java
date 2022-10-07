package org.kayteam.actionapi;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.actionapi.expansions.*;
import org.kayteam.actionapi.util.ActionUtil;
import org.kayteam.actionapi.util.VaultUtil;

import java.util.HashMap;
import java.util.List;

public class ActionManager {

    private final JavaPlugin javaPlugin;
    private Economy economy = null;
    private final HashMap< String , ActionExpansion > actionExpansions = new HashMap<>();

    public ActionManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public JavaPlugin getJavaPlugin() {
        return javaPlugin;
    }

    public void registerManager() {

        if ( VaultUtil.isEconomyEnabled() ) economy = VaultUtil.getEconomy();

        addActionExpansion( new ActionBarExpansion() );
        addActionExpansion( new ConsoleExpansion() );
        addActionExpansion( new MessageExpansion() );
        addActionExpansion( new PlayerExpansion() );
        addActionExpansion( new SoundExpansion() );

    }

    public void reloadManager() {

    }

    public Economy getEconomy() {
        return economy;
    }

    public HashMap< String , ActionExpansion > getActionExpansions() {
        return actionExpansions;
    }

    public boolean existActionExpansion( String type ) {
        return actionExpansions.containsKey( type );
    }

    public void addActionExpansion( ActionExpansion actionExpansion ) {
        this.actionExpansions.put( actionExpansion.getType() , actionExpansion );
    }

    public void removeActionExpansion( String type ) {
        actionExpansions.remove( type );
    }

    public ActionExpansion getActionExpansion( String type ) {
        return actionExpansions.get( type );
    }

    public Action loadAction( String format ) {

        Action action = null;

        String type = ActionUtil.getType( format );

        ActionExpansion actionExpansion = this.actionExpansions.get( type );

        if ( actionExpansion != null ) action = actionExpansion.generateAction( format );

        if ( action != null ) action.setActionManager( this );

        return action;

    }

    public Actions loadActions( List<String> formats ) {

        Actions actions = new Actions();

        for ( String format : formats ) {

            Action action = loadAction( format );

            if ( action != null ) {

                actions.addAction(action);

            }

        }

        return actions;

    }


}