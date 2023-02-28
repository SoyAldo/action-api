package org.kayteam.actionapi;

import lombok.Data;
import org.bukkit.entity.Player;

@Data
public abstract class Action {

    private ActionManager actionManager;
    private String format;
    private final String type, value;

    public abstract void execute(Player player);

    public abstract void execute(Player player, String[][] replacements);

    @Override
    public String toString() {
        if (value.equals("")) return "[" + type + "]";

        return "[" + type + "] " + value;
    }

}