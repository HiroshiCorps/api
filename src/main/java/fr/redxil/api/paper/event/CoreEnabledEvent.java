package fr.redxil.api.paper.event;

import fr.redxil.api.paper.Paper;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoreEnabledEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    Paper paper;

    public CoreEnabledEvent(Paper paper) {
        this.paper = paper;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public Paper getPaper() {
        return paper;
    }

}
