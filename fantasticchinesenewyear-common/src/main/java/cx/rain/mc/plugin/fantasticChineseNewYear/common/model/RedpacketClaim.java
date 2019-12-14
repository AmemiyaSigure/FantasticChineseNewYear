package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import java.text.SimpleDateFormat;

public class RedpacketClaim {
    private SimpleDateFormat ClaimTime;
    private ModelPlayer ClaimPlayer;
    private ModelItemStack[] ItemStacks;
    private double Money;
    private double Points;

    public SimpleDateFormat getClaimTime() {
        return ClaimTime;
    }

    public void setClaimTime(SimpleDateFormat claimTime) {
        ClaimTime = claimTime;
    }

    public ModelPlayer getClaimPlayer() {
        return ClaimPlayer;
    }

    public void setClaimPlayer(ModelPlayer claimPlayer) {
        this.ClaimPlayer = claimPlayer;
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
}
