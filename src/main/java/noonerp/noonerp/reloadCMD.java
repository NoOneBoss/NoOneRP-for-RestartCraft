package noonerp.noonerp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.util.logging.Logger;


public class reloadCMD implements CommandExecutor {

    Logger log = Logger.getLogger("Minecraft");
    private NoOneRP plugin;

    public reloadCMD(NoOneRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("noonerp.reload")) {
            sender.sendMessage(plugin.getConfig().getString("messages.you_dont_have_permission").replace("&","§"));
            return true;
        }
        if(args.length == 0) {
            plugin.reloadConfig();
            sender.sendMessage(plugin.getConfig().getString("messages.reload").replace("&","§"));
            return true;
        }
        return false;
    }
}