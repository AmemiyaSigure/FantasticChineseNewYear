package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import java.util.UUID;

public class ModelPlayer {
    private UUID Uuid;

    public ModelPlayer(UUID uuid) {
        Uuid = uuid;
    }

    public static ModelPlayer parse(String uuid) {
        UUID u = UUID.fromString(uuid);
        return new ModelPlayer(u);
    }

    public UUID getUuid() {
        return Uuid;
    }

    public void setUuid(UUID uuid) {
        Uuid = uuid;
    }
}
