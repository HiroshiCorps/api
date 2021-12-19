package fr.redxil.api.velocity;

public class CoreEnabledEvent {

    Velocity paper;

    public CoreEnabledEvent(Velocity paper) {
        this.paper = paper;
    }

    public Velocity getVelocity() {
        return paper;
    }

}
