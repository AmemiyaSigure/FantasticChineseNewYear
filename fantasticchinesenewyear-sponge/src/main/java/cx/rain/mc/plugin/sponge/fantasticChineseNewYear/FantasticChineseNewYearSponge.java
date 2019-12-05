package cx.rain.mc.plugin.sponge.fantasticChineseNewYear;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

import static cx.rain.mc.plugin.common.fantasticChineseNewYear.FantasticChineseNewYear.*;

@Plugin(
        id = PLUGIN_ID,
        name = PLUGIN_NAME,
        description = PLUGIN_DESCRIPTION,
        authors = {
                PLUGIN_AUTHOR
        }
)
public class FantasticChineseNewYearSponge {
    @Inject
    private Logger log;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        log.info("[Fantastic Chinese New Year] Plugin enabled.");
    }
}
