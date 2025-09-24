package me.soyaldo.actionapi.util;

import me.soyaldo.actionapi.managers.ActionManager;

import java.util.HashMap;

public class ActionInfo {

    private final ActionManager actionManager;
    private final String type;
    private final String content;
    private final HashMap<String, Object> extras;

    public ActionInfo(ActionManager actionManager, String actionFormat) {
        this.actionManager = actionManager;
        String tempType = "";
        StringBuilder tempContent = new StringBuilder();
        HashMap<String, Object> tempExtras = new HashMap<>();
        String[] parts = actionFormat.split(" ");
        for (String part : parts) {
            if (part.startsWith("[") && part.endsWith("]")) {
                tempType = part.substring(1, part.length() - 1);
                continue;
            }
            if (part.startsWith("<") && part.endsWith(">")) {
                String extra = part.substring(1, part.length() - 1);
                if (extra.contains("=")) {
                    tempExtras.put(extra.split("=")[0], extra.split("=")[1]);
                } else {
                    tempExtras.put(extra, "");
                }
                continue;
            }

            tempContent.append(part).append(" ");
        }
        if (tempContent.length() > 0) {
            tempContent = new StringBuilder(tempContent.substring(0, tempContent.length() - 1));
        }

        this.type = tempType;
        this.content = tempContent.toString();
        this.extras = tempExtras;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public HashMap<String, Object> getExtras() {
        return extras;
    }

}