package org.kayteam.actionapi.actions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class MessageAction extends Action {

    public MessageAction( String value ) {
        super( "message" , value );
    }

    @Override
    public void execute( Player player ) {

        String realValue = getValue();

        realValue = PlaceholderAPIUtil.setPlaceholders( player , realValue );

        realValue = ChatColor.translateAlternateColorCodes( '&' , realValue );

        player.sendMessage( realValue );

    }

}