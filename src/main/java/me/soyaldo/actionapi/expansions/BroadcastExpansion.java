package me.soyaldo.actionapi.expansions;

import me.soyaldo.actionapi.actions.BroadcastAction;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;

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