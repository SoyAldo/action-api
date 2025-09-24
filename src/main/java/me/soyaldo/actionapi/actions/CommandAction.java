package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.PapiUtil;
import me.soyaldo.actionapi.util.SchedulerUtil;
import me.soyaldo.actionapi.util.TextUtil;
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
        String command = getContent();
        // Apply replacements
        command = TextUtil.replace(command, replacements);
        // Apply color
        command = ChatUtil.colorizeLegacy(command);
        // Execute command
        JavaPlugin plugin = getActionManager().getJavaPlugin();
        ConsoleCommandSender console = plugin.getServer().getConsoleSender();
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(plugin, () -> plugin.getServer().dispatchCommand(console, finalCommand));
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String command = getContent();
        // Apply replacements
        command = TextUtil.replace(command, replacements);
        // Apply PlaceholderAPI
        command = PapiUtil.setPlaceholders(player, command);
        // Apply color
        command = ChatUtil.colorizeLegacy(command);
        // Execute command
        JavaPlugin plugin = getActionManager().getJavaPlugin();
        ConsoleCommandSender console = getActionManager().getJavaPlugin().getServer().getConsoleSender();
        CommandSender dispatcher = getExtras().containsKey("console") ? console : player;
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(plugin, () -> plugin.getServer().dispatchCommand(dispatcher, finalCommand));
    }

}