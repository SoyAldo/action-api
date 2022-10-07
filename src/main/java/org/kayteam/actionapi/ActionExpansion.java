package org.kayteam.actionapi;

public abstract class ActionExpansion {

    private final String type;

    public ActionExpansion( String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract Action generateAction( String format );

}