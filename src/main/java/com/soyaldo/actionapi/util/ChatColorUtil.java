package com.soyaldo.actionapi.util;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatColorUtil {

    private static final Pattern hexPattern = Pattern.compile("#([a-fA-F0-9]){6}");

    public static String translate(String text) {
        if (text.isEmpty()) return text;
        try {
            Matcher matcher = hexPattern.matcher(text);
            while (matcher.find()) {
                String color = text.substring(matcher.start(), matcher.end());
                text = text.replace(color, String.valueOf(ChatColor.of(color)));
                matcher = hexPattern.matcher(text);
            }
        } catch (Exception e) {
            return ChatColor.translateAlternateColorCodes('&', text);
        }

        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String translate(char colorChar, String text) {
        if (text.isEmpty()) return text;
        text = translateRGB(text);
        return ChatColor.translateAlternateColorCodes(colorChar, text);
    }

    public static String translateRGB(String text) {
        String finalText = text;
        try {
            Matcher matcher = hexPattern.matcher(finalText);
            while (matcher.find()) {
                String color = finalText.substring(matcher.start(), matcher.end());
                finalText = finalText.replace(color, String.valueOf(ChatColor.of(color)));
                matcher = hexPattern.matcher(finalText);
            }
        } catch (Exception e) {
            return text;
        }
        return finalText;
    }

    public static String strip(String text) {
        if (text.isEmpty()) return text;
        return ChatColor.stripColor(text);
    }

}