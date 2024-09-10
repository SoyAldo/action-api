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
import org.bukkit.entity.Player;

public class MessageAction extends Action {

    public MessageAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String message = Text.replace(getActionInfo().getContent(), replacements);
        // Executing for all players.
        if (getActionInfo().getExtras().containsKey("global")) {
            PlayerUtil.executeAll(player -> {
                String finalMessage = PlaceholderApi.setPlaceholders(player, message);
                Component component = MiniMessage.miniMessage().deserialize(finalMessage);
                Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(player);
                audience.sendMessage(component);
            });
        }
        // Execute for console.
        Component component = MiniMessage.miniMessage().deserialize(message);
        Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).console();
        audience.sendMessage(component);
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String message = Text.replace(getActionInfo().getContent(), replacements);
        // Executing for all players.
        if (getActionInfo().getExtras().containsKey("global")) {
            PlayerUtil.executeAll(target -> {
                String finalMessage = PlaceholderApi.setPlaceholders(target, message);
                Component component = MiniMessage.miniMessage().deserialize(finalMessage);
                Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(target);
                audience.sendMessage(component);
            });
        } else {
            // Execute only to player.
            String finalMessage = PlaceholderApi.setPlaceholders(player, message);
            Component component = MiniMessage.miniMessage().deserialize(finalMessage);
            Audience audience = BukkitAudiences.create(getActionManager().getJavaPlugin()).player(player);
            audience.sendMessage(component);
        }
    }

}