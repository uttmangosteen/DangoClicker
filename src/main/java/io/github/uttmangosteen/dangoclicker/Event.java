package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Event implements Listener {public Event(Plugin plugin){Bukkit.getPluginManager().registerEvents(this, plugin);}
    @EventHandler
    public void onClick(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || !e.getView().getTitle().equals("§d§lD§f§lan§a§lgo§e§lClicker§f")) return;
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        switch (clickedItem.getItemMeta().getDisplayName()){
            case "§e§lクリックで作る":
                Global.stock.put(player, Global.DPC.get(player) + Global.stock.get(player));
                GUI.createInventory(player);
                break;
            case "§e§lカーソル":
                if(Global.stock.get(player) >= Global.cursorPrise.get(player)){
                    Global.stock.put(player, Global.stock.get(player) - Global.cursorPrise.get(player));
                    Global.DPC.put(player, Global.DPC.get(player) + 0.1);
                    Global.DPS.put(player, Global.DPS.get(player) + 0.1);
                    Global.cursorAmount.put(player, Global.cursorAmount.get(player) + 1);
                    Global.cursorPrise.put(player, Global.cursorPrise.get(player) * 1.1);
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
