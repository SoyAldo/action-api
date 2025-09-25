package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.PapiUtil;
import me.soyaldo.actionapi.util.SchedulerUtil;
import me.soyaldo.actionapi.util.TextUtil;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerAction extends Action {

    public PlayerAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        String command = getActionInfo().getContent();
        // Apply replacements
        command = TextUtil.replace(command, replacements);
        // Apply PlaceholderAPI
        command = PapiUtil.setPlaceholders(player, command);
        // Apply color
        command = ChatUtil.colorizeLegacy(command);
        // Execute command
        JavaPlugin plugin = getActionManager().getJavaPlugin();
        String finalCommand = command;
        SchedulerUtil.runTaskLaterSync(plugin, () -> plugin.getServer().dispatchCommand(player, finalCommand));
    }

}