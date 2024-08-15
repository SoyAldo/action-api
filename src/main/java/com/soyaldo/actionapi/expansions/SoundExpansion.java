package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.SoundAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;

public class SoundExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "sound";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new SoundAction(actionInfo);
    }

}