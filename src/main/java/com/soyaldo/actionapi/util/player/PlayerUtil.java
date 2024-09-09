package com.soyaldo.actionapi.util.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static void executeAll(PlayerAction playerAction) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerAction.execute(player);
        }
    }

}