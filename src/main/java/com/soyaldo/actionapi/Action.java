package com.soyaldo.actionapi;

import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;
import org.bukkit.entity.Player;

public abstract class Action {

    private final ActionManager actionManager;
    private final String type, value;

    public Action(ActionManager actionManager, String type, String value) {
        this.actionManager = actionManager;
        this.type = type;
        this.value = value;
    }

    public Action(ActionManager actionManager, String format) {
        this.actionManager = actionManager;
        this.type = ActionUtil.getType(format);
        this.value = ActionUtil.getValue(format);
    }

    /**
     * Get the action manager that belongs to this action.
     * @return actionManager
     */
    public ActionManager getActionManager() {
        return actionManager;
    }

    /**
     * Get the action string format.
     * @return The formatted string format.
     */
    public String getFormat() {
        if (value.isEmpty()) return "[" + type + "]";
        return "[" + type + "] " + value;
    }

    /**
     * Ge the action type.
     * @return String with the action type.
     */
    public String getType() {
        return type;
    }

    /**
     * Ge the action value.
     * @return String with the action value.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getFormat();
    }

    public abstract void execute(Player player);

    public abstract void execute(Player player, String[][] replacements);

}