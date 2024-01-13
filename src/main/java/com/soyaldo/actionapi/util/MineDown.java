package com.soyaldo.actionapi.util;

import net.md_5.bungee.api.chat.BaseComponent;

public class MineDown {

    public static BaseComponent[] parse(String text) {
        return de.themoep.minedown.MineDown.parse(text);
    }

    public static String parseLegacy(String text) {
        String result = "";
        for (BaseComponent component : de.themoep.minedown.MineDown.parse(text)) {
            result = result + component.toLegacyText() + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

}