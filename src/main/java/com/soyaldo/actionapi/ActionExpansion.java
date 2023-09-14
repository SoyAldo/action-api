package com.soyaldo.actionapi;

import com.soyaldo.actionapi.managers.ActionManager;

public abstract class ActionExpansion {

    private final ActionManager actionManager;
    private final String type;

    public ActionExpansion(ActionManager actionManager, String type) {
        this.actionManager = actionManager;
        this.type = type;
    }

    /**
     * Get the action manager.
     * @return actionManager
     */
    public ActionManager getActionManager() {
        return actionManager;
    }

    /**
     * Get the expansion type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Generate a new Action.
     * @param format The action format.
     * @return Action
     */
    public abstract Action generateAction(String format);

}