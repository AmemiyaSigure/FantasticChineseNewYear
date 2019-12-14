package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import com.google.gson.Gson;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.database.Redpacket;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.RedPacketType;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.RewardType;

import java.util.Date;

public class RedpacketParsed {
    private String Name;
    private ModelPlayer Sender;
    private Date SendTime;
    private Date ExpireTime;
    private RedPacketType Type;
    private ModelPlayer ReceiverPlayer;
    private String Password;
    private RewardType Reward;
    private ModelItemStack[] ItemStacks;
    private double Money;
    private double Points;
    private int Amount;
    private RedpacketClaim[] ClaimPlayersAndRewards;

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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ModelPlayer getSender() {
        return Sender;
    }

    public void setSender(ModelPlayer sender) {
        Sender = sender;
    }

    public Date getSendTime() {
        return SendTime;
    }

    public void setSendTime(Date sendTime) {
        SendTime = sendTime;
    }

    public Date getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(Date expireTime) {
        ExpireTime = expireTime;
    }

    public RedPacketType getType() {
        return Type;
    }

    public void setType(RedPacketType type) {
        Type = type;
    }

    public RewardType getReward() {
        return Reward;
    }

    public void setReward(RewardType reward) {
        Reward = reward;
    }

    public ModelItemStack[] getItemStacks() {
        return ItemStacks;
    }

    public void setItemStacks(ModelItemStack[] itemStacks) {
        this.ItemStacks = itemStacks;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public double getPoints() {
        return Points;
    }

    public void setPoints(double points) {
        Points = points;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public ModelPlayer getReceiverPlayer() {
        return ReceiverPlayer;
    }

    public void setReceiverPlayer(ModelPlayer receiverPlayer) {
        this.ReceiverPlayer = receiverPlayer;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public RedpacketClaim[] getClaimPlayersAndRewards() {
        return ClaimPlayersAndRewards;
    }

    public void setClaimPlayersAndRewards(RedpacketClaim[] claimPlayersAndRewards) {
        ClaimPlayersAndRewards = claimPlayersAndRewards;
    }
}
