package cx.rain.mc.plugin.fantasticChineseNewYear.spigot.util.parser;

import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.ModelItemStack;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.model.ItemFlags;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModelItemStackToItemStack {
    public static ItemStack parse(ModelItemStack model) {
        Material material = Material.matchMaterial(model.getName());

//        assert material != null;

        ItemStack itemStack = new ItemStack(material, model.getAmount(), model.getDamage());

        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(model.getDisplayName());
        meta.setLocalizedName(model.getLocalizedName());
        meta.setLore(model.getLore());
        meta.setUnbreakable(model.isUnbreakable());
        for (ItemFlags i : model.getItemFlags()) {
            meta.addItemFlags(ItemFlag.values()[i.ordinal()]);
        }
        itemStack.setItemMeta(meta);

        model.getEnchantments().forEach(((name, level) -> {
            itemStack.addEnchantment(Enchantment.getByName(name), level);
        }));

        return itemStack;
    }
}
