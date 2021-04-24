package com.boomboomch.rideablecow;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    FileConfiguration config = this.getConfig();


    @Override
    public void onEnable(){
        this.getCommand("help2").setExecutor(new FireballCmd());
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        config.addDefault("fireball", false);
        config.options().copyDefaults(true);

    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
}
