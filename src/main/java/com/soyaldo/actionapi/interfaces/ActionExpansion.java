package com.soyaldo.actionapi.interfaces;

import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;

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