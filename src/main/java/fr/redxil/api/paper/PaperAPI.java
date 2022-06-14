package fr.redxil.api.paper;

import fr.redxil.api.common.APIEnabler;

public abstract class PaperAPI {
    static PaperAPI instance;

    public static PaperAPI getInstance() {
        return instance;
    }

    public PaperAPI(){
        PaperAPI.instance = this;
    }

    public abstract void startAPI(APIEnabler APIEnabler);
}