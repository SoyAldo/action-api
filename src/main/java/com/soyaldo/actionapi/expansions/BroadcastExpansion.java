package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.BroadcastAction;
import com.soyaldo.actionapi.util.ActionUtil;

public class BroadcastExpansion extends ActionExpansion {

    public BroadcastExpansion() {
        super("broadcast");
    }

    @Override
    public Action generateAction(String format) {
        return new BroadcastAction(ActionUtil.getValue(format));
    }

}