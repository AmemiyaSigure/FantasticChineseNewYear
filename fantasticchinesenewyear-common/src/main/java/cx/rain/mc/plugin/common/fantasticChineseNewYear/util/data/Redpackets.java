package cx.rain.mc.plugin.common.fantasticChineseNewYear.util.data;

import cx.rain.mc.plugin.common.fantasticChineseNewYear.database.Database;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.model.RedpacketParsed;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.model.database.Redpacket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                "select * from `redpackets` where `SenderUuid` = ? limit ? offset ?;"
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
        return redpacketParseds;
    }
}
