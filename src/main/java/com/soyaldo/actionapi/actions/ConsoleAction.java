package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.util.ChatColorUtil;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.PlaceholderAPIUtil;

public class ConsoleAction extends Action {

    public ConsoleAction(ActionManager actionManager, String value) {
        super(actionManager, "console", value);
    }

    @Override
    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    @Override
    public void execute(Player player, String[][] replacements) {
        String command = getValue();

        // Replacements
        for (String[] replacement : replacements) {
            command = command.replace(replacement[0], replacement[1]);
        }

        // PlaceholderAPI
        command = PlaceholderAPIUtil.setPlaceholders(player, command);

        // Color
        command = ChatColorUtil.translate(command);

        // ActionManager
        ActionManager actionManager = getActionManager();

        // JavaPlugin
        JavaPlugin javaPlugin = actionManager.getJavaPlugin();

        // Server
        Server server = javaPlugin.getServer();

        // ConsoleCommandSender
        ConsoleCommandSender consoleCommandSender = server.getConsoleSender();

        // Execute command
        server.dispatchCommand(consoleCommandSender, command);
    }

}