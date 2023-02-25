package org.kayteam.actionapi.actions;

import de.slikey.effectlib.effect.HelixEffect;
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

        VortexEffect vortexEffect = new VortexEffect(getActionManager().getEffectManager());

        vortexEffect.setEntity(player);

        vortexEffect.setDynamicTarget(new DynamicLocation(player));

        vortexEffect.particle = Particle.VILLAGER_HAPPY;

        vortexEffect.duration = 30 * 1000;

        vortexEffect.start();

    }

    @Override
    public void execute(Player player, Object data) {

        VortexEffect vortexEffect = new VortexEffect(getActionManager().getEffectManager());

        vortexEffect.setEntity(player);

        vortexEffect.setDynamicTarget(new DynamicLocation(player));

        vortexEffect.particle = Particle.VILLAGER_HAPPY;

        vortexEffect.duration = 30 * 1000;

        vortexEffect.start();

    }

}