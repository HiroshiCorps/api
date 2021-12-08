package fr.redxil.api.paper;

import fr.redxil.api.common.PluginEnabler;
import fr.redxil.api.paper.holograms.HologramsManager;
import fr.redxil.api.paper.scoreboard.BoardManager;
import fr.redxil.api.paper.tags.TagsManager;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Paper extends JavaPlugin implements PluginEnabler {

    static Paper instance;

    public Paper() {
        instance = this;
    }

    public static Paper getInstance() {
        return instance;
    }

    public abstract TagsManager getTagsManager();

    public abstract BoardManager getBoardManager();

    public abstract HologramsManager getHologramManager();

}
