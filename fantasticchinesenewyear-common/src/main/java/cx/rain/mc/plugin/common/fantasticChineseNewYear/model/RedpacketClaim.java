package cx.rain.mc.plugin.common.fantasticChineseNewYear.model;

import java.text.SimpleDateFormat;

public class RedpacketClaim {
    private SimpleDateFormat ClaimTime;
    private Player ClaimPlayer;
    private ItemStack[] ItemStacks;
    private double Money;
    private double Points;

    public SimpleDateFormat getClaimTime() {
        return ClaimTime;
    }

    public void setClaimTime(SimpleDateFormat claimTime) {
        ClaimTime = claimTime;
    }

    public Player getClaimPlayer() {
        return ClaimPlayer;
    }

    public void setClaimPlayer(Player claimPlayer) {
        ClaimPlayer = claimPlayer;
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
}
