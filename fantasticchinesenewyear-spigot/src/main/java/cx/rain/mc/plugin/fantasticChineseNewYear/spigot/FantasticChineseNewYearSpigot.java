package cx.rain.mc.plugin.fantasticchinesenewyear.spigot;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.command.Commands;
import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.crafting.Recipes;
import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.listener.Listeners;
import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.util.I18n;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FantasticChineseNewYearSpigot extends JavaPlugin {
    private static FantasticChineseNewYearSpigot INSTANCE = null;

    private Logger log = this.getLogger();
    private FileConfiguration config = null;
    private FileConfiguration messages = null;
    private boolean hasLoad = false;
    private boolean isDebug = false;

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

        loadConfigs();
        checkEnv();

        log.info(I18n.format("life_circle.load_commands"));
        new Commands();
        log.info(I18n.format("life_circle.load_listeners"));
        new Listeners();
    }

    private void loadConfigs() {
        // Put the log message in last for prevent loop.
        saveDefaultConfig();
        config = this.getConfig();
        I18n.loadMessages(config.getString("general.language"));
        log.info(I18n.format("life_circle.load_config"));
        isDebug = config.getBoolean("general.debug");
    }

    private void checkEnv() {
        log.info(I18n.format("life_circle.check_environment",
                Bukkit.getServer().getName(), Bukkit.getBukkitVersion()));
        if (isDebug) {
            log.info(I18n.format("life_circle.debug_enabled"));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info(I18n.format("life_circle.save_config"));
        // Fixme: Comment in config will lost.
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
