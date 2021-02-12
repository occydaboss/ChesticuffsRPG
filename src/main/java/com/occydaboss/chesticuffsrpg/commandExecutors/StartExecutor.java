package com.occydaboss.chesticuffsrpg.commandExecutors;

import com.occydaboss.chesticuffsrpg.PluginMain;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class StartExecutor implements CommandExecutor
{
    public void start (World spawn, World gameWorld)
    {
        List<Player> players = spawn.getPlayers();

        for (Player player : players) {
            player.sendTitle(ChatColor.YELLOW + "Starting in 5...", "", 1, 20, 1);
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.YELLOW + "Starting in 4...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 20);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.YELLOW + "Starting in 3...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 40);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.YELLOW + "Starting in 2...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 60);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.YELLOW + "Starting in 1...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 80);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                BukkitRunnable runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int x = random.nextInt(100);
                        int z = random.nextInt(100);
                        int y = gameWorld.getHighestBlockYAt(x, z);
                        if (!((gameWorld.getBlockAt(x, y, z).getType().equals(Material.WATER))
                                || (gameWorld.getBlockAt(x, y, z).getType().equals(Material.KELP_PLANT))
                                || (gameWorld.getBlockAt(x, y, z).getType().equals(Material.LAVA))))
                        {
                            player.teleport(new Location(gameWorld, x, y+1, z));
                            cancel();
                        }
                    }
                };
                runnable.runTaskTimer(PluginMain.instance, 0, 1);
                }, 100);
        }
    }

    public void gameTimer (World world)
    {
        List<Player> players = world.getPlayers();

        for (Player player : players)
        {
            player.sendMessage(ChatColor.AQUA + "10 Minutes until DeathMatch");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendMessage(ChatColor.AQUA + "5 Minutes until DeathMatch");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);
            }, 6000);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendMessage(ChatColor.AQUA + "3 Minutes until DeathMatch");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);
            }, 8400);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendMessage(ChatColor.AQUA + "1 Minute until DeathMatch");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);
            }, 10800);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendMessage(ChatColor.AQUA + "30 Seconds until DeathMatch");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);
            }, 11400);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendMessage(ChatColor.AQUA + "10 Seconds until DeathMatch");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);
            }, 11800);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.RED + "5...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 11900);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.RED + "4...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 11920);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.DARK_RED + "3...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 11940);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.DARK_RED + "2...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 11960);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.DARK_RED + "1...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 11980);

            Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
                player.sendTitle(ChatColor.WHITE + "Go!", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 0.5f, 1);
            }, 12000);

        }
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        String worldID = UUID.randomUUID().toString();

        for (World world : Bukkit.getWorlds())
        {
            if (world.getName().equals(worldID))
            {
                worldID = UUID.randomUUID().toString();
            }
        }

        WorldCreator wc = new WorldCreator(worldID);
        World gameWorld = wc.createWorld();

        World spawn = Bukkit.getWorld("world");

        start(spawn, gameWorld);
        String finalWorldID = worldID;
        Bukkit.getScheduler().runTaskLater(PluginMain.instance, () -> {
            gameTimer(Bukkit.getWorld(finalWorldID));
        }, 101);

        return true;
    }
}
