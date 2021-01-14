package noonerp.noonerp;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class NoOneRP extends JavaPlugin {
    Logger log = Logger.getLogger("Minecraft");
    private static Configuration configuration;


    @Override
    public void onEnable() {
        File config = new File(getDataFolder() + File.separator + "cofig.yml");
        if(!config.exists()) {
            log.info("Файл конфигрурации успешно создан!");
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        registerCommands();
        log.info("Плагин успешно запущен!");

    }

    @Override
    public void onDisable() {
        log.info("Плагин успешно отключён!");
    }

    private void registerCommands() {
        this.getServer().getPluginCommand("me").setExecutor(new meCMD(this));
        this.getServer().getPluginCommand("do").setExecutor(new doCMD(this));
        this.getServer().getPluginCommand("try").setExecutor(new tryCMD(this));
        this.getServer().getPluginCommand("rpreload").setExecutor(new reloadCMD(this));
    }
}
