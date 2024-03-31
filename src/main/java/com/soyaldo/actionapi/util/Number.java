package com.soyaldo.actionapi.util;

public class Number {

    /**
     * Get a number from specific text.
     * @param text The string number.
     * @param def The default value if the text not is a text.
     * @return The text parsed or default value.
     */
    public static int getInt(String text, int def) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

}