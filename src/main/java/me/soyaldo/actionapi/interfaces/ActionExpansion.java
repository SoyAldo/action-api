package me.soyaldo.actionapi.interfaces;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.util.ActionInfo;

public interface ActionExpansion {

    /**
     * Get the expansion name.
     *
     * @return expansion name.
     */
    String getName();

    /**
     * Generate a new Action.
     *
     * @param actionInfo The action info.
     * @return Action
     */
    Action generateAction(ActionInfo actionInfo);

}