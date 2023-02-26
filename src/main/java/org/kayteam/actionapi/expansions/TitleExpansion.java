package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.TitleAction;
import org.kayteam.actionapi.util.ActionUtil;

public class TitleExpansion extends ActionExpansion {

    public TitleExpansion() {
        super("title");
    }

    @Override
    public Action generateAction(String format) {
        return new TitleAction(ActionUtil.getValue(format));
    }

}