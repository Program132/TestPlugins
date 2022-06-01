package fr.program.testplugin.commands;

import fr.program.testplugin.TestPlugin;
import fr.program.testplugin.utils.UtilsTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PvpCMD implements CommandExecutor {
    TestPlugin plugin;

    public PvpCMD(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("pvp")) {
            if (sender instanceof Player) {
                Player plr = (Player) sender;

                plr.sendMessage("En attente d'autres joueurs !");

                UtilsTimer timer = new UtilsTimer(5);
                timer.runTaskTimer(plugin, 0, 20);
            }
        }

        return false;
    }
}
