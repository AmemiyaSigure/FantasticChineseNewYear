package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command;

import org.bukkit.Bukkit;

public class Commands {
    public Commands() {
        Bukkit.getPluginCommand("redpacket").setExecutor(new CommandRedPacket());
        Bukkit.getPluginCommand("fantasticchinesenewyear").setExecutor(new CommandFantasticChineseNewYear());
    }
}
