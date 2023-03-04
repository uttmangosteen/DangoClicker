package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GUI {

    private static final String[] digitName = {"", "万", "億", "兆", "京", "垓", "秭", "穰", "溝", "澗", "正", "載", "極", "恒河沙", "阿僧祇", "那由他", "不可思議", "無量大数"};
    private static String bigIntegerFormat(BigInteger number) {
        StringBuilder viewString = new StringBuilder();
        int digitAmount = String.valueOf(number).length() - 1;
        if (digitAmount == 0) {
            return viewString.append("0.").append(number).toString();
        } else if (digitAmount <= 4) {
            return viewString.append(String.valueOf(number), 0, digitAmount + 1).insert(digitAmount, ".").toString();
        } else if (digitAmount <= 64) {
            viewString.append(String.valueOf(number), 0, (digitAmount - 1) % 4 + 1).append(digitName[(digitAmount - 1) / 4]);
            int small4Digit = Integer.parseInt(String.valueOf(number).substring((digitAmount - 1) % 4 + 1, (digitAmount - 1) % 4 + 5));
            if(!(small4Digit == 0)){
                viewString.append(small4Digit).append(digitName[(digitAmount - 1) / 4 - 1]);
            }
            return viewString.toString();
        } else {
            return viewString.append(String.valueOf(number), 0, 5).insert(1, ".").append("E+").append(digitAmount - 1).toString();
        }
    }

    private static ItemStack createItem(Material material, int customModelData, String displayName, List<String> lore){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(customModelData);
        meta.setDisplayName(displayName);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        if(lore != null){meta.setLore(lore);}
        item.setItemMeta(meta);
        return item;
    }

    private static final ItemStack itemSpace = createItem(Material.GREEN_STAINED_GLASS_PANE, 0, " ", null);
    private static final ItemStack itemSeparate = createItem(Material.LIME_STAINED_GLASS_PANE, 0, " ", null);
    private static final ItemStack itemSave = createItem(Material.WRITABLE_BOOK, 0, "§e§lSAVE", List.of("§f§lクリックでデータ保存"));
    private static final ItemStack itemLoad = createItem(Material.BOOK, 0, "§e§lLOAD", List.of("§f§lクリックでデータ呼び出し"));

    private static final ItemStack[][] itemUpGrade = {{
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l強化人差し指", "§a§l100.0団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l手根管症候群防止クリーム", "§a§l500.0団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l二刀流", "§a§l1万団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l千手観音", "§a§l10万団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l万手観音", "§a§l1000万団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l億手観音", "§a§l1億団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l兆手観音", "§a§l10億団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l京手観音", "§a§l100億団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l垓手観音", "§a§l10兆団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§7§l秭手観音", "§a§l100兆団子", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§lグランマからの返信", "§a§l1000.0団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§l金属製のし棒", "§a§l5000.0団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§lなめらかな総入れ歯", "§a§l5万団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§lプルーンジュース", "§a§l500万団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§l2倍分厚いメガネ", "§a§l5億団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§l老化剤", "§a§l500億団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§lエクストリーム歩行器", "§a§l50兆団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§l制約を越えた者", "§a§l5京団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§l逆認知症", "§a§l5000京団子", "§7§lグランマが§f§l2倍§7§l効率的になる")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§7§l色落ち防止ヘアカラー", "§a§l500垓団子", "§7§lグランマが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l安いクワ", "§a§l1万1000団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l化学肥料", "§a§l5万5000団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l団子の木", "§a§l55万団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l遺伝子組み換え団子", "§a§l5500万団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§lパルススプリンクラー", "§a§l55億団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§lファッジ菌", "§a§l5500億団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l稲トリフィド", "§a§l550兆団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l人道的農薬", "§a§l55京団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§lリントヴルム", "§a§l5垓5000京団子", "§7§l農場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§7§l逆菜食主義", "§a§l5500垓団子", "§7§l農場が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§lメガドリル", "§a§l12万団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§lウルトラドリル", "§a§l60万団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§lアルテマドリル", "§a§l600万団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§l水爆採掘", "§a§l6億団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§l中心炉", "§a§l600億団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§l惑星割り", "§a§l6兆団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§lキャノーラ油井", "§a§l6000兆団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§lモグラ人間", "§a§l600京団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§l坑道のカナリア", "§a§l60垓団子", "§7§l採掘場が§f§l2倍§7§l効率的になる")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§7§l空気採鉱", "§a§l6秭団子", "§7§l採掘場が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§lより丈夫なベルトコンベアー", "§a§l130万団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§l児童労働", "§a§l650万団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§l搾取工場", "§a§l6500万団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§lラジウム反応装置", "§a§l65億団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§l再教育制度", "§a§l6500億団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§l深焼き製法", "§a§l65兆団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§lサイボーグ工員", "§a§l6京5000兆団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§l1日78時間労働", "§a§l6500京団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§l機械学習", "§a§l650垓団子", "§7§l工場が§f§l2倍§7§l効率的になる")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§7§lブラウニーポイント制度", "§a§l65秭団子", "§7§l工場が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§lのっぽの窓口係", "§a§l1400万団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§lハサミで切れないクレジットカード", "§a§l7000万団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§l耐酸性金庫", "§a§l7億団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§l指数関数的利息", "§a§l700億団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§l金融禅", "§a§l7兆団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§lサイフ道", "§a§l700兆団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§lマネーの原理", "§a§l70京団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§l金儲けの秘訣", "§a§l7垓団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§l食用貨幣", "§a§l7000垓団子", "§7§l銀行が§f§l2倍§7§l効率的になる")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§7§lグランド・スーパーサイクル", "§a§l700秭団子", "§7§l銀行が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l黄金の偶像", "§a§l2億団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§lいけにえ", "§a§l10億団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§lおいしい恩恵", "§a§l100億団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l太陽祀り", "§a§l1兆団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l増築された万神殿", "§a§l100兆団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l天にまします大いなる焼き主", "§a§l1京団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l創造神話", "§a§l1000京団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l神権政治", "§a§l100垓団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l見たことねぇラップ祈祷", "§a§l10秭団子", "§7§l神殿が§f§l2倍§7§l効率的になる")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§7§l詩篇の朗読", "§a§l1穰団子", "§7§l神殿が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l三角帽子", "§a§l33億団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§lフサフサのあごひげ", "§a§l165億団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l旧き魔道書", "§a§l1650億団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§lキッチンの呪い", "§a§l16兆5000億団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l魔法学校", "§a§l1650兆団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l暗黒の術式", "§a§l16京5000兆団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§lうさぎのトリック", "§a§l1垓6500京団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l贅沢仕立ての杖", "§a§l1650垓団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l不動如山の呪文詠唱", "§a§l165秭団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§7§l魔術的現実主義", "§a§l16穰5000秭団子", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§lバニラ星雲", "§a§l510億団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§lワームホール", "§a§l2550億団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§l頻回発射", "§a§l2兆5500億団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§lワープ航法", "§a§l255兆団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§l世代宇宙船", "§a§l2京5500兆団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§lダイソン球", "§a§l255京団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§l最後のフロンティア", "§a§l25垓5000京団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§l自動操縦", "§a§l2秭5500垓団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§l宇宙の果てのレストラン", "§a§l2550秭団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる")),
            createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船アップグレード", List.of("§7§l環状体の宇宙", "§a§l255穰団子", "§7§l宇宙船が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§lアンチモン", "§a§l7500億団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l生地のエッセンス", "§a§l3兆7500億団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§lアンブロシア", "§a§l37兆5000億団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l生地の水", "§a§l3750兆団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l根源のるつぼ", "§a§l37京5000兆団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l原子流転説", "§a§l3750京団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§lギンガトビバッタ", "§a§l375垓団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l化学の到来", "§a§l37秭5000垓団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l考え直した結果", "§a§l3穰7500秭団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§7§l市民意識の改善", "§a§l3750穰団子", "§7§l錬金術室が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l魂の契約", "§a§l10兆団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l「健全な」踊り", "§a§l50兆団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§lブレーン移植", "§a§l500兆団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l神サイズのポータル", "§a§l5京団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l終末の日バックアップ計画", "§a§l500京団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l人をキレさせるシュプレヒコール", "§a§l5垓団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l現実世界", "§a§l5000垓団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l異次元ゴミ投棄場", "§a§l500秭団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l埋め込み式極小ポータル", "§a§l50穰団子", "§7§lポータルが§f§l2倍§7§l効率的になる")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§7§l家庭用の裂け目", "§a§l5溝団子", "§7§lポータルが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l次元移転装置", "§a§l140兆団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§lタイムパラドックスリゾルバー", "§a§l700兆団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l量子的難問", "§a§l7000兆団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l因果律強要課程", "§a§l70京団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l昨日と明日の投影機", "§a§l7000京団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l遠未来条例", "§a§l70垓団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§lグレートループ仮説", "§a§l7秭団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§lクッキートピアンの夢想", "§a§l7000秭団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l第二の秒", "§a§l700穰団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§7§l増設用時計の手", "§a§l70溝団子", "§7§lタイムマシンが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§l弦理論", "§a§l1700兆団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§l大型マカロン衝突型加速器", "§a§l8500兆団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§lビッグバンベイク", "§a§l8京5000兆団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§lリバースサイクロトロン", "§a§l850京団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§lナノ宇宙学", "§a§l8垓5000京団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§lパルス", "§a§l850垓団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§l他にも基本的な超微粒子があるだろう、多分", "§a§l85秭団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§l量子櫛", "§a§l8穰5000秭団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§lベーキングノーベル賞", "§a§l8500穰団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§7§l明確な構造の分子", "§a§l850溝団子", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l宝石研磨", "§a§l2京1000兆団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l第９の色", "§a§l10京5000兆団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l団子光", "§a§l105京団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l「グレイン」ボー", "§a§l1垓500京団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l超純粋宇宙光", "§a§l105垓団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l燐光", "§a§l1秭500垓団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l光のサンクトラム", "§a§l1050秭団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l陰影反転", "§a§l105穰団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l水晶の鏡", "§a§l10溝5000穰団子", "§7§lプリズムが§f§l2倍§7§l効率的になる")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§7§l逆光理論", "§a§l1澗500溝団子", "§7§lプリズムが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l「全てが水の泡になる」魔法のコイン", "§a§l260京団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l抽選勝利チケット", "§a§l1300京団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l四葉のクローバー畑", "§a§l1垓3000京団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§lトリックに関する虎の巻", "§a§l130垓団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§lレプラコーンの村", "§a§l1秭3000垓団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l不可能性駆動装置", "§a§l130秭団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l反迷信学", "§a§l13穰団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§lうさぎの足", "§a§l1溝3000穰団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l改定確率論", "§a§l1300溝団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§7§l0面サイコロ", "§a§l130澗団子", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§lメタなベーカリー", "§a§l3100京団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§l自己相似事実", "§a§l1垓5500京団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§l入れ子型の宇宙説", "§a§l15垓5000京団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§lメンガーのスポンジケーキ", "§a§l1550垓団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§lとある一際陽気な雌牛", "§a§l15秭5000垓団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§lネステッド", "§a§l1550秭団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§l空間充填繊維", "§a§l155穰団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§l巡り続ける読本", "§a§l15溝5000穰団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§l全ての集合の集合", "§a§l1澗5500溝団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§7§l函", "§a§l1550澗団子", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる"))
    }, {
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§l猿でも分かるJavaコンソール", "§a§l71垓団l子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§l64ビット配列", "§a§l355垓団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§lスタック・オーバーフロー", "§a§l3550垓団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§l企業向けコンパイラ", "§a§l35秭5000垓団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§l一杯のおいしいコーヒー", "§a§l3550秭団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§lその場でベーキング", "§a§l35穰5000秭団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§ldango++;", "§a§l3溝5500穰団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§lソフトウェア更新;", "§a§l3550溝団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§lあなたの一番のファン", "§a§l355澗団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§7§lハッカーの陰", "§a§l35正5000澗団子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる"))
    }};

    private static final int[] amountUnLockUpGrade = {1, 5, 25, 50, 100, 150, 200, 250, 300, 350};
    private static final int[] amountUnLockUpGradeCursor = {1, 1, 10, 25, 50, 100, 150, 200, 250, 300};

    public static void createInventory(Player player) {
        UUID uuid = player.getUniqueId();
        PlayerData playerData = Global.saveData.get(uuid);
        Inventory inv = Bukkit.createInventory(null, 54, "§1§a§l現在の在庫 §2§l" + bigIntegerFormat(playerData.stock) + "団子");

        ArrayList<ItemStack> upGrade = new ArrayList<>();
        if(playerData.amountBuilding[0] >= amountUnLockUpGradeCursor[playerData.powerBuilding[0]]){
            upGrade.add(itemUpGrade[0][playerData.powerBuilding[0]]);
        }
        for(int i = 1; i <= 16; i++){
            if(playerData.amountBuilding[i] >= amountUnLockUpGrade[playerData.powerBuilding[i]]){
                upGrade.add(itemUpGrade[i][playerData.powerBuilding[i]]);
            }
        }

        ItemStack[] containUpGrade = new ItemStack[9];

        inv.setContents(new ItemStack[] {
            createItem(Material.ARROW, 0, "§e§lカーソル", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[0]) + "団子", "§f§l" + playerData.amountBuilding[0] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[0]) + "§7§l団子生産", "§7§o「10秒毎に自動クリック」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマ", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[1]) + "団子", "§f§l" + playerData.amountBuilding[1] + "§7§lグランマが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[1]) + "§7§l団子生産", "§7§o「団子を作ってくれる素敵なおばあちゃん」")),
            playerData.amountBuilding[1] == 0 ? itemSpace : createItem(Material.WOODEN_HOE, 0, "§e§l農場", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[2]) + "団子", "§f§l" + playerData.amountBuilding[2] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[2]) + "§7§l団子生産", "§7§o「団子の種から団子を育てます」")),
            playerData.amountBuilding[2] == 0 ? itemSpace : createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[3]) + "団子", "§f§l" + playerData.amountBuilding[3] + "§7§l採掘場が毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[3]) + "§7§l団子生産", "§7§o「団子の生地と串を掘り出します」")),
            playerData.amountBuilding[3] == 0 ? itemSpace : createItem(Material.STONECUTTER, 0, "§e§l工場", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[4]) + "団子", "§f§l" + playerData.amountBuilding[4] + "§7§l工場が毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[4]) + "§7§l団子生産", "§7§o「大量の団子を生産します」")),
            playerData.amountBuilding[4] == 0 ? itemSpace : createItem(Material.LECTERN, 0, "§e§l銀行", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[5]) + "団子", "§f§l" + playerData.amountBuilding[5] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[5]) + "§7§l団子生産", "§7§o「利子から団子を生み出します」")),
            playerData.amountBuilding[5] == 0 ? itemSpace : createItem(Material.CANDLE, 0, "§e§l神殿", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[6]) + "団子", "§f§l" + playerData.amountBuilding[6] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[6]) + "§7§l団子生産", "§7§o「貴重な古代団子の宝庫」")),
            playerData.amountBuilding[6] == 0 ? itemSpace : createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[7]) + "団子", "§f§l" + playerData.amountBuilding[7] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[7]) + "§7§l団子生産", "§7§o「魔法の呪文で団子を召喚します」")),
            playerData.amountBuilding[7] == 0 ? itemSpace : createItem(Material.DRAGON_HEAD, 0, "§e§l宇宙船", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[8]) + "団子", "§f§l" + playerData.amountBuilding[8] + "§7§l宇宙船が毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[8]) + "§7§l団子生産", "§7§o「異世界から新鮮な団子を輸送します」")),
            playerData.amountBuilding[8] == 0 ? itemSpace : createItem(Material.BREWING_STAND, 0, "§e§l錬金術室", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[9]) + "団子", "§f§l" + playerData.amountBuilding[9] + "§7§l錬金術ラボが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[9]) + "§7§l団子生産", "§7§o「金を団子に変化させます」")),
            playerData.amountBuilding[9] == 0 ? itemSpace : createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータル", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[10]) + "団子", "§f§l" + playerData.amountBuilding[10] + "§7§lポータルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[10]) + "§7§l団子生産", "§7§o「団子界に繋がる扉を開きます」")),
            playerData.amountBuilding[10] == 0 ? itemSpace : createItem(Material.CLOCK, 0, "§e§lタイムマシン", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[11]) + "団子", "§f§l" + playerData.amountBuilding[11] + "§7§lタイムマシンが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[11]) + "§7§l団子生産", "§7§o「食べられる前の団子を過去から取り寄せます」")),
            playerData.amountBuilding[11] == 0 ? itemSpace : createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[12]) + "団子", "§f§l" + playerData.amountBuilding[12] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[12]) + "§7§l団子生産", "§7§o「宇宙の反物質を圧縮し団子に変換します」")),
            playerData.amountBuilding[12] == 0 ? itemSpace : createItem(Material.BEACON, 0, "§e§lプリズム", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[13]) + "団子", "§f§l" + playerData.amountBuilding[13] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[13]) + "§7§l団子生産", "§7§o「光を団子に変換します」")),
            playerData.amountBuilding[13] == 0 ? itemSpace : createItem(Material.BELL, 0, "§e§lチャンスメーカー", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[14]) + "団子", "§f§l" + playerData.amountBuilding[14] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[14]) + "§7§l団子生産", "§7§o「無から団子が生まれる可能性を作ります」")),
            playerData.amountBuilding[14] == 0 ? itemSpace : createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジン", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[15]) + "団子", "§f§l" + playerData.amountBuilding[15] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[15]) + "§7§l団子生産", "§7§o「団子からさらに多くの団子を生成します」")),
            playerData.amountBuilding[15] == 0 ? itemSpace : createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソール", List.of("§a§l" + bigIntegerFormat(playerData.priceBuilding[16]) + "団子", "§f§l" + playerData.amountBuilding[16] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playerData.dPSBuilding[16]) + "§7§l団子生産", "§7§o「このゲームを記述していることに他ならない" , "§7§oコードから団子を生み出します」")),
            createItem(Material.CHEST, 0, "§e§l現在の生産数", List.of("§f§l" + bigIntegerFormat(playerData.dPS) + "§7§l団子／秒")),
            itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSpace, itemLoad, itemSpace, itemSeparate,
            createItem(Material.matchMaterial(Global.config.getString("clickItem.itemId", "COOKIE")), Global.config.getInt("clickItem.customModelData", 0), "§e§lクリックで作る", List.of("§f§l" + bigIntegerFormat(playerData.dPC) + "§7§l団子／クリック")),
            itemSeparate, itemSpace, itemSave, itemSpace, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate,
            itemSpace,
                itemSpace,
                itemSpace,
                itemSpace,
                itemSpace,
                itemSpace,
                itemSpace,
                itemSpace,
                itemSpace
        });
        player.openInventory(inv);
    }
}
