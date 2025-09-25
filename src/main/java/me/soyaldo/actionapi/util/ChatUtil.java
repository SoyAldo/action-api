package me.soyaldo.actionapi.util;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class ChatUtil {

    public static void sendMessage(List<Player> players, String message, String[][] replacements) {
        // Apply the replacements
        message = TextUtil.replace(message, replacements);
        // Enviamos el mensaje a cada jugador dentro de la lista de jugadores
        for (Player player : players) {
            // Apply the variables from PlaceholderAPI.
            message = PapiUtil.setPlaceholders(player, message);
            // Send the message to the player.
            player.spigot().sendMessage(ColorUtil.colorize(message));
        }
    }

    public static void sendMessage(Player player, String message, String[][] replacements) {
        sendMessage(Collections.singletonList(player), message, replacements);
    }

    public static void sendMessage(List<Player> players, String message) {
        sendMessage(players, message, new String[][]{});
    }

    public static void sendMessage(Player player, String message) {
        sendMessage(Collections.singletonList(player), message, new String[][]{});
    }

    public static void sendMessage(ConsoleCommandSender console, String message, String[][] replacements) {
        // Apply the replacements
        message = TextUtil.replace(message, replacements);
        // Send the message to the console.
        console.spigot().sendMessage(ColorUtil.colorize(message));
    }

    public static void sendMessage(ConsoleCommandSender console, String message) {
        sendMessage(console, message, new String[][]{});
    }

    public static void sendMessage(CommandSender sender, String message, String[][] replacements) {
        if (sender instanceof Player) {
            sendMessage((Player) sender, message, replacements);
        } else {
            sendMessage((ConsoleCommandSender) sender, message, replacements);
        }
    }

    public static void sendMessage(CommandSender sender, String message) {
        sendMessage(sender, message, new String[][]{});
    }

    public static void sendActionBar(List<Player> players, String message, String[][] replacements) {
        // Apply the replacements
        message = TextUtil.replace(message, replacements);
        // Enviamos el mensaje a cada jugador dentro de la lista de jugadores
        for (Player player : players) {
            // Apply the variables from PlaceholderAPI.
            message = PapiUtil.setPlaceholders(player, message);
            // Send the message to the player.
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, ColorUtil.colorize(message));
        }
    }

    public static void sendActionBar(Player player, String message, String[][] replacements) {
        sendActionBar(Collections.singletonList(player), message, replacements);
    }

    public static void sendActionBar(List<Player> players, String message) {
        sendActionBar(players, message, new String[][]{});
    }

    public static void sendActionBar(Player player, String message) {
        sendActionBar(Collections.singletonList(player), message, new String[][]{});
    }

}