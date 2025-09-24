package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.util.ActionInfo;
import me.soyaldo.actionapi.util.PlaceholderApi;
import de.themoep.minedown.MineDown;
import org.bukkit.entity.Player;

public class BroadcastAction extends Action {

    public BroadcastAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        // Created a variable that will be the message.
        String message = getContent();
        // Replacements
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }
        // Send the message to the entire server.
        for (Player target : getActionManager().getJavaPlugin().getServer().getOnlinePlayers()) {
            target.spigot().sendMessage(MineDown.parse(message));
        }
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        // Created a variable that will be the message.
        String message = getContent();
        // Replacements
        for (String[] replacement : replacements) {
            message = message.replace(replacement[0], replacement[1]);
        }
        // Apply the variables from PlaceholderAPI.
        message = PlaceholderApi.setPlaceholders(player, message);
        // Send the message to the entire server.
        for (Player target : getActionManager().getJavaPlugin().getServer().getOnlinePlayers()) {
            target.spigot().sendMessage(MineDown.parse(message));
        }
    }

}