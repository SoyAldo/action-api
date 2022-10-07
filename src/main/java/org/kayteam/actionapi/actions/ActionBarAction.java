package org.kayteam.actionapi.actions;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class ActionBarAction extends Action {

    public ActionBarAction(String value ) {
        super( "actionbar" , value );
    }

    @Override
    public void execute( Player player ) {

        String realValue = getValue();

        realValue = PlaceholderAPIUtil.setPlaceholders( player , realValue );

        realValue = ChatColor.translateAlternateColorCodes( '&' , realValue );

        player.spigot().sendMessage( ChatMessageType.ACTION_BAR , TextComponent.fromLegacyText( realValue ) );

    }

}