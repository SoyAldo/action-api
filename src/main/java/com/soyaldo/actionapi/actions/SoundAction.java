package com.soyaldo.actionapi.actions;

import com.soyaldo.actionapi.models.Action;
import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.PlaceholderApi;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundAction extends Action {

    public SoundAction(ActionInfo actionInfo) {
        super(actionInfo);
    }

    @Override
    public void executeAction(String[][] replacements) {
        // Extras
        boolean global = getExtras().containsKey("global");
        try {
            String realValue = getContent();
            // Apply replacements.
            for (String[] replacement : replacements) {
                realValue = realValue.replace(replacement[0], replacement[1]);
            }
            // Sound variables.
            Sound sound;
            float volume = 1;
            float pitch = 1;
            // Setting Sound.
            if (realValue.contains(" ")) {
                String[] realValues = realValue.split(" ");
                sound = Sound.valueOf(realValues[0]);
                if (realValues.length >= 2) volume = Float.parseFloat(realValues[1]);
                if (realValues.length >= 3) pitch = Float.parseFloat(realValues[2]);
            } else {
                sound = Sound.valueOf(realValue);
            }
            // Play sound
            if (global) {
                for (Player player : getActionManager().getJavaPlugin().getServer().getOnlinePlayers()) {
                    player.playSound(player.getLocation(), sound, volume, pitch);
                }
            }
        } catch (IllegalArgumentException ignore) {
            getActionManager().getJavaPlugin().getLogger().info("Invalid sound format: " + getContent());
        }
    }

    @Override
    public void executeAction(Player player, String[][] replacements) {
        // Extras
        boolean global = getExtras().containsKey("global");
        try {
            String soundFormat = getContent();
            // Apply replacements.
            for (String[] replacement : replacements) {
                soundFormat = soundFormat.replace(replacement[0], replacement[1]);
            }
            // Apply PlaceholderAPI placeholders.
            soundFormat = PlaceholderApi.setPlaceholders(player, soundFormat);
            // Sound variables.
            Sound sound;
            float volume = 1;
            float pitch = 1;
            // Setting Sound.
            if (soundFormat.contains(" ")) {
                String[] realValues = soundFormat.split(" ");
                sound = Sound.valueOf(realValues[0]);
                if (realValues.length >= 2) volume = Float.parseFloat(realValues[1]);
                if (realValues.length >= 3) pitch = Float.parseFloat(realValues[2]);
            } else {
                sound = Sound.valueOf(soundFormat);
            }
            // Play sound
            if (global) {
                for (Player target : getActionManager().getJavaPlugin().getServer().getOnlinePlayers()) {
                    target.playSound(target.getLocation(), sound, volume, pitch);
                }
            }
        } catch (IllegalArgumentException ignore) {
            getActionManager().getJavaPlugin().getLogger().info("Invalid sound format: " + getContent());
        }
    }

}