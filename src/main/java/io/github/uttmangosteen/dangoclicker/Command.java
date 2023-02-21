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
                Global.saveData.put(uuid, new PlayerData(BigInteger.ZERO, BigInteger.TEN, BigInteger.ZERO, BigInteger.ZERO, BigInteger.valueOf(150), BigInteger.ZERO, BigInteger.valueOf(1000), BigInteger.ZERO, BigInteger.valueOf(5000), BigInteger.ZERO, BigInteger.valueOf(20000), BigInteger.ZERO, BigInteger.valueOf(70000), BigInteger.ZERO, BigInteger.valueOf(500000), BigInteger.ZERO, BigInteger.valueOf(10000000), BigInteger.ZERO, BigInteger.valueOf(1234567890)));
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
