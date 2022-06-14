package fr.redxil.api.paper;

import fr.redxil.api.common.API;
import fr.redxil.api.common.PluginEnabler;
import fr.xilitra.hiroshisav.enums.ServerType;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

public class PaperAPIStarter {
    private static void startPaperAPI(PluginEnabler pluginEnabler, JavaPlugin javaPlugin){
        if(pluginEnabler.getServerType() == ServerType.VELOCITY)
            return;
        if(API.getInstance() == null)
            return;
        try {
            Class.forName("fr.redxil.core.paper.CorePlugin").getConstructor(PluginEnabler.class, JavaPlugin.class).newInstance(pluginEnabler, javaPlugin);
        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            pluginEnabler.onAPILoadFail();
        }
    }
}
