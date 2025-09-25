package me.soyaldo.actionapi.util;

public class NumberUtil {

    /**
     * Get a number from specific text.
     *
     * @param text The string number.
     * @param def  The default value if the text not is a text.
     * @param min  The minimum value
     * @return The text parsed or default value.
     */
    public static int getInt(String text, int def, int min) {
        try {
            return Math.max(Integer.parseInt(text), min);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

    /**
     * Get a number from specific text.
     *
     * @param text The string number.
     * @param def  The default value if the text not is a text.
     * @return The text parsed or default value.
     */
    public static int getInt(String text, int def) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

    /**
     * Get a number from specific text.
     *
     * @param text The string number.
     * @param def  The default value if the text not is a text.
     * @param min  The minimum value
     * @return The text parsed or default value.
     */
    public static double getDouble(String text, double def, double min) {
        try {
            return Math.max(Double.parseDouble(text), min);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

    /**
     * Get a number from specific text.
     *
     * @param text The string number.
     * @param def  The default value if the text not is a text.
     * @return The text parsed or default value.
     */
    public static double getDouble(String text, double def) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

    /**
     * Get a number from specific text.
     *
     * @param text The string number.
     * @param def  The default value if the text not is a text.
     * @param min  The minimum value
     * @return The text parsed or default value.
     */
    public static float getDouble(String text, float def, float min) {
        try {
            return Math.max(Float.parseFloat(text), min);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

    /**
     * Get a number from specific text.
     *
     * @param text The string number.
     * @param def  The default value if the text not is a text.
     * @return The text parsed or default value.
     */
    public static float getFloat(String text, float def) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException ignore) {
            return def;
        }
    }

}