package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.SoundAction;
import org.kayteam.actionapi.util.ActionUtil;

public class SoundExpansion extends ActionExpansion {

    public SoundExpansion() {
        super( "sound" );
    }

    @Override
    public Action generateAction( String format ) {
        return new SoundAction( ActionUtil.getValue( format ) );
    }

}