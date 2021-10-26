/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.moderators.event.spigot;

import fr.redxil.api.common.moderators.APIPlayerModerator;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ModeratorLeaveModEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final APIPlayerModerator moderator;

    public ModeratorLeaveModEvent(APIPlayerModerator moderator) {
        this.moderator = moderator;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public APIPlayerModerator getModerator() {
        return moderator;
    }
}
