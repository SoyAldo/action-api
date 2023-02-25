package org.kayteam.actionapi.actions;

import de.slikey.effectlib.effect.BleedEffect;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;

public class EffectAction extends Action {

    public EffectAction(String value) {
        super("effect", value);
    }

    @Override
    public void execute(Player player) {

        BleedEffect bleedEffect = new BleedEffect(getActionManager().getEffectManager());

        bleedEffect.setTargetEntity(player);

        // Add a callback to the effect
        bleedEffect.callback = () -> {
            player.sendMessage("You bled out..");
            player.setHealth(0d);
        };
        // Bleeding takes 15 seconds
        // period * iterations = time of effect
        bleedEffect.iterations = 15 * 20;
        bleedEffect.start();

    }

    @Override
    public void execute(Player player, Object data) {

        BleedEffect bleedEffect = new BleedEffect(getActionManager().getEffectManager());

        bleedEffect.setTargetEntity(player);

        // Add a callback to the effect
        bleedEffect.callback = () -> {
            player.sendMessage("You bled out..");
            player.setHealth(0d);
        };
        // Bleeding takes 15 seconds
        // period * iterations = time of effect
        bleedEffect.iterations = 15 * 20;
        bleedEffect.start();

    }

}