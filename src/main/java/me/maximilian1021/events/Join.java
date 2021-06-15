package me.maximilian1021.events;

import me.maximilian1021.main.Main;
import me.maximilian1021.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.util.Objects;

public class Join implements Listener {

    private final File file = FileManager.getConf();

    private final FileConfiguration FC = (FileConfiguration) YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        int x = FC.getInt("Spawn-X");
        int y = FC.getInt("Spawn-Y");
        int z = FC.getInt("Spawn-Z");
        World world = Bukkit.getWorld(Objects.requireNonNull(FC.getString("Spawn-World")));

        Location loc = new Location(world, x,y,z);
        Player p = e.getPlayer();

        /* Header */
        p.setPlayerListHeader(FC.getString("Tab-Header"));
        p.setPlayerListFooter(FC.getString("Tab-Footer"));

        /* Join Message */
        e.setJoinMessage("§a+ §b " + e.getPlayer().getName());

        /* Teleport */
        if(Bukkit.getWorld(Objects.requireNonNull(FC.getString("Spawn-World"))) != null){
            p.teleport(loc);
        } else {
            Bukkit.getConsoleSender().sendMessage("§cWelt wurde nicht gefunden Kein Teleport möglich");
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§c- §b " + e.getPlayer().getName());
    }


    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent e) {
        if (!e.getPlayer().spigot().getRawAddress().getAddress().toString().contains(Main.getPlugin().getConfig().getString("bungee-ip"))) {
            e.getPlayer().kickPlayer(Main.getPlugin().getConfig().getString("kick-message").replace("&", "§"));
        }
    }
}
