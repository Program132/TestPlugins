package fr.program.testplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("spawn") || command.getName().equalsIgnoreCase("lobby")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                Location spawnLocation = new Location(plr.getWorld(), -31.442, 86, -55.528, 1.0f, 0.1f);
                plr.sendMessage("[SPAWN] Tu es retourne au spawn (lobby) !");
                plr.teleport(spawnLocation);
            }
        }
        return false;
    }
}
