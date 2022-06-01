package fr.program.testplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class UtilsTimer extends BukkitRunnable {
    private int timer;

    public UtilsTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        Bukkit.broadcastMessage("Le jeu va commencer dans " + timer + "s !");

        if (timer == 0)
        {
            Bukkit.broadcastMessage("Le jeu commence !");
            cancel();
        }

        this.timer--;
    }
}
