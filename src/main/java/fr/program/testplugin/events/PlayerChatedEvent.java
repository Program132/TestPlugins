package fr.program.testplugin.events;

import fr.program.testplugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatedEvent {
    public static void init(AsyncPlayerChatEvent event, TestPlugin plugin) {
        String message = event.getMessage();
        Player plr = event.getPlayer();
        event.setCancelled(true);
        Bukkit.broadcastMessage("[" + plugin.getConfig().getString("players." + plr.getUniqueId() + ".rank") + "]" + "<" + plr.getDisplayName() + "> " + message);
    }
}
