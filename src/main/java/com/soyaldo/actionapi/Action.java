package com.soyaldo.actionapi;

import com.soyaldo.actionapi.util.ActionUtil;
import org.bukkit.entity.Player;

public abstract class Action {

    private ActionManager actionManager;
    private String format;
    private final String type, value;

    public Action(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public abstract void execute(Player player);

    public abstract void execute(Player player, String[][] replacements);

    @Override
    public String toString() {
        if (value.equals("")) return "[" + type + "]";

        return "[" + type + "] " + value;
    }

}