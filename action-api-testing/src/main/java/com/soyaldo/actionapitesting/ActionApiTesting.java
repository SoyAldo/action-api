package com.soyaldo.actionapitesting;

import com.soyaldo.actionapi.managers.ActionManager;
import com.soyaldo.actionapitesting.commands.AdminCommand;
import com.soyaldo.actionapitesting.utils.BrandUtil;
import com.soyaldo.actionapitesting.utils.Yaml;
import com.soyaldo.actionapitesting.utils.messenger.Messenger;
import org.bukkit.plugin.java.JavaPlugin;

public final class ActionApiTesting extends JavaPlugin {

    // Files
    private final Yaml settings = new Yaml(this, "settings", getResource("settings.yml"));
    private final Yaml messages = new Yaml(this, "messages", getResource("messages.yml"));

    // Messenger
    private Messenger messenger;

    // ActionManager
    private final ActionManager actionManager = new ActionManager(this);

    @Override
    public void onEnable() {
        // Files
        settings.register();
        messages.register();
        // Messenger
        messenger = new Messenger(this, messages.getFileConfiguration());
        // Managers
        actionManager.registerManager();
        // Commands
        new AdminCommand(this).registerCommand(this);
        // Brand
        BrandUtil.sendVersionStatusFromConsole(this, "&aEnabled");
    }

    @Override
    public void onDisable() {
        // Brand
        BrandUtil.sendVersionStatusFromConsole(this, "&cDisabled");
    }

    public void onReload() {
        // Files
        settings.reload();
        messages.reload();
        // Messenger
        messenger = new Messenger(this, messages.getFileConfiguration());
        // Managers
        actionManager.reloadManager();
    }

    public Yaml getSettings() {
        return settings;
    }

    public Yaml getMessages() {
        return messages;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

}