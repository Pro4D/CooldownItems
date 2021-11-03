package io.github.pro4d.cooldownitems.Listeners;

import io.github.pro4d.cooldownitems.CooldownItems;
import net.Indyuce.mmoitems.api.event.AbilityUseEvent;
import net.Indyuce.mmoitems.stat.data.AbilityData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ItemListener implements Listener {

    private final CooldownItems plugin;


    public ItemListener(CooldownItems plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onItemUse(AbilityUseEvent event) {
        AbilityData abilityData = event.getAbility();
        if(abilityData.hasModifier("cooldown")) {
            if(event.getPlayer().getInventory().getItemInMainHand() != null) {
                ItemStack eventItem = event.getPlayer().getInventory().getItemInMainHand();
                Player player = event.getPlayer();
                //DurabilityItem durabilityItem = new DurabilityItem(player, eventItem);
                int cooldown = (int)abilityData.getModifier("cooldown");
                player.setCooldown(eventItem.getType(), cooldown * 20);
                player.updateInventory();
            }
        }
    }


}
