package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandAction extends Action {

    public CommandAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String command = getActionInfo().getContent();
        // Apply replacements and color
        command = ActionUtil.processText(command, replacements);
        // Get all necessary to execute the command
        JavaPlugin plugin = getActionManager().getJavaPlugin();
        ConsoleCommandSender console = ActionUtil.getConsole();
        // Execute the command
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(plugin, () -> plugin.getServer().dispatchCommand(console, finalCommand));
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String command = getActionInfo().getContent();
        // Apply replacements, PlaceholderAPI and color
        command = ActionUtil.processText(command, player, replacements);
        // Get all necessary to execute the command
        JavaPlugin plugin = getActionManager().getJavaPlugin();
        boolean isConsole = getActionInfo().getExtras().containsKey("console");
        CommandSender dispatcher = isConsole ? ActionUtil.getConsole() : player;
        // Execute the command
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(plugin, () -> plugin.getServer().dispatchCommand(dispatcher, finalCommand));
    }

}