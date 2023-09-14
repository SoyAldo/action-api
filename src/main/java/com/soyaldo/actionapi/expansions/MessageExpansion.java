package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.MessageAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;

public class MessageExpansion extends ActionExpansion {

    public MessageExpansion(ActionManager actionManager) {
        super(actionManager, "message" );
    }

    @Override
    public Action generateAction( String format ) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new MessageAction(actionManager, value);
    }

}