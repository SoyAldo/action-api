package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.PlayerAction;
import org.kayteam.actionapi.util.ActionUtil;

public class PlayerExpansion extends ActionExpansion {

    public PlayerExpansion() {
        super( "player" );
    }

    @Override
    public Action generateAction( String format ) {
        return new PlayerAction( ActionUtil.getValue( format ) );
    }

}