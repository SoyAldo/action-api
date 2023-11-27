package com.soyaldo.actionapi.managers;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.Actions;
import com.soyaldo.actionapi.expansions.*;
import com.soyaldo.actionapi.util.ActionUtil;
import com.soyaldo.actionapi.util.VaultUtil;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

public class ActionManager {

    private final JavaPlugin javaPlugin;
    private Economy economy = null;
    private final HashMap<String, ActionExpansion> actionExpansions = new HashMap<>();
    private final BukkitAudiences bukkitAudiences;

    public ActionManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        bukkitAudiences = BukkitAudiences.create(javaPlugin);
    }

    public JavaPlugin getJavaPlugin() {
        return javaPlugin;
    }

    public BukkitAudiences getBukkitAudiences() {
        return bukkitAudiences;
    }

    public Economy getEconomy() {
        return economy;
    }

    public void registerManager() {
        if (VaultUtil.isEconomyEnabled()) {
            economy = VaultUtil.getEconomy();
        }

        addActionExpansion(new ActionBarExpansion(this));
        addActionExpansion(new BroadcastExpansion(this));
        addActionExpansion(new ConsoleExpansion(this));
        addActionExpansion(new MessageExpansion(this));
        addActionExpansion(new PlayerExpansion(this));
        addActionExpansion(new SoundExpansion(this));
        addActionExpansion(new TitleExpansion(this));

    }

    public void reloadManager() {

    }

    public boolean existActionExpansion(String type) {
        return actionExpansions.containsKey(type);
    }

    public void addActionExpansion(ActionExpansion actionExpansion) {
        actionExpansions.put(actionExpansion.getType(), actionExpansion);
    }

    public void removeActionExpansion(String type) {
        actionExpansions.remove(type);
    }

    public ActionExpansion getActionExpansion(String type) {
        return actionExpansions.get(type);
    }

    public Action loadAction(String format) {
        // Get the action type of the format.
        String actionType = ActionUtil.getType(format);

        // Get the ActionExpansion corresponding to the type of action.
        ActionExpansion actionExpansion = actionExpansions.get(actionType);

        // If the ActionExpansion is not null.
        if (actionExpansion != null) {
            // Return the Action.
            return actionExpansion.generateAction(format);
        }

        // Return null.
        return null;
    }

    public Actions loadActions(List<String> formats) {
        // Create a new Actions.
        Actions actions = new Actions();

        // Iterate all formats.
        for (String format : formats) {

            // Create a new Action from the load method with the format.
            Action action = loadAction(format);

            // If Action created is not null.
            if (action != null) {

                // Add the Action to Actions.
                actions.addAction(action);

            }

        }

        // Return the Actions.
        return actions;
    }

}