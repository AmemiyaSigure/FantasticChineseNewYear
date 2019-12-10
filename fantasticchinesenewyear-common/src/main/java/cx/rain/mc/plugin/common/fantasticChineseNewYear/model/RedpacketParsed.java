package cx.rain.mc.plugin.common.fantasticChineseNewYear.model;

import com.google.gson.Gson;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.model.database.Redpacket;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.util.enumerate.RedPacketType;
import cx.rain.mc.plugin.common.fantasticChineseNewYear.util.enumerate.RewardType;

import java.util.Date;

public class RedpacketParsed {
    private Player Sender;
    private Date SendTime;
    private Date ExpireTime;
    private RedPacketType Type;
    private Player ReceiverPlayer;
    private String Password;
    private RewardType Reward;
    private ItemStack[] ItemStacks;
    private double Money;
    private double Points;
    private int Amount;
    private RedpacketClaim[] ClaimPlayersAndRewards;

    public static RedpacketParsed parse(Redpacket r) {
        // Believe all of the data from database.
        Gson gson = new Gson();

        RedpacketParsed rp = new RedpacketParsed();
        rp.setSender(Player.parse(r.getSenderUuid()));
        rp.setSendTime(new Date(r.getSendTime()));
        rp.setExpireTime(new Date(r.getExpireTime()));
        rp.setType(RedPacketType.valueOf(String.valueOf(r.getRedPacketType())));
        rp.setReward(RewardType.valueOf(String.valueOf(r.getRewardType())));

        switch (rp.getType()) {
            case Password:
                rp.setPassword(r.getPassword());
                break;
            case Exclusive:
                rp.setReceiverPlayer(Player.parse(r.getReceiverPlayerUuid()));
                break;
        }

        switch (rp.getReward()) {
            case Items:
                rp.setItemStacks(gson.fromJson(r.getItems(), ItemStack[].class));
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

    public Player getSender() {
        return Sender;
    }

    public void setSender(Player sender) {
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

    public ItemStack[] getItemStacks() {
        return ItemStacks;
    }

    public void setItemStacks(ItemStack[] itemStacks) {
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

    public Player getReceiverPlayer() {
        return ReceiverPlayer;
    }

    public void setReceiverPlayer(Player receiverPlayer) {
        ReceiverPlayer = receiverPlayer;
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
