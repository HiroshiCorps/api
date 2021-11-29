package fr.redxil.api.paper;

import fr.redxil.api.common.PluginEnabler;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Paper extends JavaPlugin implements PluginEnabler {

    static Paper instance;

    public Paper() {
        instance = this;
    }

    public static Paper getInstance() {
        return instance;
    }

}
