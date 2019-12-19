package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.listener;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.crafting.Items;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class ListenerPrepareItemCraft implements Listener {
    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        Recipe recipe = event.getRecipe();
        if (recipe instanceof ShapedRecipe) {
            // Check dough to cake.
            if (recipe.getResult().isSimilar(new ItemStack(Material.CAKE))) {
                for (ItemStack i : event.getInventory().getMatrix()) {
                    if (i.isSimilar(Items.getDough())
                            && !i.getItemMeta().getLore().equals(Items.getDough().getItemMeta().getLore())) {
                        event.getInventory().setResult(null);
                    }
                }
            }

            // Check wheat flour to dough.
            if (recipe.getResult().isSimilar(Items.getDough())) {
                System.out.println("1");
                for (ItemStack i : event.getInventory().getMatrix()) {
                    System.out.println("2");
                    if (i.isSimilar(Items.getWheatFlour())
                            && !i.getItemMeta().getLore().equals(Items.getWheatFlour().getItemMeta().getLore())) {
                        System.out.println("3");
                        event.getInventory().setResult(null);
                    }
                }
            }

        } else if (recipe instanceof FurnaceRecipe) {
            // Check dough to bread.
            if (recipe.getResult().isSimilar(new ItemStack(Material.BREAD))) {
                for (ItemStack i : event.getInventory().getMatrix()) {
                    if (i.isSimilar(Items.getDough())
                            && !i.getItemMeta().getLore().equals(Items.getDough().getItemMeta().getLore())) {
                        event.getInventory().setResult(null);
                    }
                }
            }
        }
    }
}
