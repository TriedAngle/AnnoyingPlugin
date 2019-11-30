package net.strobl.annoyingplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Annoy implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
