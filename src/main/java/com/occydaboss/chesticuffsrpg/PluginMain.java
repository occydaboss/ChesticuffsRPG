package com.occydaboss.chesticuffsrpg;

import com.occydaboss.chesticuffsrpg.commandExecutors.StartExecutor;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PluginMain extends JavaPlugin
{
    public static PluginMain instance;
    public static Logger logger;
    @Override
    public void onEnable()
    {
        instance = this;
        this.getCommand("start").setExecutor(new StartExecutor());
    }

    @Override
    public void onDisable()
    {

    }

}
