package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command;

import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.common.ShowMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandRedPacket implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("fantasticchinesenewyear.redpacket.use")) {
            ShowMessage.noPermission(sender);
        }

        if (args.length >= 1) {
            switch (args[0]) {
                case "help":
                    ShowMessage.helpRedPacket(sender);
                    break;
                case "history":
                    if (args.length == 2) {
                        ShowMessage.helpRedPacketHistory();
                    }
                    break;
                default:
                    ShowMessage.usageRedPacket(sender);
                    break;
            }
        } else {
            ShowMessage.usageRedPacket(sender);
        }
        return true;
    }


}
