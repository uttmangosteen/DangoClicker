package io.github.uttmangosteen.dangoclicker;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static JavaPlugin config;

    public static int Z = 0;

    @Override
    public void onEnable() {
        getCommand("dclicker").setExecutor(new Commands());
        new Events(this);
        saveDefaultConfig();
        config = this;
    }
    @Override
    public void onDisable() {
    }
}
