package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.crafting;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.util.I18n;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {
    public static ItemStack getWheatFlour() {
        return getWheatFlour(1);
    }

    public static ItemStack getWheatFlour(int count) {
        ItemStack wheatFlour = new ItemStack(Material.SUGAR, count);
        ItemMeta wheatFlourMeta = wheatFlour.getItemMeta();
        wheatFlourMeta.setDisplayName(I18n.format("item.wheat_flour.name"));
        ArrayList<String> wheatFlourMetaLore = new ArrayList<>();
        wheatFlourMetaLore.add(I18n.format("item.wheat_flour.lore"));
        wheatFlourMeta.setLore(wheatFlourMetaLore);
        wheatFlour.setItemMeta(wheatFlourMeta);
        return wheatFlour;
    }

    public static ItemStack getDough() {
        return getDough(1);
    }

    public static ItemStack getDough(int count) {
        ItemStack dough = new ItemStack(Material.LIGHT_GRAY_DYE, count);
        ItemMeta doughMeta = dough.getItemMeta();
        doughMeta.setDisplayName(I18n.format("item.dough.name"));
        ArrayList<String> doughMetaLore = new ArrayList<>();
        doughMetaLore.add(I18n.format("item.dough.lore"));
        doughMeta.setLore(doughMetaLore);
        dough.setItemMeta(doughMeta);
        dough.setAmount(count);
        return dough;
    }
}
