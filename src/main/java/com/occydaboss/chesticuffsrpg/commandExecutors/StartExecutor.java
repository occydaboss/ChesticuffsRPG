package com.occydaboss.chesticuffsrpg.commandExecutors;

import com.occydaboss.chesticuffsrpg.PluginMain;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class StartExecutor implements CommandExecutor
{
    public void chesticuffsGame (World spawn, World gameWorld)
    {
        List<Player> players = spawn.getPlayers();

        for (Player player : players)
        {
            player.sendTitle("Starting in 5...", "", 1, 20, 1);
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, ()->{
                player.sendTitle("Starting in 4...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
                }, 20);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, ()->{
                player.sendTitle("Starting in 3...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 40);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, ()->{
                player.sendTitle("Starting in 2...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 60);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, ()->{
                player.sendTitle("Starting in 1...", "", 1, 20, 1);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1);
            }, 80);
            Bukkit.getScheduler().runTaskLater(PluginMain.instance, ()->{
                player.sendMessage("Sending to World");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 5);

                Random random = new Random();
                int x = random.nextInt(100);
                int z = random.nextInt(100);
                int y = gameWorld.getHighestBlockYAt(x, z) + 1;
                Location location = new Location(gameWorld, x, y, z);
                player.teleport(location);

            }, 100);


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

        chesticuffsGame(spawn, gameWorld);

        return true;
    }
}
