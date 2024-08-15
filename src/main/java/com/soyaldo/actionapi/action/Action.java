package com.soyaldo.actionapi.action;

import com.soyaldo.actionapi.util.ActionInfo;
import com.soyaldo.actionapi.util.Number;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class Action {

    private final ActionInfo actionInfo;
    private ActionManager actionManager;

    public abstract void executeAction(String[][] replacements);

    public abstract void executeAction(Player player, String[][] replacements);

    public void execute() {
        execute(new String[][]{});
    }

    public void execute(String[][] replacements) {
        // Delay
        int delay = 0;
        if (actionInfo.getExtras().containsKey("delay")) {
            delay = Number.getInt((String) actionInfo.getExtras().get("delay"), 0);
        }
        if (delay < 0) delay = 0;
        // Async
        JavaPlugin javaPlugin = actionManager.getJavaPlugin();
        BukkitScheduler bukkitScheduler = javaPlugin.getServer().getScheduler();
        if (actionInfo.getExtras().containsKey("async")) {
            bukkitScheduler.runTaskLaterAsynchronously(javaPlugin, () -> executeAction(replacements), delay);
        } else {
            bukkitScheduler.runTaskLater(javaPlugin, () -> executeAction(replacements), delay);
        }
    }

    public void execute(Player player) {
        execute(player, new String[][]{});
    }

    public void execute(Player player, String[][] replacements) {
        // Delay
        int delay = 0;
        if (actionInfo.getExtras().containsKey("delay")) {
            delay = Number.getInt((String) actionInfo.getExtras().get("delay"), 0);
        }
        if (delay < 0) delay = 0;
        // Async
        JavaPlugin javaPlugin = actionManager.getJavaPlugin();
        BukkitScheduler bukkitScheduler = javaPlugin.getServer().getScheduler();
        if (actionInfo.getExtras().containsKey("async")) {
            bukkitScheduler.runTaskLaterAsynchronously(javaPlugin, () -> executeAction(player, replacements), delay);
        } else {
            bukkitScheduler.runTaskLater(javaPlugin, () -> executeAction(player, replacements), delay);
        }
    }

    @Override
    public String toString() {
        return actionInfo.toString();
    }

}