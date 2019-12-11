package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command;

import cx.rain.mc.plugin.common.fantasticChineseNewYear.database.Database;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.model.RedpacketParsed;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.util.data.Redpackets;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.common.ShowMessage;
import cx.rain.mc.plugin.spigot.fantasticChineseNewYear.util.I18n;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class CommandRedPacket implements CommandExecutor {
    private Logger log;
    private Database db;

    public CommandRedPacket(Logger logger, Database database) {
        log = logger;
        db = database;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("fantasticchinesenewyear.redpacket.use")) {
            ShowMessage.noPermission(sender);
            return true;
        }


        if (args.length >= 1) {
            switch (args[0]) {
                case "help":
                    helpRedPacket(sender);
                    break;
                case "history":
                    if (sender instanceof Player) {
                        if (args.length == 2) {
                            showHistory(sender);
                        } else if (args.length == 3) {
                            int page = -1;
                            try {
                                page = Integer.parseInt(args[2]);
                            } catch (NumberFormatException ignored) {
                                ShowMessage.notIntegerAt(sender, 3);
                                return true;
                            }
                            showHistory(sender, page);
                        } else {
                            usageRedPacketHistory(sender);
                        }
                    } else {
                        ShowMessage.notPlayer(sender);
                    }
                    break;
                default:
                    helpRedPacket(sender);
                    break;
            }
        } else {
            helpRedPacket(sender);
        }
        return true;
    }

    private void showHistory(CommandSender sender) {
        showHistory(sender, 1);
    }

    private void showHistory(CommandSender sender, int page) {
        Redpackets redpackets = new Redpackets(db);

        if (page <= 0) {
            sender.sendMessage(I18n.format("commands.redpacket_history_usage"));
        } else {
            UUID uuid = ((Player) sender).getUniqueId();
            int pages = -1;
            try {
                pages = redpackets.getPages(uuid);
            } catch (SQLException ex) {
                sender.sendMessage(I18n.format("commands.error.database"));
                log.severe(I18n.format("exception.database"));
                ex.printStackTrace();
                return;
            }

            if (pages <= 0) {
                sender.sendMessage(I18n.format("commands.redpacket_history_empty"));
                return;
            }

            if (pages < page) {
                sender.sendMessage(I18n.format("commands.redpacket_history_page_empty"));
                return;
            }

            List<RedpacketParsed> rps = null;
            try {
                rps = redpackets.getRedpackets(uuid, (page - 1) * 5, 5);
            } catch (SQLException ex) {
                sender.sendMessage(I18n.format("commands.error.database"));
                log.severe(I18n.format("exception.database"));
                ex.printStackTrace();
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            sender.sendMessage(I18n.format("commands.redpacket_history_head", page, pages));
            for (RedpacketParsed r : rps) {
                sender.sendMessage(I18n.format("commands.redpacket_history_body",
                        r.getName(), sdf.format(r.getSendTime()), r.getAmount(), r.getClaimPlayersAndRewards().length));
            }
            sender.sendMessage(I18n.format("commands.redpacket_history_foot", page, pages));
        }
    }

    private void usageRedPacketHistory(CommandSender sender) {
        sender.sendMessage(I18n.format("commands.redpacket_history_usage"));
    }

    private void helpRedPacket(CommandSender sender) {
        sender.sendMessage(I18n.format("help.redpacket"));
        sender.sendMessage(I18n.format("help.redpacket_2"));
        sender.sendMessage(I18n.format("help.redpacket_3"));
        sender.sendMessage(I18n.format("help.redpacket_4"));
        sender.sendMessage(I18n.format("help.redpacket_5"));
        sender.sendMessage(I18n.format("help.redpacket_6"));
        sender.sendMessage(I18n.format("help.redpacket_7"));
    }
}
