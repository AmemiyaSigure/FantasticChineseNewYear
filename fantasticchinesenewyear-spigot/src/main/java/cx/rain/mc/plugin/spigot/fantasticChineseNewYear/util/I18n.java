package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.FantasticChineseNewYearSpigot;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.logging.Logger;

public class I18n {
    public static Language language = Language.zhcn;
    public static void loadMessages(String lang) {
        FantasticChineseNewYearSpigot instance = FantasticChineseNewYearSpigot.getInstance();
        Logger log = instance.getLog();
        language = Language.valueOf(lang);
        if (!new File(instance.getDataFolder(), language.file).exists()) {
            instance.saveResource(language.file, false);
        }
        File messagesFile = new File(instance.getDataFolder(), language.file);
        instance.setMessages(YamlConfiguration.loadConfiguration(messagesFile));
        log.info(I18n.format("languages.set", I18n.format(language.description)));
    }

    public static String format(String key, Object... args) {
        if (FantasticChineseNewYearSpigot.getInstance().getMessages() == null) {
            loadMessages(FantasticChineseNewYearSpigot.getInstance().getConf().getString("general.language"));
        }
        FileConfiguration messages = FantasticChineseNewYearSpigot.getInstance().getMessages();
        if (!messages.isSet(key)) {
            throw new IllegalArgumentException(I18n.format("language.no_such_key", key, language.file));
        }
        String format = messages.getString(key);
        return String.format(format, args);
    }

    enum Language {
        zhcn("languages.chinese_simplified", "messages_zhcn.yml"),
        en("languages.english", "messages_en.yml");

        private String description;
        private String file;

        private Language(String desc, String fileName) {
            description = desc;
            file = fileName;
        }
    }
}
