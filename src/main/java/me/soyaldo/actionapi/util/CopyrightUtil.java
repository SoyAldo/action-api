package me.soyaldo.actionapi.util;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class CopyrightUtil {

    public static void sendVersion(JavaPlugin javaPlugin, CommandSender commandSender) {
        sendVersionStatus(javaPlugin, commandSender, "");
    }

    public static void sendVersionStatusFromConsole(JavaPlugin javaPlugin, String status) {
        sendVersionStatus(javaPlugin, javaPlugin.getServer().getConsoleSender(), status);
    }

    public static void sendVersionStatus(JavaPlugin javaPlugin, CommandSender commandSender, String status) {
        String[] versionStatus = {
                "&4»",
                "&4» &c" + javaPlugin.getDescription().getName() + " " + status,
                "&4»",
                "&4» &cVersion: &f" + javaPlugin.getDescription().getVersion(),
                "&4» &cAuthors: &f" + javaPlugin.getDescription().getAuthors(),
                "&4» &cWebsite: &f" + javaPlugin.getDescription().getWebsite(),
                "&4»",
                "&4» &cI love the bread!",
                "&4»"
        };
        for (String text : versionStatus) {
            ChatUtil.sendMessage(commandSender, text);
        }
    }

}