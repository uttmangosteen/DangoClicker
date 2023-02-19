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
                if(playerData.stock >= playerData.cursorPrise){
                    playerData.stock = playerData.stock - playerData.cursorPrise;
                    playerData.DPS = playerData.DPS + 0.2;
                    playerData.cursorAmount++;
                    playerData.cursorPrise = playerData.cursorPrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lスティーブ":
                if(playerData.stock >= playerData.cursorPrise){
                    playerData.stock = playerData.stock - playerData.grandmaPrise;
                    playerData.DPS = playerData.DPS + 1;
                    playerData.grandmaAmount++;
                    playerData.grandmaPrise = playerData.grandmaPrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§l工場":
                if(playerData.stock >= playerData.factoryPrise){
                    playerData.stock = playerData.stock - playerData.factoryPrise;
                    playerData.DPS = playerData.DPS + 4;
                    playerData.factoryAmount++;
                    playerData.factoryPrise = playerData.factoryPrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§l採掘場":
                if(playerData.stock >= playerData.minePrise){
                    playerData.stock = playerData.stock - playerData.minePrise;
                    playerData.DPS = playerData.DPS + 10;
                    playerData.mineAmount++;
                    playerData.minePrise = playerData.minePrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lドラゴン":
                if(playerData.stock >= playerData.shipmentPrise){
                    playerData.stock = playerData.stock - playerData.shipmentPrise;
                    playerData.DPS = playerData.DPS + 20;
                    playerData.shipmentAmount++;
                    playerData.shipmentPrise = playerData.shipmentPrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§l錬金術ラボ":
                if(playerData.stock >= playerData.alchemyLabPrise){
                    playerData.stock = playerData.stock - playerData.alchemyLabPrise;
                    playerData.DPS = playerData.DPS + 100;
                    playerData.alchemyLabAmount++;
                    playerData.alchemyLabPrise = playerData.alchemyLabPrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lポータル":
                if(playerData.stock >= playerData.portalPrise){
                    playerData.stock = playerData.stock - playerData.portalPrise;
                    playerData.DPS = playerData.DPS + 1333.2;
                    playerData.portalAmount++;
                    playerData.portalPrise = playerData.portalPrise * 1.1;
                    GUI.createInventory(player);
                }
                break;
            case "§e§lタイムマシン":
                if(playerData.stock >= playerData.timeMachinePrise){
                    playerData.stock = playerData.stock - playerData.timeMachinePrise;
                    playerData.DPS = playerData.DPS + 24691.2;
                    playerData.timeMachineAmount++;
                    playerData.timeMachinePrise = playerData.timeMachinePrise * 1.1;
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
