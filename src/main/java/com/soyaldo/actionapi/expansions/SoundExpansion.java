package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.actions.SoundAction;
import com.soyaldo.actionapi.util.ActionUtil;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;

public class SoundExpansion extends ActionExpansion {

    public SoundExpansion() {
        super( "sound" );
    }

    @Override
    public Action generateAction( String format ) {
        return new SoundAction( ActionUtil.getValue( format ) );
    }

}