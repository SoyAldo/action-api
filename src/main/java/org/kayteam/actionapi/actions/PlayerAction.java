package org.kayteam.actionapi.actions;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionManager;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class PlayerAction extends Action {

    public PlayerAction( String value ) {
        super( "player" , value );
    }

    @Override
    public void execute( Player player ) {
        String command = getValue();

        command = PlaceholderAPIUtil.setPlaceholders( player , command );
        command = ChatColor.translateAlternateColorCodes( '&' , command );

        ActionManager actionManager = getActionManager();
        JavaPlugin javaPlugin = actionManager.getJavaPlugin();
        Server server = javaPlugin.getServer();

        server.dispatchCommand( player , command );
    }

    @Override
    public void execute( Player player , Object data ) {
        execute( player );
    }

}