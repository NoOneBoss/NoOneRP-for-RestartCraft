package noonerp.noonerp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Logger;


public class tryCMD implements CommandExecutor {

    Logger log = Logger.getLogger("Minecraft");
    private NoOneRP plugin;
    public tryCMD(NoOneRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("noonerp.try")) {
            sender.sendMessage(plugin.getConfig().getString("messages.you_dont_have_permission").replace("&","§"));
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(plugin.getConfig().getString("messages.bad_usage_try").replace("&","§"));
            return true;
        }
        String result;
        int random_number = 0 + (int) (Math.random() * 2);
        if (random_number == 1) result = "&aУдачно";
        else result = "&cНеудачно";
        String text = "";
        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                text += args[i];
            }
            else text += args[i] + " ";
        }
        int radius = plugin.getConfig().getInt("radius.try");
        Player player = (Player)sender;
        List<Entity> p = player.getNearbyEntities(radius,radius,radius);
        for (int i = 0; i < p.size(); i++) {
            if (String.valueOf(p.get(i).getType()) == "PLAYER") p.get(i).sendMessage(plugin.getConfig().getString("messages.commands.try").replace("%result%", result).replace("%text%", sender.getName()).replace("%player%", text).replace("&","§"));
        }
        sender.sendMessage(plugin.getConfig().getString("messages.commands.try").replace("%result%", result).replace("%text%", text).replace("%player%", sender.getName()).replace("&","§"));
        return true;
    }
}
