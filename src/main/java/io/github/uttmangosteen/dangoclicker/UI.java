package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class UI {
    public static Inventory inv;
    public static FileConfiguration config = Main.config.getConfig();
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

    public static Inventory mainMenu(){
        inv = Bukkit.createInventory(null, 54, "§d§lD§f§lan§a§lgo§e§lClicker§f");
        ItemStack item_0 = UI.createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, 0, " ", null);

        ItemStack cursor = UI.createItem(Material.ARROW, 1, 0, "§e§lカーソル", List.of("§e§l1カーソルが毎秒0.1個生産", "§6§lコスト:§e§l15団子", "§7§o自動クリック"));

        ItemStack crickItem = UI.createItem(Material.matchMaterial(config.getString("clickItem.itemId", "COOKIE")), 1, config.getInt("clickItem.customModelData",0), "§e§lクリックで作る", null);
        ItemStack stock = UI.createItem(Material.CHEST, 1, 0, "§e§l現在の生産数", List.of("§e§l" + TemporaryClass.stock + "個"));
        ItemStack save = UI.createItem(Material.EMERALD_BLOCK, 1, 0, "§e§lSAVE", null);

        for (int i = 0; i <= 53; i++){
            inv.setItem(i, item_0);
        }

        inv.setItem(0, cursor);

        inv.setItem(22, stock);
        inv.setItem(40, crickItem);
        inv.setItem(53, save);

        return inv;
    }
}
