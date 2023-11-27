package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.PlaceholderApi;
import de.themoep.minedown.MineDown;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Player;

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
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, MineDown.parse(message));
    }

}