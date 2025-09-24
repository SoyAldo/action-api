package me.soyaldo.actionapi.models;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Actions {

    private final List<Action> actions = new ArrayList<>();

    public List<Action> getActions() {
        return actions;
    }

    public boolean containAction(Action action) {
        return actions.contains(action);
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    public void execute() {
        actions.forEach(Action::execute);
    }

    public void execute(String[][] requirements) {
        actions.forEach(action -> action.execute(requirements));
    }

    public void execute(Player player) {
        actions.forEach(action -> action.execute(player));
    }

    public void execute(Player player, String[][] requirements) {
        actions.forEach(action -> action.execute(player, requirements));
    }

    public List<String> serialize() {
        List<String> serialized = new ArrayList<>();

        for (Action action : actions) {
            serialized.add(action.serialize());
        }

        return serialized;
    }

}