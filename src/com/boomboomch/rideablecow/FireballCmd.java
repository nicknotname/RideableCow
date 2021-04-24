package com.boomboomch.rideablecow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class FireballCmd implements CommandExecutor {

    Plugin plugin = Bukkit.getPluginManager().getPlugin("RideableCow");
    FileConfiguration config = plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            if (config.get("fireball").equals(true)) {
                config.set("fireball", false);
                Bukkit.broadcastMessage(ChatColor.RED + " YOU DONT DESERVE HELP");
                return true;
            }
            if (config.get("fireball").equals(false)) {
                config.set("fireball", true);
                Bukkit.broadcastMessage(ChatColor.GREEN + " YOU DESERVE HELP");
                return true;
            }
        return false;
        }
    }

