package com.soyaldo.actionapi.action;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Actions implements Serializable {

    private final List<Action> actions = new ArrayList<>();

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.add(action);
    }

    public void execute() {
        for (Action action : actions) {
            action.execute();
        }
    }

    public void execute(String[][] requirements) {
        for (Action action : actions) {
            action.execute(requirements);
        }
    }

    public void execute(Player player) {
        for (Action action : actions) {
            action.execute(player);
        }
    }

    public void execute(Player player, String[][] requirements) {
        for (Action action : actions) {
            action.execute(player, requirements);
        }
    }

    public List<String> serialize() {
        // Creating a new list of string.
        List<String> serialized = new ArrayList<>();
        // Adding the action format into serialized list.
        for (Action action : actions) {
            serialized.add(action.toString());
        }
        // Returning the serialized actions.
        return serialized;
    }

}