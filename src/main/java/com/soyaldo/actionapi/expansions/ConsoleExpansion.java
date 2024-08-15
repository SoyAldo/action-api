package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.ConsoleAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;

public class ConsoleExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "console";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new ConsoleAction(actionInfo);
    }

}