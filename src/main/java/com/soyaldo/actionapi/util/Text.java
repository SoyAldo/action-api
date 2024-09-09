package com.soyaldo.actionapi.util;

public class Text {

    public static String replace(String text, String[][] replacements) {
        for (String[] replacement : replacements) {
            text = text.replace(replacement[0], replacement[1]);
        }
        return text;
    }

}