package org.kayteam.actionapi.actions;

import de.slikey.effectlib.effect.HelixEffect;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;

public class EffectAction extends Action {

    public EffectAction(String value) {
        super("effect", value);
    }

    @Override
    public void execute(Player player) {

        HelixEffect helixEffect = new HelixEffect(getActionManager().getEffectManager());

        helixEffect.setEntity(player);

        helixEffect.duration = 30 * 1000;

        helixEffect.start();

    }

    @Override
    public void execute(Player player, Object data) {

        HelixEffect helixEffect = new HelixEffect(getActionManager().getEffectManager());

        helixEffect.setEntity(player);

        helixEffect.duration = 30 * 1000;

        helixEffect.start();

    }

}