package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ActionUtil;
import me.soyaldo.actionapi.util.ChatUtil;
import org.bukkit.entity.Player;

public class ActionBarAction extends Action {

    public ActionBarAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        ChatUtil.sendMessage(ActionUtil.getConsole(), getActionInfo().getContent());
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        ChatUtil.sendActionBar(player, getActionInfo().getContent(), replacements);
    }

}