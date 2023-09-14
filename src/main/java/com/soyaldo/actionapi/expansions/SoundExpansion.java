package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.SoundAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;

public class SoundExpansion extends ActionExpansion {

    public SoundExpansion(ActionManager actionManager) {
        super(actionManager, "sound");
    }

    @Override
    public Action generateAction(String format) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new SoundAction(actionManager, value);
    }

}