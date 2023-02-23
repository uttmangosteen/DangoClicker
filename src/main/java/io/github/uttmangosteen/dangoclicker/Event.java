package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.math.BigInteger;
import java.util.UUID;

public class Event implements Listener {public Event(Plugin plugin){Bukkit.getPluginManager().registerEvents(this, plugin);}
    @EventHandler
    public void onClick(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || !e.getClick().isLeftClick() || !e.getView().getTitle().contains("§1§a§l")) return;
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        UUID uuid = player.getUniqueId();
        PlayerData playerData = Global.saveData.get(uuid);
        switch (clickedItem.getItemMeta().getDisplayName()){
            case "§e§lクリックで作る":
                playerData.stock = playerData.stock.add(playerData.DPC);
                GUI.createInventory(player);
                break;
            case "§e§lカーソル":
                if(playerData.stock.compareTo(playerData.priseCursor) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseCursor);
                    playerData.DPS = playerData.DPS.add(BigInteger.TWO);
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountCursor = playerData.amountCursor.add(BigInteger.ONE);
                    playerData.priseCursor = playerData.priseCursor.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lスティーブ":
                if(playerData.stock.compareTo(playerData.priseGrandma) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseGrandma);
                    playerData.DPS = playerData.DPS.add(BigInteger.TEN);
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountGrandma = playerData.amountGrandma.add(BigInteger.ONE);
                    playerData.priseGrandma = playerData.priseGrandma.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§l工場":
                if(playerData.stock.compareTo(playerData.priseFactory) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseFactory);
                    playerData.DPS = playerData.DPS.add(BigInteger.valueOf(40));
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountFactory = playerData.amountFactory.add(BigInteger.ONE);
                    playerData.priseFactory = playerData.priseFactory.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§l採掘場":
                if(playerData.stock.compareTo(playerData.priseMine) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseMine);
                    playerData.DPS = playerData.DPS.add(BigInteger.valueOf(100));
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountMine = playerData.amountMine.add(BigInteger.ONE);
                    playerData.priseMine = playerData.priseMine.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lドラゴン":
                if(playerData.stock.compareTo(playerData.priseShipment) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseShipment);
                    playerData.DPS = playerData.DPS.add(BigInteger.valueOf(200));
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountShipment = playerData.amountShipment.add(BigInteger.ONE);
                    playerData.priseShipment = playerData.priseShipment.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§l錬金術ラボ":
                if(playerData.stock.compareTo(playerData.priseAlchemyLab) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseAlchemyLab);
                    playerData.DPS = playerData.DPS.add(BigInteger.valueOf(1000));
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountAlchemyLab = playerData.amountAlchemyLab.add(BigInteger.ONE);
                    playerData.priseAlchemyLab = playerData.priseAlchemyLab.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lポータル":
                if(playerData.stock.compareTo(playerData.prisePortal) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.prisePortal);
                    playerData.DPS = playerData.DPS.add(BigInteger.valueOf(13332));
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountPortal = playerData.amountPortal.add(BigInteger.ONE);
                    playerData.prisePortal = playerData.prisePortal.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lタイムマシン":
                if(playerData.stock.compareTo(playerData.priseTimeMachine) >= 0){
                    playerData.stock = playerData.stock.subtract(playerData.priseTimeMachine);
                    playerData.DPS = playerData.DPS.add(BigInteger.valueOf(246912));
                    playerData.DPC = playerData.DPC.add(BigInteger.ONE);
                    playerData.amountTimeMachine = playerData.amountTimeMachine.add(BigInteger.ONE);
                    playerData.priseTimeMachine = playerData.priseTimeMachine.multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                break;
            case "§e§lLOAD":
                player.sendMessage("§f§l[§d§lD§f§lan§a§lgo§e§lClicker§f§l]§b§lロード");
                break;
            case "§e§lSAVE":
                player.closeInventory();
                player.sendMessage("§f§l[§d§lD§f§lan§a§lgo§e§lClicker§f§l]§a§lセーブ");
                break;
        }
    }
}
