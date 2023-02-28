package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.BroadcastAction;
import org.kayteam.actionapi.util.ActionUtil;

public class BroadcastExpansion extends ActionExpansion {

    public BroadcastExpansion() {
        super("broadcast");
    }

    @Override
    public Action generateAction(String format) {
        return new BroadcastAction(ActionUtil.getValue(format));
    }

}