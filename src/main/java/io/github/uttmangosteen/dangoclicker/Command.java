package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;
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
        Player p = (Player) sender;
        if (args.length == 0){
            p.openInventory(UI.mainMenu());
            return true;
        }
        switch (args[0]) {
            case "help":
                p.sendMessage("/dclicker メインメニューを開く");
                return true;
        }
        return false;
    }
}
