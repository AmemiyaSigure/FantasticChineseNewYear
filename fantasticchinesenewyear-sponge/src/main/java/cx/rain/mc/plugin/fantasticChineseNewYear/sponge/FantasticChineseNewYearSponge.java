package cx.rain.mc.plugin.fantasticchinesenewyear.sponge;

import com.google.inject.Inject;
import cx.rain.mc.plugin.fantasticchinesenewyear.common.FantasticChineseNewYear;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = FantasticChineseNewYear.PLUGIN_ID,
        name = FantasticChineseNewYear.PLUGIN_NAME,
        description = FantasticChineseNewYear.PLUGIN_DESCRIPTION,
        authors = {
                FantasticChineseNewYear.PLUGIN_AUTHOR
        }
)
public class FantasticChineseNewYearSponge {
    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
