package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.enumerate;

public enum Language {
    zhcn("languages.chinese_simplified", "messages_zhcn.yml"),
    en("languages.english", "messages_en.yml");

    private String description;
    private String file;

    private Language(String desc, String fileName) {
        description = desc;
        file = fileName;
    }

    public String getFile() {
        return file;
    }

    public String getDescription() {
        return description;
    }
}
