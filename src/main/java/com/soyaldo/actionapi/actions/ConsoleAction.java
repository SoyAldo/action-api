package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.MineDown;
import com.soyaldo.actionapi.util.PlaceholderApi;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsoleAction extends Action {

    public ConsoleAction(ActionInfo actionInfo) {
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
        // JavaPlugin
        JavaPlugin javaPlugin = getActionManager().getJavaPlugin();
        // ConsoleCommandSender
        ConsoleCommandSender consoleCommandSender = javaPlugin.getServer().getConsoleSender();
        // Execute command
        String finalCommand = command;
        javaPlugin.getServer().getScheduler().runTaskLater(javaPlugin, () -> javaPlugin.getServer().dispatchCommand(consoleCommandSender, finalCommand), 0L);
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
        // JavaPlugin
        JavaPlugin javaPlugin = getActionManager().getJavaPlugin();
        // ConsoleCommandSender
        ConsoleCommandSender consoleCommandSender = javaPlugin.getServer().getConsoleSender();
        // Execute command
        String finalCommand = command;
        javaPlugin.getServer().getScheduler().runTaskLater(javaPlugin, () -> javaPlugin.getServer().dispatchCommand(consoleCommandSender, finalCommand), 0L);
    }

}