package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Timer {
    public static void perSecond() {
        Bukkit.getScheduler().runTaskTimer(Main.plugin,()-> Bukkit.getScheduler().runTask(Main.plugin,()->{
            for(Player player : Bukkit.getOnlinePlayers()){
                UUID uuid = player.getUniqueId();
                PlayerData playerData = Global.saveData.get(uuid);
                if(player.getOpenInventory().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")){
                    playerData.stock = playerData.stock + playerData.DPS;
                    GUI.createInventory(player);
                }
            }
        }),0, 20);
    }
}
