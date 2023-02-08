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
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        if(lore != null){
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        return item;
    }

    public static Inventory mainMenu(){
        inv = Bukkit.createInventory(null, 54, "§d§lM§f§lan§a§l10§e§lClicker§f");
        ItemStack item_0 = UI.createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, 0, " ", null);

        ItemStack cursor = UI.createItem(Material.ARROW, 1, 0, "§e§lカーソル", null);
        ItemStack grandma = UI.createItem(Material.PLAYER_HEAD, 1, 0, "§e§lグランドマ", null);
        ItemStack factory = UI.createItem(Material.SMOKER, 1, 0, "§e§l工場", null);
        ItemStack main = UI.createItem(Material.NETHERITE_PICKAXE, 1, 0, "§e§l採掘場", null);
        ItemStack shipment = UI.createItem(Material.DRAGON_HEAD, 1, 0, "§e§lドラゴン", null);
        ItemStack alchemy_lab = UI.createItem(Material.BREWING_STAND, 1, 0, "§e§l錬金術ラボ", null);
        ItemStack portal = UI.createItem(Material.END_PORTAL_FRAME, 1, 0, "§e§lポータル", null);
        ItemStack time_machine = UI.createItem(Material.END_CRYSTAL, 1, 0, "§e§lタイムマシン", null);
        ItemStack save = UI.createItem(Material.EMERALD_BLOCK, 1, 0, "§e§lSAVE", null);

        ItemStack item_1 = UI.createItem(Material.CHEST, 1, 0, "§e§l現在の生産数", List.of("§e§l" + Main.Z + "個"));
        ItemStack variableItem_1 = UI.createItem(Material.matchMaterial(config.getString("click_item.itemId", "COOKIE")), 1, config.getInt("click_item.customModelData",0), "§e§lクリックで作る", null);

        for (int i = 0; i <= 53; i++){
            inv.setItem(i, item_0);
        }

        inv.setItem(1, time_machine);
        inv.setItem(2, portal);
        inv.setItem(3, alchemy_lab);
        inv.setItem(4, shipment);
        inv.setItem(5, main);
        inv.setItem(6, factory);
        inv.setItem(7, grandma);
        inv.setItem(8, cursor);
        inv.setItem(53, save);

        inv.setItem(22, item_1);
        inv.setItem(40, variableItem_1);

        return inv;
    }
}
