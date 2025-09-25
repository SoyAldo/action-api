package me.soyaldo.actionapi.managers;

import me.soyaldo.actionapi.models.Actions;
import me.soyaldo.actionapi.expansions.*;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
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
        addExpansion(new CommandExpansion());
        addExpansion(new ConsoleExpansion());
        addExpansion(new MessageExpansion());
        addExpansion(new PlayerExpansion());
        addExpansion(new SoundExpansion());
        addExpansion(new TitleExpansion());
    }

    /**
     * Check if an expansion exist
     *
     * @param expansionName the expansion name
     * @return true if the expansion exist or false if not
     */
    public boolean existExpansionByName(String expansionName) {
        return expansions.containsKey(expansionName);
    }

    /**
     * Add new expansion
     *
     * @param actionExpansion the expansion to add
     */
    public void addExpansion(ActionExpansion actionExpansion) {
        expansions.put(actionExpansion.getName(), actionExpansion);
    }

    /**
     * Remove an expansion
     *
     * @param expansionName the expansion name
     */
    public boolean removeExpansionByName(String expansionName) {
        return expansions.remove(expansionName) != null;
    }

    /**
     * Get an expansion by name
     *
     * @param expansionName the expansion name
     * @return The expansion if exist or null if not
     */
    public ActionExpansion getExpansionByName(String expansionName) {
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