package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.ConsoleAction;
import org.kayteam.actionapi.util.ActionUtil;

public class ConsoleExpansion extends ActionExpansion {

    public ConsoleExpansion() {
        super( "console" );
    }

    @Override
    public Action generateAction( String format ) {
        return new ConsoleAction( ActionUtil.getValue( format ) );
    }

}