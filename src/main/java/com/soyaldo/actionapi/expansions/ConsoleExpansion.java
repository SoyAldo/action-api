package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.ConsoleAction;
import com.soyaldo.actionapi.util.ActionUtil;

public class ConsoleExpansion extends ActionExpansion {

    public ConsoleExpansion() {
        super("console");
    }

    @Override
    public Action generateAction(String format) {
        return new ConsoleAction(ActionUtil.getValue(format));
    }

}