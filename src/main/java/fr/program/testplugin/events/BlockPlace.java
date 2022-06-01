package fr.program.testplugin.events;

import fr.program.testplugin.TestPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BlockPlace {
    public static void init(BlockPlaceEvent event, TestPlugin plugin) {
        Block block = event.getBlock();
        Player plr = event.getPlayer();
        ItemStack item = event.getItemInHand();

        if (block != null && block.getType() == Material.CHEST && item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Shop")) {
            NamespacedKey key = new NamespacedKey(plugin, "shop-key");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer container_chestGUI = meta.getPersistentDataContainer();
            if (container_chestGUI.has(key, PersistentDataType.DOUBLE)) {
                event.setCancelled(true); //Vérifie si le chest provient bien du chest que l'on a créé
            }
        }
    }
}