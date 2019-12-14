package cx.rain.mc.plugin.fantasticChineseNewYear.spigot.util.parser;

import cx.rain.mc.plugin.fantasticChineseNewYear.common.model.ModelItemStack;
import cx.rain.mc.plugin.fantasticChineseNewYear.common.util.enumerate.model.ItemFlags;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemStackToModelItemStack {
    public static ModelItemStack parse(ItemStack itemStack) {
        ModelItemStack model = new ModelItemStack();

        // ItemStack properties.
        model.setName(itemStack.getType().name());
        model.setAmount(itemStack.getAmount());
        model.setDamage(itemStack.getDurability());
        model.setMaxDamage(itemStack.getType().getMaxDurability());
        model.setMaxStackSize(itemStack.getType().getMaxStackSize());

        HashMap<String, Integer> enchants = new HashMap<>();
        itemStack.getEnchantments().forEach((enchantment, integer) -> {
            enchants.put(enchantment.getName(), integer);
        });
        model.setEnchantments(enchants);

        // ItemMeta properties.
        ItemMeta meta = itemStack.getItemMeta();

        model.setDisplayName(meta.getDisplayName());
        model.setLocalizedName(meta.getLocalizedName());
        model.setLore(meta.getLore());
        model.setUnbreakable(meta.isUnbreakable());
        List<ItemFlags> flags = new ArrayList<>();
        for (ItemFlag f : meta.getItemFlags()) {
            flags.add(ItemFlags.values()[f.ordinal()]);
        }
        model.setItemFlags(flags);

        return model;
    }
}
