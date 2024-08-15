package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.MessageAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;

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