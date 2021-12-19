package fr.redxil.api.velocity;

import fr.redxil.api.paper.Paper;

public class CoreEnabledEvent {

    Paper paper;

    public CoreEnabledEvent(Paper paper) {
        this.paper = paper;
    }

    public Paper getPaper() {
        return paper;
    }

}
