package com.soyaldo.actionapitesting.commands;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapitesting.utils.Command;
import com.soyaldo.actionapitesting.utils.messenger.Messenger;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import com.soyaldo.actionapitesting.ActionApiTesting;

public class AdminCommand extends Command {

    private final ActionApiTesting plugin;

    public AdminCommand(ActionApiTesting plugin) {
        super("ActionApiTesting");
        this.plugin = plugin;
    }

    @Override
    public void onPlayerExecute(Player sender, String[] args) {
        Messenger messenger = plugin.getMessenger();
        FileConfiguration settings = plugin.getSettings().getFileConfiguration();

        if (args.length == 0) {
            messenger.send(sender, "emptyArgs");
            return;
        }

        String subCommand = args[0];

        switch (subCommand.toLowerCase()) {
            case "reload": {
                plugin.onReload();
                messenger.send(sender, "reloaded");
                break;
            }
            case "test": {
                if (args.length < 2) {
                    messenger.send(sender, "emptyAction");
                    return;
                }

                ActionManager actionManager = plugin.getActionManager();
                String type = args[1];

                if (!settings.contains("types." + type) || !actionManager.existActionExpansion(type)) {
                    messenger.send(sender, "invalidAction", new String[][]{{"%type%", type}});
                    return;
                }

                String format = settings.getString("types." + type);

                Action action = actionManager.loadAction(format);

                action.execute(sender);

                messenger.send(sender, "executed");
                break;
            }
            default: {
                messenger.send(sender, "invalidArgs");
            }
        }
    }

    @Override
    public void onConsoleExecute(ConsoleCommandSender sender, String[] args) {
        plugin.getMessenger().send(sender, "onlyPlayers");
    }

    @Override
    public String onPlayerTabComplete(Player requester, int position, String[] previousArguments) {
        if (position == 1) {
            return "reload,test";
        }

        if (position == 2) {
            if (previousArguments[0].equalsIgnoreCase("test")) {
                return "actionbar,broadcast,console,message,player,sound,title";
            }
        }

        return "";
    }

}