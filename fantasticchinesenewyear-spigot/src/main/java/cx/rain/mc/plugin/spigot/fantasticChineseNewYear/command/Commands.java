package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.completer.CompleterFantasticChineseNewYear;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.completer.CompleterRedPacket;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

public class Commands {
    protected static PluginCommand redpacket;
    protected static PluginCommand fantasticChineseNewYear;
    public Commands() {
        redpacket = Bukkit.getPluginCommand("redpacket");
        redpacket.setExecutor(new CommandRedPacket());
        redpacket.setTabCompleter(new CompleterRedPacket());

        fantasticChineseNewYear = Bukkit.getPluginCommand("fantasticchinesenewyear");
        fantasticChineseNewYear.setExecutor(new CommandFantasticChineseNewYear());
        fantasticChineseNewYear.setTabCompleter(new CompleterFantasticChineseNewYear());
    }
}
