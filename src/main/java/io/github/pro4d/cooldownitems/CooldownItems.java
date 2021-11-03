package io.github.pro4d.cooldownitems;

import io.github.pro4d.cooldownitems.Listeners.ItemListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CooldownItems extends JavaPlugin {

    private ItemListener itemListener;
    @Override
    public void onEnable() {
        // Plugin startup logic
        itemListener = new ItemListener(this);
    }

}
