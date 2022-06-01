package fr.program.testplugin.events;

import fr.program.testplugin.TestPlugin;
import fr.program.testplugin.utils.UtilsItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerInteraction {
    private static void InteractIronAxe1(Player plr, Action action, ItemStack item) {
        plr.sendMessage("Vous avez clique (droit OU gauche) avec une hache en fer !");

        if (action == Action.LEFT_CLICK_BLOCK) {
            plr.sendMessage("Vous avez fait un clique gauche sur un bloc !");
        } else if (action == Action.LEFT_CLICK_AIR) {
            plr.sendMessage("Vous avez fait un clique gauche dans l'air !");
        } else if (action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR) {
            plr.sendMessage("Vous avez clique (droit OU gauche) avec une hache en fer mais dans l'air !");
        }
    }

    private static void InteractEpeeCheat(Player plr, Action action, ItemStack item) {
        plr.sendMessage("Vous utiliser l'epee cheat");
    }

    private static void InteractShop(Player plr, Action action, ItemStack item) {
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            Inventory ShopGUI = Bukkit.createInventory(null, 18, "Shop");

            ItemStack tnt_item = UtilsItem.createItem(Material.TNT, 1, "Explosion");
            tnt_item = UtilsItem.addItemFlag(ItemFlag.HIDE_ENCHANTS, tnt_item);
            tnt_item = UtilsItem.addEnchant(Enchantment.ARROW_DAMAGE, 1, tnt_item);

            ShopGUI.setItem(1, tnt_item);

            plr.openInventory(ShopGUI);
        }
    }

    public static void init(PlayerInteractEvent event, TestPlugin plugin) {
        Player plr = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.IRON_AXE) {
            InteractIronAxe1(plr, action, item);
        } else if (item != null && item.getType() == Material.DIAMOND_SWORD && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Epee cheat")) {
            InteractEpeeCheat(plr, action, item);
        } else if (item != null && item.getType() == Material.CHEST && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Shop")) {
            if (item instanceof ItemStack) {
                NamespacedKey key = new NamespacedKey(plugin, "shop-key");
                ItemMeta meta = item.getItemMeta();
                PersistentDataContainer container_chestGUI = meta.getPersistentDataContainer();
                if (container_chestGUI.has(key, PersistentDataType.DOUBLE)) {
                    InteractShop(plr, action, item); //Vérifie si le chest provient bien du chest que l'on a créé
                }
            }
        }
    }
}
