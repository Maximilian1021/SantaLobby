package me.maximilian1021.events;

import me.maximilian1021.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        World world = Bukkit.getWorld("Wartelobby");
        Location loc = new Location(world,0.5,100,0.5);
        Player p = e.getPlayer();

        /* Header */
        p.setPlayerListHeader("§k!i!i   §cDas Klassenzimmer - Lobby   §r§k!i!i!");
        p.setPlayerListFooter("§7+++ §bNetwork hosted by §6§lMaximilian1021  §7+++");

        /* Join Message */
        e.setJoinMessage("§a+ §b " + e.getPlayer().getName());

        /* Teleport */
        p.teleport(loc);
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
