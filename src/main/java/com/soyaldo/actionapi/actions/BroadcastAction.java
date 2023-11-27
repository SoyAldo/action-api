package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.PlaceholderApi;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class BroadcastAction extends Action {

    public BroadcastAction(ActionManager actionManager, String value) {
        super(actionManager, "broadcast", value);
    }

    @Override
    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    @Override
    public void execute(Player player, String[][] replacements) {
        // Created a variable that will be the message.
        String message = getValue();

        // Replacements
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }

        // Apply the variables from PlaceholderAPI.
        message = PlaceholderApi.setPlaceholders(player, message);

        // Send the message to the entire server.
        Audience audience = getActionManager().getBukkitAudiences().all();
        Component component = MiniMessage.miniMessage().deserialize(message);
        audience.sendMessage(component);
    }

}