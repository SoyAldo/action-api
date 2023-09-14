package com.soyaldo.actionapi.util;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BrandUtil {

    public static void sendVersion(JavaPlugin javaPlugin, CommandSender commandSender) {
        sendVersionStatus(javaPlugin, commandSender, "");
    }

    public static void sendVersionStatusFromConsole(JavaPlugin javaPlugin, String status) {
        sendVersionStatus(javaPlugin, javaPlugin.getServer().getConsoleSender(), status);
    }

    public static void sendVersionStatus(JavaPlugin javaPlugin, CommandSender commandSender, String status) {
        String[] versionStatus = {
                "&4»",
                "&4» &caction-api " + status,
                "&4»",
                "&4» &cVersion: &f" + javaPlugin.getDescription().getVersion(),
                "&4» &cAuthor: &fSoyAldo",
                "&4» &cWebsite: &fhttps://soyaldo.com/plugins/action-api",
                "&4»",
                "&4» &cI love the bread!",
                "&4»"
        };
        for (String text : versionStatus) commandSender.sendMessage(ChatColorUtil.translate(text));
    }

}