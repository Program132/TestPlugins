package fr.program.testplugin.init;

import fr.program.testplugin.TestPlugin;
import fr.program.testplugin.events.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventsManager implements Listener {

    TestPlugin plugin;

    public EventsManager(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoined(PlayerJoinEvent event) {
        PlayerJoin.init(event, plugin);
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event) {
        PlayerLeft.init(event);
    }

    @EventHandler
    public void Interaction(PlayerInteractEvent event) {
        PlayerInteraction.init(event, plugin);
    }

    @EventHandler
    public void BlockPlaced(BlockPlaceEvent event) {
        BlockPlace.init(event, plugin);
    }

    @EventHandler
    public void InventotyClicked(InventoryClickEvent event) {
        InventotyPlayerClick.init(event);
    }

    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) { PlayerChatedEvent.init(event, plugin); }
}
