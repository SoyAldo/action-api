package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.PlaceholderApi;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class MessageAction extends Action {

    public MessageAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String message = getActionInfo().getContent();
        // Apply the replacements.
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }
        // Send the message.
        try {
            Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).console();
            MiniMessage miniMessage = MiniMessage.miniMessage();
            Component component = miniMessage.deserialize(message);
            audience.sendMessage(component);
        } catch (Exception e) {
            getActionManager().getJavaPlugin().getLogger().info("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String message = getActionInfo().getContent();
        // Apply the replacements
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }
        // Apply the variables from PlaceholderAPI.
        message = PlaceholderApi.setPlaceholders(player, message);
        // Send the message.
        try {
            Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(player);
            MiniMessage miniMessage = MiniMessage.miniMessage();
            Component component = miniMessage.deserialize(message);
            audience.sendMessage(component);
        } catch (Exception e) {
            getActionManager().getJavaPlugin().getLogger().info("ERROR: " + e.getMessage());
        }
    }

}