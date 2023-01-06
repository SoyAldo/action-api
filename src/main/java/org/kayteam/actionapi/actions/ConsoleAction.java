package org.kayteam.actionapi.actions;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionManager;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class ConsoleAction extends Action {

    public ConsoleAction( String value ) {
        super( "console" , value );
    }

    @Override
    public void execute( Player player ) {
        String realValue = getValue();

        realValue = PlaceholderAPIUtil.setPlaceholders( player , realValue );
        realValue = ChatColor.translateAlternateColorCodes( '&' , realValue );

        ActionManager actionManager = getActionManager();

        JavaPlugin javaPlugin = actionManager.getJavaPlugin();
        Server server = javaPlugin.getServer();
        ConsoleCommandSender consoleCommandSender = server.getConsoleSender();

        server.dispatchCommand( consoleCommandSender , realValue );
    }

    @Override
    public void execute( Player player , Object data ) {
        execute( player );
    }

}