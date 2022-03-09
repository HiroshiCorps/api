/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.moderators.event.bungee;

import fr.redxil.api.common.player.moderators.APIPlayerModerator;

/**
 * This Event is called when Moderator quit the moderator mod
 */
public class ModeratorLeaveModEvent {

    private final APIPlayerModerator moderator;
    private boolean cancelled = false;

    public ModeratorLeaveModEvent(APIPlayerModerator moderator) {
        this.moderator = moderator;
    }

    /**
     * Check if operation is Cancelled
     *
     * @return true if operation is cancelled
     */
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Set the operation to cancelled or not
     */
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    /**
     * Get the moderator
     *
     * @return the apiModeratorClass related to the moderator
     */
    public APIPlayerModerator getModerator() {
        return moderator;
    }

}
