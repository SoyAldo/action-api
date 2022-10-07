package org.kayteam.actionapi.expansions;

import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.ActionExpansion;
import org.kayteam.actionapi.actions.MessageAction;
import org.kayteam.actionapi.util.ActionUtil;

public class MessageExpansion extends ActionExpansion {

    public MessageExpansion() {
        super( "message" );
    }

    @Override
    public Action generateAction( String format ) {

        String value = ActionUtil.getValue( format );

        return new MessageAction( value );

    }

}