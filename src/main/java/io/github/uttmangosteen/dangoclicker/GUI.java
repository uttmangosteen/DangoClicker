package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

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
        UUID uuid = player.getUniqueId();
        PlayerData playerData = Global.saveData.get(uuid);

        Inventory inv = Bukkit.createInventory(null, 54, "§d§lD§f§lan§a§lgo§e§lClicker§f");

        ItemStack spaceItem = GUI.createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, 0, " ", null);

        ItemStack cursor = GUI.createItem(Material.ARROW, 1, 0, "§e§lカーソル", List.of("§a§l" + playerData.getCursorPrise() + "団子", "§f§l" + playerData.getCursorAmount() + "§7§lカーソルが毎秒§f§l" + playerData.getCursorAmount() * 0.2 + "§7§l団子生産", "§7§o「10秒毎に自動クリック」"));
        ItemStack grandma = GUI.createItem(Material.PLAYER_HEAD, 1, 0, "§e§lスティーブ", List.of("§a§l" + playerData.getGrandmaPrise() + "団子", "§f§l" + playerData.getGrandmaAmount() + "§7§lスティーブが毎秒§f§l" + playerData.getGrandmaAmount() + "§7§l団子生産", "§7§o「団子を作ってくれる素敵なスティーブ」"));
        ItemStack factory = GUI.createItem(Material.SMOKER, 1, 0, "§e§l工場", List.of("§a§l" + playerData.getFactoryPrise() + "団子", "§f§l" + playerData.getFactoryAmount() + "§7§l工場が毎秒§f§l" + playerData.getFactoryAmount() * 4 + "§7§l団子生産", "§7§o「大量の団子を生産します」"));
        ItemStack mine = GUI.createItem(Material.NETHERITE_PICKAXE, 1, 0, "§e§l採掘場", List.of("§a§l" + playerData.getMinePrise() + "団子", "§f§l" + playerData.getMineAmount() + "§7§l採掘場が毎秒§f§l" + playerData.getMineAmount() * 10 + "§7§l団子生産", "§7§o「団子の生地と串を掘り出します」"));
        ItemStack shipment = GUI.createItem(Material.DRAGON_HEAD, 1, 0, "§e§lドラゴン", List.of("§a§l" + playerData.getShipmentPrise() + "団子", "§f§l" + playerData.getShipmentAmount() + "§7§lドラゴンが毎秒§f§l" + playerData.getShipmentAmount() * 20 + "§7§l団子生産", "§7§o「異世界から新鮮な団子を輸送します」"));
        ItemStack alchemyLab = GUI.createItem(Material.BREWING_STAND, 1, 0, "§e§l錬金術ラボ", List.of("§a§l" + playerData.getAlchemyLabPrise() + "団子", "§f§l" + playerData.getAlchemyLabAmount() + "§7§l錬金術ラボが毎秒§f§l" + playerData.getAlchemyLabAmount() * 100 + "§7§l団子生産", "§7§o「金を団子に変化させます」"));
        ItemStack portal = GUI.createItem(Material.END_PORTAL_FRAME, 1, 0, "§e§lポータル", List.of("§a§l" + playerData.getPortalPrise() + "団子", "§f§l" + playerData.getPortalAmount() + "§7§lポータルが毎秒§f§l" + playerData.getPortalAmount() * 1333.2 + "§7§l団子生産", "§7§o「団子界に繋がる扉を開きます」"));
        ItemStack timeMachine = GUI.createItem(Material.CLOCK, 1, 0, "§e§lタイムマシン", List.of("§a§l" + playerData.getTimeMachinePrise() + "団子", "§f§l" + playerData.getTimeMachineAmount() + "§7§lタイムマシンが毎秒§f§l" + playerData.getTimeMachineAmount() * 24691.2 + "§7§l団子生産", "§7§o「食べられる前の団子を過去から取り寄せます」"));

        ItemStack crickItem = GUI.createItem(Material.matchMaterial(Global.config.getString("clickItem.itemId", "COOKIE")), 1, Global.config.getInt("clickItem.customModelData",0), "§e§lクリックで作る", null);
        ItemStack stock = GUI.createItem(Material.CHEST, 1, 0, "§e§l現在の生産数", List.of("§e§l" + playerData.getStock() + "個"));
        ItemStack save = GUI.createItem(Material.EMERALD_BLOCK, 1, 0, "§e§lSAVE", null);

        for (int i = 0; i <= 53; i++){inv.setItem(i, spaceItem);}

        inv.setItem(0, cursor);
        inv.setItem(1, grandma);
        inv.setItem(2, factory);
        inv.setItem(3, mine);
        inv.setItem(4, shipment);
        inv.setItem(5, alchemyLab);
        inv.setItem(6, portal);
        inv.setItem(7, timeMachine);

        inv.setItem(22, stock);
        inv.setItem(40, crickItem);
        inv.setItem(53, save);

        player.openInventory(inv);
    }
}
