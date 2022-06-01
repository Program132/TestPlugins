package fr.program.testplugin;

import fr.program.testplugin.init.CommandsManager;
import fr.program.testplugin.init.EventsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println("Le plugin se lance !");
    }

    @Override
    public void onEnable() {
        System.out.println("Le plugin est pret !");

        saveDefaultConfig();

        CommandsManager.initiation(this);
        getServer().getPluginManager().registerEvents(new EventsManager(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin s'eteint !");
    }
}