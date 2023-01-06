package org.kayteam.actionapi;

import lombok.Getter;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.actionapi.expansions.*;
import org.kayteam.actionapi.util.ActionUtil;
import org.kayteam.actionapi.util.VaultUtil;

import java.util.HashMap;
import java.util.List;

public class ActionManager {

    @Getter private final JavaPlugin javaPlugin;
    @Getter private Economy economy;
    @Getter private final HashMap<String, ActionExpansion> actionExpansions;

    public ActionManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        economy = null;
        actionExpansions = new HashMap<>();
    }

    public void registerManager() {
        if (VaultUtil.isEconomyEnabled()) economy = VaultUtil.getEconomy();

        addActionExpansion(new ActionBarExpansion());
        addActionExpansion(new ConsoleExpansion());
        addActionExpansion(new MessageExpansion());
        addActionExpansion(new PlayerExpansion());
        addActionExpansion(new SoundExpansion());

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
        String type = ActionUtil.getType(format);

        ActionExpansion actionExpansion = this.actionExpansions.get(type);

        if (actionExpansion == null) return null;

        Action action = actionExpansion.generateAction(format);

        if (action == null) return null;

        action.setFormat(format);
        action.setActionManager(this);

        return action;
    }

    public Actions loadActions(List<String> formats) {
        Actions actions = new Actions();

        for (String format : formats) {
            Action action = loadAction(format);

            if (action == null) continue;

            actions.addAction(action);
        }

        return actions;
    }

}