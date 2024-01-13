package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.CommandAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;

public class CommandExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "command";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new CommandAction(actionInfo);
    }

}