package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.PlayerAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;

public class PlayerExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "player";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new PlayerAction(actionInfo);
    }

}