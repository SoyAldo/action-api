package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.TitleAction;
import com.soyaldo.actionapi.interfaces.ActionExpansion;
import com.soyaldo.actionapi.action.Action;
import com.soyaldo.actionapi.util.ActionInfo;

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