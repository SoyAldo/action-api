package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.EffectAction;
import org.kayteam.actionapi.util.ActionUtil;

public class EffectExpansion extends ActionExpansion {

    public EffectExpansion() {
        super("effect");
    }

    @Override
    public Action generateAction(String format) {
        return new EffectAction(ActionUtil.getValue(format));
    }

}