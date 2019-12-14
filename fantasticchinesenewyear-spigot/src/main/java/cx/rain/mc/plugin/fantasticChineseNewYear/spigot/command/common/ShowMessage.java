package cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command.common;

import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.util.I18n;
import org.bukkit.command.CommandSender;

public class ShowMessage {
    public static void notEnabled(CommandSender sender) {
        sender.sendMessage(I18n.format("commons.error.not_enabled"));
    }

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

    public static void notDouble(CommandSender sender) {
        sender.sendMessage(I18n.format("commands.error.not_double"));
    }

    public static void notDoubleAt(CommandSender sender, int at) {
        sender.sendMessage(I18n.format("commands.error.not_double_at", at));
    }

    public static void notPositive(CommandSender sender) {
        sender.sendMessage(I18n.format("commands.error.not_positive"));
    }

    public static void notPositiveAt(CommandSender sender, int at) {
        sender.sendMessage(I18n.format("commands.error.not_positive_at", at));
    }

    public static void cantDivideEqually(CommandSender sender) {
        sender.sendMessage(I18n.format("commons.error.cant_divide_equally"));
    }
}
