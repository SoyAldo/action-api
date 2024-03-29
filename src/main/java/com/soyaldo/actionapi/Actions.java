package com.soyaldo.actionapi;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Actions {

    private final LinkedHashMap<String, Action> actions = new LinkedHashMap<>();

    public boolean existAction(String format) {
        return actions.containsKey(format);
    }

    public void addAction(Action action) {
        actions.put(action.getFormat(), action);
    }

    public Action getAction(String format) {
        return actions.get(format);
    }

    public void removeAction(String format) {
        actions.remove(format);
    }

    public void executeAll(Player player) {
        actions.values().forEach(action -> action.execute(player));
    }

    public void executeAll(Player player, String[][] replacements) {
        actions.values().forEach(action -> action.execute(player, replacements));
    }

    public List<String> serialize() {
        List<String> result = new ArrayList<>();

        for (Action action : actions.values()) result.add(action.toString());

        return result;
    }

}