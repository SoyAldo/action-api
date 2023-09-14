package com.soyaldo.actionapi;

import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapi.util.BrandUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class ActionAPI extends JavaPlugin {

    private static ActionManager actionManager;

    @Override
    public void onEnable() {
        actionManager = new ActionManager(this);
        actionManager.registerManager();
        // Sending the status to the console.
        BrandUtil.sendVersionStatusFromConsole(this, "&aEnabled");
    }

    @Override
    public void onDisable() {
        // Sending the status to the console.
        BrandUtil.sendVersionStatusFromConsole(this, "&cDisabled");
    }

    /**
     * Get the action manager from the ActionAPI
     * @return actionManager
     */
    public static ActionManager getActionManager() {
        return actionManager;
    }

}