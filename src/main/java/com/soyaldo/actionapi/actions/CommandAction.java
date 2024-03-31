package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.MineDown;
import com.soyaldo.actionapi.util.PlaceholderApi;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandAction extends Action {

    public CommandAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String command = getContent();
        // Replacements
        for (String[] replacement : replacements) {
            command = command.replace(replacement[0], replacement[1]);
        }
        // Color
        command = MineDown.parseLegacy(command);
        // Execute command
        String finalCommand = command;
        ConsoleCommandSender consoleCommandSender = getActionManager().getJavaPlugin().getServer().getConsoleSender();
        getActionManager().getJavaPlugin().getServer().getScheduler().runTaskLater(
                getActionManager().getJavaPlugin(),
                () -> getActionManager().getJavaPlugin().getServer().dispatchCommand(consoleCommandSender, finalCommand),
                0L
        );
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

        player.sendMessage("command: |" + finalCommand + '|');

        if (getExtras().containsKey("console")) {
            ConsoleCommandSender consoleCommandSender = getActionManager().getJavaPlugin().getServer().getConsoleSender();
            getActionManager().getJavaPlugin().getServer().getScheduler().runTaskLater(
                    getActionManager().getJavaPlugin(),
                    () -> getActionManager().getJavaPlugin().getServer().dispatchCommand(consoleCommandSender, finalCommand),
                    0L
            );
        } else {
            getActionManager().getJavaPlugin().getServer().getScheduler().runTaskLater(
                    getActionManager().getJavaPlugin(),
                    () -> getActionManager().getJavaPlugin().getServer().dispatchCommand(player, finalCommand),
                    0L
            );
        }
    }

}