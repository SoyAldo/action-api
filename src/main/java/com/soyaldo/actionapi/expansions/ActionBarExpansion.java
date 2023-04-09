package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.ActionBarAction;
import com.soyaldo.actionapi.util.ActionUtil;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;

public class ActionBarExpansion extends ActionExpansion {

    public ActionBarExpansion() {
        super( "actionbar" );
    }

    @Override
    public Action generateAction( String format ) {
        return new ActionBarAction( ActionUtil.getValue( format ) );
    }

}