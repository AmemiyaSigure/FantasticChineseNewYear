package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.I18n;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandRedPacket implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("fantasticchinesenewyear.redpacket.use")) {
            showNoPermission(sender);
        }

        if (args.length >= 1) {
            switch (args[0]) {
                case "putong":
                    break;
                case "kouling":
                    break;
                case "zhuanshu":
                    if (args.length == 2)
                    break;
                default:
                    showUsage(sender);
            }
        }
        return true;
    }

    private void showNoPermission(CommandSender sender) {
        sender.sendMessage(I18n.format("permission.deny"));
    }

    private void showUsage(CommandSender sender) {
        sender.sendMessage(I18n.format("command_usage.redpacket"));
    }
}
