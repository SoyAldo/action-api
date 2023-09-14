package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.ChatColorUtil;
import org.bukkit.entity.Player;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.util.PlaceholderAPIUtil;

public class TitleAction extends Action {

    public TitleAction(ActionManager actionManager, String value) {
        super(actionManager, "title", value);
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
                title = title.replace(replacement[0], replacement[1]);
            }

            // PlaceholderAPI
            title = PlaceholderAPIUtil.setPlaceholders(player, title);

            // Color
            title = ChatColorUtil.translate(title);

            player.sendTitle(title, subTitle, 10, 70, 20);
            return;
        }

        String[] values = getValue().split(";");

        title = values[0];
        subTitle = values[1];

        // Replacements
        for (String[] replacement : replacements) {
            title = title.replace(replacement[0], replacement[1]);
            subTitle = title.replace(replacement[0], replacement[1]);
        }

        // PlaceholderAPI
        title = PlaceholderAPIUtil.setPlaceholders(player, title);
        subTitle = PlaceholderAPIUtil.setPlaceholders(player, subTitle);

        // Color
        title = ChatColorUtil.translate(title);
        subTitle = ChatColorUtil.translate(subTitle);

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