package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.BroadcastAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;

public class BroadcastExpansion extends ActionExpansion {

    public BroadcastExpansion(ActionManager actionManager) {
        super(actionManager, "broadcast");
    }

    @Override
    public Action generateAction(String format) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new BroadcastAction(actionManager, value);
    }

}