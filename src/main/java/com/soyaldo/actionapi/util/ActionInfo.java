package com.soyaldo.actionapi.util;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class ActionInfo {

    private final String type;
    private final String content;
    private final HashMap<String, Object> extras = new HashMap<>();

    public ActionInfo(String actionFormat) {
        String tempType = "";
        StringBuilder tempContent = new StringBuilder();
        List<String> tempExtras = new ArrayList<>();

        String[] parts = actionFormat.split(" ");
        for (String part : parts) {
            if (part.startsWith("(") && part.endsWith(")")) {
                tempType = part.substring(1, part.length() - 1);
                continue;
            }
            if (part.startsWith("<") && part.endsWith(">")) {
                tempExtras.add(part.substring(1, part.length() - 1));
                continue;
            }
            tempContent.append(part).append(" ");
        }
        if (tempContent.length() > 0) {
            tempContent = new StringBuilder(tempContent.substring(0, tempContent.length() - 1));
        }

        type = tempType;
        content = tempContent.toString();
        for (String tempExtra : tempExtras) {
            if (tempExtra.contains("=")) {
                String tempExtraName = tempExtra.split("=")[0];
                String tempExtraValue = tempExtra.split("=")[1];
                extras.put(tempExtraName, tempExtraValue);
            } else {
                extras.put(tempExtra, "");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        // Type
        result.append("(").append(type).append(")");
        // Content
        if (!content.isEmpty()) {
            result.append(" ").append(content).append(" ");
        }
        // Extra
        if (!extras.isEmpty()) {
            for (String extra : extras.keySet()) {
                if (((String) extras.get(extra)).isEmpty()) {
                    result.append("<").append(extra).append("> ");
                } else {
                    result.append("<").append(extra).append("=").append(extras.get(extra).toString()).append("> ");
                }
            }
        }
        // Remove last blank space.
        if (result.toString().endsWith(" ")) {
            result = new StringBuilder(result.substring(0, result.length() - 1));
        }
        // Return result.
        return result.toString();
    }
}