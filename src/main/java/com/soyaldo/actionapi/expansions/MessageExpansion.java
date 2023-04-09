package com.soyaldo.actionapi.expansions;

import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.ActionExpansion;
import com.soyaldo.actionapi.actions.MessageAction;
import com.soyaldo.actionapi.util.ActionUtil;

public class MessageExpansion extends ActionExpansion {

    public MessageExpansion() {
        super( "message" );
    }

    @Override
    public Action generateAction( String format ) {
        return new MessageAction( ActionUtil.getValue( format ) );
    }

}