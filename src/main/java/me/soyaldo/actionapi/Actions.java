package me.soyaldo.actionapi;

import me.soyaldo.actionapi.models.Action;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Actions {

    private final List<Action> actions = new ArrayList<>();

    public boolean containAction(Action action) {
        return actions.contains(action);
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    public List<Action> getActions() {
        return actions;
    }

    public void execute() {
        for (Action action : actions) action.execute();
    }

    public void execute(String[][] requirements) {
        for (Action action : actions) action.execute(requirements);
    }

    public void execute(Player player) {
        for (Action action : actions) action.execute(player);
    }

    public void execute(Player player, String[][] requirements) {
        for (Action action : actions) action.execute(player, requirements);
    }

}