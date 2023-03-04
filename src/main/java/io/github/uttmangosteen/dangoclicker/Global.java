package io.github.uttmangosteen.dangoclicker;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Global {
    public static FileConfiguration config = Main.config.getConfig();
    public static boolean playable;
    public static ConcurrentHashMap<UUID, PlayerData> saveData = new ConcurrentHashMap<>();
}

