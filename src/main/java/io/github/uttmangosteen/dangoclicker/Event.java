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
                playerData.setStock(playerData.getStock() + playerData.getDPC());
                GUI.createInventory(player);
                break;
            case "§e§lカーソル":
                if(playerData.getStock() >= playerData.getCursorPrise()){
                    playerData.setStock(playerData.getStock() - playerData.getCursorPrise());
                    playerData.setDPS(playerData.getDPS() + 0.2);
                    playerData.setCursorAmount(playerData.getCursorAmount() + 1);
                    playerData.setCursorPrise(playerData.getCursorPrise() * 1.1);
                    GUI.createInventory(player);
                }
            case "§e§lスティーブ":
                if(playerData.getStock() >= playerData.getGrandmaPrise()){
                    playerData.setStock(playerData.getStock() - playerData.getGrandmaPrise());
                    playerData.setDPS(playerData.getDPS() + 1);
                    playerData.setGrandmaAmount(playerData.getGrandmaAmount() + 1);
                    playerData.setGrandmaPrise(playerData.getGrandmaPrise() * 1.1);
                    GUI.createInventory(player);
                }
                break;
            case "§e§l工場":
                if(playerData.getStock() >= playerData.getFactoryPrise()){
                    playerData.setStock(playerData.getStock() - playerData.getFactoryPrise());
                    playerData.setDPS(playerData.getDPS() + 4);
                    playerData.setFactoryAmount(playerData.getFactoryAmount() + 1);
                    playerData.setFactoryPrise(playerData.getFactoryPrise() * 1.1);
                    GUI.createInventory(player);
                }
                break;
            case "§e§l採掘場":
                if(playerData.getStock() >= playerData.getMinePrise()){
                    playerData.setStock(playerData.getStock() - playerData.getMinePrise());
                    playerData.setDPS(playerData.getDPS() + 10);
                    playerData.setMineAmount(playerData.getMineAmount() + 1);
                    playerData.setMinePrise(playerData.getMinePrise() * 1.1);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lドラゴン":
                if(playerData.getStock() >= playerData.getShipmentPrise()){
                    playerData.setStock(playerData.getStock() - playerData.getShipmentPrise());
                    playerData.setDPS(playerData.getDPS() + 20);
                    playerData.setShipmentAmount(playerData.getShipmentAmount() + 1);
                    playerData.setShipmentPrise(playerData.getShipmentPrise() * 1.1);
                    GUI.createInventory(player);
                }
                break;
            case "§e§l錬金術ラボ":
                if(playerData.getStock() >= playerData.getAlchemyLabPrise()){
                    playerData.setStock(playerData.getStock() - playerData.getAlchemyLabPrise());
                    playerData.setDPS(playerData.getDPS() + 100);
                    playerData.setAlchemyLabAmount(playerData.getAlchemyLabAmount() + 1);
                    playerData.setAlchemyLabPrise(playerData.getAlchemyLabPrise() * 1.1);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lポータル":
                if(playerData.getStock() >= playerData.getPortalPrise()){
                    playerData.setStock(playerData.getStock() - playerData.getPortalPrise());
                    playerData.setDPS(playerData.getDPS() + 1333.2);
                    playerData.setPortalAmount(playerData.getPortalAmount() + 1);
                    playerData.setPortalPrise(playerData.getPortalPrise() * 1.1);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lタイムマシン":
                if(playerData.getStock() >= playerData.getTimeMachinePrise()){
                    playerData.setStock(playerData.getStock() - playerData.getTimeMachinePrise());
                    playerData.setDPS(playerData.getDPS() + 24691.2);
                    playerData.setTimeMachineAmount(playerData.getTimeMachineAmount() + 1);
                    playerData.setTimeMachinePrise(playerData.getTimeMachinePrise() * 1.1);
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
