package me.soyaldo.actionapi.expansions;

import me.soyaldo.actionapi.actions.SoundAction;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;

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