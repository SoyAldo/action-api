package com.soyaldo.actionapi.v2;

import java.util.ArrayList;
import java.util.List;

public class Action {

    private final String type;
    private String content = "";
    private List<String> extras = new ArrayList<>();

    public Action(String type) {
        this.type = type;
    }

    /*
    String action = "(message) Hi :D <delay=10> <async>";

        String type = "";
        String content = "";
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

            content = content + part + " ";
        }
        if (!content.isEmpty()) {
            content = content.substring(0, content.length() - 1);
        }

        System.out.println("Type: '" + type + "'");
        System.out.println("Content: '" + content + "'");
        System.out.println("Extras: '" + extras.toString() + "'");
     */

}