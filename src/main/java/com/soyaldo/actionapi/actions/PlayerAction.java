package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.PlaceholderApi;
import org.bukkit.entity.Player;

public class PlayerAction extends Action {

    public PlayerAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String command = getContent();
        // Replacements
        for (String[] replacement : replacements) {
            command = command.replace(replacement[0], replacement[1]);
        }
        // PlaceholderAPI
        command = PlaceholderApi.setPlaceholders(player, command);
        // Color
        command = MineDown.parseLegacy(command);
        // Execute command
        String finalCommand = command;
        getActionManager().getJavaPlugin().getServer().getScheduler().runTaskLater(
                getActionManager().getJavaPlugin(),
                () -> getActionManager().getJavaPlugin().getServer().dispatchCommand(player, finalCommand),
                0L
        );
    }

}