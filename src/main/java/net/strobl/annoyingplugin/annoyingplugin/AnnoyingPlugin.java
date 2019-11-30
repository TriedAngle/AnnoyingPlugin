package net.strobl.annoyingplugin.annoyingplugin;

import net.strobl.annoyingplugin.commands.Annoy;
import net.strobl.annoyingplugin.events.DeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnnoyingPlugin extends JavaPlugin {

  private String currentVersion = "0.2";
  private static AnnoyingPlugin instance;

  @Override
  public void onEnable() {
    System.out.println("AnnoyingPluginVersion " + currentVersion);
    System.out.println("initializing Events: ");
    Bukkit.getPluginManager().registerEvents(new DeathEvent(this), this);
    System.out.println("Done initializing Events");
    System.out.println("initializing Commands: ");
    this.getCommand("annoy").setExecutor(new Annoy());
    System.out.println("Done initializing Commands");
    System.out.println("Annoyance has been initialized");
  }

  @Override
  public void onDisable() {
    System.out.println("This is so sad, Alexa... play Despacito");
  }

}
