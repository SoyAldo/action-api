package com.soyaldo.actionapi.action;

import com.soyaldo.actionapi.expansions.*;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.util.ActionInfo;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

public class ActionManager {

    @Getter
    private final JavaPlugin javaPlugin;
    private final HashMap<String, ActionExpansion> expansions = new HashMap<>();

    public ActionManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public void registerManager() {
        reloadManager();
    }

    public void reloadManager() {
        // Clear current expansions.
        expansions.clear();
        // Adding default expansion.
        addExpansion(new ActionBarExpansion());
        addExpansion(new BroadcastExpansion());
        addExpansion(new CommandExpansion());
        addExpansion(new ConsoleExpansion());
        addExpansion(new MessageExpansion());
        addExpansion(new PlayerExpansion());
        addExpansion(new SoundExpansion());
        addExpansion(new TitleExpansion());
    }

    public boolean existExpansion(String expansionName) {
        return expansions.containsKey(expansionName);
    }

    public void addExpansion(ActionExpansion actionExpansion) {
        expansions.put(actionExpansion.getName(), actionExpansion);
    }

    public void removeExpansion(String expansionName) {
        expansions.remove(expansionName);
    }

    public ActionExpansion getExpansion(String expansionName) {
        return expansions.get(expansionName);
    }

    /**
     * Load an Action from action format.
     *
     * @param actionFormat The action format.
     * @return Action if the format is correct of null if not.
     */
    public Action loadAction(String actionFormat) {
        // Create a new instance of ActionInfo with the action format.
        ActionInfo actionInfo = new ActionInfo(actionFormat);
        // Get the ActionExpansion from the expansions map.
        ActionExpansion actionExpansion = expansions.get(actionInfo.getType());
        // If the ActionExpansion is null. Return clause.
        if (actionExpansion == null) return null;
        // Return the Action.
        return actionExpansion.generateAction(actionInfo);
    }

    public Actions loadActions(List<String> actionFormats) {
        Actions actions = new Actions();
        for (String actionFormat : actionFormats) {
            Action action = loadAction(actionFormat);
            if (action != null) {
                actions.addAction(action);
            }
        }
        return actions;
    }

}