package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.common;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.I18n;
import org.bukkit.command.CommandSender;

public class ShowMessage {
    public static void noPermission(CommandSender sender) {
        sender.sendMessage(I18n.format("permission.deny"));
    }

    public static  void usageRedPacket(CommandSender sender) {
        sender.sendMessage(I18n.format("command_usage.redpacket"));
    }

    public static void helpRedPacket(CommandSender sender) {
        sender.sendMessage(I18n.format("help.redpacket"));
        sender.sendMessage(I18n.format("help.redpacket_2"));
        sender.sendMessage(I18n.format("help.redpacket_3"));
        sender.sendMessage(I18n.format("help.redpacket_4"));
        sender.sendMessage(I18n.format("help.redpacket_5"));
        sender.sendMessage(I18n.format("help.redpacket_6"));
    }

    public static void helpRedPacketHistory() {

    }
}
