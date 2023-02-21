package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public class GUI {
     private static ItemStack createItem(Material material, int customModelData, String displayName, List<String> lore){
        ItemStack item;
        item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(customModelData);
        meta.setDisplayName(displayName);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        if(lore != null){meta.setLore(lore);}
        item.setItemMeta(meta);
        return item;
    }

    public static void createInventory(Player player) {
        UUID uuid = player.getUniqueId();
        PlayerData playerData = Global.saveData.get(uuid);

        Inventory inv = Bukkit.createInventory(null, 54, "§d§lD§f§lan§a§lgo§e§lClicker§f");


        ItemStack spaceItem = GUI.createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 0, " ", null);

        ItemStack cursor = GUI.createItem(Material.ARROW, 0, "§e§lカーソル", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseCursor) + "団子", "§f§l" + playerData.amountCursor + "§7§lカーソルが毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountCursor.multiply(BigInteger.TWO)) + "§7§l団子生産", "§7§o「10秒毎に自動クリック」"));
        ItemStack grandma = GUI.createItem(Material.PLAYER_HEAD, 0, "§e§lスティーブ", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseGrandma) + "団子", "§f§l" + playerData.amountGrandma + "§7§lスティーブが毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountGrandma.multiply(BigInteger.TEN)) + "§7§l団子生産", "§7§o「団子を作ってくれる素敵なスティーブ」"));
        ItemStack factory = GUI.createItem(Material.SMOKER, 0, "§e§l工場", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseFactory) + "団子", "§f§l" + playerData.amountFactory + "§7§l工場が毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountFactory.multiply(BigInteger.valueOf(40))) + "§7§l団子生産", "§7§o「大量の団子を生産します」"));
        ItemStack mine = GUI.createItem(Material.NETHERITE_PICKAXE, 0, "§e§l採掘場", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseMine) + "団子", "§f§l" + playerData.amountMine + "§7§l採掘場が毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountMine.multiply(BigInteger.valueOf(100))) + "§7§l団子生産", "§7§o「団子の生地と串を掘り出します」"));
        ItemStack shipment = GUI.createItem(Material.DRAGON_HEAD, 0, "§e§lドラゴン", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseShipment) + "団子", "§f§l" + playerData.amountShipment + "§7§lドラゴンが毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountShipment.multiply(BigInteger.valueOf(200))) + "§7§l団子生産", "§7§o「異世界から新鮮な団子を輸送します」"));
        ItemStack alchemyLab = GUI.createItem(Material.BREWING_STAND, 0, "§e§l錬金術ラボ", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseAlchemyLab) + "団子", "§f§l" + playerData.amountAlchemyLab + "§7§l錬金術ラボが毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountAlchemyLab.multiply(BigInteger.valueOf(1000))) + "§7§l団子生産", "§7§o「金を団子に変化させます」"));
        ItemStack portal = GUI.createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータル", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.prisePortal) + "団子", "§f§l" + playerData.amountPortal + "§7§lポータルが毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountPortal.multiply(BigInteger.valueOf(13332))) + "§7§l団子生産", "§7§o「団子界に繋がる扉を開きます」"));
        ItemStack timeMachine = GUI.createItem(Material.CLOCK, 0, "§e§lタイムマシン", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.priseTimeMachine) + "団子", "§f§l" + playerData.amountTimeMachine + "§7§lタイムマシンが毎秒§f§l" + ViewFormat.bigIntegerFormat(playerData.amountTimeMachine.multiply(BigInteger.valueOf(246912))) + "§7§l団子生産", "§7§o「食べられる前の団子を過去から取り寄せます」"));

        ItemStack crickItem = GUI.createItem(Material.matchMaterial(Global.config.getString("clickItem.itemId", "COOKIE")), Global.config.getInt("clickItem.customModelData", 0), "§e§lクリックで作る", List.of("§f§l" + ViewFormat.bigIntegerFormat(playerData.DPC) + "§7§l団子／クリック"));
        ItemStack stock = GUI.createItem(Material.CHEST, 0, "§e§l現在の生産数", List.of("§a§l" + ViewFormat.bigIntegerFormat(playerData.stock) + "団子", "§f§l" + ViewFormat.bigIntegerFormat(playerData.DPS) + "§7§l団子／秒"));
        ItemStack save = GUI.createItem(Material.EMERALD_BLOCK, 0, "§e§lSAVE", null);

        for (int i = 0; i <= 53; i++) {inv.setItem(i, spaceItem);}

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
