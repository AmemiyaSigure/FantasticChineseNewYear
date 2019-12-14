package cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command;

import cx.rain.mc.plugin.fantasticChineseNewYear.common.database.Database;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.ModelItemStack;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.data.Redpackets;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.FantasticChineseNewYearSpigot;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.command.common.ShowMessage;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.util.I18n;
import cx.rain.mc.plugin.fantasticChineseNewYear.spigot.util.parser.ItemStackToModelItemStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.logging.Logger;

public class CommandRedPacketNormal implements CommandExecutor {
    private Logger log;
    private Database db;
    private FileConfiguration config;
    private long expire;
    private boolean enabled;

    public CommandRedPacketNormal() {
        log = FantasticChineseNewYearSpigot.getInstance().getLog();
        db = FantasticChineseNewYearSpigot.getInstance().getDatabase();

        config = FantasticChineseNewYearSpigot.getInstance().getConf();
        enabled = config.getBoolean("features.red_packet.putong");
        expire = config.getLong("features.red_packet.expire");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!enabled) {
            ShowMessage.notEnabled(sender);
        }

        if (!sender.hasPermission("fantasticchinesenewyear.redpacket.make")) {
            ShowMessage.noPermission(sender);
        }

        if (args.length >= 1) {
            switch (args[0]) {
                case "item":
                    if (args.length == 3) {
                        if (!(sender instanceof Player)) {
                            ShowMessage.notPlayer(sender);
                            return true;
                        }

                        int amount = -1;
                        try {
                            amount = Integer.parseInt(args[2]);
                        } catch (NumberFormatException ignored) {
                            ShowMessage.notIntegerAt(sender, 3);
                            return true;
                        }

                        if (amount <= 0) {
                            ShowMessage.notPositiveAt(sender, 3);
                            return true;
                        }

                        Player player = (Player) sender;
                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        int itemAmount = itemStack.getAmount();

                        if (itemAmount % amount != 0) {
                            ShowMessage.cantDivideEqually(sender);
                            return true;
                        }

                        Redpackets redpackets = new Redpackets(db);
                        ModelItemStack model = ItemStackToModelItemStack.parse(itemStack);

                        try {
                            redpackets.sendRedpacketNormalItem(args[1], player.getUniqueId(), expire,
                                    new ModelItemStack[] { model }, amount);
                        } catch (SQLException ex) {
                            sender.sendMessage(I18n.format("commands.error.database"));
                            log.severe(I18n.format("exception.database"));
                            ex.printStackTrace();
                        }
                    } else {
                        showUsageItem(sender);
                    }
                    break;
                case "money":
                    if (args.length == 4) {
                        if (!(sender instanceof Player)) {
                            ShowMessage.notPlayer(sender);
                            return true;
                        }

                        int amount = -1;
                        try {
                            amount = Integer.parseInt(args[2]);
                        } catch (NumberFormatException ignored) {
                            ShowMessage.notIntegerAt(sender, 3);
                            return true;
                        }

                        if (amount <= 0) {
                            ShowMessage.notPositiveAt(sender, 3);
                            return true;
                        }

                        double money = -1;
                        try {
                            money = Double.parseDouble(args[3]);
                        } catch (NumberFormatException ignored) {
                            ShowMessage.notDoubleAt(sender, 4);
                            return true;
                        }

                        if (money <= 0) {
                            ShowMessage.notPositiveAt(sender, 4);
                            return true;
                        }

                        if (money % amount != 0) {
                            ShowMessage.cantDivideEqually(sender);
                            return true;
                        }

                        Redpackets redpackets = new Redpackets(db);
                        try {
                            redpackets.sendRedpacketNormalMoney(args[1], ((Player) sender).getUniqueId(),
                                    expire, money, amount);
                        } catch (SQLException ex) {
                            sender.sendMessage(I18n.format("commands.error.database"));
                            log.severe(I18n.format("exception.database"));
                            ex.printStackTrace();
                        }
                    } else {
                        showUsageMoney(sender);
                    }
                    break;
                case "points":
                    if (args.length == 4) {
                        if (!(sender instanceof Player)) {
                            ShowMessage.notPlayer(sender);
                            return true;
                        }

                        int amount = -1;
                        try {
                            amount = Integer.parseInt(args[2]);
                        } catch (NumberFormatException ignored) {
                            ShowMessage.notIntegerAt(sender, 3);
                            return true;
                        }

                        if (amount <= 0) {
                            ShowMessage.notPositiveAt(sender, 3);
                            return true;
                        }

                        double points = -1;
                        try {
                            points = Double.parseDouble(args[3]);
                        } catch (NumberFormatException ignored) {
                            ShowMessage.notDoubleAt(sender, 4);
                            return true;
                        }

                        if (points <= 0) {
                            ShowMessage.notPositiveAt(sender, 4);
                            return true;
                        }

                        if (points % amount != 0) {
                            ShowMessage.cantDivideEqually(sender);
                            return true;
                        }

                        Redpackets redpackets = new Redpackets(db);
                        try {
                            redpackets.sendRedpacketNormalPoints(args[1], ((Player) sender).getUniqueId(),
                                    expire, points, amount);
                        } catch (SQLException ex) {
                            sender.sendMessage(I18n.format("commands.error.database"));
                            log.severe(I18n.format("exception.database"));
                            ex.printStackTrace();
                        }
                    } else {
                        showUsagePoints(sender);
                    }
                    break;
                default:
                    showUsage(sender);
                    break;
            }
        } else {
            showUsage(sender);
        }

        return true;
    }

    private void showUsage(CommandSender sender) {
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_items"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_items_description"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_money"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_money_description"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_points"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_points_description"));
    }

    private void showUsageItem(CommandSender sender) {
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_items"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_items_description"));
    }

    private void showUsageMoney(CommandSender sender) {
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_money"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_money_description"));
    }

    private void showUsagePoints(CommandSender sender) {
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_points"));
        sender.sendMessage(I18n.format("help.redpackets.redpacket_normal_points_description"));
    }
}
