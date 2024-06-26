package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.PlaceholderApi;
import de.themoep.minedown.MineDown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageAction extends Action {

    public MessageAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String message = getContent();
        // Apply the replacements
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }
        // Send the message to the player.
        Bukkit.getServer().getConsoleSender().spigot().sendMessage(MineDown.parse(message));
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String message = getContent();
        // Apply the replacements
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }
        // Apply the variables from PlaceholderAPI.
        message = PlaceholderApi.setPlaceholders(player, message);
        // Send the message to the player.
        player.spigot().sendMessage(MineDown.parse(message));
    }

}