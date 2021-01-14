package noonerp.noonerp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Logger;


public class doCMD implements CommandExecutor {

    Logger log = Logger.getLogger("Minecraft");
    private final NoOneRP plugin;
    public doCMD(NoOneRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("noonerp.do")) {
            sender.sendMessage(plugin.getConfig().getString("messages.you_dont_have_permission").replace("&","§"));
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(plugin.getConfig().getString("messages.bad_usage_do").replace("&","§"));
            return true;
        }
        String text = "";
        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                text += args[i];
            }
            else text += args[i] + " ";
        }
        int radius = plugin.getConfig().getInt("radius.do");
        Player player = (Player)sender;
        List<Entity> p = player.getNearbyEntities(radius,radius,radius);
        for (int i = 0; i < p.size(); i++) {
            if (String.valueOf(p.get(i).getType()) == "PLAYER") p.get(i).sendMessage(plugin.getConfig().getString("messages.commands.me").replace("&","§").replace("%player%", sender.getName()).replace("%text%", text));
        }
        sender.sendMessage(plugin.getConfig().getString("messages.commands.do").replace("&","§").replace("%player%", sender.getName()).replace("%text%", text));
        return true;
    }
}
