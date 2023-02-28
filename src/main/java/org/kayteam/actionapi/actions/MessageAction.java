package org.kayteam.actionapi.actions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class MessageAction extends Action {

    public MessageAction(String value) {
        super("message", value);
    }

    @Override
    public void execute(Player player) {
        // Created a variable that will be the message.
        String message = getValue();

        // Apply the variables from PlaceholderAPI.
        message = PlaceholderAPIUtil.setPlaceholders(player, message);

        // Apply color.
        message = ChatColor.translateAlternateColorCodes('&', message);

        // Send the message to the player.
        player.sendMessage(message);
    }

    @Override
    public void execute(Player player, Object data) {
        execute(player);
    }

}