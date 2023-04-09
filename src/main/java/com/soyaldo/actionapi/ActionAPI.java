package com.soyaldo.actionapi;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ActionAPI extends JavaPlugin {

    private static ActionManager actionManager;

    @Override
    public void onEnable() {
        actionManager = new ActionManager(this);
        actionManager.registerManager();
        sendStatus("&aEnabled");
    }

    @Override
    public void onDisable() {
        sendStatus("&cDisabled");
    }

    private void sendStatus(String status) {
        List<String> messages = new ArrayList<>();
        messages.add("&5»");
        messages.add("&5» &daction-api " + status);
        messages.add("&5»");
        messages.add("&5» &dVersion: &f" + getDescription().getVersion());
        messages.add("&5» &dAuthor: &fSoyAldo");
        messages.add("&5» &dWebsite: &fhttps://soyaldo.com/project/action-api");
        messages.add("&5»");
        messages.add("&5» &dAll rights reserved © soyaldo.com");
        messages.add("&5»");
        for (String message : messages) {
            getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public static ActionManager getActionManager() {
        return actionManager;
    }

}