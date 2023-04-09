package com.soyaldo.actionapi.actions;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import com.soyaldo.actionapi.Action;
import com.soyaldo.actionapi.util.PlaceholderAPIUtil;

public class SoundAction extends Action {

    public SoundAction(String value) {
        super("sound", value);
    }

    @Override
    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    @Override
    public void execute(Player player, String[][] replacements) {
        try {
            String realValue = getValue();

            for (String[] replacement : replacements) {
                try {
                    realValue = StringUtils.replace(realValue, replacement[0], replacement[1]);
                } catch (Exception ignored) {
                }
            }

            realValue = PlaceholderAPIUtil.setPlaceholders(player, realValue);

            Sound sound;
            float volume = 1, pitch = 1;

            if (realValue.contains(" ")) {
                String[] realValues = realValue.split(" ");

                sound = Sound.valueOf(realValues[0]);

                if (realValues.length >= 2) volume = Float.parseFloat(realValues[1]);
                if (realValues.length >= 3) pitch = Float.parseFloat(realValues[2]);
            } else {
                sound = Sound.valueOf(realValue);
            }

            player.playSound(player.getLocation(), sound, volume, pitch);

        } catch (IllegalArgumentException ignore) {
        }
    }

}