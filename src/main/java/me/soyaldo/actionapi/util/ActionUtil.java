package me.soyaldo.actionapi.util;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ActionUtil {

    public static String processText(String text, Player player, String[][] replacements) {
        String modifiedText = text;
        modifiedText = TextUtil.replace(modifiedText, replacements);
        modifiedText = PapiUtil.setPlaceholders(player, modifiedText);
        modifiedText = ColorUtil.colorizeLegacy(modifiedText);
        return modifiedText;
    }

    public static String processText(String text, String[][] replacements) {
        String modifiedText = text;
        modifiedText = TextUtil.replace(modifiedText, replacements);
        modifiedText = ColorUtil.colorizeLegacy(modifiedText);
        return modifiedText;
    }

    public static ConsoleCommandSender getConsole() {
        return Bukkit.getConsoleSender();
    }

}