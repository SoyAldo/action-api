package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.PapiUtil;
import me.soyaldo.actionapi.util.SchedulerUtil;
import me.soyaldo.actionapi.util.TextUtil;
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
        // Apply replacements
        command = TextUtil.replace(command, replacements);
        // Apply color
        command = ChatUtil.colorizeLegacy(command);
        // Getting the plugin and the console
        JavaPlugin javaPlugin = getActionManager().getJavaPlugin();
        ConsoleCommandSender console = javaPlugin.getServer().getConsoleSender();
        // Execute command
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(javaPlugin, () -> javaPlugin.getServer().dispatchCommand(console, finalCommand), 0L);
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String command = getContent();
        // Apply Replacements
        command = TextUtil.replace(command, replacements);
        // Apply PlaceholderAPI
        command = PapiUtil.setPlaceholders(player, command);
        // Apply color
        command = ChatUtil.colorizeLegacy(command);
        // Getting the plugin and the console
        JavaPlugin javaPlugin = getActionManager().getJavaPlugin();
        ConsoleCommandSender console = javaPlugin.getServer().getConsoleSender();
        // Execute command
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(javaPlugin, () -> javaPlugin.getServer().dispatchCommand(console, finalCommand), 0L);
    }

}