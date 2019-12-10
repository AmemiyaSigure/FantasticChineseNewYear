package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.common;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.I18n;
import org.bukkit.command.CommandSender;

public class ShowMessage {
    public static void noPermission(CommandSender sender) {
        sender.sendMessage(I18n.format("permission.deny"));
    }

    public static void notPlayer(CommandSender sender) {
        sender.sendMessage(I18n.format("commands.error.not_player"));
    }

    public static void notInteger(CommandSender sender) {
        sender.sendMessage(I18n.format("commands.error.not_integer"));
    }

    public static void notIntegerAt(CommandSender sender, int at) {
        sender.sendMessage(I18n.format("commands.error.not_integer_at", at));
    }
}
