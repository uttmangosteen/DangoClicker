package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Events implements Listener {
    public  Events(Plugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || !e.getView().getTitle().equals("§d§lM§f§lan§a§l10§e§lClicker§f")) return;
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();
        switch (clickedItem.getItemMeta().getDisplayName()){
            case "§e§lクリックで作る":
                p.sendMessage("§d§l" + p.getName() + "§a§lがクリックした！");
                Main.Z = Main.Z + 1;
                UI.mainMenu().getItem(22).getItemMeta().setLore(List.of("§e§" + Main.Z + "l個"));
                p.openInventory(UI.mainMenu());
                break;
        }
    }
}
