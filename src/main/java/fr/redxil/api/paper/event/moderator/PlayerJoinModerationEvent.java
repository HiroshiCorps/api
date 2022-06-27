/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.event.moderator;

import fr.redxil.api.common.player.moderators.APIPlayerModerator;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerJoinModerationEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    APIPlayerModerator APIPlayer;

    public PlayerJoinModerationEvent(APIPlayerModerator APIPlayer) {
        this.APIPlayer = APIPlayer;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public APIPlayerModerator getAPIPlayerModerator() {
        return APIPlayer;
    }

}
