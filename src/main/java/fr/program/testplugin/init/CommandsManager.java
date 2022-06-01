package fr.program.testplugin.init;

import fr.program.testplugin.TestPlugin;
import fr.program.testplugin.commands.*;

public class CommandsManager {

    public static void initiation(TestPlugin plugin) {
        plugin.getCommand("bienvenue").setExecutor(new BienvenueCMD(plugin));
        plugin.getCommand("annonce").setExecutor(new AnnonceCMD());
        plugin.getCommand("kb").setExecutor(new KbCMD());
        plugin.getCommand("spawn").setExecutor(new SpawnCMD());
        plugin.getCommand("pvp").setExecutor(new PvpCMD(plugin));
    }
}