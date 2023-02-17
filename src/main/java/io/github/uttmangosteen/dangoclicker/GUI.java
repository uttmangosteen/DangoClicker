package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GUI {
    public static ItemStack createItem(Material material, int amount, int customModelData, String displayName, List<String> lore){
        ItemStack item;
        item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(customModelData);
        meta.setDisplayName(displayName);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        if(lore != null){
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        return item;
    }

    public static void createInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 54, "§d§lD§f§lan§a§lgo§e§lClicker§f");

        ItemStack spaceItem = GUI.createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, 0, " ", null);

        ItemStack cursor = GUI.createItem(Material.ARROW, 1, 0, "§e§lカーソル", List.of("§a§l" + String.format("%.1f", Global.cursorPrise.get(player)) + "団子", "§f§l" + Global.cursorAmount.get(player) + "§7§lカーソルが毎秒§f§l" + String.format("%.1f", Global.cursorAmount.get(player) * 0.1) + "§7§l団子生産", "§7§o「自動クリック」"));

        ItemStack crickItem = GUI.createItem(Material.matchMaterial(Global.config.getString("clickItem.itemId", "COOKIE")), 1, Global.config.getInt("clickItem.customModelData",0), "§e§lクリックで作る", null);
        ItemStack stock = GUI.createItem(Material.CHEST, 1, 0, "§e§l現在の生産数", List.of("§e§l" + String.format("%.1f", Global.stock.get(player)) + "個"));
        ItemStack save = GUI.createItem(Material.EMERALD_BLOCK, 1, 0, "§e§lSAVE", null);

        for (int i = 0; i <= 53; i++){
            inv.setItem(i, spaceItem);
        }

        inv.setItem(0, cursor);

        inv.setItem(22, stock);
        inv.setItem(40, crickItem);
        inv.setItem(53, save);

        player.openInventory(inv);
    }
}
