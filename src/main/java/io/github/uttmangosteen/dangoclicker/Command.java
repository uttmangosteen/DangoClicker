package io.github.uttmangosteen.dangoclicker;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
                Global.saveData.put(uuid, new PlayerData(0, 1, 0, 0, 15, 0, 100, 0, 500, 0, 2000, 0, 7000, 0, 50000, 0, 1000000, 0, 123456789));
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
