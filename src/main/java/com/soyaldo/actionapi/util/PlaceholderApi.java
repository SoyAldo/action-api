package com.soyaldo.actionapi.util;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class PlaceholderApi {

    public static boolean isPluginLoaded() {
        Server server = Bukkit.getServer();
        PluginManager pluginManager = server.getPluginManager();
        Plugin placeholderapi = pluginManager.getPlugin("PlaceholderAPI");
        return placeholderapi != null;
    }

    /**
     * Set placeholders in the text.
     *
     * @param player Player be the replacement target.
     * @param text   Text to be replaced the placeholders.
     * @return The text with the placeholders replaced if PlaceholderAPI is installed or the text without changes if not.
     */
    public static String setPlaceholders(Player player, String text) {
        if (!isPluginLoaded()) return text;
        return PlaceholderAPI.setPlaceholders(player, text);
    }

    /**
     * Set placeholders in the text.
     *
     * @param offlinePlayer Player be the replacement target.
     * @param text          Text to be replaced the placeholders.
     * @return The text with the placeholders replaced if PlaceholderAPI is installed or the text without changes if not.
     */
    public static String setPlaceholders(OfflinePlayer offlinePlayer, String text) {
        if (!isPluginLoaded()) return text;
        return PlaceholderAPI.setPlaceholders(offlinePlayer, text);
    }

    /**
     * Register a PlaceholderExpansion.
     *
     * @param placeholderExpansion The PlaceholderExpansion to register.
     * @return true if the PlaceholderExpansion has been registered or false if not.
     */
    public static boolean registerExpansion(PlaceholderExpansion placeholderExpansion) {
        if (!isPluginLoaded()) return false;
        return placeholderExpansion.register();
    }

}