package cx.rain.mc.plugin.common.fantasticChineseNewYear.entity;

public class Redpackets {
    private int Id;
    private String SenderUuid;
    private long SendTime;
    private long ExpireTime;
    private int RedPacketType;
    private int RewardType;
    private String Items;
    private double Money;
    private double Points;
    private int Amount;
    private String ReceiverPlayerUuid;
    private String Password;
    private String ClaimPlayersAndRewards;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSenderUuid() {
        return SenderUuid;
    }

    public void setSenderUuid(String senderUuid) {
        SenderUuid = senderUuid;
    }

    public long getSendTime() {
        return SendTime;
    }

    public void setSendTime(long sendTime) {
        SendTime = sendTime;
    }

    public long getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(long expireTime) {
        ExpireTime = expireTime;
    }

    public int getRedPacketType() {
        return RedPacketType;
    }

    public void setRedPacketType(int redPacketType) {
        RedPacketType = redPacketType;
    }

    public int getRewardType() {
        return RewardType;
    }

    public void setRewardType(int rewardType) {
        RewardType = rewardType;
    }

    public String getItems() {
        return Items;
    }

    public void setItems(String items) {
        Items = items;
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

    public String getReceiverPlayerUuid() {
        return ReceiverPlayerUuid;
    }

    public void setReceiverPlayerUuid(String receiverPlayerUuid) {
        ReceiverPlayerUuid = receiverPlayerUuid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getClaimPlayersAndRewards() {
        return ClaimPlayersAndRewards;
    }

    public void setClaimPlayersAndRewards(String claimPlayersAndRewards) {
        ClaimPlayersAndRewards = claimPlayersAndRewards;
    }
}
