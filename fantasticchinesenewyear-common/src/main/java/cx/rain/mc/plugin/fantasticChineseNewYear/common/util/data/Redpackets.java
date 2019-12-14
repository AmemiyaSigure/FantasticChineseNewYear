package cx.rain.mc.plugin.fantasticChineseNewYear.common.util.data;

import com.google.gson.Gson;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.database.Database;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.ModelItemStack;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.RedpacketParsed;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.database.Redpacket;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.RedPacketType;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.RewardType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Redpackets {
    private Database db;

    public Redpackets(Database database) {
        db = database;
    }

    public int getPages(UUID uuid) throws SQLException {
        Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "select count(*) from `redpackets` where `SenderUuid` = ?;"
        );
        ps.setString(1, uuid.toString());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int records = rs.getInt("count(*)");
            if (records == 0) {
                return 0;
            } else {
                return records % 5 + 1;
            }
        } else {
            return 0;
        }
    }

    public List<RedpacketParsed> getRedpackets(UUID uuid, int offset, int count) throws SQLException {
        ArrayList<RedpacketParsed> redpacketParseds = new ArrayList<>();

        Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "select * from `redpackets` " +
                        "where `SenderUuid` = ? " +
                        "limit ? " +
                        "offset ?;"
        );
        ps.setString(1, uuid.toString());
        ps.setInt(2, count);
        ps.setInt(3, offset);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Redpacket r = new Redpacket();
            r.setId(rs.getInt("Id"));
            r.setSenderUuid(rs.getString("SenderUuid"));
            r.setSendTime(rs.getLong("SendTime"));
            r.setExpireTime(rs.getLong("ExpireTime"));
            r.setRedPacketType(rs.getInt("RedPacketType"));
            r.setRewardType(rs.getInt("RewardType"));
            r.setItems(rs.getString("Items"));
            r.setMoney(rs.getDouble("Money"));
            r.setPoints(rs.getDouble("Points"));
            r.setAmount(rs.getInt("Amount"));
            r.setReceiverPlayerUuid(rs.getString("ReceiverPlayerUuid"));
            r.setPassword(rs.getString("Password"));
            r.setClaimPlayersAndRewards(rs.getString("ClaimPlayersAndRewards"));

            redpacketParseds.add(RedpacketParsed.parse(r));
        }

        rs.close();
        ps.close();
        connection.close();

        return redpacketParseds;
    }

    public void sendRedpacketNormalItem(String name, UUID sender, Date expire, ModelItemStack[] modelItemStacks, int amount)
            throws SQLException {
        Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "insert into `redpackets` " +
                        "(`Name`, `SenderUuid`, `SendTime`, `ExpireTime`, `RedPacketType`, `RewardType`, `Items`, `Amount`) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?);");

        ps.setString(1, name);
        ps.setString(2, sender.toString());
        ps.setLong(3, new Date().getTime());
        ps.setLong(4, expire.getTime());
        ps.setInt(5, RedPacketType.Normal.ordinal());
        ps.setInt(6, RewardType.Items.ordinal());
        Gson gson = new Gson();
        ps.setString(7, gson.toJson(modelItemStacks));
        ps.setInt(8, amount);

        ps.execute();

        ps.close();
        connection.close();
    }

    public void sendRedpacketNormalMoney(String name, UUID sender, Date expire, double money, int amount)
            throws SQLException {
        Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "insert into `redpackets` " +
                        "(`Name`, `SenderUuid`, `SendTime`, `ExpireTime`, `RedPacketType`, `RewardType`, `Money`, `Amount`) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?);");

        ps.setString(1, name);
        ps.setString(2, sender.toString());
        ps.setLong(3, new Date().getTime());
        ps.setLong(4, expire.getTime());
        ps.setInt(5, RedPacketType.Normal.ordinal());
        ps.setInt(6, RewardType.Money.ordinal());
        ps.setDouble(7, money);
        ps.setInt(8, amount);

        ps.execute();

        ps.close();
        connection.close();
    }

    public void sendRedpacketNormalPoints(String name, UUID sender, Date expire, double points, int amount)
            throws SQLException {
        Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "insert into `redpackets` " +
                        "(`Name`, `SenderUuid`, `SendTime`, `ExpireTime`, `RedPacketType`, `RewardType`, `Points`, `Amount`) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?);");

        ps.setString(1, name);
        ps.setString(2, sender.toString());
        ps.setLong(3, new Date().getTime());
        ps.setLong(4, expire.getTime());
        ps.setInt(5, RedPacketType.Normal.ordinal());
        ps.setInt(6, RewardType.Points.ordinal());
        ps.setDouble(7, points);
        ps.setInt(8, amount);

        ps.execute();

        ps.close();
        connection.close();
    }
}
