package me.soyaldo.actionapi.expansions;

import me.soyaldo.actionapi.actions.MessageAction;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.util.ActionInfo;

public class MessageExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "message";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new MessageAction(actionInfo);
    }

}