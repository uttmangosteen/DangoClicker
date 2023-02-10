package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Event implements Listener {public Event(Plugin plugin){Bukkit.getPluginManager().registerEvents(this, plugin);}
    @EventHandler
    public void onClick(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || !e.getView().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")) return;
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();
        switch (clickedItem.getItemMeta().getDisplayName()){
            case "§e§lクリックで作る":
                TemporaryClass.stock = TemporaryClass.stock + TemporaryClass.DPC;
                UI.mainMenu().getItem(22).getItemMeta().setLore(List.of("§e§" + TemporaryClass.stock + "l個"));
                p.openInventory(UI.mainMenu());
                break;
            case "§e§lカーソル":
                if(TemporaryClass.stock >= TemporaryClass.cursorPrise){
                    TemporaryClass.stock = TemporaryClass.stock - TemporaryClass.cursorPrise;
                    TemporaryClass.DPC = TemporaryClass.DPC + 0.1;
                    TemporaryClass.DPS = TemporaryClass.DPS + 0.1;
                    TemporaryClass.cursorAmount++;
                    TemporaryClass.cursorPrise = TemporaryClass.cursorPrise * 1.1;
                    p.openInventory(UI.mainMenu());
                }
                break;
            case "§e§lSAVE":
                p.sendMessage("§f§l[§d§lD§f§lan§a§lgo§e§lClicker§f§l]§a§lセーブ");
                break;
        }
    }
}
