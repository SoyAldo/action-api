package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.PlayerAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;

public class PlayerExpansion extends ActionExpansion {

    public PlayerExpansion(ActionManager actionManager) {
        super(actionManager, "player");
    }

    @Override
    public Action generateAction(String format) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new PlayerAction(actionManager, value);
    }

}