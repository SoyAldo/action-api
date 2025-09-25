package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.PapiUtil;
import de.themoep.minedown.MineDown;
import me.soyaldo.actionapi.util.TextUtil;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BroadcastAction extends Action {

    public BroadcastAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        // Created a variable that will be the message.
        String message = getContent();
        // Send the message to the entire server.
        List<Player> players = new ArrayList<>(getActionManager().getJavaPlugin().getServer().getOnlinePlayers());
        ChatUtil.sendMessage(players, message, replacements);
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        // Created a variable that will be the message.
        String message = getContent();
        // Send the message to the entire server.
        List<Player> players = new ArrayList<>(getActionManager().getJavaPlugin().getServer().getOnlinePlayers());
        ChatUtil.sendMessage(players, message, replacements);
    }

}