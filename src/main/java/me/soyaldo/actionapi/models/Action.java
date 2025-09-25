package me.soyaldo.actionapi.models;

import me.soyaldo.actionapi.managers.ActionManager;
import me.soyaldo.actionapi.util.NumberUtil;
import me.soyaldo.actionapi.util.SchedulerUtil;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Action {

    private final ActionManager actionManager;
    private final ActionInfo actionInfo;

    public Action(ActionInfo actionInfo) {
        this.actionManager = actionInfo.getActionManager();
        this.actionInfo = actionInfo;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public ActionInfo getActionInfo() {
        return actionInfo;
    }

    public abstract void executeAction(String[][] replacements);

    public abstract void executeAction(Player player, String[][] replacements);

    public void execute(String[][] replacements) {
        JavaPlugin plugin = actionManager.getJavaPlugin();
        boolean global = actionInfo.getExtras().containsKey("global");
        boolean async = actionInfo.getExtras().containsKey("async");
        int delay = NumberUtil.getInt(String.valueOf(actionInfo.getExtras().get("delay")), 0);
        String permission = String.valueOf(actionInfo.getExtras().get("permission"));

        Runnable execution = () -> {
            if (global) {
                for (Player tempPlayer : plugin.getServer().getOnlinePlayers()) {
                    if (permission != null) {
                        if (tempPlayer.hasPermission(permission)) {
                            executeAction(tempPlayer, replacements);
                        }
                    }
                }
            } else {
                executeAction(replacements);
            }
        };

        SchedulerUtil.runTaskLater(plugin, execution, Math.max(delay, 0), async);
    }

    public void execute() {
        execute(new String[][]{});
    }

    public void execute(Player player, String[][] replacements) {
        JavaPlugin plugin = actionManager.getJavaPlugin();
        boolean global = actionInfo.getExtras().containsKey("global");
        boolean async = actionInfo.getExtras().containsKey("async");
        int delay = NumberUtil.getInt(String.valueOf(actionInfo.getExtras().get("delay")), 0);
        String permission = String.valueOf(actionInfo.getExtras().get("permission"));

        Runnable execution = () -> {
            if (global) {
                for (Player tempPlayer : plugin.getServer().getOnlinePlayers()) {
                    if (permission != null) {
                        if (tempPlayer.hasPermission(permission)) {
                            executeAction(tempPlayer, replacements);
                        }
                    }
                }
            } else {
                if (permission != null) {
                    if (player.hasPermission(permission)) {
                        executeAction(player, replacements);
                    }
                }
            }
        };

        SchedulerUtil.runTaskLater(plugin, execution, Math.max(delay, 0), async);
    }

    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    public String serialize() {
        StringBuilder result = new StringBuilder();
        // Type
        result.append("[").append(actionInfo.getType()).append("]");
        // Content
        if (!actionInfo.getContent().isEmpty()) {
            result.append(" ").append(actionInfo.getContent()).append(" ");
        }
        // Extra
        if (!actionInfo.getExtras().isEmpty()) {
            for (String extra : actionInfo.getExtras().keySet()) {
                if (((String) actionInfo.getExtras().get(extra)).isEmpty()) {
                    result.append("<").append(extra).append("> ");
                } else {
                    result.append("<").append(extra).append("=").append(actionInfo.getExtras().get(extra).toString()).append(">");
                }
            }
        }
        // Remove last blank space.
        if (result.toString().endsWith(" ")) {
            result = new StringBuilder(result.substring(0, result.length() - 1));
        }
        // Return result.
        return result.toString();
    }

}