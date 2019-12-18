package cx.rain.mc.plugin.fantasticchinesenewyear.spigot.struct;

import cx.rain.mc.plugin.fantasticchinesenewyear.spigot.FantasticChineseNewYearSpigot;
import nl.shanelab.multiblock.MultiBlockFactory;

public class Structures {
    public Structures() {
        MultiBlockFactory.INSTANCE.register(FantasticChineseNewYearSpigot.getInstance(), PowderMachine.class);
    }
}
