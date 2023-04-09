package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.util.PlaceholderAPIUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.soyaldo.actionapi.Action;

public class ActionBarAction extends Action {

    public ActionBarAction(String value) {
        super("actionbar", value);
    }

    @Override
    public void execute(Player player) {

    }

    @Override
    public void execute(Player player, String[][] replacements) {
        // Created a variable that will be the message.
        String message = getValue();

        // Apply the replacements
        for (String[] replacement : replacements) {
            try {
                message = StringUtils.replace(message, replacement[0], replacement[1]);
            } catch (Exception ignored) {
            }
        }

        // Apply the variables from PlaceholderAPI.
        message = PlaceholderAPIUtil.setPlaceholders(player, message);

        // Apply color.
        message = ChatColor.translateAlternateColorCodes('&', message);

        // Send the message to the player.
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }

}