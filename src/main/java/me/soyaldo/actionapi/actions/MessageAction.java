package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.PapiUtil;
import de.themoep.minedown.MineDown;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MessageAction extends Action {

    public MessageAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        String message = getActionInfo().getContent();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        ChatUtil.sendMessage(console, message, replacements);
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String message = getActionInfo().getContent();
        ChatUtil.sendMessage(player, message, replacements);
    }

}