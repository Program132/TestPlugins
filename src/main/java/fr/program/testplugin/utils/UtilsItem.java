package fr.program.testplugin.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UtilsItem {
    public static ItemStack createItem(Material material, int quantity, String name) {
        ItemStack item = new ItemStack(material, quantity);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack addEnchant(Enchantment enchantment, int level, ItemStack item) {
        if(item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(enchantment, level, true);
            item.setItemMeta(meta);
        }
        return item;
    }

    public static ItemStack addItemFlag(ItemFlag flag, ItemStack item) {
        if(item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(flag);
            item.setItemMeta(meta);
        }
        return item;
    }
}
