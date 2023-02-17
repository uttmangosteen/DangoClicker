package io.github.uttmangosteen.dangoclicker;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("プレイヤーでないと実行できません");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0){
            if (Global.stock.isEmpty()){
                Global.stock.put(player, 0.0);
                Global.DPC.put(player, 1.0);
                Global.DPS.put(player, 0.0);
                Global.cursorAmount.put(player, 0);
                Global.cursorPrise.put(player, 15.0);
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
