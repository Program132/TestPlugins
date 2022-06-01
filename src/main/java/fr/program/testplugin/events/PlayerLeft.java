package fr.program.testplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeft {
    public static void init(PlayerQuitEvent event) {
        Player plr = event.getPlayer();
        System.out.println("Le joueur " + plr.getDisplayName() + " a quitte le serveur !");
    }
}
