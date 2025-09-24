package me.soyaldo.actionapi.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class PapiUtil {

    public static String setPlaceholders(Player player, String text) {
        // Obtengo el plugin de PlaceholderAPI
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI");
        // Si el plugin de PlaceholderAPI no es nulo retorno el texto modificado de lo contrario el texto original
        return plugin != null ? PlaceholderAPI.setPlaceholders(player, text) : text;
    }

    public static String setPlaceholders(OfflinePlayer player, String text) {
        // Obtengo el plugin de PlaceholderAPI
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI");
        // Si el plugin de PlaceholderAPI no es nulo retorno el texto modificado de lo contrario el texto original
        return plugin != null ? PlaceholderAPI.setPlaceholders(player, text) : text;
    }

}