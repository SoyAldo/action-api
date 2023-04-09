package com.soyaldo.actionapi.actions;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.util.PlaceholderAPIUtil;

public class TitleAction extends Action {

    public TitleAction(String value) {
        super("title", value);
    }

    @Override
    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    @Override
    public void execute(Player player, String[][] replacements) {
        if (getValue().isEmpty()) return;

        String title;
        String subTitle = "";

        if (!getValue().contains(";")) {

            title = getValue();

            // Replacements
            for (String[] replacement : replacements) {
                try {
                    title = StringUtils.replace(title, replacement[0], replacement[1]);
                } catch (Exception ignored) {
                }
            }

            // PlaceholderAPI
            title = PlaceholderAPIUtil.setPlaceholders(player, title);

            // Color
            title = ChatColor.translateAlternateColorCodes('&', title);

            player.sendTitle(title, subTitle, 10, 70, 20);
            return;
        }

        String[] values = getValue().split(";");

        title = values[0];
        subTitle = values[1];

        // Replacements
        for (String[] replacement : replacements) {
            try {
                title = StringUtils.replace(title, replacement[0], replacement[1]);
                subTitle = StringUtils.replace(subTitle, replacement[0], replacement[1]);
            } catch (Exception ignored) {
            }
        }

        // PlaceholderAPI
        title = PlaceholderAPIUtil.setPlaceholders(player, title);
        subTitle = PlaceholderAPIUtil.setPlaceholders(player, subTitle);

        // Color
        title = ChatColor.translateAlternateColorCodes('&', title);
        subTitle = ChatColor.translateAlternateColorCodes('&', subTitle);

        int fadeIn = 10;
        int stay = 70;
        int fadeOut = 20;

        if (values.length > 2) {
            try {
                fadeIn = Integer.parseInt(values[2]);
            } catch (NumberFormatException ignore) {
            }
        }

        if (values.length > 3) {
            try {
                stay = Integer.parseInt(values[3]);
            } catch (NumberFormatException ignore) {
            }
        }

        if (values.length > 4) {
            try {
                fadeOut = Integer.parseInt(values[4]);
            } catch (NumberFormatException ignore) {
            }
        }

        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
    }

}