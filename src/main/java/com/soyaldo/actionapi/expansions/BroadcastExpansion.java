package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.BroadcastAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;

public class BroadcastExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "broadcast";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new BroadcastAction(actionInfo);
    }

}