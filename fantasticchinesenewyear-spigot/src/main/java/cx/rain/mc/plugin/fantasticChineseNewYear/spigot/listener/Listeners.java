package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.listener;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.FantasticChineseNewYearSpigot;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Listeners {
    public Listeners() {
        Plugin plugin = FantasticChineseNewYearSpigot.getInstance();
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new ListenerBlockPlace(), plugin);
        pm.registerEvents(new ListenerPlayerInteract(), plugin);
    }
}
