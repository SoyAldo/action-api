package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.ConsoleAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;

public class ConsoleExpansion extends ActionExpansion {

    public ConsoleExpansion(ActionManager actionManager) {
        super(actionManager, "console");
    }

    @Override
    public Action generateAction(String format) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new ConsoleAction(actionManager, value);
    }

}