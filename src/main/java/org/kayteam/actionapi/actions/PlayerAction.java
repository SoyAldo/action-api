package org.kayteam.actionapi.actions;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionManager;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class PlayerAction extends Action {

    public PlayerAction(String value) {
        super("player", value);
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
            try {
                command = StringUtils.replace(command, replacement[0], replacement[1]);
            } catch (Exception ignored) {
            }
        }

        // PlaceholderAPI
        command = PlaceholderAPIUtil.setPlaceholders(player, command);

        // Color
        command = ChatColor.translateAlternateColorCodes('&', command);

        // ActionManager
        ActionManager actionManager = getActionManager();

        // JavaPlugin
        JavaPlugin javaPlugin = actionManager.getJavaPlugin();

        // Server
        Server server = javaPlugin.getServer();

        // Execute command
        server.dispatchCommand(player, command);
    }

}