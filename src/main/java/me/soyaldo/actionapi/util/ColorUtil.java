package me.soyaldo.actionapi.util;

import de.themoep.minedown.MineDown;
import net.md_5.bungee.api.chat.BaseComponent;

public class ColorUtil {

    public static BaseComponent[] colorize(String text) {
        return MineDown.parse(text);
    }

    public static String colorizeLegacy(String text) {
        StringBuilder result = new StringBuilder();
        for (BaseComponent component : MineDown.parse(text)) {
            result.append(component.toLegacyText()).append(" ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return result.toString();
    }

}
