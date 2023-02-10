package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Timer {
    public static void perSecond() {
        Bukkit.getScheduler().runTaskTimer(Main.plugin,()->{
            Bukkit.getScheduler().runTask(Main.plugin,()->{
                for(Player p: Bukkit.getOnlinePlayers()){
                    if(p.getOpenInventory().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")){
                        p.openInventory(UI.mainMenu());
                        TemporaryClass.stock = TemporaryClass.stock + TemporaryClass.DPS;
                    }
                }
            });
        },0, 20);
    }
}
