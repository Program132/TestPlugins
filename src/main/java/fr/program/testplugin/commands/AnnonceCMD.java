package fr.program.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnonceCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("annonce")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                if (args.length <= 0) {
                    plr.sendMessage(ChatColor.RED + "ERREUR " + ChatColor.WHITE + "| Veuillez donner des arguments pour votre annonce !");
                } else {
                    StringBuilder finalMessage = new StringBuilder();
                    for (String part : args) {
                        finalMessage.append(part).append(" ");
                    }
                    Bukkit.broadcastMessage(ChatColor.WHITE  + "[" + ChatColor.BOLD + plr.getDisplayName() + ChatColor.RESET + "][" + ChatColor.RED +"ANNONCE" + ChatColor.WHITE + "]" + finalMessage.toString());
                }
            }
        }

        return false;
    }}
