/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.moderators.event.bungee;

import fr.redxil.api.common.player.moderators.APIPlayerModerator;

public class ModeratorJoinModEvent {

    private final APIPlayerModerator moderator;
    private boolean cancelled = false;

    public ModeratorJoinModEvent(APIPlayerModerator moderator) {
        this.moderator = moderator;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public APIPlayerModerator getModerator() {
        return moderator;
    }
}
