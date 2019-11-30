package net.strobl.annoyingplugin.events;

import net.strobl.annoyingplugin.annoyingplugin.AnnoyingPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathEvent implements org.bukkit.event.Listener {

  private AnnoyingPlugin main;

  public DeathEvent(AnnoyingPlugin main){
    this.main = main;
  }

  @EventHandler
  public void onDeath(PlayerDeathEvent e){
    Player player = e.getEntity();
    e.setDeathMessage(ChatColor.YELLOW + "Press " + ChatColor.GOLD + "F " + ChatColor.YELLOW + "to pay respect for " + ChatColor.GOLD + ChatColor.ITALIC + player.getDisplayName());
    new BukkitRunnable() {
      @Override
      public void run(){
        main.getServer().broadcastMessage("F");
      }
    }.runTaskLater(main, 2);
  }
}
