package me.soyaldo.actionapi.actions;

import me.soyaldo.actionapi.models.Action;
import me.soyaldo.actionapi.models.ActionInfo;
import me.soyaldo.actionapi.util.ActionUtil;
import me.soyaldo.actionapi.util.ChatUtil;
import me.soyaldo.actionapi.util.NumberUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundAction extends Action {

    public SoundAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        ChatUtil.sendMessage(ActionUtil.getConsole(), getActionInfo().getContent());
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        try {
            String soundName = getActionInfo().getContent();
            // Apply replacements and PlaceholderAPI
            soundName = ActionUtil.processTextWithoutColor(getActionInfo().getContent(), player, replacements);
            // Sound variables.
            Sound sound = Sound.valueOf(soundName);
            float volume = NumberUtil.getFloat(String.valueOf(getActionInfo().getExtras().get("volume")), (float) 1.0);
            float pitch = NumberUtil.getFloat(String.valueOf(getActionInfo().getExtras().get("pitch")), (float) 1.0);
            // Play the sound
            player.playSound(player.getLocation(), sound, volume, pitch);
        } catch (IllegalArgumentException ignore) {
            getActionManager().getJavaPlugin().getLogger().info("Invalid sound format: " + getActionInfo().getContent());
        }
    }

}