package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.PlayerAction;
import com.soyaldo.actionapi.util.ActionUtil;

public class PlayerExpansion extends ActionExpansion {

    public PlayerExpansion() {
        super( "player" );
    }

    @Override
    public Action generateAction(String format ) {
        return new PlayerAction( ActionUtil.getValue( format ) );
    }

}