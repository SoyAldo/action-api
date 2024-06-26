package com.soyaldo.actionapi.models;

import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionInfo;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;

public abstract class Action {

    private final ActionManager actionManager;
    private final String type;
    private final String content;
    private final HashMap<String, Object> extras;

    public Action(ActionInfo actionInfo) {
        this.actionManager = actionInfo.getActionManager();
        this.type = actionInfo.getType();
        this.content = actionInfo.getContent();
        this.extras = actionInfo.getExtras();
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    /**
     * Get the action type.
     *
     * @return the action type.
     */
    public String getType() {
        return type;
    }

    /**
     * Get the content.
     *
     * @return The action content if exist or empty.
     */
    public String getContent() {
        return content;
    }

    /**
     * Get a list of extras.
     *
     * @return Map of extras.
     */
    public HashMap<String, Object> getExtras() {
        return extras;
    }

    // Execute
    public abstract void executeAction(String[][] replacements);

    public abstract void executeAction(Player player, String[][] replacements);

    public void execute() {
        execute(new String[][]{});
    }

    public void execute(String[][] replacements) {
        if (extras.containsKey("delay")) {
            try {
                int delay = Integer.parseInt((String) extras.get("delay"));
                if (delay > 0) {
                    JavaPlugin javaPlugin = actionManager.getJavaPlugin();
                    BukkitScheduler bukkitScheduler = javaPlugin.getServer().getScheduler();
                    if (extras.containsKey("async")) {
                        bukkitScheduler.runTaskLaterAsynchronously(javaPlugin, () -> executeAction(replacements), delay);
                    } else {
                        bukkitScheduler.runTaskLater(javaPlugin, () -> executeAction(replacements), delay);
                    }
                } else {
                    executeAction(replacements);
                }
            } catch (NumberFormatException e) {
                executeAction(replacements);
            }
        } else {
            executeAction(replacements);
        }
    }

    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    public void execute(Player player, String[][] replacements) {
        if (extras.containsKey("delay")) {
            try {
                int delay = Integer.parseInt((String) extras.get("delay"));
                if (delay > 0) {
                    JavaPlugin javaPlugin = actionManager.getJavaPlugin();
                    BukkitScheduler bukkitScheduler = javaPlugin.getServer().getScheduler();
                    if (extras.containsKey("async")) {
                        bukkitScheduler.runTaskLaterAsynchronously(javaPlugin, () -> executeAction(player, replacements), delay);
                    } else {
                        bukkitScheduler.runTaskLater(javaPlugin, () -> executeAction(player, replacements), delay);
                    }
                } else {
                    executeAction(replacements);
                }
            } catch (NumberFormatException e) {
                executeAction(replacements);
            }
        } else {
            executeAction(player, replacements);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        // Type
        result.append("[").append(type).append("]");
        // Content
        if (!content.isEmpty()) {
            result.append(" ").append(content).append(" ");
        }
        // Extra
        if (!extras.isEmpty()) {
            for (String extra : extras.keySet()) {
                if (((String) extras.get(extra)).isEmpty()) {
                    result.append("<").append(extra).append("> ");
                } else {
                    result.append("<").append(extra).append("=").append(extras.get(extra).toString()).append(">");
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