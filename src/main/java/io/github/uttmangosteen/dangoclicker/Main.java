package io.github.uttmangosteen.dangoclicker;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static JavaPlugin config;
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        getCommand("dclicker").setExecutor(new Command());

        new Event(this);

        saveDefaultConfig();
        config = this;

        Timer.perSecond();
        plugin = this;
    }
    @Override
    public void onDisable() {
    }
}
