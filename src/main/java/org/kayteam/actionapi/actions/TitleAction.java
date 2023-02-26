package org.kayteam.actionapi.actions;

import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;

public class TitleAction extends Action {

    public TitleAction(String value) {
        super("title", value);
    }

    @Override
    public void execute(Player player) {

        if (getValue().isEmpty()) return;

        if (!getValue().contains(";")) player.sendTitle(getValue(), "", 10, 70, 20);

        String[] values = getValue().split(";");

        String title = values[0];
        String subTitle = values[1];
        int fadeIn = 10;
        int stay = 70;
        int fadeOut = 20;

        if (values.length > 2) {
            try {
                fadeIn = Integer.parseInt(values[2]);
            } catch (NumberFormatException ignore) {
            }
        }

        if (values.length > 3) {
            try {
                stay = Integer.parseInt(values[3]);
            } catch (NumberFormatException ignore) {
            }
        }

        if (values.length > 4) {
            try {
                fadeOut = Integer.parseInt(values[4]);
            } catch (NumberFormatException ignore) {
            }
        }

        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);

    }

    @Override
    public void execute(Player player, Object data) {
        execute(player);
    }

}