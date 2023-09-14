package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.TitleAction;
import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ActionUtil;

public class TitleExpansion extends ActionExpansion {

    public TitleExpansion(ActionManager actionManager) {
        super(actionManager, "title");
    }

    @Override
    public Action generateAction(String format) {
        ActionManager actionManager = getActionManager();
        String value = ActionUtil.getValue(format);
        return new TitleAction(actionManager, value);
    }

}