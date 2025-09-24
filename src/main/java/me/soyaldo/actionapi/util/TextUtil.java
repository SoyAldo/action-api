package me.soyaldo.actionapi.util;

public class TextUtil {

    public static String replace(String text, String[][] replacements) {
        String replacedText = text;
        for (String[] replacement : replacements) {
            replacedText = replacedText.replace(replacement[0], replacement[1]);
        }
        return replacedText;
    }

}