package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.ActionBarAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;

public class ActionBarExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "actionbar";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new ActionBarAction(actionInfo);
    }
}