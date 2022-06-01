package fr.program.testplugin.commands;

import fr.program.testplugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BienvenueCMD implements CommandExecutor {
    TestPlugin plugin;

    public BienvenueCMD(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("bienvenue") || command.getName().equalsIgnoreCase("bienvenu") || command.getName().equalsIgnoreCase("welcome")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                Bukkit.broadcastMessage("Le joueur " + plr.getDisplayName() + " a bien ete acceuilli !");

                Bukkit.broadcastMessage("[" + ChatColor.DARK_RED + "ACCUEIL" + ChatColor.WHITE + "] " + plugin.getConfig().getString("messages.commands.bienvenue"));
            }
        }

        return false;
    }
}
