package net.strobl.annoyingplugin.annoyingplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnnoyingPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    System.out.println("Annoyance has been initialized");
  }

  @Override
  public void onDisable() {
    System.out.println("This is so sad, Alexa... play Despacito");
  }


  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (label.equals("annoy")){
      if(sender.isOp()){
        if(sender instanceof Player) {
          Player player = (Player) sender;
          player.sendMessage(ChatColor.GOLD + "Annoying Commands:");
        }
      } else {
        sender.sendMessage(ChatColor.RED + "HaHa lol, no permission for that XD");
      }
    }
    return false;
  }

}
