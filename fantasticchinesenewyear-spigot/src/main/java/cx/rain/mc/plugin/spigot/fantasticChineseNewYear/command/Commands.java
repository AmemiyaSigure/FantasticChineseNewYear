package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command;

import cx.rain.mc.plugin.common.fantasticChineseNewYear.database.Database;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.completer.CompleterFantasticChineseNewYear;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.completer.CompleterRedPacket;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.I18n;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

import java.util.logging.Logger;

public class Commands {
    protected static PluginCommand redpacket;
    protected static PluginCommand redpacketExclusive;
    protected static PluginCommand redpacketNormal;
    protected static PluginCommand redpacketPassword;
    protected static PluginCommand redpacketRandom;
    protected static PluginCommand fantasticChineseNewYear;

    public Commands(Logger log, Database db) {
        redpacket = Bukkit.getPluginCommand("redpacket");
        redpacket.setExecutor(new CommandRedPacket(log, db));
        redpacket.setTabCompleter(new CompleterRedPacket());

        redpacketNormal = Bukkit.getPluginCommand("putonghongbao");
        redpacketNormal.setExecutor(new CommandRedPacketNormal());
        redpacketRandom = Bukkit.getPluginCommand("pinshouqihongbao");
        redpacketRandom.setExecutor(new CommandRedPacketRandom());
        redpacketPassword = Bukkit.getPluginCommand("koulinghongbao");
        redpacketPassword.setExecutor(new CommandRedPacketPassword());
        redpacketExclusive = Bukkit.getPluginCommand("zhuanshuhongbao");
        redpacketExclusive.setExecutor(new CommandRedPacketExclusive());

        fantasticChineseNewYear = Bukkit.getPluginCommand("fantasticchinesenewyear");
        fantasticChineseNewYear.setExecutor(new CommandFantasticChineseNewYear());
        fantasticChineseNewYear.setTabCompleter(new CompleterFantasticChineseNewYear());
    }
}
