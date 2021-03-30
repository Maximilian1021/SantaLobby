package me.maximilian1021.main;

import me.maximilian1021.events.onJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();


        pm.registerEvents(new onJoin(), this);

    }

    @Override
    public void onDisable() {

    }
}
