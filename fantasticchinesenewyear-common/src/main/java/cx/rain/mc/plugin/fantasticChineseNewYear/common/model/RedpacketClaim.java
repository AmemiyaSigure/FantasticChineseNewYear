package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import java.text.SimpleDateFormat;

public class RedpacketClaim {
    private SimpleDateFormat claimTime;
    private ModelPlayer claimPlayer;
    private ModelItemStack[] items;
    private double money;
    private double points;

    public SimpleDateFormat getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(SimpleDateFormat claimTime) {
        this.claimTime = claimTime;
    }

    public ModelPlayer getClaimPlayer() {
        return claimPlayer;
    }

    public void setClaimPlayer(ModelPlayer claimPlayer) {
        this.claimPlayer = claimPlayer;
    }

    public ModelItemStack[] getItems() {
        return items;
    }

    public void setItems(ModelItemStack[] items) {
        this.items = items;
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
}
