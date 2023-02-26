package org.kayteam.actionapi.actions;

import de.slikey.effectlib.effect.HelixEffect;
import de.slikey.effectlib.effect.TornadoEffect;
import de.slikey.effectlib.effect.VortexEffect;
import de.slikey.effectlib.util.DynamicLocation;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;

public class EffectAction extends Action {

    public EffectAction(String value) {
        super("effect", value);
    }

    @Override
    public void execute(Player player) {

        TornadoEffect vortexEffect = new TornadoEffect(getActionManager().getEffectManager());

        vortexEffect.setEntity(player);

        vortexEffect.duration = 30 * 1000;

        vortexEffect.start();

    }

    @Override
    public void execute(Player player, Object data) {

        TornadoEffect vortexEffect = new TornadoEffect(getActionManager().getEffectManager());

        vortexEffect.setEntity(player);

        vortexEffect.setDynamicTarget(new DynamicLocation(player));

        vortexEffect.duration = 30 * 1000;

        vortexEffect.start();

    }

}