package org.kayteam.actionapi.actions;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class ActionBarAction extends Action {

    public ActionBarAction(String value) {
        super("actionbar", value);
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
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }

    @Override
    public void execute(Player player, Object data) {
        execute(player);
    }

}