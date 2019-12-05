package cx.rain.mc.plugin.spigot.fantasticChineseNewYear;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.listeners.Listeners;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public final class FantasticChineseNewYearSpigot extends JavaPlugin {
    private static FantasticChineseNewYearSpigot INSTANCE = null;

    private Logger log = this.getLogger();
    private FileConfiguration config = null;
    private FileConfiguration messages = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;

        log.info("Loading configs.");
        saveDefaultConfig();
        saveResource("messages.yml", false);
        config = this.getConfig();
        File messagesFile = new File(this.getDataFolder(), "messages.yml");
        messages = YamlConfiguration.loadConfiguration(messagesFile);

        log.info("Registering events.");
        new Listeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Saving configs.");
        saveConfig();
        try {
            messages.save("messages.yml");
        } catch (IOException ex) {

        }
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
}
