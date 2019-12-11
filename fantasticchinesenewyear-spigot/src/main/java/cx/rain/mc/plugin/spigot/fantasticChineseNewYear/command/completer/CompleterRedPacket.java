package cx.rain.mc.plugin.spigot.fantasticChineseNewYear.command.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CompleterRedPacket implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> completes = new ArrayList<>();
        if (args.length == 1) {
            completes.add("help");
            completes.add("history");
        }
        return completes;
    }
}
