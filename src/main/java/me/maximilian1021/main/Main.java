package me.maximilian1021.main;

import me.maximilian1021.commands.CMDSpawn;
import me.maximilian1021.events.Join;
import me.maximilian1021.events.Tablistener;
import me.maximilian1021.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;
    public static Main getPlugin() {
        return plugin;
    }

    public final boolean isPlaceholderAPIEnabled() {
        return this.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");

    }

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        saveDefaultConfig();
        reloadConfig();

        Main.plugin = this;


        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Tablistener(), this);
        pm.registerEvents(new Chatformat(), this);
        getCommand("Spawn").setExecutor(new CMDSpawn());

    }

    @Override
    public void onDisable() {

    }
}
