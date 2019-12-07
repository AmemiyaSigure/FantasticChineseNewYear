package cx.rain.mc.plugin.spigot.fantasticChineseNewYear;

import cx.rain.mc.plugin.common.fantasticChineseNewYear.util.enumerate.DatabaseType;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.Commands;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.listener.Listeners;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.I18n;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FantasticChineseNewYearSpigot extends JavaPlugin {
    private static FantasticChineseNewYearSpigot INSTANCE = null;

    private Logger log = this.getLogger();
    private FileConfiguration config = null;
    private FileConfiguration messages = null;

    private boolean hasLoad = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        load(hasLoad);
    }

    private void load(boolean isReload) {
        if (!isReload) {
            hasLoad = true;
        }

        loadConfigs(isReload);

        log.info(I18n.format("life_circle.load_commands"));
        new Commands();
        log.info(I18n.format("life_circle.load_listeners"));
        new Listeners();
    }

    private void loadConfigs(boolean isReload) {
        // Put the log message in last for prevent loop.
        saveDefaultConfig();
        config = this.getConfig();
        I18n.loadMessages(config.getString("general.language"));
        log.info(I18n.format("life_circle.load_config"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info(I18n.format("life_circle.save_config"));
        //saveConfig();
    }

    public static FantasticChineseNewYearSpigot getInstance() {
        return INSTANCE;
    }

    public Logger getLog() {
        return log;
    }

    public FileConfiguration getConf() {
        return config;
    }

    public FileConfiguration getMessages() {
        return messages;
    }

    public void setMessages(FileConfiguration messages) {
        this.messages = messages;
    }
}
