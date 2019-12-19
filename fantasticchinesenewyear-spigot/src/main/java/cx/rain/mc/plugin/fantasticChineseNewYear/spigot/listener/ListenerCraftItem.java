package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.listener;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.crafting.Items;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerCraftItem implements Listener {
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        // Dough crafting return empty bucket.
        if (event.getRecipe().getResult().getItemMeta().getLore().equals(
                Items.getDough().getItemMeta().getLore()
        )) {
            event.getWhoClicked().getInventory().addItem(new ItemStack(Material.BUCKET));
        }


    }
}
