package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.TimerTask;

public class Timer {
    public static void perSecond() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if(!Main.runnable)timer.cancel();
                for(Player p : Bukkit.getServer().getOnlinePlayers()){
                    if(p.getOpenInventory().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")){
                        p.sendMessage("aaaaa");
                        TemporaryClass.stock = TemporaryClass.stock + TemporaryClass.DPS;
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
