package me.soyaldo.actionapi.models;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Actions {

    private final List<Action> actions = new ArrayList<>();

    public List<Action> getActions() {
        return actions;
    }

    /**
     * Check if an action exist by id
     *
     * @param id the action id to check
     * @return true if the action exist o false is not
     */
    public boolean containActionById(String id) {
        for (Action action : actions) {
            if (action.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an action exist by id
     *
     * @param action the action to check
     * @return true if the action exist o false is not
     */
    public boolean containAction(Action action) {
        return containActionById(action.getId());
    }

    /**
     * Add new action
     *
     * @param action the action added
     */
    public void addAction(Action action) {
        actions.add(action);
    }


    /**
     * Remove an action by id
     *
     * @param id the action id to remove
     * @return true if the action has removed o false is not
     */
    public boolean removeActionById(String id) {
        for (Action action : actions) {
            if (action.getId().equals(id)) {
                actions.remove(action);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove an action
     *
     * @param action the action to remove
     * @return true if the action has removed o false is not
     */
    public boolean removeAction(Action action) {
        return removeActionById(action.getId());
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