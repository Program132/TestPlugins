package fr.program.testplugin.events;

import fr.program.testplugin.TestPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PlayerJoin {

    public static void init(PlayerJoinEvent event, TestPlugin plugin) {
        Player player = event.getPlayer();

        player.getInventory().clear();

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta_item = item.getItemMeta();
        meta_item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta_item.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
        meta_item.setDisplayName("Epee cheat");
        item.setItemMeta(meta_item);

        player.getInventory().addItem(item);


        // Config du chest GUI

        NamespacedKey key = new NamespacedKey(plugin, "shop-key");
        ItemStack chestGUI = new ItemStack(Material.CHEST, 1);
        ItemMeta meta_chestGUI = chestGUI.getItemMeta();
        meta_chestGUI.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, Math.PI);
        meta_chestGUI.setDisplayName("Shop");
        chestGUI.setItemMeta(meta_chestGUI);

        player.getInventory().setItem(9, chestGUI);

        // MISE A JOUR DE L'INV
        player.updateInventory();


        // DATA

        if (!plugin.getConfig().contains("players." + player.getUniqueId())) {
            plugin.getConfig().set("players." + player.getUniqueId() + ".name", player.getDisplayName());
            plugin.getConfig().set("players." + player.getUniqueId() + ".rank", "Starter");
            plugin.getConfig().set("players." + player.getUniqueId() + ".level", 0);
            plugin.getConfig().set("players." + player.getUniqueId() + ".xp", 0);
            plugin.getConfig().set("players." + player.getUniqueId() + ".kills", 0);
            plugin  .saveConfig();
        }
    }
}
