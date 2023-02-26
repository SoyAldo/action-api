package org.kayteam.actionapitesting.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionManager;
import org.kayteam.actionapitesting.ActionApiTesting;

import java.util.Arrays;
import java.util.List;

public class ActionApiTestingCommand implements CommandExecutor, TabCompleter {

    private final ActionApiTesting PLUGIN;

    public ActionApiTestingCommand(ActionApiTesting PLUGIN) {

        this.PLUGIN = PLUGIN;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration config = PLUGIN.getConfig();

        if (!(sender instanceof Player)) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.onlyPlayers")));

            return true;

        }

        Player player = (Player) sender;

        if (args.length < 1) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.emptyArgs")));

            return true;

        }

        String subcommand = args[0];

        if (subcommand.equalsIgnoreCase("reload")) {

            PLUGIN.onReload();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.reloaded")));

        } else if (subcommand.equalsIgnoreCase("test")) {

            if (args.length < 2) {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.emptyAction")));

                return true;

            }

            String actionType = args[1];

            ActionManager actionManager = PLUGIN.getActionManager();

            if (!config.contains("types." + actionType) || !actionManager.existActionExpansion(actionType)) {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.invalidAction")));

                return true;

            }

            String actionFormat = config.getString("types." + actionType);

            Action action = actionManager.loadAction(actionFormat);

            action.execute(player);

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.executed")));

        } else {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.invalidArgs")));

        }

        return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1) {

            return Arrays.asList("reload", "test");

        }

        if (args.length == 2) {

            return Arrays.asList("actionbar", "console", "message", "player", "sound", "effect");

        }

        return null;

    }

}