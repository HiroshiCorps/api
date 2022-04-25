package fr.redxil.api.common.event;

import fr.redxil.api.common.PluginEnabler;

public class CoreEnabledEvent {

    PluginEnabler enabler;

    public CoreEnabledEvent(PluginEnabler enabler) {
        this.enabler = enabler;
    }

    public PluginEnabler getPluginEnabler() {
        return enabler;
    }

}
