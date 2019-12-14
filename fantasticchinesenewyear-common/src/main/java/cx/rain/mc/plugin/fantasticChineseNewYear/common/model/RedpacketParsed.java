package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import com.google.gson.Gson;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.database.Redpacket;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.RedPacketType;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.RewardType;

import java.util.Date;

public class RedpacketParsed {
    private String name;
    private ModelPlayer sender;
    private Date sendTime;
    private Date expireTime;
    private RedPacketType type;
    private ModelPlayer receiverPlayer;
    private String password;
    private RewardType reward;
    private ModelItemStack[] items;
    private double money;
    private double points;
    private int amount;
    private RedpacketClaim[] claimPlayersAndRewards;

    public static RedpacketParsed parse(Redpacket r) {
        // Believe all of the data from database.
        Gson gson = new Gson();

        RedpacketParsed rp = new RedpacketParsed();
        rp.setName(r.getName());
        rp.setSender(ModelPlayer.parse(r.getSenderUuid()));
        rp.setSendTime(new Date(r.getSendTime()));
        rp.setExpireTime(new Date(r.getExpireTime()));
        rp.setType(RedPacketType.valueOf(String.valueOf(r.getRedPacketType())));
        rp.setReward(RewardType.valueOf(String.valueOf(r.getRewardType())));

        switch (rp.getType()) {
            case Password:
                rp.setPassword(r.getPassword());
                break;
            case Exclusive:
                rp.setReceiverPlayer(ModelPlayer.parse(r.getReceiverPlayerUuid()));
                break;
        }

        switch (rp.getReward()) {
            case Items:
                rp.setItemStacks(gson.fromJson(r.getItems(), ModelItemStack[].class));
                break;
            case Money:
                rp.setMoney(r.getMoney());
                break;
            case Points:
                rp.setPoints(r.getPoints());
                break;
        }

        rp.setAmount(r.getAmount());

        rp.setClaimPlayersAndRewards(gson.fromJson(r.getClaimPlayersAndRewards(), RedpacketClaim[].class));
        return rp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelPlayer getSender() {
        return sender;
    }

    public void setSender(ModelPlayer sender) {
        this.sender = sender;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public RedPacketType getType() {
        return type;
    }

    public void setType(RedPacketType type) {
        this.type = type;
    }

    public RewardType getReward() {
        return reward;
    }

    public void setReward(RewardType reward) {
        this.reward = reward;
    }

    public ModelItemStack[] getItemStacks() {
        return items;
    }

    public void setItemStacks(ModelItemStack[] itemStacks) {
        this.items = itemStacks;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ModelPlayer getReceiverPlayer() {
        return receiverPlayer;
    }

    public void setReceiverPlayer(ModelPlayer receiverPlayer) {
        this.receiverPlayer = receiverPlayer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RedpacketClaim[] getClaimPlayersAndRewards() {
        return claimPlayersAndRewards;
    }

    public void setClaimPlayersAndRewards(RedpacketClaim[] claimPlayersAndRewards) {
        this.claimPlayersAndRewards = claimPlayersAndRewards;
    }
}
