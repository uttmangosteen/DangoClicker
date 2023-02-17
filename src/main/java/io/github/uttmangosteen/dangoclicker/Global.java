package io.github.uttmangosteen.dangoclicker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public class Global{
    public static FileConfiguration config = Main.config.getConfig();
    public static boolean playable;
    public static ConcurrentHashMap<Player, Double> stock = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Player, Double> DPC = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Player, Double> DPS = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Player, Integer> cursorAmount = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Player, Double> cursorPrise = new ConcurrentHashMap<>();
}
