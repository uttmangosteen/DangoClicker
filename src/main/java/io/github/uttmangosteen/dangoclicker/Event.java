package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class Event implements Listener {public Event(Plugin plugin){Bukkit.getPluginManager().registerEvents(this, plugin);}
    @EventHandler
    public void onClick(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || !e.getView().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")) return;
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        UUID uuid = player.getUniqueId();
        PlayerData playerData = Global.saveData.get(uuid);
        switch (clickedItem.getItemMeta().getDisplayName()){
            case "§e§lクリックで作る":
                playerData.stock = playerData.stock + playerData.DPC;
                GUI.createInventory(player);
                break;
            case "§e§lカーソル":
                if(playerData.stock >= playerData.priseCursor){
                    playerData.stock = playerData.stock - playerData.priseCursor;
                    playerData.DPS = playerData.DPS + 0.2;
                    playerData.amountCursor++;
                    playerData.priseCursor = playerData.priseCursor * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lスティーブ":
                if(playerData.stock >= playerData.priseCursor){
                    playerData.stock = playerData.stock - playerData.priseGrandma;
                    playerData.DPS = playerData.DPS + 1;
                    playerData.amountGrandma++;
                    playerData.priseGrandma = playerData.priseGrandma * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§l工場":
                if(playerData.stock >= playerData.priseFactory){
                    playerData.stock = playerData.stock - playerData.priseFactory;
                    playerData.DPS = playerData.DPS + 4;
                    playerData.amountFactory++;
                    playerData.priseFactory = playerData.priseFactory * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§l採掘場":
                if(playerData.stock >= playerData.priseMine){
                    playerData.stock = playerData.stock - playerData.priseMine;
                    playerData.DPS = playerData.DPS + 10;
                    playerData.amountMine++;
                    playerData.priseMine = playerData.priseMine * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lドラゴン":
                if(playerData.stock >= playerData.priseShipment){
                    playerData.stock = playerData.stock - playerData.priseShipment;
                    playerData.DPS = playerData.DPS + 20;
                    playerData.amountShipment++;
                    playerData.priseShipment = playerData.priseShipment * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§l錬金術ラボ":
                if(playerData.stock >= playerData.priseAlchemyLab){
                    playerData.stock = playerData.stock - playerData.priseAlchemyLab;
                    playerData.DPS = playerData.DPS + 100;
                    playerData.amountAlchemyLab++;
                    playerData.priseAlchemyLab = playerData.priseAlchemyLab * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lポータル":
                if(playerData.stock >= playerData.prisePortal){
                    playerData.stock = playerData.stock - playerData.prisePortal;
                    playerData.DPS = playerData.DPS + 1333.2;
                    playerData.amountPortal++;
                    playerData.prisePortal = playerData.prisePortal * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lタイムマシン":
                if(playerData.stock >= playerData.priseTimeMachine){
                    playerData.stock = playerData.stock - playerData.priseTimeMachine;
                    playerData.DPS = playerData.DPS + 24691.2;
                    playerData.amountTimeMachine++;
                    playerData.priseTimeMachine = playerData.priseTimeMachine * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lSAVE":
                player.closeInventory();
                player.sendMessage("§f§l[§d§lD§f§lan§a§lgo§e§lClicker§f§l]§a§lセーブ");
                break;
        }
    }
}
