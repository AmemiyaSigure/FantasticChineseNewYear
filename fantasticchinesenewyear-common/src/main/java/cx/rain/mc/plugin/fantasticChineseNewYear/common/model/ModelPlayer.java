package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import java.util.UUID;

public class ModelPlayer {
    private UUID uuid;

    public ModelPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public static ModelPlayer parse(String uuid) {
        UUID u = UUID.fromString(uuid);
        return new ModelPlayer(u);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
