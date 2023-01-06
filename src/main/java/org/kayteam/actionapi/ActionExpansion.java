package org.kayteam.actionapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public abstract class ActionExpansion {

    private final String type;

    public abstract Action generateAction(String format);

}