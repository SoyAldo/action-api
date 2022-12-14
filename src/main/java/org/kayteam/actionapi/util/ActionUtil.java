package org.kayteam.actionapi.util;

public class ActionUtil {

    public static String getType(String format) {
        String type = format;

        if (format.contains(" ")) type = format.split(" ")[0];

        type = type.replaceFirst("\\[", "");
        type = type.replaceFirst("]", "");

        return type;
    }

    public static String getValue(String format) {
        String value = "";

        if (!format.contains(" ")) return value;

        value = format;
        value = value.substring(getType(format).length() + 3);

        return value;

    }

}