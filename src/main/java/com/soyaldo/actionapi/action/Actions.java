package com.soyaldo.actionapi.action;

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

    public void asd() {
        String action = "(message) Hi :D <delay=10> <async>";

        String type = "";
        StringBuilder content = new StringBuilder();
        List<String> extras = new ArrayList<>();

        String[] parts = action.split(" ");
        for (String part : parts) {
            if (part.startsWith("(") && part.endsWith(")")) {
                type = part.substring(1, part.length() - 1);
                continue;
            }
            if (part.startsWith("<") && part.endsWith(">")) {
                extras.add(part.substring(1, part.length() - 1));
                continue;
            }

            content.append(part).append(" ");
        }
        if (content.length() > 0) {
            content = new StringBuilder(content.substring(0, content.length() - 1));
        }

        System.out.println("Type: '" + type + "'");
        System.out.println("Content: '" + content + "'");
        System.out.println("Extras: '" + extras.toString() + "'");
    }

}