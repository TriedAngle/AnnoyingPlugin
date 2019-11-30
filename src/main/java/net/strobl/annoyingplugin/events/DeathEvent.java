package net.strobl.annoyingplugin.events;

import net.strobl.annoyingplugin.annoyingplugin.AnnoyingPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements org.bukkit.event.Listener {

  private AnnoyingPlugin main;

  public DeathEvent(AnnoyingPlugin main){
    this.main = main;
  }

  @EventHandler
  public void onDeath(PlayerDeathEvent e){
    Player player = e.getEntity();
    e.setDeathMessage(ChatColor.YELLOW + "Press " + ChatColor.GOLD + "F" + ChatColor.YELLOW + "to pay respect for " + player.getDisplayName());
    main.getServer().broadcastMessage("F");
  }

}
