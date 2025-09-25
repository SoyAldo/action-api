package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ActionUtil;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.NumberUtil;
import org.bukkit.entity.Player;

public class TitleAction extends Action {

    public TitleAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        ChatUtil.sendMessage(ActionUtil.getConsole(), getActionInfo().getContent(), replacements);
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        // Default values.
        String title = getActionInfo().getContent();
        String subTitle = "";
        int fadeIn = NumberUtil.getInt(String.valueOf(getActionInfo().getExtras().get("fade-in")), 10, 0);
        int stay = NumberUtil.getInt(String.valueOf(getActionInfo().getExtras().get("stay")), 70, 0);
        int fadeOut = NumberUtil.getInt(String.valueOf(getActionInfo().getExtras().get("fade-out")), 20, 0);
        // Check title and subtitle
        if (title.contains(";")) {
            String[] values = title.split(";");
            // Apply title and subtitle.
            title = values[0];
            subTitle = values[1];
        }
        // Apply replacements, PlaceholderAPI and color
        title = ActionUtil.processText(title, player, replacements);
        subTitle = ActionUtil.processText(subTitle, player, replacements);
        // Send title.
        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
    }

}