package org.kayteam.actionapi.actions;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;
import org.kayteam.actionapi.util.PlaceholderAPIUtil;

public class SoundAction extends Action {

    public SoundAction(String value) {
        super("sound", value);
    }

    @Override
    public void execute(Player player) {
        try {
            String realValue = getValue();

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

    @Override
    public void execute(Player player, Object data) {
        execute(player);
    }

}