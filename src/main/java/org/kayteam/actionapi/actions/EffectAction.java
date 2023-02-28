package org.kayteam.actionapi.actions;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.effect.*;
import org.bukkit.entity.Player;
import org.kayteam.actionapi.Action;

public class EffectAction extends Action {

    public EffectAction(String value) {
        super("effect", value);
    }

    @Override
    public void execute(Player player) {

        if (getValue().isEmpty()) {
            return;
        }

        String type = "";
        int duration = 1;

        if (getValue().contains(" ")) {
            type = getValue().split(" ")[0];
            try {
                duration = Integer.parseInt(getValue().split(" ")[1]);
            } catch (NumberFormatException ignored) {
            }
        }

        Effect effect = null;

        switch (type) {
            case "atom": {
                effect = new AtomEffect(getActionManager().getEffectManager());
                break;
            }
            case "bigbang": {
                effect = new BigBangEffect(getActionManager().getEffectManager());
                break;
            }
            case "bleed": {
                effect = new BleedEffect(getActionManager().getEffectManager());
                break;
            }
            case "circle": {
                effect = new CircleEffect(getActionManager().getEffectManager());
                break;
            }
            case "cloud": {
                effect = new CloudEffect(getActionManager().getEffectManager());
                break;
            }
            case "cone": {
                effect = new ConeEffect(getActionManager().getEffectManager());
                break;
            }
            case "cube": {
                effect = new CubeEffect(getActionManager().getEffectManager());
                break;
            }
            case "cuboid": {
                effect = new CuboidEffect(getActionManager().getEffectManager());
                break;
            }
            case "cylinder": {
                effect = new CylinderEffect(getActionManager().getEffectManager());
                break;
            }
            case "dna": {
                effect = new DnaEffect(getActionManager().getEffectManager());
                break;
            }
            case "donut": {
                effect = new DonutEffect(getActionManager().getEffectManager());
                break;
            }
            case "dragon": {
                effect = new DragonEffect(getActionManager().getEffectManager());
                break;
            }
            case "earth": {
                effect = new EarthEffect(getActionManager().getEffectManager());
                break;
            }
            case "explode": {
                effect = new ExplodeEffect(getActionManager().getEffectManager());
                break;
            }
            case "flame": {
                effect = new FlameEffect(getActionManager().getEffectManager());
                break;
            }
            case "grid": {
                effect = new GridEffect(getActionManager().getEffectManager());
                break;
            }
            case "heart": {
                effect = new HeartEffect(getActionManager().getEffectManager());
                break;
            }
            case "helix": {
                effect = new HelixEffect(getActionManager().getEffectManager());
                break;
            }
            case "hill": {
                effect = new HillEffect(getActionManager().getEffectManager());
                break;
            }
            case "line": {
                effect = new LineEffect(getActionManager().getEffectManager());
                break;
            }
            case "love": {
                effect = new LoveEffect(getActionManager().getEffectManager());
                break;
            }
            case "music": {
                effect = new MusicEffect(getActionManager().getEffectManager());
                break;
            }
            case "plot": {
                effect = new PlotEffect(getActionManager().getEffectManager());
                break;
            }
            case "pyramid": {
                effect = new PyramidEffect(getActionManager().getEffectManager());
                break;
            }
            case "shield": {
                effect = new ShieldEffect(getActionManager().getEffectManager());
                break;
            }
            case "skyrocket": {
                effect = new SkyRocketEffect(getActionManager().getEffectManager());
                break;
            }
            case "smoke": {
                effect = new SmokeEffect(getActionManager().getEffectManager());
                break;
            }
            case "sphere": {
                effect = new SphereEffect(getActionManager().getEffectManager());
                break;
            }
            case "square": {
                effect = new SquareEffect(getActionManager().getEffectManager());
                break;
            }
            case "star": {
                effect = new StarEffect(getActionManager().getEffectManager());
                break;
            }
            case "tornado": {
                effect = new TornadoEffect(getActionManager().getEffectManager());
                break;
            }
            case "trace": {
                effect = new TraceEffect(getActionManager().getEffectManager());
                break;
            }
            case "turn": {
                effect = new TurnEffect(getActionManager().getEffectManager());
                break;
            }
            case "vortex": {
                effect = new VortexEffect(getActionManager().getEffectManager());
                break;
            }
            case "warp": {
                effect = new WarpEffect(getActionManager().getEffectManager());
                break;
            }
            case "wave": {
                effect = new WaveEffect(getActionManager().getEffectManager());
                break;
            }
        }

        if (effect != null) {

            effect.setEntity(player);
            effect.duration = duration * 1000;
            effect.start();

        }

    }

    @Override
    public void execute(Player player, Object data) {

        execute(player);

    }

}