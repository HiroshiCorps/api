package fr.redxil.api.paper;

import java.io.File;

public abstract class PaperAPI {
    static PaperAPI instance;

    public PaperAPI() {
        PaperAPI.instance = this;
    }

    public static PaperAPI getInstance() {
        return instance;
    }

    abstract public File getCoreFile();
}