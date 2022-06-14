package fr.redxil.api.common;

import java.lang.reflect.InvocationTargetException;

public class APIStarter {

    public static void startAPI(PluginEnabler pluginEnabler){
        try {
            Class.forName("fr.redxil.core.common.CoreAPI").getConstructor(PluginEnabler.class).newInstance(pluginEnabler);
        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            pluginEnabler.onAPILoadFail();
        }
    }

}
