package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Timer {
    public static void perSecond() {
        Bukkit.getScheduler().runTaskTimer(Main.plugin,()-> Bukkit.getScheduler().runTask(Main.plugin,()->{
            for(Player player : Bukkit.getOnlinePlayers()){
                if(player.getOpenInventory().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")){
                    Global.stock.put(player, Global.stock.get(player) + Global.DPS.get(player));
                    GUI.createInventory(player);
                }
            }
        }),0, 20);
    }
}
