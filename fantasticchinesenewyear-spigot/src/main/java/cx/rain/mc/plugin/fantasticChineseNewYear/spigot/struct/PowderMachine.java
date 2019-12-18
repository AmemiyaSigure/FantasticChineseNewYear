package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.struct;

import nl.shanelab.multiblock.IMultiBlock;
import nl.shanelab.multiblock.MultiBlockActivation;
import nl.shanelab.multiblock.MultiBlockPattern;
import nl.shanelab.multiblock.SpecificMaterial;
import nl.shanelab.multiblock.patternobjects.PatternBlock;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PowderMachine implements IMultiBlock {
    @Override
    public void onActivate(Plugin plugin, Location location, Player player, MultiBlockActivation multiBlockActivation) {
        player.sendMessage("Debug!");
    }

    @Override
    public MultiBlockPattern getMultiBlockPattern() {
        return new MultiBlockPattern(
                SpecificMaterial.SLAB_COBBLESTONE,
                new PatternBlock(Material.FENCE, 0, 1, 0)
        );
    }
}
