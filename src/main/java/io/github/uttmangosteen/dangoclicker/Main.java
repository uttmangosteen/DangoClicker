package io.github.uttmangosteen.dangoclicker;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static JavaPlugin config;
    public static boolean runnable;

    @Override
    public void onEnable() {
        getCommand("dclicker").setExecutor(new Command());

        new Event(this);

        saveDefaultConfig();
        config = this;

        runnable = true;
        Timer.perSecond();
    }
    @Override
    public void onDisable() {
        runnable = false;
    }
}
