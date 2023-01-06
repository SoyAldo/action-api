package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.ActionBarAction;
import org.kayteam.actionapi.util.ActionUtil;

public class ActionBarExpansion extends ActionExpansion {

    public ActionBarExpansion() {
        super( "actionbar" );
    }

    @Override
    public Action generateAction( String format ) {
        return new ActionBarAction( ActionUtil.getValue( format ) );
    }

}