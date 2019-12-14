package cx.rain.mc.plugin.fantasticChineseNewYear.spigot;

import cx.rain.mc.plugin.fantasticChineseNewYear.common.database.Database;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.DatabaseType;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command.Commands;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.listener.Listeners;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.util.I18n;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.logging.Logger;

public final class FantasticChineseNewYearSpigot extends JavaPlugin {
    private static FantasticChineseNewYearSpigot INSTANCE = null;

    private Logger log = this.getLogger();
    private FileConfiguration config = null;
    private FileConfiguration messages = null;
    private Database db = null;

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

        loadConfigs();
        loadDatabase();

        log.info(I18n.format("life_circle.load_commands"));
        new Commands();
        log.info(I18n.format("life_circle.load_listeners"));
        new Listeners();
    }

    /*
    private BinderModule loadDI() {
        BinderModule module = new BinderModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);
        return module;
    }
     */

    private void loadConfigs() {
        // Put the log message in last for prevent loop.
        saveDefaultConfig();
        config = this.getConfig();
        I18n.loadMessages(config.getString("general.language"));
        log.info(I18n.format("life_circle.load_config"));
    }

    private void loadDatabase() {
        log.info(I18n.format("life_circle.load_database"));
        DatabaseType type = DatabaseType.valueOf(config.getString("database.type"));
        String file = config.getString("database.file");
        String host = config.getString("database.host");
        int port = config.getInt("database.port");
        String user = config.getString("database.user");
        String password = config.getString("database.password");
        String name = config.getString("database.name");
        boolean useSsl = config.getBoolean("database.useSsl");
        db = new Database(type, host, port, user, password, name, useSsl, getDataFolder().getAbsolutePath(), file);

        log.info(I18n.format("life_circle.test_database"));
        try {
            db.getConnection().close();
        } catch (SQLException ex) {
            log.severe(I18n.format("exception.test_database"));
            ex.printStackTrace();
        }

        try {
            if (!db.isDatabaseInitialized()) {
                log.warning(I18n.format("life_circle.init_database"));
                db.initializeDatabase();
            }
        } catch (SQLException ex) {
            log.severe(I18n.format("exception.init_database"));
            ex.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info(I18n.format("life_circle.save_config"));
        // Fixme: Comment in config will lost.
        //saveConfig();
        log.info(I18n.format("life_circle.close_database"));
        if (db != null) {
            db.dispose();
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

    public void setMessages(FileConfiguration messages) {
        this.messages = messages;
    }

    public Database getDatabase() {
        return db;
    }
}
