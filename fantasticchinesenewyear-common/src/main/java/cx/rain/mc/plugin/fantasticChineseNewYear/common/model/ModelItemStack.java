package cx.rain.mc.plugin.fantasticChineseNewYear.common.model;

import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.model.ItemFlags;

import java.util.List;
import java.util.Map;

public class ModelItemStack {
    private String name;
    private int amount;
    private short damage;
    private int maxDamage;
    private int maxStackSize;
    private String displayName;
    private String localizedName;
    private List<String> lore;
    private boolean unbreakable;
    private List<ItemFlags> itemFlags;
    private Map<String, Integer> enchantments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public short getDamage() {
        return damage;
    }

    public void setDamage(short damage) {
        this.damage = damage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public void setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    public List<ItemFlags> getItemFlags() {
        return itemFlags;
    }

    public void setItemFlags(List<ItemFlags> itemFlags) {
        this.itemFlags = itemFlags;
    }

    public Map<String, Integer> getEnchantments() {
        return enchantments;
    }

    public void setEnchantments(Map<String, Integer> enchantments) {
        this.enchantments = enchantments;
    }
}
