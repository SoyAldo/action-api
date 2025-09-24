package me.soyaldo.actionapi.expansions;

import me.soyaldo.actionapi.actions.TitleAction;
import me.soyaldo.actionapi.interfaces.ActionExpansion;
import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.util.ActionInfo;

public class TitleExpansion implements ActionExpansion {

    @Override
    public String getName() {
        return "title";
    }

    @Override
    public Action generateAction(ActionInfo actionInfo) {
        return new TitleAction(actionInfo);
    }

}