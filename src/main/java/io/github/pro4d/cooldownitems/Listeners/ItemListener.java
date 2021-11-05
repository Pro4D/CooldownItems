package io.github.pro4d.cooldownitems.Listeners;

import io.github.pro4d.cooldownitems.CooldownItems;
import io.lumine.mythic.lib.api.item.NBTItem;
import net.Indyuce.mmoitems.api.event.AbilityUseEvent;
import net.Indyuce.mmoitems.stat.data.AbilityData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ItemListener implements Listener {


    public ItemListener(CooldownItems plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onAbilityUse(AbilityUseEvent event) {
        AbilityData abilityData = event.getAbility();
        ItemStack eventItem = event.getPlayer().getInventory().getItemInMainHand();
        NBTItem nbtItem = NBTItem.get(eventItem);

        if(abilityData.hasModifier("cooldown")) {
            Player player = event.getPlayer();
            double cooldown = abilityData.getModifier("cooldown");

            player.setCooldown(eventItem.getType(), (int) (cooldown * 20));
            player.updateInventory();
        }

        if(nbtItem.hasTag("MMOITEMS_ITEM_COOLDOWN")) {
            Player player = event.getPlayer();

            double cooldown = nbtItem.getDouble("MMOITEMS_ITEM_COOLDOWN");

            player.setCooldown(nbtItem.getItem().getType(), (int) (cooldown * 20));
            player.updateInventory();
        }
    }
}
