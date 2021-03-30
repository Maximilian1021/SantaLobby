package me.maximilian1021.main;

import me.maximilian1021.events.onJoin;
import me.maximilian1021.events.tablistener;
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

        Main.plugin = this;


        pm.registerEvents(new onJoin(), this);
        pm.registerEvents(new tablistener(), this);

    }

    @Override
    public void onDisable() {

    }
}
