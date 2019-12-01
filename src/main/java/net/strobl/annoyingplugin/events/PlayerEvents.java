package net.strobl.annoyingplugin.events;

import net.strobl.annoyingplugin.annoyingplugin.AnnoyingPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerEvents implements org.bukkit.event.Listener {

  private AnnoyingPlugin main;
  private int currently_sleeping;

  public PlayerEvents(AnnoyingPlugin main) {
    this.main = main;
  }

  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e) {
    Player player = e.getEntity();
    main.getServer().broadcastMessage(
        ChatColor.YELLOW + "Press " + ChatColor.GOLD + "F " + ChatColor.YELLOW
            + "to pay respect for " + ChatColor.GOLD + ChatColor.ITALIC + player.getDisplayName());
    main.getServer()
        .broadcastMessage(ChatColor.YELLOW + "lost: " + ChatColor.GOLD + e.getDroppedExp() + ChatColor.YELLOW + " xp");

    e.setDeathMessage(ChatColor.YELLOW + "cause:" + ChatColor.GOLD + e.getDeathMessage().replace(player.getDisplayName(), ""));
    new BukkitRunnable() {
      @Override
      public void run() {
        main.getServer().broadcastMessage(ChatColor.RED + "<Server> " + ChatColor.WHITE + "F");
      }
    }.runTaskLater(main, 2);
  }

  @EventHandler
  public void onPlayerBedEnter(PlayerBedEnterEvent e) {
    Player player = e.getPlayer();
    currently_sleeping++;
    main.getServer().broadcastMessage(
        ChatColor.GOLD + player.getDisplayName() + ChatColor.YELLOW + " wants to sleep");
    main.getServer().broadcastMessage(
        ChatColor.GOLD + String.valueOf(currently_sleeping) + "/" + main.getServer()
            .getOnlinePlayers().size() + ChatColor.YELLOW + " Players are sleeping");
  }

  @EventHandler
  public void onPlayerBedLeave(PlayerBedLeaveEvent e) {
    Player player = e.getPlayer();
    currently_sleeping--;
    main.getServer().broadcastMessage(
        ChatColor.GOLD + player.getDisplayName() + ChatColor.YELLOW + " left the bed");
    main.getServer().broadcastMessage(
        ChatColor.GOLD + String.valueOf(currently_sleeping) + "/" + main.getServer()
            .getOnlinePlayers().size() + ChatColor.YELLOW + " Players are sleeping");
  }
}
