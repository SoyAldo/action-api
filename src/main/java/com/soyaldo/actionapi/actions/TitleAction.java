package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.MineDown;
import com.soyaldo.actionapi.util.Number;
import com.soyaldo.actionapi.util.PlaceholderApi;
import org.bukkit.entity.Player;

public class TitleAction extends Action {

    public TitleAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        if (getContent().isEmpty()) return;
        if (!getExtras().containsKey("global")) return;

        String content = getContent();
        // Default values.
        String title;
        String subTitle = "";
        int fadeIn = 10;
        int stay = 70;
        int fadeOut = 20;
        // Setting values.
        if (!content.contains(";")) {
            // Setting the title.
            title = content;
            // Apply replacements.
            for (String[] replacement : replacements) {
                title = title.replace(replacement[0], replacement[1]);
            }
            // Apply colors.
            title = MineDown.parseLegacy(title);
        } else {
            String[] values = content.split(";");
            // Apply title and subtitle.
            title = values[0];
            subTitle = values[1];
            // Apply replacements.
            for (String[] replacement : replacements) {
                title = title.replace(replacement[0], replacement[1]);
                subTitle = title.replace(replacement[0], replacement[1]);
            }
            // Apply colors.
            title = MineDown.parseLegacy(title);
            subTitle = MineDown.parseLegacy(subTitle);
            // Apply fade in.
            if (values.length > 2) fadeIn = Number.getInt(values[2], fadeIn);
            // Apply stay.
            if (values.length > 3) stay = Number.getInt(values[3], stay);
            // Apply fade out.
            if (values.length > 4) fadeOut = Number.getInt(values[4], fadeOut);
        }
        // Send title.
        for (Player target : getActionManager().getJavaPlugin().getServer().getOnlinePlayers()) {
            target.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
        }
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        if (getContent().isEmpty()) return;
        String content = getContent();
        // Default values.
        String title;
        String subTitle = "";
        int fadeIn = 10;
        int stay = 70;
        int fadeOut = 20;
        // Setting values.
        if (!content.contains(";")) {
            // Setting the title.
            title = content;
            // Apply replacements.
            for (String[] replacement : replacements) {
                title = title.replace(replacement[0], replacement[1]);
            }
            // Apply PlaceholderAPI placeholders.
            title = PlaceholderApi.setPlaceholders(player, title);
            // Apply colors.
            title = MineDown.parseLegacy(title);
        } else {
            String[] values = content.split(";");
            // Apply title and subtitle.
            title = values[0];
            subTitle = values[1];
            // Apply replacements.
            for (String[] replacement : replacements) {
                title = title.replace(replacement[0], replacement[1]);
                subTitle = title.replace(replacement[0], replacement[1]);
            }
            // Apply PlaceholderAPI placeholders.
            title = PlaceholderApi.setPlaceholders(player, title);
            subTitle = PlaceholderApi.setPlaceholders(player, subTitle);
            // Apply colors.
            title = MineDown.parseLegacy(title);
            subTitle = MineDown.parseLegacy(subTitle);
            // Apply fade in.
            if (values.length > 2) fadeIn = Number.getInt(values[2], fadeIn);
            // Apply stay.
            if (values.length > 3) stay = Number.getInt(values[3], stay);
            // Apply fade out.
            if (values.length > 4) fadeOut = Number.getInt(values[4], fadeOut);
        }
        // Send title.
        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
    }

}