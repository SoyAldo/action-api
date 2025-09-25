package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.NumberUtil;
import me.soyaldo.actionapi.util.PapiUtil;
import org.bukkit.entity.Player;

public class TitleAction extends Action {

    public TitleAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        if (getActionInfo().getContent().isEmpty()) return;
        if (!getActionInfo().getExtras().containsKey("global")) return;

        String content = getActionInfo().getContent();
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
            title = ChatUtil.colorizeLegacy(title);
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
            title = ChatUtil.colorizeLegacy(title);
            subTitle = ChatUtil.colorizeLegacy(subTitle);
            // Apply fade in.
            if (values.length > 2) fadeIn = NumberUtil.getInt(values[2], fadeIn);
            // Apply stay.
            if (values.length > 3) stay = NumberUtil.getInt(values[3], stay);
            // Apply fade out.
            if (values.length > 4) fadeOut = NumberUtil.getInt(values[4], fadeOut);
        }
        // Send title.
        for (Player target : getActionManager().getJavaPlugin().getServer().getOnlinePlayers()) {
            target.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
        }
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        if (getActionInfo().getContent().isEmpty()) return;
        String content = getActionInfo().getContent();
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
            title = PapiUtil.setPlaceholders(player, title);
            // Apply colors.
            title = ChatUtil.colorizeLegacy(title);
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
            title = PapiUtil.setPlaceholders(player, title);
            subTitle = PapiUtil.setPlaceholders(player, subTitle);
            // Apply colors.
            title = ChatUtil.colorizeLegacy(title);
            subTitle = ChatUtil.colorizeLegacy(subTitle);
            // Apply fade in.
            if (values.length > 2) fadeIn = NumberUtil.getInt(values[2], fadeIn);
            // Apply stay.
            if (values.length > 3) stay = NumberUtil.getInt(values[3], stay);
            // Apply fade out.
            if (values.length > 4) fadeOut = NumberUtil.getInt(values[4], fadeOut);
        }
        // Send title.
        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
    }

}