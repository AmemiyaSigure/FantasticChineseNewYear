package cx.rain.mc.plugin.common.fantasticChineseNewYear.model;

import java.util.UUID;

public class Player {
    private UUID Uuid;

    public Player(UUID uuid) {
        Uuid = uuid;
    }

    public static Player parse(String uuid) {
        UUID u = UUID.fromString(uuid);
        return new Player(u);
    }

    public UUID getUuid() {
        return Uuid;
    }

    public void setUuid(UUID uuid) {
        Uuid = uuid;
    }
}
