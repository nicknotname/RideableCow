package com.boomboomch.rideablecow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MyListener implements Listener {

    Plugin plugin = Bukkit.getPluginManager().getPlugin("RideableCow");
    FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void PlayerItemConsumeEvent(PlayerItemConsumeEvent event){
        int amount = 1;
        ItemStack consumed = event.getItem();
        String name = consumed.toString();
        ItemStack cookie = new ItemStack(Material.COOKIE);
        Player p = event.getPlayer();
        Bukkit.getServer().getConsoleSender().sendMessage(name);

        if(consumed.getType().equals(Material.COOKIE)){
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 2));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 2));
        }
    }

    @EventHandler
    public void EntityDeathEvent(EntityDeathEvent event){
        LivingEntity killer = event.getEntity().getKiller();
        EntityType killed = event.getEntityType();
        EntityType horsie = EntityType.HORSE;
        if(killer instanceof Player){
            if(killed.equals(horsie)){
                Bukkit.broadcastMessage(ChatColor.RED + "" + ((Player) killer).getDisplayName() + " killed a horse!");
            }
        }

    }

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player p = event.getPlayer();

        if (config.get("fireball").equals(true)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if (item.getType().equals(Material.BLAZE_ROD)) {
                    p.launchProjectile(Fireball.class);
                }
            }
        }
    }

    @EventHandler
    public void PlayerEggThrowEvent(PlayerEggThrowEvent event){
        event.setHatching(true);
        event.setHatchingType(EntityType.HORSE);
    }
    
}
