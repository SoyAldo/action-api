package com.soyaldo.actionapi.managers;

import com.soyaldo.actionapi.Actions;
import com.soyaldo.actionapi.expansions.*;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

public class ActionManager {

    private final JavaPlugin javaPlugin;
    private final HashMap<String, ActionExpansion> expansions = new HashMap<>();

    public ActionManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public JavaPlugin getJavaPlugin() {
        return javaPlugin;
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

    public Action loadAction(String actionFormat) {
        Action action = null;
        ActionInfo actionInfo = new ActionInfo(this, actionFormat);
        if (expansions.containsKey(actionInfo.getType())) {
            ActionExpansion actionExpansion = expansions.get(actionInfo.getType());
            if (actionExpansion != null) {
                action = actionExpansion.generateAction(actionInfo);
            }
        }
        return action;
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