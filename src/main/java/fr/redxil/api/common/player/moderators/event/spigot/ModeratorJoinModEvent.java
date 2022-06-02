/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.moderators.event.spigot;

import fr.redxil.api.common.player.moderators.APIPlayerModerator;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ModeratorJoinModEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final APIPlayerModerator moderator;
    private boolean cancelled = false;

    public ModeratorJoinModEvent(APIPlayerModerator moderator) {
        this.moderator = moderator;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public APIPlayerModerator getModerator() {
        return moderator;
    }
}
