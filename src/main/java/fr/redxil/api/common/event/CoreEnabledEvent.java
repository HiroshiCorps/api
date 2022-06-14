package fr.redxil.api.common.event;

import fr.redxil.api.common.APIEnabler;

public class CoreEnabledEvent {

    APIEnabler enabler;

    public CoreEnabledEvent(APIEnabler enabler) {
        this.enabler = enabler;
    }

    public APIEnabler getAPIEnabler() {
        return enabler;
    }

}
