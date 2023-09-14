package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.ActionBarAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;

public class ActionBarExpansion extends ActionExpansion {

    public ActionBarExpansion(ActionManager actionManager) {
        super(actionManager, "actionbar");
    }

    @Override
    public Action generateAction( String format ) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new ActionBarAction(actionManager, value);
    }

}