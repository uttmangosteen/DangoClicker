package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.math.BigInteger;
import java.util.Arrays;

public class Event implements Listener {public Event(Plugin plugin){Bukkit.getPluginManager().registerEvents(this, plugin);}
    private static final BigInteger[] buildingStandardDPS = {BigInteger.valueOf(1), BigInteger.valueOf(10), BigInteger.valueOf(80), BigInteger.valueOf(470), BigInteger.valueOf(2600), BigInteger.valueOf(14000), BigInteger.valueOf(78000), BigInteger.valueOf(440000), BigInteger.valueOf(2600000), BigInteger.valueOf(16000000), BigInteger.valueOf(100000000), BigInteger.valueOf(650000000), BigInteger.valueOf(4300000000L), BigInteger.valueOf(29000000000L), BigInteger.valueOf(21000000000000L), BigInteger.valueOf(150000000000000L), BigInteger.valueOf(1100000000000000000L)};
    private static final BigInteger[] upGradeStandardPrice = {BigInteger.TEN, BigInteger.valueOf(50), BigInteger.valueOf(500), BigInteger.valueOf(50000), BigInteger.valueOf(5000000), BigInteger.valueOf(500000000), BigInteger.valueOf(500000000000L), BigInteger.valueOf(500000000000000L), BigInteger.valueOf(500000000000000000L), BigInteger.valueOf(5000000000000000000L).multiply(BigInteger.valueOf(100))};
    private static final BigInteger[] upGradeCursorPrice = {BigInteger.valueOf(1000), BigInteger.valueOf(5000), BigInteger.valueOf(100000), BigInteger.valueOf(1000000), BigInteger.valueOf(100000000), BigInteger.valueOf(1000000000), BigInteger.valueOf(10000000000L), BigInteger.valueOf(100000000000L), BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L)};
    private static final BigInteger[] buildingStandardPrice = {BigInteger.valueOf(150), BigInteger.valueOf(1000), BigInteger.valueOf(11000), BigInteger.valueOf(120000), BigInteger.valueOf(1300000), BigInteger.valueOf(14000000), BigInteger.valueOf(200000000), BigInteger.valueOf(3300000000L), BigInteger.valueOf(51000000000L), BigInteger.valueOf(750000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(140000000000000L), BigInteger.valueOf(1700000000000000L), BigInteger.valueOf(21000000000000000L), BigInteger.valueOf(2600000000000000000L), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(31)), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(7100))};
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || !e.getView().getTitle().contains("§1§a§l")) return;
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        PlayerData playerData = Global.saveData.get(player.getUniqueId());
        int originalItemID;
        switch (clickedItem.getItemMeta().getDisplayName()) {
            case "§e§lLOAD":
                player.closeInventory();
                player.sendMessage("§f§l[§d§lD§f§lan§a§lgo§e§lClicker§f§l]§b§lロード");
                GUI.createInventory(player);
                return;
            case "§e§lSAVE":
                player.closeInventory();
                player.sendMessage("§f§l[§d§lD§f§lan§a§lgo§e§lClicker§f§l]§a§lセーブ");
                return;

            case "§e§lクリックで作る":
                playerData.stock = playerData.stock.add(playerData.dPC);
                GUI.createInventory(player);
                return;
            case "§e§lカーソルアップグレード":
                if (playerData.stock.compareTo(upGradeCursorPrice[playerData.powerBuilding[0]]) >= 0) {
                    playerData.stock = playerData.stock.subtract(upGradeCursorPrice[playerData.powerBuilding[0]]);
                    playerData.powerBuilding[0]++;
                    playerData.dPSBuilding[0] = playerData.dPSBuilding[0].multiply(BigInteger.TWO);
                    playerData.dPS = Arrays.stream(playerData.dPSBuilding).reduce(BigInteger.ZERO, BigInteger::add);
                    playerData.dPC = playerData.dPSBuilding[0].divide(BigInteger.valueOf(playerData.amountBuilding[0])).multiply(BigInteger.TEN);
                    GUI.createInventory(player);
                }
                return;

            case "§e§lカーソル": originalItemID = 0; break;
            case "§e§lグランマ": originalItemID = 1; break;
            case "§e§l農場": originalItemID = 2; break;
            case "§e§l採掘場": originalItemID = 3; break;
            case "§e§l工場": originalItemID = 4; break;
            case "§e§l銀行": originalItemID = 5; break;
            case "§e§l神殿": originalItemID = 6; break;
            case "§e§l魔法使いの塔": originalItemID = 7; break;
            case "§e§l宇宙船": originalItemID = 8; break;
            case "§e§l錬金術室": originalItemID = 9; break;
            case "§e§lポータル": originalItemID = 10; break;
            case "§e§lタイムマシン": originalItemID = 11; break;
            case "§e§l反物質凝縮器": originalItemID = 12; break;
            case "§e§lプリズム": originalItemID = 13; break;
            case "§e§lチャンスメーカー": originalItemID = 14; break;
            case "§e§l自己無限生成エンジン": originalItemID = 15; break;
            case "§e§lJavaコンソール": originalItemID = 16; break;

            case "§e§lグランマアップグレード": originalItemID = 101; break;
            case "§e§l農場アップグレード": originalItemID = 102; break;
            case "§e§l採掘場アップグレード": originalItemID = 103; break;
            case "§e§l工場アップグレード": originalItemID = 104; break;
            case "§e§ll銀行アップグレード": originalItemID = 105; break;
            case "§e§l神殿アップグレード": originalItemID = 106; break;
            case "§e§l魔法使いの塔アップグレード": originalItemID = 107; break;
            case "§e§l宇宙船アップグレード": originalItemID = 108; break;
            case "§e§l錬金術室アップグレード": originalItemID = 109; break;
            case "§e§lポータルアップグレード": originalItemID = 110; break;
            case "§e§lタイムマシンアップグレード": originalItemID = 111; break;
            case "§e§l反物質凝縮器アップグレード": originalItemID = 112; break;
            case "§e§lプリズムアップグレード": originalItemID = 113; break;
            case "§e§lチャンスメーカーアップグレード": originalItemID = 114; break;
            case "§e§l自己無限生成エンジンアップグレード": originalItemID = 115; break;
            case "§e§lJavaコンソールアップグレード": originalItemID = 116; break;

            default: return;
        }
        if (originalItemID <= 16) {
            if (playerData.stock.compareTo(playerData.priceBuilding[originalItemID]) >= 0) {
                playerData.stock = playerData.stock.subtract(playerData.priceBuilding[originalItemID]);
                playerData.amountBuilding[originalItemID]++;
                playerData.dPSBuilding[originalItemID] = buildingStandardDPS[originalItemID].multiply(BigInteger.valueOf(playerData.amountBuilding[originalItemID])).multiply(BigInteger.TWO.pow(playerData.powerBuilding[originalItemID]));
                playerData.priceBuilding[originalItemID] = playerData.priceBuilding[originalItemID].multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                playerData.dPS = Arrays.stream(playerData.dPSBuilding).reduce(BigInteger.ZERO, BigInteger::add);
                GUI.createInventory(player);
            }
        } else {
            originalItemID = originalItemID - 100;
            if (playerData.stock.compareTo(buildingStandardPrice[originalItemID].multiply(upGradeStandardPrice[playerData.powerBuilding[originalItemID]])) >= 0) {
                playerData.stock = playerData.stock.subtract(buildingStandardPrice[originalItemID].multiply(upGradeStandardPrice[playerData.powerBuilding[originalItemID]]));
                playerData.powerBuilding[originalItemID]++;
                playerData.dPSBuilding[originalItemID] = playerData.dPSBuilding[originalItemID].multiply(BigInteger.TWO);
                playerData.dPS = Arrays.stream(playerData.dPSBuilding).reduce(BigInteger.ZERO, BigInteger::add);
                GUI.createInventory(player);
            }
        }
    }
}
