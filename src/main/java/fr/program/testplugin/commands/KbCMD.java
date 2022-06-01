package fr.program.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KbCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kb") || command.getName().equalsIgnoreCase("knowback")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                ItemStack kbStick = new ItemStack(Material.STICK, 1);

                ItemMeta meta_kbStick = kbStick.getItemMeta();
                meta_kbStick.addEnchant(Enchantment.KNOCKBACK, 2, true);
                meta_kbStick.setLore(Arrays.asList("Un stick pour kb des joueurs", "Un stick pour kb des cheaters"));
                meta_kbStick.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                kbStick.setItemMeta(meta_kbStick);

                plr.getInventory().addItem(kbStick);
                plr.updateInventory();
            }
        }
        return false;
    }
}
