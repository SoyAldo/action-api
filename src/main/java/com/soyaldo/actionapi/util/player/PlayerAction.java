package com.soyaldo.actionapi.util.player;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface PlayerAction {

    void execute(Player player);

}