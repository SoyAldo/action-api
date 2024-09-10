package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.PlaceholderApi;
import com.soyaldo.actionapi.util.Text;
import com.soyaldo.actionapi.util.player.PlayerUtil;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionBarAction extends Action {

    public ActionBarAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String message = getActionInfo().getContent();
        // Apply the replacements.
        String finalMessage = Text.replace(message, replacements);
        // Send the message.
        try {
            // Creating a final message constant.
            MiniMessage miniMessage = MiniMessage.miniMessage();
            // Executing for all players.
            if (getActionInfo().getExtras().containsKey("global")) {
                PlayerUtil.executeAll(player -> {
                    Component component = miniMessage.deserialize(finalMessage);
                    Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(player);
                    audience.sendActionBar(component);
                });
            }
            // Execute for console.
            Component component = miniMessage.deserialize(finalMessage);
            Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).console();
            audience.sendMessage(component);
        } catch (Exception e) {
            // Executing for all players.
            if (getActionInfo().getExtras().containsKey("global")) {
                PlayerUtil.executeAll(player -> {
                    player.sendActionBar(finalMessage);
                });
            }
            // Execute for console.
            Bukkit.getServer().getConsoleSender().sendMessage(finalMessage);
        }
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String message = getActionInfo().getContent();
        // Apply the replacements
        message = Text.replace(message, replacements);
        // Apply the variables from PlaceholderAPI.
        message = PlaceholderApi.setPlaceholders(player, message);
        // Send the message.
        try {
            // Creating a final message constant.
            MiniMessage miniMessage = MiniMessage.miniMessage();
            final Component component = miniMessage.deserialize(message);
            // Executing for all players.
            if (getActionInfo().getExtras().containsKey("global")) {
                PlayerUtil.executeAll(target -> {
                    Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(target);
                    audience.sendActionBar(component);
                });
            } else {
                // Execute only to player.
                Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(player);
                audience.sendMessage(component);
            }
        } catch (Exception e) {
            // Creating a final message constant.
            final String finalMessage = message;
            // Executing for all players.
            if (getActionInfo().getExtras().containsKey("global")) {
                PlayerUtil.executeAll(target -> {
                    target.sendMessage(finalMessage);
                });
            } else {
                player.sendActionBar(message);
            }
        }
    }

}