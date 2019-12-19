package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.crafting;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.FantasticChineseNewYearSpigot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recipes {
    private Plugin plugin = FantasticChineseNewYearSpigot.getInstance();

    private ArrayList<ItemStack> recipesToRemove = new ArrayList<>();

    public Recipes() {
        removeRecipes();
        addRecipes();
    }

    // Remove recipes.
    private void removeRecipes() {
        recipesToRemove.add(new ItemStack(Material.CAKE));
        recipesToRemove.add(new ItemStack(Material.BREAD));

        // Do remove.
        internalRemoveRecipes(recipesToRemove);
    }

    public ShapelessRecipe WHEAT_FLOUR = new ShapelessRecipe(new NamespacedKey(plugin, "wheat_flour"),
            Items.getWheatFlour(2))
            .addIngredient(1, Material.WHEAT);

    // Need check in prepare craft.
    // Return a empty bucket in crafted.
    public ShapedRecipe DOUGH = new ShapedRecipe(new NamespacedKey(plugin, "dough"),
            Items.getDough())
            .shape("WWW", "WBW", "WWW")
            .setIngredient('W', Items.getWheatFlour().getData())
            .setIngredient('B', Material.WATER_BUCKET);

    // Need check in prepare craft.
    public ShapedRecipe CAKE = new ShapedRecipe(new NamespacedKey(plugin, "cake"),
            new ItemStack(Material.CAKE))
            .shape("MMM", "SES", "WWW")
            .setIngredient('M', Material.MILK_BUCKET)
            .setIngredient('S', Material.SUGAR)
            .setIngredient('E', Material.EGG)
            .setIngredient('W', Items.getDough().getData());

    // Need check in prepare craft.
    public FurnaceRecipe BREAD = new FurnaceRecipe(new ItemStack(Material.BREAD),
            Items.getDough().getData(), 1);

    // Add recipes.
    private void addRecipes() {
        Bukkit.addRecipe(WHEAT_FLOUR);
        Bukkit.addRecipe(DOUGH);
        Bukkit.getRecipesFor(new ItemStack(Material.BREAD));
        Bukkit.addRecipe(CAKE);
        Bukkit.addRecipe(BREAD);
    }

    // TODO: Detection craft recipe but not result.
    private void internalRemoveRecipes(List<ItemStack> recipesResult) {
        Iterator<Recipe> iterator = Bukkit.recipeIterator();
        while (iterator.hasNext()) {
            Recipe r = iterator.next();
            if (recipesResult.contains(r.getResult())) {
                iterator.remove();
            }
        }
    }

}
