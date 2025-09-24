package me.soyaldo.actionapi.expansions;

import me.soyaldo.actionapi.actions.ActionBarAction;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.util.ActionInfo;

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