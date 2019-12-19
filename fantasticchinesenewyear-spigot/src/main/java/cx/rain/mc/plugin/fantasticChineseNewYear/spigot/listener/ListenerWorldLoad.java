package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.listener;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.FantasticChineseNewYearSpigot;
import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.crafting.Recipes;
import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.util.I18n;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class ListenerWorldLoad implements Listener {
    private boolean isCalled = false;

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        if (!isCalled) {
            isCalled = true;
            FantasticChineseNewYearSpigot.getInstance().getLog().info(I18n.format("life_circle.load_crafting"));
            new Recipes();
        }
    }
}
