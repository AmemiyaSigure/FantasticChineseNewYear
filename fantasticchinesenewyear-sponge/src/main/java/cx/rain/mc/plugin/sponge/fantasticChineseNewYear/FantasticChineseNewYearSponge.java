package cx.rain.mc.plugin.sponge.fantasticChineseNewYear;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "fantasticchinesenewyear",
        name = "FantasticChineseNewYear",
        description = "A Minecraft Bukkit Server Plugin with theme of Chinese New Year.",
        authors = {
                "AmemiyaSigure"
        }
)
public class FantasticChineseNewYearSponge {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
