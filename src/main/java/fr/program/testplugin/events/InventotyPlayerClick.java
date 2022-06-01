package fr.program.testplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventotyPlayerClick {

    private static void ShopGUI(Player plr, Inventory inv, ItemStack item, InventoryClickEvent event) {
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Explosion")) {
            event.setCancelled(true);
        }
    }

    public static void init(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        Player plr = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (inv != null && inv.getSize() == 18 && event.getView().getTitle().equalsIgnoreCase("Shop")) {
            ShopGUI(plr, inv, item, event);
        }
    }
}
