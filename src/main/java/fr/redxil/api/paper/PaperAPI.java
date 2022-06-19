package fr.redxil.api.paper;

public abstract class PaperAPI {
    static PaperAPI instance;

    public PaperAPI() {
        PaperAPI.instance = this;
    }

    public static PaperAPI getInstance() {
        return instance;
    }
}