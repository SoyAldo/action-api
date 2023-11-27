package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.PlaceholderApi;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import com.soyaldo.actionapi.Action;

public class ActionBarAction extends Action {

    public ActionBarAction(ActionManager actionManager, String value) {
        super(actionManager, "actionbar", value);
    }

    @Override
    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    @Override
    public void execute(Player player, String[][] replacements) {
        // Created a variable that will be the message.
        String message = getValue();
        // Apply the replacements
        for (String[] replacement : replacements) message = message.replace(replacement[0], replacement[1]);
        // Apply the variables from PlaceholderAPI.
        message = PlaceholderApi.setPlaceholders(player, message);
        // Send the message to the player.
        Audience audience = getActionManager().getBukkitAudiences().player(player);
        Component component = MiniMessage.miniMessage().deserialize(message);
        audience.sendActionBar(component);
    }

}