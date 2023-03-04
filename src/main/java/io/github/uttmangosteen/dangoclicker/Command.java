package io.github.uttmangosteen.dangoclicker;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.UUID;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("プレイヤーでないと実行できません");
            return true;
        }
        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        if (args.length == 0){
            if (!Global.saveData.containsKey(uuid)){
                Global.saveData.put(uuid, new PlayerData(BigInteger.ZERO, BigInteger.ZERO, BigInteger.TEN, new BigInteger[]{BigInteger.valueOf(150), BigInteger.valueOf(1000), BigInteger.valueOf(11000), BigInteger.valueOf(120000), BigInteger.valueOf(1300000), BigInteger.valueOf(14000000), BigInteger.valueOf(200000000), BigInteger.valueOf(3300000000L), BigInteger.valueOf(51000000000L), BigInteger.valueOf(750000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(140000000000000L), BigInteger.valueOf(1700000000000000L), BigInteger.valueOf(21000000000000000L), BigInteger.valueOf(2600000000000000000L), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(31)), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(7100))}, new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
            }
            GUI.createInventory(player);
            return true;
        }

        switch (args[0]) {
            case "help":
                player.sendMessage("/dclicker メインメニューを開く");
                return true;
        }
        return false;
    }
}
