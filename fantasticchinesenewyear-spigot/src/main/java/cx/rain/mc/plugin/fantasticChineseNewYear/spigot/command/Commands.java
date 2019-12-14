package cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command;

import cx.rain.mc.plugin.fantasticChineseNewYear.common.database.Database;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command.completer.CompleterFantasticChineseNewYear;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command.completer.CompleterRedPacket;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

import java.util.logging.Logger;

public class Commands {
    protected static PluginCommand redpacket;
    protected static PluginCommand redpacketClaim;
    protected static PluginCommand redpacketExclusive;
    protected static PluginCommand redpacketNormal;
    protected static PluginCommand redpacketPassword;
    protected static PluginCommand redpacketRandom;
    protected static PluginCommand fantasticChineseNewYear;

    public Commands() {
        redpacket = Bukkit.getPluginCommand("redpacket");
        redpacket.setExecutor(new CommandRedPacket());
        redpacket.setTabCompleter(new CompleterRedPacket());

        redpacketClaim = Bukkit.getPluginCommand("redpacketclaim");
        redpacketClaim.setExecutor(new CommandRedPacketClaim());

        redpacketNormal = Bukkit.getPluginCommand("redpacketnormal");
        redpacketNormal.setExecutor(new CommandRedPacketNormal());
        redpacketRandom = Bukkit.getPluginCommand("redpacketrandom");
        redpacketRandom.setExecutor(new CommandRedPacketRandom());
        redpacketPassword = Bukkit.getPluginCommand("redpacketpassword");
        redpacketPassword.setExecutor(new CommandRedPacketPassword());
        redpacketExclusive = Bukkit.getPluginCommand("redpacketexclusive");
        redpacketExclusive.setExecutor(new CommandRedPacketExclusive());

        fantasticChineseNewYear = Bukkit.getPluginCommand("fantasticchinesenewyear");
        fantasticChineseNewYear.setExecutor(new CommandFantasticChineseNewYear());
        fantasticChineseNewYear.setTabCompleter(new CompleterFantasticChineseNewYear());
    }
}
