package com.soyaldo.actionapi.util;

public class ActionUtil {

    /**
     * Get the type from a format.
     * @param format Format to get the type.
     * @return String with the action type.
     */
    public static String getType(String format) {
        String type = format;
        if (format.contains(" ")) type = format.split(" ")[0];

        type = type.replaceFirst("\\[", "");
        type = type.replaceFirst("]", "");

        return type;
    }

    /**
     * Get the value from a format.
     * @param format Format to get the value.
     * @return String with the action value.
     */
    public static String getValue(String format) {
        String value = "";
        if (!format.contains(" ")) return value;

        value = format;
        value = value.substring(getType(format).length() + 3);

        return value;

    }

}