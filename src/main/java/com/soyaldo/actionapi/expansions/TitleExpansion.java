package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.TitleAction;
import com.soyaldo.actionapi.util.ActionUtil;

public class TitleExpansion extends ActionExpansion {

    public TitleExpansion() {
        super("title");
    }

    @Override
    public Action generateAction(String format) {
        return new TitleAction(ActionUtil.getValue(format));
    }

}