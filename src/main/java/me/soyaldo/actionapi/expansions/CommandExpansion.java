package me.soyaldo.actionapi.expansions;

import me.soyaldo.actionapi.actions.CommandAction;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;

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