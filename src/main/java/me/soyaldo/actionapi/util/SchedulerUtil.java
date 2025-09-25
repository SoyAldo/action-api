package me.soyaldo.actionapi.util;

import org.bukkit.plugin.java.JavaPlugin;

public class SchedulerUtil {

    public static void runTaskLaterSync(JavaPlugin javaPlugin, Runnable runnable, long ticks) {
        javaPlugin.getServer().getScheduler().runTaskLater(javaPlugin, runnable, ticks >= 0 ? ticks : 0L);
    }

    public static void runTaskLaterSync(JavaPlugin javaPlugin, Runnable runnable) {
        runTaskLaterSync(javaPlugin, runnable, 0L);
    }

    public static void runTaskLaterAsync(JavaPlugin javaPlugin, Runnable runnable, long ticks) {
        javaPlugin.getServer().getScheduler().runTaskLaterAsynchronously(javaPlugin, runnable, ticks >= 0 ? ticks : 0L);
    }

    public static void runTaskLaterAsync(JavaPlugin javaPlugin, Runnable runnable) {
        runTaskLaterAsync(javaPlugin, runnable, 0L);
    }

    public static void runTaskLater(JavaPlugin javaPlugin, Runnable runnable, long ticks, boolean async) {
        if (async) {
            runTaskLaterAsync(javaPlugin, runnable, ticks);
        } else {
            runTaskLaterSync(javaPlugin, runnable, ticks);
        }
    }

    public static void runTaskLater(JavaPlugin javaPlugin, Runnable runnable, boolean async) {
        runTaskLater(javaPlugin, runnable, 0, async);
    }

    public static void runTaskLater(JavaPlugin javaPlugin, Runnable runnable, long ticks) {
        runTaskLater(javaPlugin, runnable, 0, false);
    }

    public static void runTaskLater(JavaPlugin javaPlugin, Runnable runnable) {
        runTaskLater(javaPlugin, runnable, 0, false);
    }

}