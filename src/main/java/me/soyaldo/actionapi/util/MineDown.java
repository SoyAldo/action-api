package me.soyaldo.actionapi.util;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class MineDown {

    public static BaseComponent[] parse(String text) {
        return new BaseComponent[]{
                new TextComponent(text)
        };
    }

    public static String parseLegacy(String text) {
        StringBuilder result = new StringBuilder();
        for (BaseComponent component : parse(text)) {
            result.append(component.toLegacyText()).append(" ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return result.toString();
    }

}